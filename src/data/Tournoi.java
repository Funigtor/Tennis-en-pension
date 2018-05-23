package data;

import game.Joueur;
import game.Match;
import game.MatchHistory;
import game.Sexe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tournoi {
    private TypeTournoi type;
    private List<MatchHistory> matches;
    private List<Joueur> participants;
    private Sexe sexe;

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

    @Deprecated
    public Tournoi(TypeTournoi type) {
        // TODO remove ou autogénération
        this.type = type;
    }

    public Tournoi(TypeTournoi type, List<Joueur> participants) {
        this.type = type;
        this.participants = participants;
        this.sexe = participants.get(0).getSexe();
        this.matches = new ArrayList<>();
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

    public void jouerTournoi() {
        // On vérifie qu'on est dans un cas où le tournoi se joue en trois set
        boolean inThreeSets = sexe == Sexe.MASCULIN && type != TypeTournoi.IndianWells && type != TypeTournoi.Miami;
        List<Joueur> joueursRestants = this.participants;
        for (int ronde = 1; ronde <= 7; ronde++) {
            if (ronde == 6) continue; // On jouera la troisième place plus tard
            List<Joueur> vainqueurs = new ArrayList<>();
            // On va lancer tous les matchs du tournoi
            // Génération
            List<Match> listMatches = new ArrayList<>();
            for (int i = 0; i < joueursRestants.size(); i += 2)
                listMatches.add(new Match(joueursRestants.get(i), joueursRestants.get(i + 1), ronde, inThreeSets));
            // Sauvegarde des matches
            for (Match j : listMatches) {
                this.matches.add(j.jouerMatch());
                vainqueurs.add(j.getVainqueur());
            }
            joueursRestants = vainqueurs;
        }
        // On organise le match de la troisième place
        // size() - 2 et -3 comme le -1 est la finale on cherche les perdants des demi-finales.
        Match tp = new Match(this.matches.get(this.matches.size() - 2).getPerdant(),
                this.matches.get(this.matches.size() - 3).getPerdant(), 6, inThreeSets);
        this.matches.add(this.matches.size() - 2, tp.jouerMatch()); // On a ajouté la troisième place avant la finale.
    }
}