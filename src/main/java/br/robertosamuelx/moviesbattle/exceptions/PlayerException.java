package br.robertosamuelx.moviesbattle.exceptions;

import static br.robertosamuelx.moviesbattle.constants.IssueConstant.INVALID_PLAYER_CODE;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.INVALID_PLAYER_MESSAGE;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.INVALID_PLAYER_SUBJECT;

public class PlayerException extends GlobalException {

  private static final long serialVersionUID = 7102808585278540318L;

  protected PlayerException(Issue issue) {
    super(issue);
  }

  public static PlayerException invalidPlayer() {
    return new PlayerException(
        new Issue(INVALID_PLAYER_SUBJECT, INVALID_PLAYER_MESSAGE, INVALID_PLAYER_CODE));
  }
}
