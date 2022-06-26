package ru.albank.trainee.traineemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"ru.albank.trainee.traineemanager.models" })
@EnableJpaRepositories(basePackages = {"ru.albank.trainee.traineemanager.repo"})
public class TraineemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraineemanagerApplication.class, args);
	}

}
