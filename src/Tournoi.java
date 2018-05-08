import game.Joueur;
import game.Match;
import game.MatchHistory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tournoi {
  private TypeTournoi type;
  private List<MatchHistory> matches;
  private List<Joueur> participants;

  // TODO Tournoi en trois sets

  public TypeTournoi getType() {
    // Getter de type
    return type;
  }

  public void setType(TypeTournoi type) {
    // Setter de type
    this.type = type;
  }

  public List<MatchHistory> getMatches() {
    // Getter de matches
    return matches;
  }

  public void setMatches(List<MatchHistory> matches) {
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

  public void jouerTournoi(){
    // TODO 3ème place
    Joueur[] joueursRestants = (Joueur[])this.participants.toArray();
    for (int ronde = 1; ronde <= 7; ronde++){
      List<Joueur> vainqueurs = new ArrayList<>();
      // On va lancer tous les matchs du tournoi
      List<Match> listMatches = new ArrayList<>();
      for (int i  = 0; i < joueursRestants.length; i += 2)
          listMatches.add(new Match(joueursRestants[i],joueursRestants[i+1]));
      for (Match j : listMatches) {
        this.matches.add(j.jouerMatch());
        vainqueurs.add(j.getVainqueur());
      }
      joueursRestants = (Joueur[])vainqueurs.toArray();
    }
  }
}