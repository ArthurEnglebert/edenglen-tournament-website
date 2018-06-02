package be.edenglen.tournament.ws.model.service;

import be.edenglen.tournament.ws.model.Inscription;

public interface AmountCalculatorService {
    int calculateDue(Inscription inscription);
}
