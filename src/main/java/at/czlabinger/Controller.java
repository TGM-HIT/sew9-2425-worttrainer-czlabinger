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
        this.wt = new WortTrainer(new String[]{"Hund"}, new String[]{"https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg"});
        this.v = new View(this);
    }

    public String getImageUrl() {
        return wt.getWortListe().getUrl(wt.getSelectedIndex());
    }
}
