package br.robertosamuelx.moviesbattle.exceptions;

import java.io.Serializable;

public class Issue implements Serializable {

  private static final long serialVersionUID = -4029023152796315286L;

  private String subject;
  private String message;
  private Integer code;

  public Issue(String subject, String message, Integer code) {
    this.subject = subject;
    this.message = message;
    this.code = code;
  }

  public String getSubject() {
    return subject;
  }

  public String getMessage() {
    return message;
  }

  public Integer getCode() {
    return code;
  }
}
