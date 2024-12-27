package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	DemoSecurityRepository demoSecurityRepository;

	@Autowired
	PasswordEncoder passwordEncoder;


	@Override
	public void run(String... args) throws Exception {
			/*DemoUser demoUser  = DemoUser.builder()
					.username("anup@gmail.com")
					.password(passwordEncoder.encode("anup1234"))
					.authorities(Constants.DEO_DETAILS_AUTHORITY+ Constants.DELIMITER + Constants.SCHEDULE_APPOINTMENTS_AUTHORITY)
					.build();

		DemoUser demoUser2  = DemoUser.builder()
				.username("ashu@gmail.com")
				.password(passwordEncoder.encode("ashu1234"))
				.authorities(Constants.DOCTOR_DETAILS_AUTHORITY)
				.build();

		demoSecurityRepository.saveAll(Arrays.asList(demoUser, demoUser2)); */
	}
}
