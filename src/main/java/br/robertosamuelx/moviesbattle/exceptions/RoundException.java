package br.robertosamuelx.moviesbattle.exceptions;

import static br.robertosamuelx.moviesbattle.constants.IssueConstant.MAX_ATTEMPTS_CODE;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.MAX_ATTEMPTS_MESSAGE;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.MAX_ATTEMPTS_SUBJECT;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.ROUND_ALREADY_ANSWERED_CODE;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.ROUND_ALREADY_ANSWERED_MESSAGE;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.ROUND_ALREADY_ANSWERED_SUBJECT;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.ROUND_NOT_ANSWERED_CODE;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.ROUND_NOT_ANSWERED_MESSAGE;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.ROUND_NOT_ANSWERED_SUBJECT;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.WRONG_ANSWER_CODE;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.WRONG_ANSWER_MESSAGE;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.WRONG_ANSWER_SUBJECT;

public class RoundException extends GlobalException {

  private static final Integer MAX_ATTEMPTS = 3;

  protected RoundException(Issue issue) {
    super(issue);
  }

  private static final long serialVersionUID = -8057294119626627071L;

  public static RoundException roundNotAnswered() {
    return new RoundException(
        new Issue(ROUND_NOT_ANSWERED_SUBJECT, ROUND_NOT_ANSWERED_MESSAGE, ROUND_NOT_ANSWERED_CODE));
  }

  public static RoundException roundAlreadyAnswered() {
    return new RoundException(
        new Issue(
            ROUND_ALREADY_ANSWERED_SUBJECT,
            ROUND_ALREADY_ANSWERED_MESSAGE,
            ROUND_ALREADY_ANSWERED_CODE));
  }

  public static RoundException wrongAnswer(Integer attempts) {
    Integer ramainingAttempts = MAX_ATTEMPTS - attempts;
    return new RoundException(
        new Issue(
            WRONG_ANSWER_SUBJECT,
            String.format(WRONG_ANSWER_MESSAGE, ramainingAttempts),
            WRONG_ANSWER_CODE));
  }

  public static RoundException maxAttempts() {
    return new RoundException(
        new Issue(
            MAX_ATTEMPTS_SUBJECT,
            String.format(MAX_ATTEMPTS_MESSAGE, MAX_ATTEMPTS),
            MAX_ATTEMPTS_CODE));
  }
}
