package br.ufrpe.sistema_bancario.gui;

import br.ufrpe.sistema_bancario.exceptions.ContaJaExisteException;
import br.ufrpe.sistema_bancario.negocio.BancoFachada;
import br.ufrpe.sistema_bancario.negocio.beans.Conta;

public class TelaMobile {

  public TelaMobile() {
  }

  public void pintarTela() {
    // Usando a instância da Fachada
    String num = "1234-5"; // Número deve vir da tela
    double saldo = 50.0; // Número deve vir da tela
    Conta c = new Conta(num, saldo);
    try {
      BancoFachada.getInstance().cadastrarConta(c);
    } catch (ContaJaExisteException e) {
      // Tratamento de exceção deve mostrar alguma mensagem para o usário
      System.out.println(e.getMessage());
    }
  }

}
