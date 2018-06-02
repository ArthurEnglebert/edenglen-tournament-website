package be.edenglen.tournament.ws.model.service;

import be.edenglen.tournament.ws.model.Eater;
import be.edenglen.tournament.ws.model.Inscription;
import be.edenglen.tournament.ws.model.Player;

import java.util.List;

public interface AmountCalculatorService {
    int calculateDue(Inscription inscription);

    int calculateDuePlayers(List<Player> players);

    int calculateDueDinner(List<Eater> eaters);

    int calculateDueDonation(Integer donation);
}
