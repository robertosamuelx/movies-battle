package br.robertosamuelx.moviesbattle.services;

import br.robertosamuelx.moviesbattle.dtos.MovieDTO;
import br.robertosamuelx.moviesbattle.dtos.QuizDTO;
import br.robertosamuelx.moviesbattle.dtos.RoundDTO;
import br.robertosamuelx.moviesbattle.exceptions.QuizException;
import br.robertosamuelx.moviesbattle.exceptions.RoundException;
import br.robertosamuelx.moviesbattle.models.MovieModel;
import br.robertosamuelx.moviesbattle.models.QuizModel;
import br.robertosamuelx.moviesbattle.models.RoundModel;
import br.robertosamuelx.moviesbattle.repositories.QuizRepository;
import br.robertosamuelx.moviesbattle.repositories.RoundRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoundService {

  private RoundRepository repository;
  private QuizRepository quizRepository;

  private static final Logger LOGGER = LoggerFactory.getLogger(RoundService.class);

  @Autowired
  public RoundService(RoundRepository repository, QuizRepository quizRepository) {
    this.repository = repository;
    this.quizRepository = quizRepository;
  }

  public RoundDTO createRound(QuizDTO quiz) {
    Optional<QuizModel> quizModelOpt = quizRepository.findById(quiz.getId());

    if (!quizModelOpt.isPresent() || Objects.nonNull(quizModelOpt.get().getClosedAt()))
      throw QuizException.invalidQuiz();

    QuizModel quizModel = quizModelOpt.get();
    List<RoundModel> rounds = quizModel.getRounds();
    rounds.forEach(
        round -> {
          if (!round.getIsAnswered()) throw RoundException.roundNotAnswered();
        });
    return toRoundResponse(repository.save(new RoundModel(quizModel, new ArrayList<MovieModel>())));
  }

  private RoundDTO toRoundResponse(RoundModel roundModel) {
    List<MovieDTO> moviesDTO =
        roundModel.getMovies().stream()
            .map(
                movie -> new MovieDTO(movie.getName(), movie.getImdbRating(), movie.getImdbVotes()))
            .collect(Collectors.toList());
    return new RoundDTO(moviesDTO, roundModel.getAttempts());
  }

  public void answer(UUID answerId, UUID roundId) {
    Optional<RoundModel> roundModelOpt = repository.findById(roundId);

    if (!roundModelOpt.isPresent() || roundModelOpt.get().getIsAnswered())
      throw RoundException.roundAlreadyAnswered();

    MovieModel movieModelWinner = defineWinner(roundModelOpt.get().getMovies());

    // if(!movieModelWinner.getId().equals(answerId))
  }

  private MovieModel defineWinner(List<MovieModel> movies) {
    if (Objects.isNull(movies) || movies.isEmpty()) return null;

    MovieModel first = movies.get(0);

    return movies.stream()
        .reduce(
            first,
            (winner, movie) -> {
              double points = movie.getImdbRating() * movie.getImdbVotes();
              double winnerPoints = winner.getImdbRating() * winner.getImdbVotes();
              if (points > winnerPoints) return movie;

              return winner;
            });
  }
}
