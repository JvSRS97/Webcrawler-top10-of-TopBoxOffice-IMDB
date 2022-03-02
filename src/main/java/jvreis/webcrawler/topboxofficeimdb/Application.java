package jvreis.webcrawler.topboxofficeimdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jvreis.webcrawler.topboxofficeimdb.services.WebcrawlerConfiguration;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Webscrapingf1Application.class, args);
		new WebcrawlerConfiguration();
	}

}
