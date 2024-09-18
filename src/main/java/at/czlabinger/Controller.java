package at.czlabinger;

import at.czlabinger.model.SaveLoadHelper;
import at.czlabinger.model.WortTrainer;
import at.czlabinger.view.View;

public class Controller {
    public static void main(String[] args) {
        new Controller();
    }

    private View v;
    private WortTrainer wt;

    public Controller() {
        try {
            this.wt = SaveLoadHelper.load("/home/stoffi05/Downloads/worttrainer.save");
        } catch (RuntimeException e) {
            this.wt = new WortTrainer(new String[]{"Dog", "Cat"}, new String[]{"https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/800px-Cat_November_2010-1a.jpg"});
        }
        this.v = new View(this);
    }

    public String getImageUrl() {
        return this.wt.getWl().getUrl(wt.getSelectedIndex());
    }

    public int getCorrect() {
        return this.wt.getRichtig();
    }

    public int getInputs() {
        return this.wt.getEingaben();
    }

    public void check() {
        if(v.getInput() == null ) return;

        wt.checkSelectedWord(v.getInput());
        wt.pickRandomWord();
        v.update();
    }

    public void save() {
        SaveLoadHelper.save(this.wt, "/home/stoffi05/Downloads/worttrainer.save");
    }

    public void load() {
        this.wt = SaveLoadHelper.load("/home/stoffi05/Downloads/worttrainer.save");
        this.v.update();
    }

    public void newGame() {
        this.wt = new WortTrainer(new String[]{"Dog"}, new String[]{"https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg"});
        this.v.update();
    }

    public void addWord(String input) {
        wt.addWord(input.split(", ")[0], input.split(", ")[1]);
        v.update();
    }
}
