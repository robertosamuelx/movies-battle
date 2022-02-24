package br.robertosamuelx.moviesbattle.configs;

import br.robertosamuelx.moviesbattle.models.MovieModel;
import br.robertosamuelx.moviesbattle.models.PlayerModel;
import br.robertosamuelx.moviesbattle.repositories.MovieRepository;
import br.robertosamuelx.moviesbattle.repositories.PlayerRepository;
import java.util.Random;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConfig {

  @Autowired private PlayerRepository playerRepository;
  @Autowired private MovieRepository movieRepository;
  private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConfig.class);

  @PostConstruct
  public void downloadDataFromImdb() {
    LOGGER.info("Downloading data...");
  }

  @PostConstruct
  public void createPlayers() {
    PlayerModel player1 = new PlayerModel();
    player1.setIsPlaying(false);
    player1.setLogin("robertosamuelx");
    player1.setName("Beto");
    player1.setPassword("123");
    player1.setRanking(0);
    playerRepository.save(player1);

    PlayerModel player2 = new PlayerModel();
    player2.setIsPlaying(false);
    player2.setLogin("robertosamuelx2");
    player2.setName("Beto2");
    player2.setPassword("123");
    player2.setRanking(0);
    playerRepository.save(player2);
  }

  @PostConstruct
  public void createMovies() {
    for (int i = 0; i < 10; i++) {
      MovieModel movie = new MovieModel();
      movie.setImdbRating(new Random().nextDouble() * 10.0);
      movie.setImdbVotes(new Random().nextInt(100));
      movie.setName("Movie_" + i);
      movieRepository.save(movie);
    }
  }
}
