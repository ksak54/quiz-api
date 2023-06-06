package com.example.quizapi;

import com.example.quizapi.service.startup.ApiIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import sun.tools.jar.CommandLine;

@SpringBootApplication
public class QuizApiApplication implements CommandLineRunner {

	public QuizApiApplication(InitGame initGame) {
		this.initGame = initGame;
	}

	private final InitGame initGame;

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(QuizApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initGame.initGame();
	}
}
