package com.example.quizapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class QuizApiApplication implements CommandLineRunner {

	private final InitGame initGame;

	public QuizApiApplication(InitGame initGame) {
		this.initGame = initGame;
	}

	public static void main(String[] args) {
		SpringApplication.run(QuizApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("************************Initializing Game**************************");
		initGame.initGame();
		log.info("************************Start Playing the Game**************************");

	}
}
