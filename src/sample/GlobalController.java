package sample;

import data.Annee;
import data.Tournoi;
import game.Joueur;
import game.Sexe;

public class GlobalController {

    //nous permet de faire communiquer les differents controllers

    public static Annee currentYear;
    public static Sexe sexe;
    public static int nbAnnee;
    public static Joueur joueurAVoir;

    public static Joueur tempWinner;
    public static Tournoi tournoiAVoir;

    public static Sexe getSexe() {
        // Getter de sexe
        return sexe;
    }

    public static void setSexe(Sexe sexe) {
        // Setter de sexe
        GlobalController.sexe = sexe;
    }

    public static Annee getCurrentYear() {
        return currentYear;
    }

    public static void setCurrentYear(Annee annee) {
        currentYear = annee;
    }

    public static Joueur getTempWinner() {
        return tempWinner;
    }

    public static void setTempWinner(Joueur tempWinner) {
        GlobalController.tempWinner = tempWinner;
    }

}
