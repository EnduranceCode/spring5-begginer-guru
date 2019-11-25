package guru.springframework.jokes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@Service
public class JokeServiceImpl implements JokeService {

    private final ChuckNorrisQuotes chuckNorrisQuotes;

    @Autowired
    public JokeServiceImpl(ChuckNorrisQuotes chuckNorrisQuotes) {
        super();
        this.chuckNorrisQuotes = chuckNorrisQuotes;
    }

    @Override
    public String getJoke() {

        return this.chuckNorrisQuotes.getRandomQuote();
    }
}
