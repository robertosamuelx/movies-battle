package br.robertosamuelx.moviesbattle.builders;

import br.robertosamuelx.moviesbattle.models.PlayerModel;
import java.util.UUID;

public class PlayerModelBuilder {

  private PlayerModel player;

  public PlayerModelBuilder(PlayerModel player) {
    this.player = player;
  }

  public static PlayerModelBuilder builder() {
    return new PlayerModelBuilder(new PlayerModel());
  }

  public PlayerModelBuilder mockValues() {
    player.setId(UUID.randomUUID());
    player.setIsPlaying(false);
    player.setLogin("Test");
    player.setPassword("123");
    player.setRanking(0);

    return this;
  }

  public PlayerModel build() {
    return player;
  }
}
