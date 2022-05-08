package com.examplesecurity.demosecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemosecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemosecurityApplication.class, args);

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		System.out.println(bCryptPasswordEncoder.encode("Tom123"));
		System.out.println(bCryptPasswordEncoder.encode("John123"));

		
		
		/* $2a$10$piylo86pG8/hdz1l3fCfFu7uaR4ol/pwxWXnIORTk2ZMcBRoaCRyu ----- Tom123
		$2a$10$6CoWPTjnf0/GvEI1xYmRtunazEAgGBU2HdZQ4nAxfXOS17i5oVUSW    ----- John123
		*/
		
		
		/*$2a$10$2AjHvz51IcH2xeTt9RvSF.jdHrlmAUyx59X8uf.GPr3qmk7V3LxuO   ----- Tom123
		$2a$10$85CRbxK9PQQtw6rtrVM6XOjg34Fmlnjur19HVWADr2fDnXATsv4Qa    ----- John123 */

		
	}

}

//
