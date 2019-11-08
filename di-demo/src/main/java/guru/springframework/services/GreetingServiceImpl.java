package guru.springframework.services;

public class GreetingServiceImpl implements GreetinService {

    public static final String HELLO_GURUS = "Hello Gurus!";

    @Override
    public String sayGreeting() {
        return HELLO_GURUS;
    }
}
