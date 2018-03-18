package be.edenglen.tournament.ws.www;

import be.edenglen.tournament.ws.model.Eater;
import be.edenglen.tournament.ws.model.service.EaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ws/eaters")
public class EaterController {

    private final EaterService eaterService;

    @Autowired
    public EaterController(EaterService eaterService) {
        this.eaterService = eaterService;
    }

    @GetMapping("/{id}")
    public Eater get(@PathVariable("id") Long id) {
        return eaterService.get(id);
    }

    @PostMapping
    public Eater create(@RequestBody Eater eater) {
        return eaterService.create(eater);
    }
}
