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


@SpringBootApplication
@RestController
public class AnimeQuotesApplication<quote> {

	public static void main(String[] args) {
		SpringApplication.run(AnimeQuotesApplication.class, args);
	}

	@GetMapping("/hello")
	public void hello(@RequestParam(value = "name", defaultValue = "World") String name) throws JsonProcessingException, JSONException {
		// request url
		String url = "https://animechanapi.xyz/api/quotes/random";

		// create an instance of RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// make an HTTP GET request
		String json = restTemplate.getForObject(url, String.class);

		//Converting info from API call to JSON object and formatting.
		JSONObject response = new JSONObject(json);
		String quote = response.getJSONArray("data").getJSONObject(0).getString("quote");
		String character = response.getJSONArray("data").getJSONObject(0).getString("character");

		System.out.println(quote);
		System.out.println(character);
		//return String.format("Hello %s!", name);
	}

}
