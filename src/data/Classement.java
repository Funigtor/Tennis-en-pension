package data;

import game.Joueur;
import game.Sexe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Classement {
    private List<Joueur> classment; // Représente la liste de joueurs du classement
    private Sexe sexe;

    public Sexe getSexe() {
        // Getter de sexe
        return sexe;
    }

    public void updateClassement(){
        this.classment.sort((joueur, t1) -> {
                if (joueur.getCurrentPoints() < t1.getCurrentPoints())
                    return -1;
                else if (joueur.getCurrentPoints() > t1.getCurrentPoints())
                    return 1;
                else
                    return 0;
        });
        // On note l'évolution
        int rang = 0;
        for (Joueur j : this.classment){
            j.addRang(this.classment.size() - rang);
            rang++;
        }
    }

    public Classement(Sexe sexe) {
        this.sexe = sexe;
        this.classment = new ArrayList<Joueur>();
    }

    public Classement(Sexe sexe, List<Joueur> list){
        this.sexe = sexe;
        this.classment = list;
    }
}