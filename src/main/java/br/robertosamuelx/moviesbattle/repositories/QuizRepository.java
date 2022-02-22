package br.robertosamuelx.moviesbattle.repositories;

import br.robertosamuelx.moviesbattle.models.QuizModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<QuizModel, UUID> {}
