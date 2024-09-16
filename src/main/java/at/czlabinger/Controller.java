package at.czlabinger;

import at.czlabinger.model.WortTrainer;
import at.czlabinger.view.View;

public class Controller {
    public static void main(String[] args) {
        Controller c = new Controller();
    }

    private View v;
    private WortTrainer wt;

    public Controller() {
        this.wt = new WortTrainer(new String[]{"Hund", "Katze"}, new String[]{"https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/800px-Cat_November_2010-1a.jpg"});
        this.v = new View(this);
    }

    public String getImageUrl() {
        return this.wt.getWortListe().getUrl(wt.getSelectedIndex());
    }

    public int getCorrect() {
        return this.wt.getRichtig();
    }

    public int getInputs() {
        return this.wt.getEingaben();
    }

    public void check() {
        wt.checkSelectedWord(v.getInput());
        wt.pickRandomWord();
        v.update();
    }

    public void save() {
        //TODO: Implement
    }

    public void load() {
        //TODO: Implement
    }

    public void newGame() {
        this.wt = new WortTrainer(new String[]{"Hund"}, new String[]{"https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg"});
        this.v.update();
    }

    public void addWord(String input) {
        //TODO: Implement
    }

}
