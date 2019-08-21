package com.example.friendnotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FriendNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendNotesApplication.class, args);
	}

}
