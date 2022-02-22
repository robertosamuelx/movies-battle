package br.robertosamuelx.moviesbattle.services;

import br.robertosamuelx.moviesbattle.dtos.QuizDTO;
import br.robertosamuelx.moviesbattle.dtos.RoundDTO;
import br.robertosamuelx.moviesbattle.exceptions.PlayerException;
import br.robertosamuelx.moviesbattle.models.PlayerModel;
import br.robertosamuelx.moviesbattle.models.QuizModel;
import br.robertosamuelx.moviesbattle.models.RoundModel;
import br.robertosamuelx.moviesbattle.repositories.PlayerRepository;
import br.robertosamuelx.moviesbattle.repositories.QuizRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

  public QuizDTO startQuiz(PlayerModel player) throws PlayerException {
    Optional<PlayerModel> playerModel = playerRepository.findById(player.getId());

    if (!playerModel.isPresent() || playerModel.get().getIsPlaying())
      throw PlayerException.invalidPlayer();

    return toQuizResponse(
        repository.save(new QuizModel(new ArrayList<RoundModel>(), playerModel.get())));
  }

  public QuizDTO toQuizResponse(QuizModel quiz) {
    List<RoundDTO> rounds =
        quiz.getRounds().stream().map(round -> new RoundDTO()).collect(Collectors.toList());
    return new QuizDTO(quiz.getId(), rounds);
  }
}
