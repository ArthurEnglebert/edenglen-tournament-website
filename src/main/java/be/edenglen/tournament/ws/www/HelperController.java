package be.edenglen.tournament.ws.www;

import be.edenglen.tournament.ws.model.Helper;
import be.edenglen.tournament.ws.model.service.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/ws/helpers")
public class HelperController {

    private final HelperService helperService;

    @Autowired
    public HelperController(HelperService helperService) {
        this.helperService = helperService;
    }

    @GetMapping("/{id}")
    public Helper get(@PathVariable("id") Long id) {
        return helperService.get(id);
    }

    @PostMapping
    public Helper create(@RequestBody Helper helper) {
        return helperService.create(helper);
    }
}
