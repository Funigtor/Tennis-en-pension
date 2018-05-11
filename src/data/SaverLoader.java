package data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;

import game.*;

public class SaverLoader {
    // Les Gson ne dépendent pas d'une instance particulière.
    private GsonBuilder builder;
    private Gson gson;
    private File file;

    public void saveAnnee(Annee toSave) {
        // On va générer un JSON
        String json = gson.toJson(toSave);
        // On sauvegarde le JSON dans un fichier
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(json);
            bw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public Annee loadAnnee() {
        // On va lire un JSON
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String json = br.readLine(); // On a généré que des JSON d'une ligne. L'utilisateur ne doit pas y toucher.
            // On regénère une année avec le fichier et on renvoie
            return gson.fromJson(json,Annee.class);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null; // Si échec.
    }

    public Joueur[] loadJoueurs() {
        // On va lire un JSON
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String json = br.readLine(); // On a généré que des JSON d'une ligne. L'utilisateur ne doit pas y toucher.
            // On regénère une année avec le fichier et on renvoie
            return gson.fromJson(json,Joueur[].class);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null; // Si échec.
    }

    public SaverLoader(String filepath) {
        this.file = new File(filepath);
        this.builder = new GsonBuilder();
        this.gson = builder.create();
    }

    public SaverLoader(File file) {
        this.file = file;
        this.builder = new GsonBuilder();
        this.gson = builder.create();
    }

    public File getFile() {
        // Getter de filepath
        return file;
    }

    public void setFilepath(String filepath) {
        // Setter de filepath
        this.file = new File(filepath);
    }

    public void setFile(File file) {
        // Setter de file
        this.file = file;
    }
}