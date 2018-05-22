package sample;

import data.Annee;
import game.Joueur;
import game.Sexe;

import java.util.ArrayList;

public class GlobalController {
    public static ArrayList<Annee> MyAnnee;
    public static ArrayList<Joueur> MyList= new ArrayList<Joueur>();
    public static int Annee;
    public static Sexe sexe;

    public static Sexe getSexe() {
        // Getter de sexe
        return sexe;
    }

    public static void setSexe(Sexe sexe) {
        // Setter de sexe
        GlobalController.sexe = sexe;
    }

    public static int getAnnee() {
        return Annee;
    }

    public static void setAnnee(int annee) {
        Annee = annee;
    }

    public ArrayList<Annee> getMyAnnee() {
        return MyAnnee;
    }

    public void setMyAnnee(ArrayList<Annee> myAnnee) {
        MyAnnee = myAnnee;
    }

    public ArrayList<Joueur> getMyList() {
        return MyList;
    }

    public void setMyList(ArrayList<Joueur> myList) {
        MyList = myList;
    }
}
