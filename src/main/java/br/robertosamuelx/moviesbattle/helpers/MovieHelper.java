package br.robertosamuelx.moviesbattle.helpers;

import br.robertosamuelx.moviesbattle.models.MovieModel;
import br.robertosamuelx.moviesbattle.models.RoundModel;
import br.robertosamuelx.moviesbattle.repositories.MovieRepository;
import br.robertosamuelx.moviesbattle.repositories.RoundRepository;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieHelper {

  private MovieRepository repository;
  private RoundRepository roundRepository;

  private static final Logger LOGGER = LoggerFactory.getLogger(MovieHelper.class);

  @Autowired
  public MovieHelper(MovieRepository repository, RoundRepository roundRepository) {
    this.repository = repository;
    this.roundRepository = roundRepository;
  }

  public List<MovieModel> createPair() {

    List<MovieModel> allMovies = repository.findAll();
    List<RoundModel> allRounds = roundRepository.findAll();

    List<MovieModel> pairMovies = null;
    boolean roundHasCreated = true;
    LOGGER.info("Creating pair...");
    do {
      pairMovies = chooseMovies(allMovies);
      roundHasCreated = hasCreated(pairMovies, allRounds);
    } while (roundHasCreated);

    return pairMovies;
  }

  public boolean hasCreated(List<MovieModel> movies, List<RoundModel> allRounds) {

    List<RoundModel> filteredMovies =
        allRounds.stream()
            .parallel()
            .filter(round -> round.getMovies().retainAll(movies))
            .collect(Collectors.toList());

    return !filteredMovies.isEmpty();
  }

  public List<MovieModel> chooseMovies(List<MovieModel> movies) {
    Random rd = new Random();
    int indexMovie = rd.nextInt(movies.size() - 1);
    int indexMovie2 = rd.nextInt(movies.size() - 1);

    while (indexMovie2 == indexMovie) indexMovie2 = rd.nextInt(movies.size() - 1);

    LOGGER.info("index: {}\tindex2: {}", indexMovie, indexMovie2);

    return List.of(movies.get(indexMovie), movies.get(indexMovie2));
  }
}
