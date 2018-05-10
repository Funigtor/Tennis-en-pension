package data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class SaverLoader {
    // Les Gson ne dépendent pas d'une instance particulière.
    private GsonBuilder builder;
    private Gson gson;
    private String filepath;

    public void saveAnnee(Annee toSave) {
        // On va générer un JSON
        String json = gson.toJson(toSave);
        // On sauvegarde le JSON dans un fichier
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
            bw.write(json);
            bw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public Annee loadAnnee() {
        // On va lire un JSON
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String json = br.readLine(); // On a généré que des JSON d'une ligne. L'utilisateur ne doit pas y toucher.
            // On regénère une année avec le fichier et on renvoie
            return gson.fromJson(json,Annee.class);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null; // Si échec.
    }

    public SaverLoader(String filepath) {
        this.filepath = filepath;
        this.builder = new GsonBuilder();
        this.gson = builder.create();
    }

    public String getFilepath() {
        // Getter de filepath
        return filepath;
    }

    public void setFilepath(String filepath) {
        // Setter de filepath
        this.filepath = filepath;
    }
}