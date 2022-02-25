package br.robertosamuelx.moviesbattle.controllers;

import br.robertosamuelx.moviesbattle.dtos.PlayerDTO;
import br.robertosamuelx.moviesbattle.dtos.QuizDTO;
import br.robertosamuelx.moviesbattle.services.QuizService;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizController {

  private QuizService service;

  private static final Logger LOGGER = LoggerFactory.getLogger(QuizController.class);

  @Autowired
  public QuizController(QuizService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<QuizDTO> startQuiz(@RequestBody PlayerDTO player) {

    LOGGER.info("Starting new quiz - playerId: {}", player.getPlayerId());
    QuizDTO startQuiz = service.startQuiz(player);

    LOGGER.info("New quiz has started - quizId: {}", startQuiz.getQuizId());
    return ResponseEntity.status(HttpStatus.CREATED).body(startQuiz);
  }

  @DeleteMapping("/{quizId}")
  public ResponseEntity stopQuiz(@PathVariable("quizId") @NotBlank UUID quizId) {
    LOGGER.info("Stopping quiz - quizId: {}", quizId);
    service.stopQuiz(quizId);
    LOGGER.info("Quiz has stopped");
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
