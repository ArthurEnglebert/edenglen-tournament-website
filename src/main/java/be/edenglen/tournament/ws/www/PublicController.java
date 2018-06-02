package be.edenglen.tournament.ws.www;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PublicController {

    public static final String PUBLIC_FOLDER = "public/";

    @RequestMapping
    public String index() {
        return PUBLIC_FOLDER + "index";
    }

    @RequestMapping("/sponsors")
    public String sponsors() {
        return PUBLIC_FOLDER + "sponsors";
    }

    @RequestMapping("editions")
    public String editions() {
        return PUBLIC_FOLDER + "editions";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
