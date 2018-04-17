import game.Joueur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Classement {
    private List<Joueur> classment;

    public void updateClassement(){
        this.classment.sort((joueur, t1) -> {
                if (joueur.getPoints() < t1.getPoints())
                    return -1;
                else if (joueur.getPoints() > t1.getPoints())
                    return 1;
                else
                    return 0;
        });
    }

    public Classement() {
        this.classment = new ArrayList<Joueur>();
    }

    public Classement(List<Joueur> list){
        this.classment = list;
    }
}