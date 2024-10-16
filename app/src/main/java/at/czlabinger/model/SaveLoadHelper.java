package at.czlabinger.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import java.io.*;

public class SaveLoadHelper {

    @Setter
    @Getter
    private static boolean json = false;

    public static void save(WortTrainer wt, String path) {
        if(json) {
            saveJson(wt, path);
        } else {
            saveObject(wt, path);
        }
    }

    public static WortTrainer load(String path) {

        if(json) {
            return loadJson(path);
        } else {
            return loadObject(path);
        }
    }

    private static void saveObject(WortTrainer wt, String path) {
        if (wt == null) {
            throw new IllegalArgumentException("WortTrainer must not be null");
        }

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path))) {
            os.writeObject(wt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveJson(WortTrainer wt, String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(path), wt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static WortTrainer loadObject(String path) {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(path))) {
            return (WortTrainer) is.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return new WortTrainer(new WortListe(new String[]{"Dog", "Cat"}, new String[]{"https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/800px-Cat_November_2010-1a.jpg"}));
        }
    }

    private static WortTrainer loadJson(String path) {
        ObjectMapper om = new ObjectMapper();

        try {
            return om.readValue(new File(path), WortTrainer.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
