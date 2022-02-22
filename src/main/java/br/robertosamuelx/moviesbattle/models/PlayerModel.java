package br.robertosamuelx.moviesbattle.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PLAYERS")
public class PlayerModel implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column private String name;

  @Column(nullable = false)
  private String login;

  @Column(nullable = false)
  private String password;

  @Column private Integer ranking;

  @Column private Boolean isPlaying;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
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
