package game;

import java.util.List;
import java.util.Random;

public class Match {

  // Stocke les joueurs participants au match
  private Joueur joueurA;
  private Joueur joueurB;

  // Stocke l'endurance des joueurs pour toute la durée du match.
  private float enduA;
  private float enduB;

  // Certains matchs se jouent en 3 sets
  private boolean inThreeSets;

  // Un match est un ensemble de Sets
  List<Set> sets;


  public void jouerMatch() {
    // TODO Do me
  }


  public Match(Joueur joueurA, Joueur joueurB) {
    this.joueurA = joueurA;
    this.joueurB = joueurB;
    this.enduA = joueurA.getEnduranceMax();
    this.enduB = joueurB.getEnduranceMax();
    this.inThreeSets = false;
  }

  public Match(Joueur joueurA, Joueur joueurB, boolean inThreeSets) {
    this.joueurA = joueurA;
    this.joueurB = joueurB;
    this.enduA = joueurA.getEnduranceMax();
    this.enduB = joueurB.getEnduranceMax();
    this.inThreeSets = inThreeSets;
  }

  public Joueur getJoueurA() {
    // Getter de joueurA
    return joueurA;
  }

  public Joueur getJoueurB() {
    // Getter de joueurB
    return joueurB;
  }
}