package br.robertosamuelx.moviesbattle.dtos;

import java.util.UUID;

public class MovieDTO {

  private UUID id;

  private String name;

  public MovieDTO() {
    // TODO Auto-generated constructor stub
  }

  public MovieDTO(UUID id, String name) {
    super();
    this.id = id;
    this.name = name;
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
}
