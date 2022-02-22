package br.robertosamuelx.moviesbattle.repositories;

import br.robertosamuelx.moviesbattle.models.PlayerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerModel, Long> {}
