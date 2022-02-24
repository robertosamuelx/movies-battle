package br.robertosamuelx.moviesbattle.dtos;

import java.util.UUID;

public class PlayerDTO {

  private UUID playerId;

  private String name;

  private Integer ranking;

  private Boolean isPlaying;

  public PlayerDTO() {
    // TODO Auto-generated constructor stub
  }

  public PlayerDTO(UUID id, String name, Integer ranking, Boolean isPlaying) {
    this.playerId = id;
    this.name = name;
    this.ranking = ranking;
    this.isPlaying = isPlaying;
  }

  public UUID getPlayerId() {
    return playerId;
  }

  public void setPlayerId(UUID id) {
    this.playerId = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getRanking() {
    return ranking;
  }

  public void setRanking(Integer ranking) {
    this.ranking = ranking;
  }

  public Boolean getIsPlaying() {
    return isPlaying;
  }

  public void setIsPlaying(Boolean isPlaying) {
    this.isPlaying = isPlaying;
  }
}
