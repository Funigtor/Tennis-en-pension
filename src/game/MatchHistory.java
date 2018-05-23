package game;

import java.util.ArrayList;
import java.util.List;

public class MatchHistory {
    // On note les joueurs qui ont participé au match
    private Joueur joueurA;
    private Joueur joueurB;
    private Sexe sexe;
    private String nom;

    // On stocke les jeux pour chaque sets comme un tableau [scoreJoueurA, scoreJoueurB]
    protected List<List<Integer[]>> jeux;

    // On note aussi l'écart et le numéro de la ronde
    private int nbJeuxEcart;
    private int numeroDeLaRonde;

    // On note le vainqueur
    private Joueur vainqueur;
    private Joueur perdant;

    public MatchHistory(Joueur joueurA, Joueur joueurB, Sexe sexe, int numeroDeLaRonde) {
        this.joueurA = joueurA;
        this.joueurB = joueurB;
        this.sexe = sexe;
        this.numeroDeLaRonde = numeroDeLaRonde;
        this.jeux = new ArrayList<>();
        this.nom= toString();
    }

    public int getNbJeuxEcart() {
        // Getter de nbJeuxEcart
        return nbJeuxEcart;
    }

    protected void setNbJeuxEcart(int nbJeuxEcart) {
        // Setter de nbJeuxEcart
        // protected car ne doit être défini que dans un Match
        this.nbJeuxEcart = nbJeuxEcart;
    }

    public int getNumeroDeLaRonde() {
        // Getter de numeroDeLaRonde
        return numeroDeLaRonde;
    }

    public Joueur getVainqueur() {
        // Getter de vainqueur
        return vainqueur;
    }

    protected void setVainqueur(Joueur vainqueur) {
        // Setter de vainqueur
        this.vainqueur = vainqueur;
        this.perdant = (joueurA == vainqueur) ? joueurB : joueurA;
    }

    public Joueur getPerdant() {
        // Getter de perdant
        return perdant;
    }

    @Override
    public String toString(){
        return joueurA.getPrenom() + " " + joueurA.getNom() + " VS " + joueurB.getPrenom() + " " + joueurB.getNom();
    }
}
