package br.robertosamuelx.moviesbattle.dtos;

import java.util.List;

public class RoundDTO {

  private List<MovieDTO> movies;

  private MovieDTO correctMovie;

  private Integer attempts;

  public RoundDTO() {
    // TODO Auto-generated constructor stub
  }

  public List<MovieDTO> getMovies() {
    return movies;
  }

  public void setMovies(List<MovieDTO> movies) {
    this.movies = movies;
  }

  public MovieDTO getCorrectMovie() {
    return correctMovie;
  }

  public void setCorrectMovie(MovieDTO correctMovie) {
    this.correctMovie = correctMovie;
  }

  public Integer getAttempts() {
    return attempts;
  }

  public void setAttempts(Integer attempts) {
    this.attempts = attempts;
  }

  public RoundDTO(List<MovieDTO> movies, MovieDTO correctMovie, Integer attempts) {
    this.movies = movies;
    this.correctMovie = correctMovie;
    this.attempts = attempts;
  }
}
