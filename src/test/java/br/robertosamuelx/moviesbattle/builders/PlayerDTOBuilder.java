package br.robertosamuelx.moviesbattle.builders;

import br.robertosamuelx.moviesbattle.dtos.PlayerDTO;
import java.util.UUID;

public class PlayerDTOBuilder {

  private static PlayerDTO player;

  public PlayerDTOBuilder(PlayerDTO player) {
    this.player = player;
  }

  public PlayerDTOBuilder mockValues() {
    player.setIsPlaying(false);
    player.setName("Beto");
    player.setRanking(0);
    player.setPlayerId(UUID.randomUUID());

    return this;
  }

  public PlayerDTO build() {
    return player;
  }

  public static PlayerDTOBuilder builder() {
    return new PlayerDTOBuilder(new PlayerDTO());
  }

  public PlayerDTOBuilder name(String name) {
    player.setName(name);
    return this;
  }

  public PlayerDTOBuilder ranking(Integer ranking) {
    player.setRanking(ranking);
    return this;
  }

  public PlayerDTOBuilder isPlaying(Boolean isPlaying) {
    player.setIsPlaying(isPlaying);
    return this;
  }

  public PlayerDTOBuilder playerId(UUID id) {
    player.setPlayerId(id);
    return this;
  }
}
