package guru.springframework.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    public static final String HELLO_GURUS = "Hello Gurus! - I was injected by the property.";

    @Override
    public String sayGreeting() {
        return HELLO_GURUS;
    }
}
