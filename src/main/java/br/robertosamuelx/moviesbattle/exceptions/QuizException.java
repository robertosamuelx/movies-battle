package br.robertosamuelx.moviesbattle.exceptions;

import static br.robertosamuelx.moviesbattle.constants.IssueConstant.INVALID_QUIZ_CODE;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.INVALID_QUIZ_MESSAGE;
import static br.robertosamuelx.moviesbattle.constants.IssueConstant.INVALID_QUIZ_SUBJECT;

public class QuizException extends GlobalException {

  protected QuizException(Issue issue) {
    super(issue);
  }

  private static final long serialVersionUID = 3434936861835250678L;

  public static QuizException invalidQuiz() {
    return new QuizException(
        new Issue(INVALID_QUIZ_SUBJECT, INVALID_QUIZ_MESSAGE, INVALID_QUIZ_CODE));
  }
}
