package be.edenglen.tournament.ws.model.service;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import be.edenglen.tournament.ws.model.Eater;
import be.edenglen.tournament.ws.model.Helper;
import be.edenglen.tournament.ws.model.ImmutableEater;
import be.edenglen.tournament.ws.model.ImmutableHelper;
import be.edenglen.tournament.ws.model.ImmutableInscription;
import be.edenglen.tournament.ws.model.ImmutablePlayer;
import be.edenglen.tournament.ws.model.Inscription;
import be.edenglen.tournament.ws.model.Player;
import be.edenglen.tournament.ws.www.dto.in.EaterInDTO;
import be.edenglen.tournament.ws.www.dto.in.HelperInDTO;
import be.edenglen.tournament.ws.www.dto.in.InscriptionInDTO;
import be.edenglen.tournament.ws.www.dto.in.PlayerInDTO;
import be.edenglen.tournament.ws.www.dto.out.ImmutableInscriptionOutDTO;
import be.edenglen.tournament.ws.www.dto.out.InscriptionOutDTO;

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
    public InscriptionOutDTO toDTO(Inscription inscription) {
        return ImmutableInscriptionOutDTO.builder()
                .id(inscription.getId())
                .firstName(inscription.getFirstName())
                .name(inscription.getName())
                .email(inscription.getEmail())
                .phone(inscription.getPhone())
                .amount(inscription.getAmount())
                .isPaid(inscription.isPaid())
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
                .comingToBuildStart(helper.getComingToBuildStart())
                .comingToBuildEnd(helper.getComingToBuildEnd())
                .isComingToDecorate(helper.isComingToDecorate())
                .comingToDecorateStart(helper.getComingToDecorateStart())
                .comingToDecorateEnd(helper.getComingToDecorateEnd())
                .isComingToUnBuild(helper.isComingToUnBuild())
                .comingToUnBuildStart(helper.getComingToUnBuildStart())
                .comingToUnBuildEnd(helper.getComingToUnBuildEnd())
                .numberComing(helper.getNumberComing())
                .build();
    }
}
