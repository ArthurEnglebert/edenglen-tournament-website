package be.edenglen.tournament.ws.www;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import be.edenglen.tournament.ws.model.Inscription;
import be.edenglen.tournament.ws.model.service.ClientConverter;
import be.edenglen.tournament.ws.model.service.ImmutableInscriptionUpdateRequest;
import be.edenglen.tournament.ws.model.service.InscriptionService;
import be.edenglen.tournament.ws.www.dto.in.ImmutableInscriptionInDTO;

import static be.edenglen.tournament.ws.www.PublicController.PUBLIC_FOLDER;

@Controller
@RequestMapping("inscription")
public class InscriptionController {

    public static final String INSCRIPTION_FOLDER = PUBLIC_FOLDER + "inscription/";

    @Autowired
    private InscriptionService inscriptionService;
    @Autowired
    private ClientConverter clientConverter;

    @RequestMapping
    public String inscription() {
        return INSCRIPTION_FOLDER + "inscription";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Long register(@RequestBody ImmutableInscriptionInDTO inscription) {
        Inscription created = inscriptionService.create(clientConverter.fromDTO(inscription));
        return created.getId();
    }

    @RequestMapping(value = "/switchStatus")
    @ResponseBody
    public void switchStatus(@RequestParam("id") Long id) {
        inscriptionService.update(id, ImmutableInscriptionUpdateRequest.builder().switchPaidStatus(true).build());
    }
}
