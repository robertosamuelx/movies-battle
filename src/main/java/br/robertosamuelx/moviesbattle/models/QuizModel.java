package br.robertosamuelx.moviesbattle.models;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
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

  @OneToMany(mappedBy = "quiz")
  private List<RoundModel> rounds;

  @OneToOne private PlayerModel player;

  @Column(nullable = false)
  private LocalDateTime startedAt;

  @Column private LocalDateTime closedAt;

  public QuizModel() {}

  public QuizModel(
      List<RoundModel> rounds,
      PlayerModel player,
      LocalDateTime startedAt,
      LocalDateTime closedAt) {
    this.rounds = rounds;
    this.player = player;
    this.startedAt = startedAt;
    this.closedAt = closedAt;
  }

  public QuizModel(List<RoundModel> rounds, PlayerModel player, LocalDateTime startedAt) {
    this.rounds = rounds;
    this.player = player;
    this.startedAt = startedAt;
  }

  public QuizModel(List<RoundModel> rounds, PlayerModel player) {
    this.rounds = rounds;
    this.player = player;
    this.startedAt = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
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

  public LocalDateTime getStartedAt() {
    return startedAt;
  }

  public void setStartedAt(LocalDateTime startedAt) {
    this.startedAt = startedAt;
  }

  public LocalDateTime getClosedAt() {
    return closedAt;
  }

  public void setClosedAt(LocalDateTime closedAt) {
    this.closedAt = closedAt;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}
