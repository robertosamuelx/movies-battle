package br.robertosamuelx.moviesbattle.dtos;

import java.util.List;
import java.util.UUID;

public class RoundDTO {

  private UUID id;

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

  public RoundDTO(UUID id, List<MovieDTO> movies, Integer attempts) {
    this.id = id;
    this.movies = movies;
    this.attempts = attempts;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}
