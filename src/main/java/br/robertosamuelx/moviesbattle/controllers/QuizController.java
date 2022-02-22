package br.robertosamuelx.moviesbattle.controllers;

import br.robertosamuelx.moviesbattle.dtos.QuizDTO;
import br.robertosamuelx.moviesbattle.exceptions.PlayerException;
import br.robertosamuelx.moviesbattle.models.PlayerModel;
import br.robertosamuelx.moviesbattle.services.QuizService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizController {

  private QuizService service;

  @Autowired
  public QuizController(QuizService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<QuizDTO> startQuiz(@RequestBody PlayerModel player) throws PlayerException {

    QuizDTO startQuiz = service.startQuiz(player);
    return ResponseEntity.status(HttpStatus.CREATED).body(startQuiz);
  }

  @PatchMapping("{quizId}")
  public ResponseEntity stopQuiz(@PathVariable("quizId") UUID quizId) {
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
