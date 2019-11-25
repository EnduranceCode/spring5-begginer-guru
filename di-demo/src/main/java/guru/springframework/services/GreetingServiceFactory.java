package guru.springframework.services;

import org.springframework.beans.factory.annotation.Autowired;

public class GreetingServiceFactory {

    private GreetingRepository greetingRepository;

    @Autowired
    public GreetingServiceFactory(GreetingRepository greetingRepository) {
        super();
        this.greetingRepository = greetingRepository;
    }

    public GreetingService createGreetingService(String lang) {

        switch (lang) {
        case "en":
            return new PrimaryGreetingService(greetingRepository);
        case "es":
            return new PrimarySpanishGreetingService(greetingRepository);
        case "de":
            return new PrimaryGermanGreetingService(greetingRepository);
        default:
            return new PrimaryGreetingService(greetingRepository);
        }
    }
}
