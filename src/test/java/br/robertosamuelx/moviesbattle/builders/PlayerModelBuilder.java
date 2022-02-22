package br.robertosamuelx.moviesbattle.builders;

import br.robertosamuelx.moviesbattle.models.PlayerModel;

public class PlayerModelBuilder {

  public static PlayerModel build() {
    PlayerModel player1 = new PlayerModel();
    player1.setIsPlaying(false);
    player1.setLogin("robertosamuelx");
    player1.setName("Beto");
    player1.setPassword("123");
    player1.setRanking(0);
    player1.setId((long) 1);

    return player1;
  }
}
