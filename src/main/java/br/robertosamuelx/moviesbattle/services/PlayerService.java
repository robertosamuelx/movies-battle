package br.robertosamuelx.moviesbattle.services;

import br.robertosamuelx.moviesbattle.dtos.PlayerDTO;
import br.robertosamuelx.moviesbattle.models.PlayerModel;
import br.robertosamuelx.moviesbattle.models.QuizModel;
import br.robertosamuelx.moviesbattle.repositories.PlayerRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

  private PlayerRepository repository;

  @Autowired
  public PlayerService(PlayerRepository repository) {
    this.repository = repository;
  }

  public PlayerDTO createPlayer(PlayerModel player) {
    PlayerModel playerModel = repository.save(player);

    return toPlayerResponse(playerModel);
  }

  public List<PlayerDTO> getRanking() {
    List<PlayerModel> findAllByOrderByRanking = repository.findAllByOrderByRankingDesc();

    return findAllByOrderByRanking.stream()
        .map(player -> toPlayerResponse(player))
        .collect(Collectors.toList());
  }

  public void updateRanking(QuizModel quiz) {
    PlayerModel playerModel = repository.findById(quiz.getPlayer().getId()).get();
    playerModel.setRanking(playerModel.getRanking() + 1);
    repository.save(playerModel);
  }

  private PlayerDTO toPlayerResponse(PlayerModel playerModel) {
    return new PlayerDTO(
        playerModel.getId(),
        playerModel.getName(),
        playerModel.getRanking(),
        playerModel.getIsPlaying());
  }
}
