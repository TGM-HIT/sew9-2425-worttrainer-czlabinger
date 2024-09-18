package at.czlabinger;

import at.czlabinger.model.SaveLoadHelper;
import at.czlabinger.model.WortListe;
import at.czlabinger.model.WortTrainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AppTest {

    private WortTrainer wt;

    @BeforeEach
    public void setup() {
        wt = new WortTrainer(new WortListe(new String[]{"Haus"}, new String[]{"https://www.haus.at"}));
    }

    @Test
    public void checkAnswer() {
        assertTrue(wt.checkSelectedWord("Haus"));
        assertFalse(wt.checkSelectedWord("Fasd"));
    }

    @Test
    public void checkAnswerIgnoreCase() {
        assertTrue(wt.checkSelectedWordIgnoreCase("haus"));
        assertFalse(wt.checkSelectedWordIgnoreCase("Fasd"));
    }

    @Test
    public void saveLoadTest() {
        SaveLoadHelper.save(wt, "/home/stoffi05/Downloads/worttrainer.save");
        wt.checkSelectedWord("ada");
        WortTrainer loaded = SaveLoadHelper.load("/home/stoffi05/Downloads/worttrainer.save");
        assertNotEquals(wt, loaded);
    }
}
