package br.robertosamuelx.moviesbattle.services;

import br.robertosamuelx.moviesbattle.dtos.AnswerDTO;
import br.robertosamuelx.moviesbattle.dtos.MovieDTO;
import br.robertosamuelx.moviesbattle.dtos.QuizDTO;
import br.robertosamuelx.moviesbattle.dtos.RoundDTO;
import br.robertosamuelx.moviesbattle.exceptions.QuizException;
import br.robertosamuelx.moviesbattle.exceptions.RoundException;
import br.robertosamuelx.moviesbattle.helpers.MovieHelper;
import br.robertosamuelx.moviesbattle.models.MovieModel;
import br.robertosamuelx.moviesbattle.models.QuizModel;
import br.robertosamuelx.moviesbattle.models.RoundModel;
import br.robertosamuelx.moviesbattle.repositories.QuizRepository;
import br.robertosamuelx.moviesbattle.repositories.RoundRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoundService {

  private RoundRepository repository;
  private QuizRepository quizRepository;
  private MovieHelper movieHelper;
  private PlayerService playerService;
  private QuizService quizService;

  private static final Logger LOGGER = LoggerFactory.getLogger(RoundService.class);
  private static final Integer MAX_ATTEMPTS = 3;

  @Autowired
  public RoundService(
      RoundRepository repository,
      QuizRepository quizRepository,
      MovieHelper movieHelper,
      PlayerService playerService,
      QuizService quizService) {
    this.repository = repository;
    this.quizRepository = quizRepository;
    this.movieHelper = movieHelper;
    this.playerService = playerService;
    this.quizService = quizService;
  }

  public RoundDTO createRound(QuizDTO quiz) {
    Optional<QuizModel> quizModelOpt = quizRepository.findById(quiz.getQuizId());

    if (!quizModelOpt.isPresent() || Objects.nonNull(quizModelOpt.get().getClosedAt()))
      throw QuizException.invalidQuiz();

    QuizModel quizModel = quizModelOpt.get();
    List<RoundModel> rounds = quizModel.getRounds();
    rounds.forEach(
        round -> {
          if (!round.getIsAnswered()) throw RoundException.roundNotAnswered();
        });
    return toRoundResponse(repository.save(new RoundModel(quizModel, movieHelper.createPair())));
  }

  private RoundDTO toRoundResponse(RoundModel roundModel) {
    List<MovieDTO> moviesDTO =
        roundModel.getMovies().stream()
            .map(movie -> new MovieDTO(movie.getId(), movie.getName()))
            .collect(Collectors.toList());
    return new RoundDTO(roundModel.getId(), moviesDTO, roundModel.getAttempts());
  }

  public void answer(AnswerDTO answer) {
    Optional<RoundModel> roundModelOpt = repository.findById(answer.getRoundId());

    if (!roundModelOpt.isPresent() || roundModelOpt.get().getIsAnswered())
      throw RoundException.roundAlreadyAnswered();

    RoundModel roundModel = roundModelOpt.get();
    if (roundModel.getAttempts() >= MAX_ATTEMPTS) {
      quizService.stopQuiz(roundModel.getQuiz().getId());
      throw RoundException.maxAttempts();
    }

    MovieModel movieModelWinner = defineWinner(roundModel.getMovies());
    LOGGER.info("name winner: " + movieModelWinner.getName());

    roundModel.setAttempts(roundModel.getAttempts() + 1);
    repository.save(roundModel);

    if (!movieModelWinner.getId().equals(answer.getMovieId()))
      throw RoundException.wrongAnswer(roundModel.getAttempts());

    roundModel.setIsAnswered(true);
    repository.save(roundModel);

    playerService.updateRanking(roundModel.getQuiz());
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
