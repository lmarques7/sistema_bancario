package br.ufrpe.sistema_bancario.negocio;

import br.ufrpe.sistema_bancario.exceptions.ContaJaExisteException;
import br.ufrpe.sistema_bancario.exceptions.ContaNaoExisteException;
import br.ufrpe.sistema_bancario.exceptions.SaldoInsuficienteException;
import br.ufrpe.sistema_bancario.negocio.beans.Conta;

public interface IBanco {

  void cadastrarCliente();

  void efetuarLogin();

  void cadastrarConta(Conta c) throws ContaJaExisteException;

  void removerConta(String num) throws ContaNaoExisteException;

  Conta procurarConta(String num) throws ContaNaoExisteException;

  void transferir(String numOrigem, String numDestino, double valor)
      throws ContaNaoExisteException, SaldoInsuficienteException;

}