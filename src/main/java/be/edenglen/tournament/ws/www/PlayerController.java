package be.edenglen.tournament.ws.www;

import be.edenglen.tournament.ws.model.Player;
import be.edenglen.tournament.ws.model.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ws/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{id}")
    public Player get(@PathVariable("id") Long id) {
        return playerService.get(id);
    }

    @PostMapping
    public Player create(@RequestBody Player player) {
        return playerService.create(player);
    }
}
