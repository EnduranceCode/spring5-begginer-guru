package guru.services;

import org.springframework.stereotype.Repository;

@Repository
public class GreetingRepositoryImpl implements GreetingRepository {

    @Override
    public String getEnglishGreeting() {
        return "Hello Gurus! - Primary Greeting Service.";
    }

    @Override
    public String getSpanishGreeting() {
        return "Hola Gurus! - Servicio de Saludo Primario.";
    }

    @Override
    public String getGermanGreeting() {
        return "Hallo Gurus! - Primärer Begrüßungsdienst.";
    }
}
