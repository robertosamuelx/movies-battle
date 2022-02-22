package br.robertosamuelx.moviesbattle.models;

import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_QUIZ")
public class QuizModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @OneToMany private List<RoundModel> rounds;

  @OneToOne private PlayerModel player;

  public QuizModel() {}

  public QuizModel(List<RoundModel> rounds, PlayerModel player) {
    this.rounds = rounds;
    this.player = player;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public List<RoundModel> getRounds() {
    return rounds;
  }

  public void setRounds(List<RoundModel> rounds) {
    this.rounds = rounds;
  }

  public PlayerModel getPlayer() {
    return player;
  }

  public void setPlayer(PlayerModel player) {
    this.player = player;
  }
}
