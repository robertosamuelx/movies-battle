package br.robertosamuelx.moviesbattle.models;

import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ROUNDS")
public class RoundModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @ManyToOne private QuizModel quiz;

  @OneToMany private List<MovieModel> movies;

  @OneToOne private MovieModel correctMovie;

  @Column private Integer attempts;

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

  public MovieModel getCorrectMovie() {
    return correctMovie;
  }

  public void setCorrectMovie(MovieModel correctMovie) {
    this.correctMovie = correctMovie;
  }

  public Integer getAttempts() {
    return attempts;
  }

  public void setAttempts(Integer attempts) {
    this.attempts = attempts;
  }
}
