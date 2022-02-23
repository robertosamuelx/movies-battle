package br.robertosamuelx.moviesbattle.models;

import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ROUNDS")
public class RoundModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @OneToOne private QuizModel quiz;

  @OneToMany private List<MovieModel> movies;

  @Column private Integer attempts;

  @Column private Boolean isAnswered;

  public RoundModel() {
    // TODO Auto-generated constructor stub
  }

  public RoundModel(QuizModel quiz, List<MovieModel> movies) {
    this.quiz = quiz;
    this.movies = movies;
    this.attempts = 0;
    this.isAnswered = false;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public QuizModel getQuiz() {
    return quiz;
  }

  public void setQuiz(QuizModel quiz) {
    this.quiz = quiz;
  }

  public List<MovieModel> getMovies() {
    return movies;
  }

  public void setMovies(List<MovieModel> movies) {
    this.movies = movies;
  }

  public Integer getAttempts() {
    return attempts;
  }

  public void setAttempts(Integer attempts) {
    this.attempts = attempts;
  }

  public Boolean getIsAnswered() {
    return isAnswered;
  }

  public void setIsAnswered(Boolean isAnswered) {
    this.isAnswered = isAnswered;
  }

  @Override
  public String toString() {
    return String.format("id={0}\tisAnswered={1}", id, isAnswered);
  }
}
