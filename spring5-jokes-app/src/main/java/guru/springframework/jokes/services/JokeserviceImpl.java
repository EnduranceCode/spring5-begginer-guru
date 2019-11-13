package guru.springframework.jokes.services;

import org.springframework.stereotype.Service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@Service
public class JokeServiceImpl implements JokeService {

    ChuckNorrisQuotes joke = new ChuckNorrisQuotes();

    @Override
    public String getJoke() {
        return this.joke.getRandomQuote();
    }
}
