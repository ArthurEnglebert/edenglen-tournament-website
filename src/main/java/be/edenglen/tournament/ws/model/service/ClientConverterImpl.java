package be.edenglen.tournament.ws.model.service;

import be.edenglen.tournament.ws.model.*;
import be.edenglen.tournament.ws.www.dto.EaterInDTO;
import be.edenglen.tournament.ws.www.dto.HelperInDTO;
import be.edenglen.tournament.ws.www.dto.InscriptionInDTO;
import be.edenglen.tournament.ws.www.dto.PlayerInDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ClientConverterImpl implements ClientConverter {

    @Override
    public Inscription fromDTO(InscriptionInDTO inscription) {
        return ImmutableInscription.builder()
                .firstName(inscription.getReferent().getFirstName())
                .name(inscription.getReferent().getName())
                .email(inscription.getReferent().getEmail())
                .phone(inscription.getReferent().getPhone())
                .addAllPlayers(inscription.getPlayers().stream()
                        .map(this::fromDTO)
                        .collect(Collectors.toList())
                )
                .addAllEaters(inscription.getEaters().stream()
                        .map(this::fromDTO)
                        .collect(Collectors.toList())
                )
                .donation(inscription.getDonation())
                .build();
    }

    @Override
    public Player fromDTO(PlayerInDTO player) {
        return ImmutablePlayer.builder()
                .name(player.getName())
                .firstName(player.getFirstName())
                .email(player.getEmail())
                .age(player.getAge())
                .sex(player.getSex())
                .skillLevel(player.getSkillLevel())
                .phone(player.getPhone())
                .championshipLevel(player.getChampionshipLevel())
                .isDining(player.isDining())
                .build();
    }

    @Override
    public Eater fromDTO(EaterInDTO eater) {
        return ImmutableEater.builder()
                .name(eater.getName())
                .firstName(eater.getFirstName())
                .age(eater.getAge())
                .email(eater.getEmail())
                .build();
    }

    @Override
    public Helper fromDTO(HelperInDTO helper) {
        return ImmutableHelper.builder()
                .name(helper.getName())
                .firstName(helper.getFirstName())
                .phone(helper.getPhone())
                .isBringingFood(helper.isBringingFood())
                .isComingToBuild(helper.isComingToBuild())
                .isComingToUnBuild(helper.isComingToUnBuild())
                .isComingToDecorate(helper.isComingToDecorate())
                .numberComing(helper.getNumberComing())
                .build();
    }
}
