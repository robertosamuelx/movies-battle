package br.robertosamuelx.moviesbattle.repositories;

import br.robertosamuelx.moviesbattle.models.PlayerModel;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerModel, UUID> {

  List<PlayerModel> findAllByOrderByRankingDesc();
}
