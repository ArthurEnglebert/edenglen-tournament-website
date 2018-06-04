package be.edenglen.tournament.ws.model.service;

import be.edenglen.tournament.ws.model.Eater;
import be.edenglen.tournament.ws.model.Helper;
import be.edenglen.tournament.ws.model.Inscription;
import be.edenglen.tournament.ws.model.Player;
import be.edenglen.tournament.ws.www.dto.in.EaterInDTO;
import be.edenglen.tournament.ws.www.dto.in.HelperInDTO;
import be.edenglen.tournament.ws.www.dto.in.InscriptionInDTO;
import be.edenglen.tournament.ws.www.dto.in.PlayerInDTO;
import be.edenglen.tournament.ws.www.dto.out.InscriptionOutDTO;

public interface ClientConverter {
    Inscription fromDTO(InscriptionInDTO inscription);
    InscriptionOutDTO toDTO(Inscription inscription);

    Player fromDTO(PlayerInDTO player);

    Eater fromDTO(EaterInDTO eater);

    Helper fromDTO(HelperInDTO helper);
}
