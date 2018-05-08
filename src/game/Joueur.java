package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joueur {

  private String nom;
  private String prenom;
  private Sexe sexe;

  private Integer puissance;
  private Integer enduranceMax;
  private List<Integer> points; // Représente l'historique

  public Joueur (String nom,String prenom, Sexe sexe){
    Random r = new Random();
    this.nom = nom;
    this.prenom = prenom;
    this.sexe = sexe;
    this.puissance = r.nextInt(100);
    this.enduranceMax = r.nextInt(100);
    this.points = new ArrayList<>();
    this.points.add(0);
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

  public List<Integer> getPoints() {
    // Getter de points
    return points;
  }

  public void setPoints(List<Integer> points) {
    // Setter de points
    this.points = points;
  }

  public void addPoints(int newPoints){
    this.points.add(newPoints);
  }

  public int getCurrentPoints(){
    return this.points.get(this.points.size() - 1);
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public Sexe getSexe() {
    return sexe;
  }

  public void setSexe(Sexe sexe) {
    this.sexe = sexe;
  }
}