package br.robertosamuelx.moviesbattle.dtos.imdb;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieImdb {

  @JsonProperty(value = "Title")
  private String title;

  @JsonProperty(value = "imdbRating")
  private String imdbRating;

  @JsonProperty(value = "imdbVotes")
  private String imdbVotes;

  public MovieImdb() {
    // TODO Auto-generated constructor stub
  }

  public MovieImdb(String title, String imdbRating, String imdbVotes) {
    super();
    this.title = title;
    this.imdbRating = imdbRating;
    this.imdbVotes = imdbVotes;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getImdbRating() {
    return imdbRating;
  }

  public void setImdbRating(String imdbRating) {
    this.imdbRating = imdbRating;
  }

  public String getImdbVotes() {
    return imdbVotes;
  }

  public void setImdbVotes(String imdbVotes) {
    this.imdbVotes = imdbVotes;
  }
}
