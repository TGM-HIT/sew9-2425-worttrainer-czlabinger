package at.czlabinger.model;

import java.util.Random;

public class WortTrainer {

    private WortListe wl;
    private int selectedIndex;
    private int richtig = 0;
    private int eingaben = 0;

    public WortTrainer(String[] words, String[] urls) {
        this.wl = new WortListe(words, urls);
    }

    public WortTrainer(WortListe wl) {
        this.wl = wl;
    }

    public String pickRandomWord() {
        return this.wl.getWord(new Random().nextInt(wl.getLength()));
    }

    public boolean checkSelectedWord(String input) {
        eingaben++;
        if(this.wl.getWord(selectedIndex).equals(input)) {
            richtig++;
            return true;
        }
        return false;
    }

    public boolean checkSelectedWordIgnoreCase(String input) {
        eingaben++;
        if(this.wl.getWord(selectedIndex).equalsIgnoreCase(input)) {
            richtig++;
            return true;
        }
        return false;
    }

    public WortListe getWortListe() {
        return this.wl;
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

}
