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
}
