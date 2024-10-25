package by.dudkin.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

/**
 * @author Alexander Dudkin
 */
@RestController
public class ProducerController {

    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);
    private final RestClient restClient;

    public ProducerController(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("http://localhost:4441")
                .build();
    }

    @GetMapping("/block/{seconds}")
    public String produce(@PathVariable Integer seconds) {
        ResponseEntity<Void> result = this.restClient.get()
                .uri("/block/" + seconds)
                .retrieve()
                .toBodilessEntity();

        logger.info("{} on {}", result.getStatusCode(), Thread.currentThread());

        return Thread.currentThread().toString();
    }

}
