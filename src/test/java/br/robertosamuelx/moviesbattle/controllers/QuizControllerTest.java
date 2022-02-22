package br.robertosamuelx.moviesbattle.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.robertosamuelx.moviesbattle.builders.PlayerModelBuilder;
import br.robertosamuelx.moviesbattle.builders.QuizDTOBuilder;
import br.robertosamuelx.moviesbattle.dtos.QuizDTO;
import br.robertosamuelx.moviesbattle.models.PlayerModel;
import br.robertosamuelx.moviesbattle.services.QuizService;

@ExtendWith(MockitoExtension.class)
public class QuizControllerTest {

  @Mock private QuizController quizController;
  @InjectMocks private QuizService quizService;

  @Test
  public void createQuizSuccessfully() {
    QuizDTO quizDTO = QuizDTOBuilder.build();
    PlayerModel playerModel = PlayerModelBuilder.build();
    Mockito.when(quizService.startQuiz(Mockito.any())).thenReturn(quizDTO);
    ResponseEntity<QuizDTO> response = quizController.startQuiz(playerModel);

    Assertions.assertEquals(response.getStatusCode(), HttpStatus.CREATED);
  }
}