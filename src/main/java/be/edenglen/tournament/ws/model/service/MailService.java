package be.edenglen.tournament.ws.model.service;

import be.edenglen.tournament.ws.model.Inscription;

public interface MailService {
	void sendConfirmationMail(Inscription inscription);
}
