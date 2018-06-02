package be.edenglen.tournament.ws.model.service;

import be.edenglen.tournament.ws.model.Inscription;
import org.springframework.stereotype.Service;

@Service
public class AmountCalculatorServiceImpl implements AmountCalculatorService {

    private static final int PRICE_PER_PLAYER_SUP_25 = 35;
    private static final int PRICE_PER_PLAYER_SUB_25 = 25;
    private static final int PRICE_PER_EATER_SUP_25 = 30;
    private static final int PRICE_PER_EATER_SUB_25 = 20;

    @Override
    public int calculateDue(Inscription inscription) {
        int result = 0;

        result += inscription.getPlayers().stream()
                .mapToInt(player -> player.getAge() > 25 ? PRICE_PER_PLAYER_SUP_25 : PRICE_PER_PLAYER_SUB_25)
                .sum();
        result += inscription.getEaters().stream()
                .mapToInt(eater -> eater.getAge() > 25 ? PRICE_PER_EATER_SUP_25 : PRICE_PER_EATER_SUB_25)
                .sum();
        result += inscription.getDonation();

        return result;
    }
}
