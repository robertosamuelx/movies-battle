package br.robertosamuelx.moviesbattle.models;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MOVIES")
public class MovieModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column private String name;

  @Column private Double imdbRating;

  @Column private Integer imdbVotes;

  public MovieModel() {
    // TODO Auto-generated constructor stub
  }

  public MovieModel(String name, Double imdbRating, Integer imdbVotes) {
    this.name = name;
    this.imdbRating = imdbRating;
    this.imdbVotes = imdbVotes;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
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
