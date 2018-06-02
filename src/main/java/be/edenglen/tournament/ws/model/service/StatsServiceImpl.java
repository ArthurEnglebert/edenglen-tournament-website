package be.edenglen.tournament.ws.model.service;

import be.edenglen.tournament.ws.model.Inscription;
import be.edenglen.tournament.ws.model.Player;
import be.edenglen.tournament.ws.model.Sex;
import be.edenglen.tournament.ws.www.dto.stats.ImmutableAwaitedAmountDTOOut;
import be.edenglen.tournament.ws.www.dto.stats.ImmutableDisparityStatDTOOut;
import be.edenglen.tournament.ws.www.dto.stats.ImmutableStatsDTOOut;
import be.edenglen.tournament.ws.www.dto.stats.StatsDTOOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class StatsServiceImpl implements StatsService {
    private final AmountCalculatorService amountCalculatorService;
    private final InscriptionService inscriptionService;
    private final PlayerService playerService;

    @Autowired
    StatsServiceImpl(InscriptionService inscriptionService, AmountCalculatorService amountCalculatorService, PlayerService playerService) {
        this.amountCalculatorService = amountCalculatorService;
        this.inscriptionService = inscriptionService;
        this.playerService = playerService;
    }

    @Override
    public StatsDTOOut getStats() {
        ImmutableStatsDTOOut.Builder builder = ImmutableStatsDTOOut.builder();

        buildAwaitedAmounts(builder);

        return builder.build();
    }

    private void buildAwaitedAmounts(ImmutableStatsDTOOut.Builder builder) {
        int validated = 0, validatedTennis = 0, validatedDinner = 0, validatedDonation = 0;
        int waiting = 0, waitingTennis = 0, waitingDinner = 0, waitingDonation = 0;

        for (Inscription inscription : inscriptionService.findAll()) {
            Integer tennis = amountCalculatorService.calculateDuePlayers(inscription.getPlayers());
            Integer dinner = amountCalculatorService.calculateDueDinner(inscription.getEaters());
            Integer donation = amountCalculatorService.calculateDueDonation(inscription.getDonation());
            Integer total = tennis + dinner + donation;

            if (inscription.isPaid()) {
                validated += total;
                validatedTennis += tennis;
                validatedDinner += dinner;
                validatedDonation += donation;
            } else {
                waiting += total;
                waitingTennis += tennis;
                waitingDinner += dinner;
                waitingDonation += donation;
            }
        }

        builder.validatedTotal(
                ImmutableAwaitedAmountDTOOut.builder()
                        .total(validated)
                        .fromTennis(validatedTennis)
                        .fromDinners(validatedDinner)
                        .fromDonations(validatedDonation)
                        .build()
        ).waitingTotal(
                ImmutableAwaitedAmountDTOOut.builder()
                        .total(waiting)
                        .fromTennis(waitingTennis)
                        .fromDinners(waitingDinner)
                        .fromDonations(waitingDonation)
                        .build()
        ).awaitedTotal(
                ImmutableAwaitedAmountDTOOut.builder()
                        .total(validated + waiting)
                        .fromTennis(validatedTennis + waitingTennis)
                        .fromDinners(validatedDinner + waitingDinner)
                        .fromDonations(validatedDonation + waitingDonation)
                        .build()
        );
    }

    private void buildDisparities(ImmutableStatsDTOOut.Builder builder) {
        int men1012 = 0, women1012 = 0;
        int men1316 = 0, women1316 = 0;
        int men1725 = 0, women1725 = 0;
        int men26 = 0, women26 = 0;

        for (Player player : playerService.findAll()) {
            if (player.getAge() <= 12) {
                if (player.getSex() == Sex.MALE) {
                    men1012++;
                } else {
                    women1012++;
                }
            } else if (player.getAge() <= 16) {
                if (player.getSex() == Sex.MALE) {
                    men1316++;
                } else {
                    women1316++;
                }
            } else if (player.getAge() <= 25) {
                if (player.getSex() == Sex.MALE) {
                    men1725++;
                } else {
                    women1725++;
                }
            } else {
                if (player.getSex() == Sex.MALE) {
                    men26++;
                } else {
                    women26++;
                }
            }
        }

        builder.disparity1012(
                ImmutableDisparityStatDTOOut.builder()
                        .absoluteMenNumber(men1012)
                        .absoluteWomenNumber(women1012)
                        .build()
        ).disparity1316(
                ImmutableDisparityStatDTOOut.builder()
                        .absoluteMenNumber(men1316)
                        .absoluteWomenNumber(women1316)
                        .build()
        ).disparity1725(
                ImmutableDisparityStatDTOOut.builder()
                        .absoluteMenNumber(men1725)
                        .absoluteWomenNumber(women1725)
                        .build()
        ).disparity26Onwards(
                ImmutableDisparityStatDTOOut.builder()
                        .absoluteMenNumber(men26)
                        .absoluteWomenNumber(women26)
                        .build()
        );
    }
}
