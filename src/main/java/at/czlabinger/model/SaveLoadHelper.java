package at.czlabinger.model;

import java.io.*;

public class SaveLoadHelper {

    public static void save(WortTrainer wt, String path) {
        if (wt == null) {
            throw new IllegalArgumentException("WortTrainer must not be null");
        }

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path))) {
            os.writeObject(wt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static WortTrainer load(String path) {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(path))) {
            return (WortTrainer) is.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
