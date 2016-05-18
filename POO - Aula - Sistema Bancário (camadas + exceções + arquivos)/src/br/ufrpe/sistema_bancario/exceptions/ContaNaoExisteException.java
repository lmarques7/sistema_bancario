package br.ufrpe.sistema_bancario.exceptions;

public class ContaNaoExisteException extends Exception {

  private String numeroInexistente;

  public ContaNaoExisteException(String num) {
    super("A conta de número " + num + " não existe");
    this.numeroInexistente = num;
  }

  public String getNumeroInexistente() {
    return numeroInexistente;
  }

}
