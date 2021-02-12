package Model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses= AddressBookController.class)
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepo buddyRepo, AddressBookRepo abRepo) {
        return (args) -> {
            AddressBook ab = new AddressBook();
            ab.setName("ab1");
            BuddyInfo b1 = new BuddyInfo("Jack", "416-525-4070",ab);
            BuddyInfo b2 = new BuddyInfo("Chloe", "416-234-1234", ab);
            ab.addBuddy(b1);
            ab.addBuddy(b2);
            abRepo.save(ab);
            buddyRepo.save(b1);
            buddyRepo.save(b2);
        };
    }
}
