package com.douzone.container.config.videosystem.mixing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

/**
 * 								  import
 * JavaConfig2(DVDPlayerConfig  <-------- JavaConfig1
 *
 * JavaConfig2 + JavaConfig1 
 * 
 * 
 */


@Configuration
@Import({DVDConfig.class})
public class DVDPlayerConfig {
	// 첫번째 임포트 방법.. 
	@Bean
	public DVDPlayer dvdPlayer01(DigitalVideoDisc dvd) { //파라미터 방식만 사용가능 이 클래스파일에 없고 임포트한 클래스에 있으니깐 ㅇㅇ  
		return new DVDPlayer(dvd);
	}
}
