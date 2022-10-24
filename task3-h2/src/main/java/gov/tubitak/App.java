package gov.tubitak;

import gov.tubitak.models.PersonEntity;
import gov.tubitak.repositories.PersonRepository;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App.class, args);
        PersonRepository repository = configurableApplicationContext.getBean(PersonRepository.class);

        PersonEntity firstPerson = new PersonEntity("Iş", "T");
        PersonEntity secondPerson = new PersonEntity("Kerem", "T");
        PersonEntity thirdPerson = new PersonEntity("Eren", "T");

        repository.save(firstPerson);
        repository.save(secondPerson);
        repository.save(thirdPerson);

    }
}
