import game.Joueur;
import game.Match;

import java.util.Collections;
import java.util.List;

public class Tournoi {
  private TypeTournoi type;
  private List<Match> matches;
  private List<Joueur> participants;

  // TODO Fonction pour lancer les matchs

  public TypeTournoi getType() {
    // Getter de type
    return type;
  }

  public void setType(TypeTournoi type) {
    // Setter de type
    this.type = type;
  }

  public List<Match> getMatches() {
    // Getter de matches
    return matches;
  }

  public void setMatches(List<Match> matches) {
    // Setter de matches
    this.matches = matches;
  }

  public Tournoi(TypeTournoi type) {
    // TODO remove ou autogénération
    this.type = type;
  }

  public Tournoi(TypeTournoi type, List<Joueur> participants) {
    this.type = type;
    this.participants = participants;
    // On assure des rencontres aléatoires aux joueurs
    Collections.shuffle(this.participants);
  }

  public List<Joueur> getParticipants() {
    // Getter de participants
    return participants;
  }

  public void setParticipants(List<Joueur> participants) {
    // Setter de participants
    this.participants = participants;
  }
}