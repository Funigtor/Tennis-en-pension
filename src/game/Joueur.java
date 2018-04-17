package game;

import java.util.Random;

public class Joueur {

  private String nom;
  private String prenom;
  private Sexe sexe;

  private Integer puissance;
  private Integer enduranceMax;
  private Integer points;

  public Joueur (String nom,String prenom, Sexe sexe){
    Random r = new Random();
    this.nom = nom;
    this.prenom = prenom;
    this.sexe = sexe;
    this.puissance = r.nextInt(100);
    this.enduranceMax = r.nextInt(100);
    this.points = 0;
  }


  public Integer getPuissance() {
    // Getter de puissance
    return puissance;
  }

  public void setPuissance(Integer puissance) {
    // Setter de puissance
    this.puissance = puissance;
  }

  public Integer getEnduranceMax() {
    // Getter de enduranceMax
    return enduranceMax;
  }

  public void setEnduranceMax(Integer enduranceMax) {
    // Setter de enduranceMax
    this.enduranceMax = enduranceMax;
  }

  public Integer getPoints() {
    // Getter de points
    return points;
  }

  public void setPoints(Integer points) {
    // Setter de points
    this.points = points;
  }
}