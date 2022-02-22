package br.robertosamuelx.moviesbattle.controllers;

import br.robertosamuelx.moviesbattle.dtos.AnswerDTO;
import br.robertosamuelx.moviesbattle.dtos.QuizDTO;
import br.robertosamuelx.moviesbattle.dtos.RoundAnswerDTO;
import br.robertosamuelx.moviesbattle.dtos.RoundDTO;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz/round")
public class RoundController {

  @PutMapping("/{roundId}")
  public ResponseEntity<RoundAnswerDTO> answerRound(
      @RequestBody AnswerDTO answer, @PathVariable("roundId") UUID roundId) {

    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @PostMapping
  public ResponseEntity<RoundDTO> nextRound(@RequestBody QuizDTO round) {

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
