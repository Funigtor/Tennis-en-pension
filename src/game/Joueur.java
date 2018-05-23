package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joueur {

  private String nom;
  private String prenom;
  private Sexe sexe;

  private int classement;
  private int score;

  private Integer puissance;
  private Integer enduranceMax;
  private List<Integer> points; // Représente l'historique
  private List<Integer> rang; // On stocke l'historique du rang

  public Joueur (String nom,String prenom, Sexe sexe){
    Random r = new Random();
    this.nom = nom;
    this.prenom = prenom;
    this.sexe = sexe;
    this.puissance = r.nextInt(100);
    this.enduranceMax = r.nextInt(100);
    this.points = new ArrayList<>();
    this.points.add(1);
    this.rang = new ArrayList<>();
    this.rang.add(0);
    this.score = 1;
    this.classement=getCurrentRang();
  }

  public Joueur (Sexe sexe){
    Random r = new Random();
    this.nom = Names.names[r.nextInt(Names.names.length)];
    this.prenom = (sexe == Sexe.MASCULIN)
            ? Names.males[r.nextInt(Names.males.length)] : Names.females[r.nextInt(Names.females.length)];
    this.sexe = sexe;
    this.puissance = r.nextInt(100);
    this.enduranceMax = r.nextInt(100);
    this.points = new ArrayList<>();
    this.points.add(1);
    this.rang = new ArrayList<>();
    this.rang.add(0);
    this.score = 1;
    this.classement = getCurrentPoints();
  }

  public int getClassement() {
    return classement;
  }

  public void setClassement(int classement) {
    this.classement = classement;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
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
      // Ajoute des points au compteur de points
    this.points.add(this.getCurrentPoints() + newPoints);
    this.score+=newPoints;
  }

   public void addRang(int newRang){
       // Ajoute le nouveau rang
       this.rang.add(newRang);
       this.classement=newRang;
   }

    public List<Integer> getRang() {
        // Getter de rang
        return rang;
    }

    public int getCurrentPoints(){
    return this.points.get(this.points.size() - 1);
  }

    public int getCurrentRang(){
    return this.rang.get(this.rang.size() - 1);
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