package be.edenglen.tournament.ws.model.service;

import be.edenglen.tournament.ws.model.Eater;
import be.edenglen.tournament.ws.model.Helper;
import be.edenglen.tournament.ws.model.Inscription;
import be.edenglen.tournament.ws.model.Player;
import be.edenglen.tournament.ws.www.dto.EaterInDTO;
import be.edenglen.tournament.ws.www.dto.HelperInDTO;
import be.edenglen.tournament.ws.www.dto.InscriptionInDTO;
import be.edenglen.tournament.ws.www.dto.PlayerInDTO;

public interface ClientConverter {
    Inscription fromDTO(InscriptionInDTO inscription);

    Player fromDTO(PlayerInDTO player);

    Eater fromDTO(EaterInDTO eater);

    Helper fromDTO(HelperInDTO helper);
}
