package br.robertosamuelx.moviesbattle.controllers;

import br.robertosamuelx.moviesbattle.dtos.AnswerDTO;
import br.robertosamuelx.moviesbattle.dtos.QuizDTO;
import br.robertosamuelx.moviesbattle.dtos.RoundAnswerDTO;
import br.robertosamuelx.moviesbattle.dtos.RoundDTO;
import br.robertosamuelx.moviesbattle.services.RoundService;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz/round")
public class RoundController {

  private RoundService service;

  @Autowired
  public RoundController(RoundService service) {
    this.service = service;
  }

  @PutMapping
  public ResponseEntity<RoundAnswerDTO> answerRound(@RequestBody @NotBlank AnswerDTO answer) {

    service.answer(answer);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @PostMapping
  public ResponseEntity<RoundDTO> nextRound(@RequestBody QuizDTO quiz) {

    RoundDTO createRound = service.createRound(quiz);
    return ResponseEntity.status(HttpStatus.CREATED).body(createRound);
  }
}
