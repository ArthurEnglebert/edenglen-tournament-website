package be.edenglen.tournament.ws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${admin.username}")
	private String username;

	@Value("${admin.password}")
	private String password;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/admin/**").authenticated()
				.antMatchers("/**").permitAll()
				.and()
				.formLogin()
				.loginPage("/login")
				.successForwardUrl("/admin")
				.permitAll()
				.and()
				.logout()
				.permitAll()
				.and()
				.headers().frameOptions().sameOrigin()
				.and()
				.csrf()
				.disable();
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username(username)
				.password(password)
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
