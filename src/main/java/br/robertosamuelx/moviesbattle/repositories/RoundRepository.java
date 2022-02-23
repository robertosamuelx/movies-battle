package br.robertosamuelx.moviesbattle.repositories;

import br.robertosamuelx.moviesbattle.models.RoundModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoundRepository extends JpaRepository<RoundModel, UUID> {}
