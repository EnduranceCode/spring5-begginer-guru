package guru.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({ "en", "default" })
@Primary
public class PrimaryGreetingService implements GreetingService {

    private GreetingRepository greetingRepository;

    /*
     * With constructor injection, the Autowired annotation is not necessary but
     * it can be a good idea to use anyway because it makes our intentions more
     * explicit. The string value of the qualifier corresponds to the name of
     * the implementation class in camel case.
     */
    @Autowired
    public PrimaryGreetingService(GreetingRepository greetingRepository) {
        super();
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getEnglishGreeting();
    }
}