package com.douzone.container.config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.videosystem.DVDPlayer;

@Configuration
public class DVDPlayerConfig {
	@Bean
	public DVDPlayer DVDPlayer() {
		return new DVDPlayer();
	}
}
