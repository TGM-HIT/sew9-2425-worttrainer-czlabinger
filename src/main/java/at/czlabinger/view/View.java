package at.czlabinger.view;

import at.czlabinger.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class View {

    private Controller c;
    private JPanel panel = new JPanel();
    private JPanel panelN = new JPanel();
    private JPanel panelE = new JPanel();
    private JPanel panelS = new JPanel();
    private JLabel text = new JLabel("Welches Wort wird unten dargestellt?");
    private JLabel correct = new JLabel("Richtig: ");
    private JLabel inputs = new JLabel("Angezeigt: ");
    private JTextField textField = new JTextField();
    private Image image;
    private JLabel imageLabel = new JLabel();
    private JButton check = new JButton("Check");
    private JButton save = new JButton("Save");
    private JButton load = new JButton("Load");
    private JButton newGame = new JButton("New Game");
    private JButton addWord = new JButton("Add word");

    public View(Controller c) {
        this.c = c;
        this.start();
    }

    private void start() {
        try {
            URL url = new URL(c.getImageUrl());
            ImageIcon imageIcon = new ImageIcon(ImageIO.read(url));
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);
            imageLabel.setIcon(imageIcon);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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

        JWindow window = new JWindow();
        window.add(panel);
        window.setSize(new Dimension(500, 500));
        window.setVisible(true);
    }

}
