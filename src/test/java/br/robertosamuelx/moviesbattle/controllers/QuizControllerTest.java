package br.robertosamuelx.moviesbattle.controllers;

import br.robertosamuelx.moviesbattle.builders.PlayerDTOBuilder;
import br.robertosamuelx.moviesbattle.builders.QuizDTOBuilder;
import br.robertosamuelx.moviesbattle.dtos.PlayerDTO;
import br.robertosamuelx.moviesbattle.dtos.QuizDTO;
import br.robertosamuelx.moviesbattle.services.QuizService;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class QuizControllerTest {

  @InjectMocks private QuizController quizController;
  @Mock private QuizService quizService;

  @Test
  public void shouldCreateQuizSuccessfully() {
    QuizDTO quizDTO = QuizDTOBuilder.build();
    PlayerDTO playerDTO = PlayerDTOBuilder.builder().mockValues().build();
    Mockito.when(quizService.startQuiz(Mockito.any())).thenReturn(quizDTO);
    ResponseEntity<QuizDTO> response = quizController.startQuiz(playerDTO);

    Assertions.assertEquals(response.getStatusCode(), HttpStatus.CREATED);
  }

  @Test
  public void shouldCloseQuizSuccessfully() {
    UUID quizId = QuizDTOBuilder.build().getQuizId();
    ResponseEntity response = quizController.stopQuiz(quizId);

    Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
  }
}
