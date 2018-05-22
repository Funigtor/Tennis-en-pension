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

    public Joueur[] loadJoueurs(Sexe sexe) {
        // On va lire un fichier formaté en nom prenom
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        ArrayList<Joueur> futursJoueurs = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null) {
            // process the line.
                String[] tab = line.split(" ");
                if (tab.length < 2)
                    throw new Exception();
                String futurNom = tab[0];
                String futurPrenom = tab[1];
                futursJoueurs.add(new Joueur(futurNom,futurPrenom,sexe));
            }
            br.close();
            return (Joueur[]) futursJoueurs.toArray();
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