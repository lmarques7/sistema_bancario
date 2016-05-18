package br.ufrpe.sistema_bancario.negocio.beans;

import java.io.Serializable;

public class Poupanca extends Conta implements Serializable {

  public Poupanca(String numero) {
    super(numero, 0.0);
  }

  public void renderJuros(double taxa) {
    this.creditar(this.getSaldo() * taxa);
  }

}
