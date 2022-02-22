package br.robertosamuelx.moviesbattle.exceptions;

public class GlobalException extends RuntimeException {

  private static final long serialVersionUID = 2460456431514646514L;

  private final Issue issue;

  protected GlobalException(Issue issue) {
    this.issue = issue;
  }

  public Issue getIssue() {
    return this.issue;
  }
}
