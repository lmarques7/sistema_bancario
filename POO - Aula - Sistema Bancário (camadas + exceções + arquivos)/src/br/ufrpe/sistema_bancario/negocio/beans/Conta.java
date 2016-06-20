package br.ufrpe.sistema_bancario.negocio.beans;

import java.io.Serializable;

public class Conta implements Serializable {

  private static final long serialVersionUID = -2936766067409686658L;
  private String numero;
  protected double saldo;

  public Conta(String numero, double saldo) {
    this.setNumero(numero);
    this.setSaldo(saldo);
  }

  public String getNumero() {
    return numero;
  }

  public double getSaldo() {
    return saldo;
  }

  private void setNumero(String numero) {
    if (numero != null) {
      this.numero = numero;
    } else {
      System.out.println("Número inválido");
    }
  }

  private void setSaldo(double saldo) {
    if (saldo >= 0.0) {
      this.saldo = saldo;
    } else {
      System.out.println("Saldo inválido");
    }
  }

  public boolean creditar(double valor) {
    boolean resultado;
    if (valor > 0) {
      this.saldo = this.saldo + valor;
      resultado = true;
    } else {
      System.out.println("Crédito inválido");
      resultado = false;
    }
    return resultado;
  }

  public boolean debitar(double valor) {
    boolean resultado;
    if (valor > 0) {
      this.saldo = this.saldo - valor;
      resultado = true;
    } else {
      System.out.println("Débito inválido");
      resultado = false;
    }
    return resultado;
  }

  public boolean transferir(double valor, Conta contaDestino) {
    boolean resultado;
    if (valor > 0) {
      if (contaDestino != null) {
        if (this.saldo >= valor) {
          this.debitar(valor);
          contaDestino.creditar(valor);
          resultado = true;
        } else {
          System.out.println("Saldo insuficiente");
          resultado = false;
        }
      } else {
        System.out.println("Conta destino inválida");
        resultado = false;
      }
    } else {
      System.out.println("Transferência inválida");
      resultado = false;
    }
    return resultado;
  }
}
