package br.robertosamuelx.moviesbattle.dtos;

import java.util.List;
import java.util.UUID;

public class QuizDTO {

  private UUID quizId;
  private List<RoundDTO> rounds;

  public QuizDTO(UUID id, List<RoundDTO> rounds) {
    this.quizId = id;
    this.rounds = rounds;
  }

  public UUID getQuizId() {
    return quizId;
  }

  public void setQuizId(UUID id) {
    this.quizId = id;
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
