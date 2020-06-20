package com.realengagement.homeschool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.realengagement.homeschool.jpa.repositories.UsersRepository;
import com.realengagement.homeschool.services.streaming.YoutubeLiveStreaming;

@SpringBootApplication
public class HomeschoolApplication {

	Logger logger  = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(HomeschoolApplication.class, args);
	}
	
	@Autowired
	YoutubeLiveStreaming youtubeLiveStreamer; 

	@Bean
	public CommandLineRunner demo(UsersRepository repository) {
		return (args) -> {
//			YouTube youtubeService = youtubeLiveStreamer.getService(); 
//			
//			LiveBroadcast broadcast = youtubeLiveStreamer.insertBroadcast(youtubeService); 
//			LiveStream stream = youtubeLiveStreamer.insertLiveStream(youtubeService); 
//			youtubeLiveStreamer.bindStreamToBroadcast(youtubeService, broadcast, stream);
			
//			youtubeService.channels()
//				.list(Arrays.asList("snippet"))
//				.forEach((a, b) -> System.out.println("channel: " + a + ", " + b));
		};
	}
}
