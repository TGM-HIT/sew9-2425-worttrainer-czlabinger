package at.czlabinger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import at.czlabinger.model.WortTrainer;
import org.junit.jupiter.api.Test;


public class AppTest {

    @Test
    public void checkAnswer() {
        WortTrainer wt = new WortTrainer(new String[]{"Haus"}, new String[]{"haus.at"});
        assertTrue(wt.checkSelectedWord("Haus"));
        assertFalse(wt.checkSelectedWord("Fasd"));
    }

    @Test
    public void checkAnswerIgnoreCase() {
        WortTrainer wt = new WortTrainer(new String[]{"Haus"}, new String[]{"haus.at"});
        assertTrue(wt.checkSelectedWordIgnoreCase("haus"));
        assertFalse(wt.checkSelectedWordIgnoreCase("Fasd"));
    }
}
