package br.ufrpe.sistema_bancario.gui;

import javax.swing.JFrame;

import br.ufrpe.sistema_bancario.exceptions.ContaJaExisteException;
import br.ufrpe.sistema_bancario.negocio.BancoFachada;
import br.ufrpe.sistema_bancario.negocio.beans.Conta;

public class TelaDesktopSwing extends JFrame {

  public TelaDesktopSwing() throws ContaJaExisteException {
    super("Meu frame de cadastro de clientes");

    Conta c = new Conta("1234-5", 100);
    BancoFachada.getInstance().cadastrarConta(c);

  }

}
