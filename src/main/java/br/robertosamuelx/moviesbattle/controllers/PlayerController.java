package br.robertosamuelx.moviesbattle.controllers;

import br.robertosamuelx.moviesbattle.dtos.PlayerDTO;
import br.robertosamuelx.moviesbattle.models.PlayerModel;
import br.robertosamuelx.moviesbattle.services.PlayerService;
import java.util.List;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {

  private PlayerService service;

  @Autowired
  public PlayerController(PlayerService service) {
    this.service = service;
  }

  @PostMapping("/create")
  public ResponseEntity<PlayerDTO> create(@RequestBody @NotBlank PlayerModel playerModel) {
    PlayerDTO createPlayer = service.createPlayer(playerModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(createPlayer);
  }

  @GetMapping("/ranking")
  public ResponseEntity<List<PlayerDTO>> ranking() {
    List<PlayerDTO> ranking = service.getRanking();

    return ResponseEntity.status(HttpStatus.OK).body(ranking);
  }
}
