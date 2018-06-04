package be.edenglen.tournament.ws.model.service;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import be.edenglen.tournament.ws.model.Inscription;

@Service
public class MailServiceImpl implements MailService {

	private static final String MAIL_FROM = "website@edenglen.be";
	private static final String MAIL_SUBJECT = "Confirmation inscription tournoi";

	private static final String TEMPLATE_LOCATION = "velocity/mailConfirm.vm";

	private final JavaMailSender javaMailSender;

	private final VelocityEngine velocityEngine;

	@Autowired
	public MailServiceImpl(JavaMailSender javaMailSender,
						   VelocityEngine velocityEngine) {
		this.javaMailSender = javaMailSender;
		this.velocityEngine = velocityEngine;
	}

	@Override
	public void sendConfirmationMail(Inscription inscription) {
		try {
			javaMailSender.send(getMimeMessagePreparator(inscription));
		} catch (MailException e) {
			throw new IllegalStateException(e);
		}
	}

	private MimeMessagePreparator getMimeMessagePreparator(Inscription inscription) {
		return (mimeMessage -> {
			MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
			message.setTo(inscription.getEmail());
			message.setFrom(MAIL_FROM);
			message.setSubject(MAIL_SUBJECT);
			message.setText(generateInscriptionConfirmationMessage(inscription), true);
		});
	}

	private String generateInscriptionConfirmationMessage(Inscription inscription) {
		StringWriter result = new StringWriter();
		Map<String, Object> context = new HashMap<>();
		context.put("inscription", inscription);
		VelocityContext velocityContext = new VelocityContext(context);
		velocityEngine.mergeTemplate(TEMPLATE_LOCATION, "UTF-8", velocityContext, result);
		return result.toString();
	}
}
