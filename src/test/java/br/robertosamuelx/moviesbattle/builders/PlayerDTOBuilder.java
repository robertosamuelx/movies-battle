package br.robertosamuelx.moviesbattle.builders;

import br.robertosamuelx.moviesbattle.dtos.PlayerDTO;
import java.util.UUID;

public class PlayerDTOBuilder {

  public static PlayerDTO build() {
    PlayerDTO player1 = new PlayerDTO();
    player1.setIsPlaying(false);
    player1.setName("Beto");
    player1.setRanking(0);
    player1.setPlayerId(UUID.randomUUID());

    return player1;
  }
}
