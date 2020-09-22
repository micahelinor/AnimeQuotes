package AnimeQuotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class AnimeQuotesApplication<input, quote> {

	public static void main(String[] args) {
		SpringApplication.run(AnimeQuotesApplication.class, args);
	}

	@GetMapping("/hello")
	public void hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		// request url
		String url = "https://animechanapi.xyz/api/quotes/random";

		// create an instance of RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// make an HTTP GET request
		String json = restTemplate.getForObject(url, String.class);

		// print json
		System.out.println(json);
	}
}
