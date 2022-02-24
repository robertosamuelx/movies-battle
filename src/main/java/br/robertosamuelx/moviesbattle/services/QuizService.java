package br.robertosamuelx.moviesbattle.services;

import br.robertosamuelx.moviesbattle.dtos.PlayerDTO;
import br.robertosamuelx.moviesbattle.dtos.QuizDTO;
import br.robertosamuelx.moviesbattle.dtos.RoundDTO;
import br.robertosamuelx.moviesbattle.exceptions.PlayerException;
import br.robertosamuelx.moviesbattle.exceptions.QuizException;
import br.robertosamuelx.moviesbattle.models.PlayerModel;
import br.robertosamuelx.moviesbattle.models.QuizModel;
import br.robertosamuelx.moviesbattle.models.RoundModel;
import br.robertosamuelx.moviesbattle.repositories.PlayerRepository;
import br.robertosamuelx.moviesbattle.repositories.QuizRepository;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

  private QuizRepository repository;
  private PlayerRepository playerRepository;

  @Autowired
  public QuizService(QuizRepository repository, PlayerRepository playerRepository) {
    this.repository = repository;
    this.playerRepository = playerRepository;
  }

  public QuizDTO startQuiz(PlayerDTO player) throws PlayerException {
    Optional<PlayerModel> playerModelOpt = playerRepository.findById(player.getPlayerId());

    if (!playerModelOpt.isPresent() || playerModelOpt.get().getIsPlaying())
      throw PlayerException.invalidPlayer();

    PlayerModel playerModel = playerModelOpt.get();
    playerModel.setIsPlaying(true);
    playerRepository.save(playerModel);

    return toQuizResponse(repository.save(new QuizModel(new ArrayList<RoundModel>(), playerModel)));
  }

  public QuizDTO toQuizResponse(QuizModel quiz) {
    List<RoundDTO> rounds =
        quiz.getRounds().stream().map(round -> new RoundDTO()).collect(Collectors.toList());
    return new QuizDTO(quiz.getId(), rounds);
  }

  public void stopQuiz(UUID quizId) {
    Optional<QuizModel> quizModelOpt = repository.findById(quizId);

    if (!quizModelOpt.isPresent() || Objects.nonNull(quizModelOpt.get().getClosedAt()))
      throw QuizException.invalidQuiz();

    QuizModel quizModel = quizModelOpt.get();
    quizModel.setClosedAt(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
    repository.save(quizModel);

    PlayerModel player = quizModel.getPlayer();
    player.setIsPlaying(false);
    playerRepository.save(player);
  }
}
