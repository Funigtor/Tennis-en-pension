package game;

import java.util.ArrayList;
import java.util.Random;

public class Match {

    // On stocke la feuille de Match
    private MatchHistory history;

    // Stocke les joueurs participants au match
    private Joueur joueurA;
    private Joueur joueurB;

    // Stocke l'endurance des joueurs pour toute la durée du match.
    private float enduA;
    private float enduB;

    // Certains matchs se jouent en 3 sets
    private boolean inThreeSets;

    // Un générateur de nombre aléatoire
    private Random r = new Random();

    // On stockera le nom du vainqueur
    private Joueur vainqueur;
    private int nbJeuxEcart;
    private int numeroDeLaRonde;

    private int nbJeuxA;
    private int nbJeuxB;

    public MatchHistory jouerMatch() {
        // On va jouer des sets
        // On va compter les sets gagnés par les joueurs.
        int setsA = 0; // Compte les sets gagnés par A
        int setsB = 0;
        int nbSetMax = 2;
        if (inThreeSets) nbSetMax++;
        while ((setsA < nbSetMax && setsB < nbSetMax)) {
            // En cas d'abandon on aura un vainqueur, il faut sortir.
            if (vainqueur != null) break;
            // On ajoute le nouveau set
            this.history.jeux.add(new ArrayList<Integer[]>());
            if (setsA == nbSetMax - 1 && setsB == nbSetMax - 1) {
                // Il s'agit du dernier set
                if (jouerSet(true) == joueurA) setsA++;
                else setsB++;
            } else {
                if (jouerSet(false) == joueurA) setsA++;
                else setsB++;
            }
        }
        // On détermine le vainqueur si ce n'est déjà fait.
        if (vainqueur == null) {
            this.vainqueur = (setsA > setsB) ? joueurA : joueurB;
        }
        Joueur perdant = (this.vainqueur == joueurA) ? joueurB : joueurA;
        // On termine de remplir l'historique avec les informations de fin de match
        nbJeuxEcart = Math.abs(nbJeuxA - nbJeuxB);
        this.history.setNbJeuxEcart(nbJeuxEcart);
        this.history.setVainqueur(this.vainqueur);
        // On met à jour le score des joueurs
        int pointsVainqueur = vainqueur.getCurrentPoints();
        int pointsPerdant = perdant.getCurrentPoints();
        int nbPointsGagnes = (int) Math.ceil(numeroDeLaRonde / 7.0 * pointsPerdant / pointsVainqueur * nbJeuxEcart);
        vainqueur.addPoints(nbPointsGagnes);
        perdant.addPoints(0); // Le perdant doit avancer aussi dans sa progression, même si elle est stable.
        return this.history;
    }

    private Joueur jouerSet(boolean isFinalSet) {
        // Un set est composé de 6 jeux, ou un tie-break en cas de 6-6
        int jeuxA = 0;
        int jeuxB = 0;
        while (Math.abs(jeuxB - jeuxA) < 2 || (jeuxA < 6 && jeuxB < 6)) {
            // On retourne tout de suite si on a un vainqueur.
            if (vainqueur != null) return vainqueur;

            if (jeuxA == 6 && jeuxB == 6 && !isFinalSet) { // Si dernier set il n'y aura pas de tie-break
                // Il s'agit d'un tie-break
                return jouerJeu(true); // le vainqueur du tie-break remporte le set
            } else {
                if (jouerJeu(false) == joueurA) jeuxA++;
                else jeuxB++;
            }
        }
        nbJeuxA += jeuxA;
        nbJeuxB += jeuxB;
        if (jeuxA > jeuxB) return joueurA;
        else return joueurB; // On retourne le joueur vainqueur
    }

    private Joueur jouerJeu(boolean isTieBreak) {
        int scoreA = 0;
        int scoreB = 0;
        int scoreAObtenir = 4;
        if (isTieBreak)
            scoreAObtenir += 3; // On est dans le cas d'un tie break.
        while (Math.abs(scoreB - scoreA) < 2 || (scoreA < scoreAObtenir && scoreB < scoreAObtenir)) {
            // On tire les valeurs des joueurs
            float valA = joueurA.getPuissance() / (100 - enduA) * r.nextInt(100);
            float valB = joueurB.getPuissance() / (100 - enduB) * r.nextInt(100);
            enduA -= joueurA.getPuissance() / 100.0;
            enduB -= joueurB.getPuissance() / 100.0;
            // On détermine si un joueur veut abandonner le match
            if (enduA <= 0) {
                this.abandon('a');
                return joueurB;
            }
            if (enduB <= 0) {
                this.abandon('b');
                return joueurA;
            }
            // On détermine le vainqueur du round
            if (valA > valB) scoreA++;
            else scoreB++;
        }
        // le jeu est fini
        Integer[] finalResult = {scoreA, scoreB};
        this.history.jeux.get(this.history.jeux.size() - 1).add(finalResult); // On a sauvegardé le jeu
        if (scoreA > scoreB) return joueurA;
        else return joueurB;
    }

    private void abandon(char joueur) {
        switch (joueur) {
            case 'a':
                this.setVainqueur(joueurB);
                break;
            case 'b':
                this.setVainqueur(joueurA);
                break;
        }
    }

    public Match(Joueur joueurA, Joueur joueurB) {
        this.joueurA = joueurA;
        this.joueurB = joueurB;
        this.enduA = joueurA.getEnduranceMax();
        this.enduB = joueurB.getEnduranceMax();
        this.inThreeSets = false;
        this.numeroDeLaRonde = 1; // On comptera 1 pour les marches hors tournoi
        this.history = new MatchHistory(joueurA, joueurB, joueurA.getSexe(), numeroDeLaRonde);
    }

    public Match(Joueur joueurA, Joueur joueurB, boolean inThreeSets) {
        this.joueurA = joueurA;
        this.joueurB = joueurB;
        this.enduA = joueurA.getEnduranceMax();
        this.enduB = joueurB.getEnduranceMax();
        this.inThreeSets = inThreeSets;
        this.numeroDeLaRonde = 1; // On comptera 1 pour les marches hors tournoi
        this.history = new MatchHistory(joueurA, joueurB, joueurA.getSexe(), numeroDeLaRonde);
    }

    public Match(Joueur joueurA, Joueur joueurB, int numeroDeLaRonde) {
        this.joueurA = joueurA;
        this.joueurB = joueurB;
        this.enduA = joueurA.getEnduranceMax();
        this.enduB = joueurB.getEnduranceMax();
        this.inThreeSets = false;
        this.numeroDeLaRonde = numeroDeLaRonde;
        this.history = new MatchHistory(joueurA, joueurB, joueurA.getSexe(), numeroDeLaRonde);
    }

    public Match(Joueur joueurA, Joueur joueurB, int numeroDeLaRonde, boolean inThreeSets) {
        this.joueurA = joueurA;
        this.joueurB = joueurB;
        this.enduA = joueurA.getEnduranceMax();
        this.enduB = joueurB.getEnduranceMax();
        this.inThreeSets = inThreeSets;
        this.numeroDeLaRonde = numeroDeLaRonde;
        this.history = new MatchHistory(joueurA, joueurB, joueurA.getSexe(), numeroDeLaRonde);
    }

    public Joueur getJoueurA() {
        // Getter de joueurA
        return joueurA;
    }

    public Joueur getJoueurB() {
        // Getter de joueurB
        return joueurB;
    }

    public Joueur getVainqueur() {
        // Getter de vainqueur
        return vainqueur;
    }

    public int getNbJeuxEcart() {
        // Getter de nbJeuxEcart
        return nbJeuxEcart;
    }

    public int getNumeroDeLaRonde() {
        // Getter de numeroDeLaRonde
        return numeroDeLaRonde;
    }

    private void setVainqueur(Joueur vainqueur) {
        // Setter de vainqueur
        this.vainqueur = vainqueur;

    }
}