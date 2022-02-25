package br.robertosamuelx.moviesbattle.builders;

import br.robertosamuelx.moviesbattle.models.PlayerModel;
import br.robertosamuelx.moviesbattle.models.QuizModel;
import br.robertosamuelx.moviesbattle.models.RoundModel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class QuizModelBuilder {
  private QuizModel quiz;

  public QuizModelBuilder(QuizModel quiz) {
    this.quiz = quiz;
  }

  public static QuizModelBuilder builder() {
    return new QuizModelBuilder(new QuizModel());
  }

  public QuizModelBuilder mockValues() {
    quiz.setId(UUID.randomUUID());
    quiz.setPlayer(getPlayer());
    quiz.setRounds(new ArrayList<RoundModel>());
    quiz.setStartedAt(LocalDateTime.now());
    return this;
  }

  private PlayerModel getPlayer() {
    return PlayerModelBuilder.builder().mockValues().build();
  }

  public QuizModel build() {
    return quiz;
  }
}
