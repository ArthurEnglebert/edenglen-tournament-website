package be.edenglen.tournament.ws.www;

import be.edenglen.tournament.ws.model.service.ClientConverter;
import be.edenglen.tournament.ws.model.service.HelperService;
import be.edenglen.tournament.ws.www.dto.ImmutableHelperInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static be.edenglen.tournament.ws.www.PublicController.PUBLIC_FOLDER;

@Controller
@RequestMapping("help")
public class HelpController {
    public static final String INSCRIPTION_FOLDER = PUBLIC_FOLDER + "help/";

    @Autowired
    private HelperService helperService;
    @Autowired
    private ClientConverter clientConverter;

    @RequestMapping
    public String help() {
        return INSCRIPTION_FOLDER + "help";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public void register(@RequestBody ImmutableHelperInDTO helper) {
        helperService.create(clientConverter.fromDTO(helper));
    }
}
