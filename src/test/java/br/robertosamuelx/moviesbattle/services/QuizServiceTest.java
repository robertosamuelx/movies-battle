package br.robertosamuelx.moviesbattle.services;

import br.robertosamuelx.moviesbattle.builders.PlayerDTOBuilder;
import br.robertosamuelx.moviesbattle.builders.PlayerModelBuilder;
import br.robertosamuelx.moviesbattle.builders.QuizModelBuilder;
import br.robertosamuelx.moviesbattle.dtos.PlayerDTO;
import br.robertosamuelx.moviesbattle.dtos.QuizDTO;
import br.robertosamuelx.moviesbattle.models.PlayerModel;
import br.robertosamuelx.moviesbattle.models.QuizModel;
import br.robertosamuelx.moviesbattle.repositories.PlayerRepository;
import br.robertosamuelx.moviesbattle.repositories.QuizRepository;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class QuizServiceTest {

  @InjectMocks private QuizService quizService;

  @Mock private PlayerRepository playerRepository;

  @Mock private QuizRepository quizRepository;

  @Test
  public void shouldCreateQuizSuccessfully() {
    PlayerDTO playerDTO = PlayerDTOBuilder.builder().mockValues().build();
    Optional<PlayerModel> player = Optional.of(PlayerModelBuilder.builder().mockValues().build());
    QuizModel quiz = QuizModelBuilder.builder().mockValues().build();
    Mockito.when(playerRepository.findById(Mockito.any(UUID.class))).thenReturn(player);
    Mockito.when(quizRepository.save(Mockito.any(QuizModel.class))).thenReturn(quiz);
    QuizDTO startQuiz = quizService.startQuiz(playerDTO);

    Assertions.assertNotNull(startQuiz);
    Assertions.assertTrue(startQuiz.getRounds().isEmpty());
  }
}
