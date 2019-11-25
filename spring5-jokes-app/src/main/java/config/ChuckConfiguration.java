package config;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

/* @Configuration annotation removed to implement XML configuration */
public class ChuckConfiguration {

    /* @Bean annotation removed to implement XML configuration */
    public ChuckNorrisQuotes chuckNorrisQuotes() {
        return new ChuckNorrisQuotes();
    }
}
