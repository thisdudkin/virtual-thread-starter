package by.dudkin.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alexander Dudkin
 */
@RestController
@RequestMapping(value = "/block")
public class ConsumerController {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @GetMapping(value = "/{seconds}")
    public void block(@PathVariable Integer seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
        logger.info("Blocked for {} seconds", seconds);
    }

}
