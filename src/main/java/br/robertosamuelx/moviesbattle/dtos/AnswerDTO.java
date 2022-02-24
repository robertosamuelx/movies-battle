package br.robertosamuelx.moviesbattle.dtos;

import java.util.UUID;

public class AnswerDTO {

  private UUID movieId;

  private UUID roundId;

  public AnswerDTO() {
    // TODO Auto-generated constructor stub
  }

  public AnswerDTO(UUID movieId, UUID roundId) {
    super();
    this.movieId = movieId;
    this.roundId = roundId;
  }

  public UUID getMovieId() {
    return movieId;
  }

  public void setMovieId(UUID movieId) {
    this.movieId = movieId;
  }

  public UUID getRoundId() {
    return roundId;
  }

  public void setRoundId(UUID roundId) {
    this.roundId = roundId;
  }
}
