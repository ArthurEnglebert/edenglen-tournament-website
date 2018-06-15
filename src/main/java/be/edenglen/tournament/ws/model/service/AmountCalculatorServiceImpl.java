package be.edenglen.tournament.ws.model.service;

import be.edenglen.tournament.ws.model.Eater;
import be.edenglen.tournament.ws.model.Inscription;
import be.edenglen.tournament.ws.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmountCalculatorServiceImpl implements AmountCalculatorService {

    private static final int PRICE_PER_PLAYER_SUP_25 = 35;
    private static final int PRICE_PER_PLAYER_SUB_25 = 25;
    private static final int PRICE_PER_EATER_SUP_25 = 30;
    private static final int PRICE_PER_EATER_SUB_25 = 20;
    private static final int PRICE_PER_EATER_SUB_8 = 0;

    @Override
    public int calculateDue(Inscription inscription) {
        int result = 0;

        result += calculateDuePlayers(inscription.getPlayers());
        result += calculateDueDinner(inscription.getEaters());
        result += calculateDueDonation(inscription.getDonation());

        return result;
    }

    @Override
    public int calculateDuePlayers(List<Player> players) {
        return players.stream()
                .mapToInt(player -> player.getAge() > 25 ? PRICE_PER_PLAYER_SUP_25 : PRICE_PER_PLAYER_SUB_25)
                .sum();
    }

    @Override
    public int calculateDueDinner(List<Eater> eaters) {
        return eaters.stream()
                .mapToInt(eater -> eater.getAge() > 25 ? PRICE_PER_EATER_SUP_25 : (eater.getAge() > 8 ? PRICE_PER_EATER_SUB_25 : PRICE_PER_EATER_SUB_8))
                .sum();
    }

    @Override
    public int calculateDueDonation(Integer donation) {
        return donation;
    }
}
