package com.k3nli.pruebaspringsecurityjwt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.k3nli.pruebaspringsecurityjwt.persistence.entities.RoleEnum;
import com.k3nli.pruebaspringsecurityjwt.persistence.entities.UserEntity;
import com.k3nli.pruebaspringsecurityjwt.persistence.repository.iUserRepository;

@SpringBootApplication
public class SpringsecurityjwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityjwtApplication.class, args);
	}

	@Autowired
	private PasswordEncoder encoder;

	@Bean	
	CommandLineRunner init(iUserRepository repository) {
		return args -> {
			UserEntity admin = UserEntity.builder()
			.email("correo@gmail.com")
			.username("administrador")
			.password(encoder.encode("administrador"))
			.role(RoleEnum.ADMIN)
			.build();

			UserEntity invited = UserEntity.builder()
				.email("correo@gmail.com")
				.username("invited")
				.password(encoder.encode("invited"))
				.role(RoleEnum.INVITED)
				.build();

			repository.saveAll(List.of(admin, invited));
		};
	}
}