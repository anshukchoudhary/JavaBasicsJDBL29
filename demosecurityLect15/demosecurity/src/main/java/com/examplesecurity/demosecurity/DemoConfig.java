package com.examplesecurity.demosecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DemoConfig extends WebSecurityConfigurerAdapter{
	
	
	private static String DEVELOPER_AUTHORITY = "developer";
	
	private static String DEVOPS_AUTHORITY = "devops";
	
	
	protected void configure(AuthenticationManagerBuilder auth ) throws Exception{
		
		auth.inMemoryAuthentication()
		    .withUser("Tom")
		    .password("$2a$10$piylo86pG8/hdz1l3fCfFu7uaR4ol/pwxWXnIORTk2ZMcBRoaCRyu")
		    .authorities(DEVELOPER_AUTHORITY)
		    .and()
		    .withUser("John")
		    .password("$2a$10$85CRbxK9PQQtw6rtrVM6XOjg34Fmlnjur19HVWADr2fDnXATsv4Qa")
		    .authorities(DEVOPS_AUTHORITY)
		    .and()
		    .withUser("Catalina")
		    .password("Catalina123")
		    .authorities(DEVOPS_AUTHORITY, DEVELOPER_AUTHORITY);
		    
		    
		
	}
	
	// always define your ant matchers from most restricted to least 
	//	.antMatchers(HttpMethod.POST,"/developer/**").hasAuthority(DEVOPS_AUTHORITY)
	protected void configure(HttpSecurity http) throws Exception{
		
		http.httpBasic()
			.and()
		    .authorizeHttpRequests()
			.antMatchers("/devops/**").hasAnyAuthority(DEVOPS_AUTHORITY)
		
			.antMatchers("/developer/**").hasAuthority(DEVELOPER_AUTHORITY)
			.antMatchers("/**").permitAll()
			.and()
			.formLogin();
		
	}
	
	
/*	@Bean
	public PasswordEncoder getPE(){
		return NoOpPasswordEncoder.getInstance();
	}
	*/
	
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
}
