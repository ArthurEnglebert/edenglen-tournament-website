package be.edenglen.tournament.ws.config;

import java.util.Properties;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	@Value("${javax.mail.username}")
	private String username;
	@Value("${javax.mail.password}")
	private String password;
	@Value("${javax.mail.host}")
	private String host;
	@Value("${javax.mail.port}")
	private int port;
	@Value("${javax.mail.protocol}")
	private String protocol;
	@Value("${javax.mail.auth}")
	private String auth;
	@Value("${javax.mail.starttls}")
	private String starttls;
	@Value("${javax.mail.ssl}")
	private String ssl;

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setDefaultEncoding("UTF-8");
		mailSender.setHost(host);
		mailSender.setPort(port);

		mailSender.setUsername(username);
		mailSender.setPassword(password);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", protocol);
		props.put("mail.smtp.auth", auth);
		props.put("mail.smtp.starttls.enable", starttls);
		props.put("mail.imap.ssl.enable", ssl);
//		props.put("mail.debug", "true");

		return mailSender;
	}

	@Bean
	public VelocityEngine velocityEngine() {
		Properties properties = new Properties();
		properties.setProperty("resource.loader", "class");
		properties.setProperty("class.resource.loader.class", ClasspathResourceLoader.class.getName());
		return new VelocityEngine(properties);
	}
}
