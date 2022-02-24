package br.robertosamuelx.moviesbattle.repositories;

import br.robertosamuelx.moviesbattle.models.MovieModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieModel, UUID> {}
