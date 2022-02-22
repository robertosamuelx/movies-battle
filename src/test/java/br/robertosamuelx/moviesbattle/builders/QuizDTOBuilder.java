package br.robertosamuelx.moviesbattle.builders;

import br.robertosamuelx.moviesbattle.dtos.QuizDTO;
import br.robertosamuelx.moviesbattle.dtos.RoundDTO;
import java.util.ArrayList;
import java.util.UUID;

public class QuizDTOBuilder {

  public static QuizDTO build() {
    return new QuizDTO(UUID.randomUUID(), new ArrayList<RoundDTO>());
  }
}
