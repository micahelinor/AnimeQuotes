package AnimeQuotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;
import org.json.*;

@SpringBootApplication
@RestController
public class AnimeQuotesApplication {

	String mainUrl;
	public AnimeQuotesApplication() {
		mainUrl = "https://animechanapi.xyz/api/quotes/random";
	}

	public static void main(String[] args) {
		SpringApplication.run(AnimeQuotesApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	//Converting to URL
	URL url = new URL(newURL.toString());

	//Opening API Connection and making it a GET Request
	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		
}
