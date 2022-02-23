package br.robertosamuelx.moviesbattle.exceptions;

import static br.robertosamuelx.moviesbattle.constants.IssueConstant.ROUND_ALREADY_ANSWERED_CODE;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.ROUND_ALREADY_ANSWERED_MESSAGE;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.ROUND_ALREADY_ANSWERED_SUBJECT;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.ROUND_NOT_ANSWERED_CODE;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.ROUND_NOT_ANSWERED_MESSAGE;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.ROUND_NOT_ANSWERED_SUBJECT;

public class RoundException extends GlobalException {

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
}
