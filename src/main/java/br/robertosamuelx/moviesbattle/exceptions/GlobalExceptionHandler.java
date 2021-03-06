package br.robertosamuelx.moviesbattle.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(value = PlayerException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  protected Issue playerException(PlayerException ex, WebRequest request) {
    LOGGER.error("player Exception");
    return ex.getIssue();
  }

  @ExceptionHandler(value = QuizException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  protected Issue quizException(QuizException ex, WebRequest request) {
    LOGGER.error("quiz Exception");
    return ex.getIssue();
  }

  @ExceptionHandler(value = RoundException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  protected Issue roundException(RoundException ex, WebRequest request) {
    LOGGER.error("round Exception");
    return ex.getIssue();
  }
}
