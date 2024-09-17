package at.czlabinger.model;

import java.io.Serializable;
import java.util.Random;

public class WortTrainer implements Serializable {

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
        this.selectedIndex = new Random().nextInt(wl.getLength());
        return this.wl.getWord(selectedIndex);
    }

    public void checkSelectedWord(String input) {
        eingaben++;
        if(this.wl.getWord(selectedIndex).equals(input)) {
            richtig++;
        }
    }

    public void checkSelectedWordIgnoreCase(String input) {
        eingaben++;
        if(this.wl.getWord(selectedIndex).equalsIgnoreCase(input)) {
            richtig++;
        }
    }

    public WortListe getWortListe() {
        return this.wl;
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    public int getRichtig(){
        return this.richtig;
    }

    public int getEingaben() {
        return eingaben;
    }

    public void addWord(String word, String url) {
        this.wl.addWord(word, url);
    }
}
