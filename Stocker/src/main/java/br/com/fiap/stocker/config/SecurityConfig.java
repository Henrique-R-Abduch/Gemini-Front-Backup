package br.com.fiap.stocker.config;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
=======
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
>>>>>>> 477b2826d31c0d3d10f1d28c15240a7875e16294

@Configuration
public class SecurityConfig {
    
<<<<<<< HEAD
	@Autowired
	AuthenticationFilter authenticationFilter;


=======
>>>>>>> 477b2826d31c0d3d10f1d28c15240a7875e16294
    @Bean
SecurityFilterChain web(HttpSecurity http) throws Exception {
	http
		.authorizeHttpRequests((authorize) -> authorize
<<<<<<< HEAD
			.requestMatchers("/login", "/usuario").permitAll()
			.anyRequest().authenticated()
			)
		.csrf(crsf -> crsf.disable())
		.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
=======

			.anyRequest().permitAll()
			)
		.csrf(crsf -> crsf.disable());
>>>>>>> 477b2826d31c0d3d10f1d28c15240a7875e16294

	return http.build();
}

<<<<<<< HEAD

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

=======
>>>>>>> 477b2826d31c0d3d10f1d28c15240a7875e16294
}
