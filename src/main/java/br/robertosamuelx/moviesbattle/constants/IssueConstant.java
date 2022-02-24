package br.robertosamuelx.moviesbattle.constants;

public class IssueConstant {

  public IssueConstant() {
    // TODO Auto-generated constructor stub
  }

  public static final String INVALID_PLAYER_MESSAGE =
      "The player is invalid or already playing a quiz now";
  public static final String INVALID_PLAYER_SUBJECT = "Invalid player";
  public static final int INVALID_PLAYER_CODE = 1;

  public static final String INVALID_QUIZ_MESSAGE = "The quiz don't exist or already was closed";
  public static final String INVALID_QUIZ_SUBJECT = "Invalid quiz";
  public static final int INVALID_QUIZ_CODE = 2;

  public static final String ROUND_NOT_ANSWERED_MESSAGE =
      "You cannot start a new round before finish all opened rounds";
  public static final String ROUND_NOT_ANSWERED_SUBJECT = "Round not answered";
  public static final int ROUND_NOT_ANSWERED_CODE = 3;

  public static final String ROUND_ALREADY_ANSWERED_MESSAGE = "This round already answered";
  public static final String ROUND_ALREADY_ANSWERED_SUBJECT = "Round already answered";
  public static final int ROUND_ALREADY_ANSWERED_CODE = 4;

  public static final String WRONG_ANSWER_MESSAGE =
      "Ops, your answer is wrong - Remaining attempts: {0}";
  public static final String WRONG_ANSWER_SUBJECT = "Answer wrong";
  public static final int WRONG_ANSWER_CODE = 5;

  public static final String MAX_ATTEMPTS_MESSAGE =
      "You exceeded the Max attempts ({0}), game over.";
  public static final String MAX_ATTEMPTS_SUBJECT = "Max attempts";
  public static final int MAX_ATTEMPTS_CODE = 6;
}
