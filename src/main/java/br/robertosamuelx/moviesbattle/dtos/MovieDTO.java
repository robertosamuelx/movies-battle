package br.robertosamuelx.moviesbattle.dtos;

public class MovieDTO {

  private String name;

  private Double imdbRating;

  private Integer imdbVotes;

  public MovieDTO() {
    // TODO Auto-generated constructor stub
  }

  public MovieDTO(String name, Double imdbRating, Integer imdbVotes) {
    this.name = name;
    this.imdbRating = imdbRating;
    this.imdbVotes = imdbVotes;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getImdbRating() {
    return imdbRating;
  }

  public void setImdbRating(Double imdbRating) {
    this.imdbRating = imdbRating;
  }

  public Integer getImdbVotes() {
    return imdbVotes;
  }

  public void setImdbVotes(Integer imdbVotes) {
    this.imdbVotes = imdbVotes;
  }
}
