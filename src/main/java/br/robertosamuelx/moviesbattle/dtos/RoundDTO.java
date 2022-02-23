package br.robertosamuelx.moviesbattle.dtos;

import java.util.List;

public class RoundDTO {

  private List<MovieDTO> movies;

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

  public Integer getAttempts() {
    return attempts;
  }

  public void setAttempts(Integer attempts) {
    this.attempts = attempts;
  }

  public RoundDTO(List<MovieDTO> movies, Integer attempts) {
    this.movies = movies;
    this.attempts = attempts;
  }
}
