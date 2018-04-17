import game.Joueur;

import java.util.ArrayList;
import java.util.List;

public class Annee {

  private List<Tournoi> tournaments;
  private List<Joueur> participants;
  private Classement classment;

  public List<Joueur> getParticipants() {
    // Getter de participants
    return participants;
  }

  public void setParticipants(List<Joueur> participants) {
    // Setter de participants
    this.participants = participants;
  }

  public Classement getClassment() {
    // Getter de classment
    return classment;
  }

  public void setClassment(Classement classment) {
    // Setter de classment
    this.classment = classment;
  }

  public List<Tournoi> getTournaments() {
    // Getter de tournaments
    return tournaments;
  }

  public void setTournaments(List<Tournoi> tournaments) {
    // Setter de tournaments
    this.tournaments = tournaments;
  }

  public Annee(List<Joueur> participants) {
    this.tournaments = new ArrayList<Tournoi>();
    // On va insérer les 6 tournois prévus
    TypeTournoi types[] = {TypeTournoi.RolandGarros,TypeTournoi.USOpen,TypeTournoi.Wimbledon,TypeTournoi.IndianWells,
            TypeTournoi.Miami,TypeTournoi.OpenAustralie};
    for (TypeTournoi i : types)
      this.tournaments.add(new Tournoi(i,this.participants));
    this.classment = new Classement(participants);
  }

  public Annee(List<Tournoi> tournaments, List<Joueur> participants) {
    this.tournaments = tournaments;
    this.participants = participants;
    this.classment = new Classement(participants);
  }
}