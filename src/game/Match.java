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

  // Un générateur de nombre aléatoire
  private Random r = new Random();


  public void jouerMatch() {
    // On va jouer des sets
    // On va compter les sets gagnés par les joueurs.
    int setsA = 0 ; // Compte les sets gagnés par A
    int setsB = 0 ;
    int nbSetMax = 2;
    if (inThreeSets) nbSetMax++;
    while (setsA < nbSetMax || setsB < nbSetMax){
      if (jouerSet() == joueurA) setsA++;
      else setsB++;
    }
    // TODO On met à jour le score des joueurs
  }

  private Joueur jouerSet(){
    // Un set est composé de 6 jeux, ou un tie-break en cas de 6-6
    int jeuxA = 0;
    int jeuxB = 0;
    while (Math.abs(jeuxB-jeuxA) < 2 || (jeuxA < 6 && jeuxB < 6)){
      if (jeuxA == 6 && jeuxB == 6){ // TODO condition différente pour dernier set
        // Il s'agit d'un tie-break
        return jouerTieBreak();
      } else {
        if (jouerJeu() == joueurA) jeuxA++;
        else jeuxB++;
      }
    }
    if (jeuxA > jeuxB) return joueurA;
    else return joueurB; // On retourne le joueur vainqueur
  }

  private Joueur jouerJeu(){
    int scoreA = 0;
    int scoreB = 0;
    while (Math.abs(scoreB-scoreA) < 2 || (scoreA < 4 && scoreB < 4) ){
      // On tire les valeurs des joueurs
      float valA = joueurA.getPuissance()/(100-enduA)*r.nextInt(100);
      float valB = joueurB.getPuissance()/(100-enduB)*r.nextInt(100);
      enduA -= joueurA.getPuissance()/100;
      enduB -= joueurB.getPuissance()/100;
      // TODO abandon
      if (valA > valB) scoreA++;
      else scoreB++;
    }
    if (scoreA > scoreB) return joueurA;
    else return joueurB;
  }

  private Joueur jouerTieBreak(){ // TODO factorize me
    int scoreA = 0;
    int scoreB = 0;
    while (Math.abs(scoreB-scoreA) < 2 || (scoreA < 7 && scoreB < 7) ){
      // On tire les valeurs des joueurs
      float valA = joueurA.getPuissance()/(100-enduA)*r.nextInt(100);
      float valB = joueurB.getPuissance()/(100-enduB)*r.nextInt(100);
      enduA -= joueurA.getPuissance()/100;
      enduB -= joueurB.getPuissance()/100;
      // TODO abandon
      if (valA > valB) scoreA++;
      else scoreB++;
    }
    if (scoreA > scoreB) return joueurA;
    else return joueurB;
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