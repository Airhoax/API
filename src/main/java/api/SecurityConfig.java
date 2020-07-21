package api;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("warehouse")
			.password("skladište")
			.roles("warehouse")
			.and()
			.withUser("sales")
			.password("prodaja")
			.roles("sales");
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/index").access("hasRole('sales') or hasRole('warehouse')")
			.antMatchers("/part/**").hasRole("warehouse")
			.antMatchers("/article/**","/action/**","/offers").hasRole("sales")
			.antMatchers("/**").hasRole("admin")
			.and().formLogin()
            .defaultSuccessUrl("/index", true);
		
	}
}