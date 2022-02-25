package br.robertosamuelx.moviesbattle.configs;

import br.robertosamuelx.moviesbattle.dtos.imdb.MovieImdb;
import br.robertosamuelx.moviesbattle.dtos.imdb.OmdbAPI;
import br.robertosamuelx.moviesbattle.models.MovieModel;
import br.robertosamuelx.moviesbattle.repositories.MovieRepository;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DatabaseConfig {

  @Autowired private MovieRepository movieRepository;
  @Autowired private RestTemplate restTemplate;
  private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConfig.class);

  @Autowired private OmdbAPI omdbApi;

  @PostConstruct
  public void downloadDataFromImdb() {
    LOGGER.info("Downloading data...");

    omdbApi.getMovies().stream()
        .forEach(
            movie -> {
              MovieImdb movieImdb = getInfoByMovie(movie);
              saveMovie(movieImdb);
            });

    LOGGER.info("All done");
  }

  private void saveMovie(MovieImdb movieImdb) {
    movieRepository.save(convertToModel(movieImdb));
  }

  private MovieModel convertToModel(MovieImdb movieImdb) {
    double imdbRating = Double.valueOf(movieImdb.getImdbRating());
    int imdbVotes = Integer.valueOf(movieImdb.getImdbVotes().replace(",", ""));
    return new MovieModel(movieImdb.getTitle(), imdbRating, imdbVotes);
  }

  private MovieImdb getInfoByMovie(String movie) {
    String url = omdbApi.getUrl() + "?apikey=" + omdbApi.getApikey() + "&t=" + movie;
    LOGGER.info(url);
    return restTemplate.getForObject(url, MovieImdb.class);
  }
}
