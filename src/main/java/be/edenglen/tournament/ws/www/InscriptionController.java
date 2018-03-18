package be.edenglen.tournament.ws.www;

import be.edenglen.tournament.ws.model.Inscription;
import be.edenglen.tournament.ws.model.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ws/inscriptions")
public class InscriptionController {

    private final InscriptionService inscriptionService;

    @Autowired
    public InscriptionController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @GetMapping("/{id}")
    public Inscription get(@PathVariable("id") Long id) {
        return inscriptionService.get(id);
    }

    @PostMapping
    public Inscription create(@RequestBody Inscription inscription) {
        return inscriptionService.create(inscription);
    }
}
