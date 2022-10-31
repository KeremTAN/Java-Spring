package gov.tubitak.keremt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ChallengeApp {
    public static void main(String[] args) {
        SpringApplication.run(ChallengeApp.class, args);
    }
}
