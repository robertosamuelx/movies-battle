package br.robertosamuelx.moviesbattle.dtos;

import java.util.List;
import java.util.UUID;

public class QuizDTO {

  private UUID id;
  private List<RoundDTO> rounds;

  public QuizDTO(UUID id, List<RoundDTO> rounds) {
    super();
    this.id = id;
    this.rounds = rounds;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public List<RoundDTO> getRounds() {
    return rounds;
  }

  public void setRounds(List<RoundDTO> rounds) {
    this.rounds = rounds;
  }

  public QuizDTO() {
    // TODO Auto-generated constructor stub
  }
}
