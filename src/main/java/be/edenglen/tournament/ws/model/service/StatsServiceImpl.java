package be.edenglen.tournament.ws.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class StatsServiceImpl implements StatsService {
    private final PlayerService playerService;
    private final InscriptionService inscriptionService;
    private final EaterService eaterService;
    private final HelperService helperService;

    @Autowired
    StatsServiceImpl(PlayerService playerService, InscriptionService inscriptionService, EaterService eaterService, HelperService helperService) {
        this.playerService = playerService;
        this.inscriptionService = inscriptionService;
        this.eaterService = eaterService;
        this.helperService = helperService;
    }
}
