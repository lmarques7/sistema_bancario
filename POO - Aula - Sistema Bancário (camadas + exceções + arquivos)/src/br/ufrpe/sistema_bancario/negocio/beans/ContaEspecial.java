package br.ufrpe.sistema_bancario.negocio.beans;

import java.io.Serializable;

public class ContaEspecial extends Conta implements Serializable {
  private static final long serialVersionUID = 2369537755551854483L;
  private double limite;

  public ContaEspecial(String numero) {
    super(numero, 0.0);
    this.limite = 100.0;
  }

  public void aumentarLimite(double aumento) {
    this.limite += aumento;
  }

  public double getLimite() {
    return this.limite;
  }

  public boolean debitar(double valor) {
    boolean resultado = false;
    if (valor < this.saldo + this.limite) {
      this.saldo = this.saldo - valor;
    }
    return resultado;
  }

  public void calcularJuros() {
    if (this.saldo < 0) {
      // Calculando o valor absoluto dos juros, porque não faz sentido
      // dos juros serem negativos e o débito ser feito de um valor
      // negativo torna-se-á um crédito
      double juros = Math.abs(this.saldo * 0.05);
      this.debitar(juros);
    }
  }

  public static void main(String[] args) {
    Conta contae = new ContaEspecial("2134-5");
    contae.creditar(500.0);
    contae.debitar(550.0);
    ((ContaEspecial) contae).aumentarLimite(100.0);
    contae.debitar(75.0);
    ((ContaEspecial) contae).calcularJuros();
    System.out.println(contae.getSaldo());

    Conta c = new Conta("1239-7", 55.0);
    c.getClass();
  }
}