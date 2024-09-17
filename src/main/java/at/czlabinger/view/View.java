package at.czlabinger.view;

import at.czlabinger.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class View {

    private Controller c;
    private JPanel panel = new JPanel();
    private JPanel panelN = new JPanel();
    private JPanel panelE = new JPanel();
    private JPanel panelS = new JPanel();
    private JLabel text = new JLabel("Welches Wort wird unten dargestellt?");
    private JLabel correct = new JLabel("Richtig: 0");
    private JLabel inputs = new JLabel("Eingaben: 0");
    private JTextField textField = new JTextField(15);
    private JLabel imageLabel = new JLabel();
    private JButton check = new JButton("Check");
    private JButton save = new JButton("Save");
    private JButton load = new JButton("Load");
    private JButton newGame = new JButton("New Game");
    private JButton addWord = new JButton("Add word");
    JFrame frame = new JFrame();

    public View(Controller c) {
        this.c = c;
        this.start();
    }

    private void start() {

        textField.setEditable(true);
        textField.setEnabled(true);

        panel.setLayout(new BorderLayout());
        panelN.add(text);
        panelN.add(textField);
        panelN.add(check);
        panelE.add(imageLabel);
        panelS.add(correct);
        panelS.add(inputs);
        panelS.add(save);
        panelS.add(load);
        panelS.add(newGame);
        panelS.add(addWord);
        panel.add(panelN, BorderLayout.NORTH);
        panel.add(panelE, BorderLayout.CENTER);
        panel.add(panelS, BorderLayout.SOUTH);

        frame.add(panel);
        this.update();
        frame.setVisible(true);
        frame.setSize(new Dimension(550, 350));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.check();
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.save();
            }
        });

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.load();
            }
        });

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.newGame();
            }
        });

        addWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.addWord(textField.getText());
            }
        });

    }

    public String getInput() {
        return this.textField.getText();
    }

    public void update() {
        try {
            URL url = new URL(c.getImageUrl());
            ImageIcon imageIcon = new ImageIcon(ImageIO.read(url));
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(220, 220,  java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);
            imageLabel.setIcon(imageIcon);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.textField.setText("");
        this.correct.setText("Richtig: " + c.getCorrect());
        this.inputs.setText("Angezeigt: " + c.getInputs());
    }

}