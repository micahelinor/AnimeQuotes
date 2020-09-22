package AnimeQuotes;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.util.Scanner;


@SpringBootApplication
@RestController
public class AnimeQuotesApplication<quote> {

	public static void main(String[] args) {
		SpringApplication.run(AnimeQuotesApplication.class, args);
	}

	@GetMapping("/BeInspired")
	public String hello(@RequestParam(value = "quote", defaultValue = "Be Inspired!") String name) throws JsonProcessingException, JSONException {
		// request url
		String url = "https://animechanapi.xyz/api/quotes?char={char}";

		// Create a Scanner object
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter Character Name");

		// Read user input
		String characName = myObj.nextLine();
		System.out.println(characName);  // Output user input

		// create an instance of RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// make an HTTP GET request
		String json = restTemplate.getForObject(url, String.class, characName);

		//Converting info from API call to JSON object and formatting.
		JSONObject response = new JSONObject(json);
		String quote = response.getJSONArray("data").getJSONObject(0).getString("quote");
		String character = response.getJSONArray("data").getJSONObject(0).getString("character");

		System.out.println(quote);
		System.out.println(character);
		return String.format("%s: '%s'", characName, quote);
	}

}
