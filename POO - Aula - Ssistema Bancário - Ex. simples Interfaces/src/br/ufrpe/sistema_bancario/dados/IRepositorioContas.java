package br.ufrpe.sistema_bancario.dados;

import br.ufrpe.sistema_bancario.negocio.beans.Conta;

public interface IRepositorioContas {

  void cadastrar(Conta c);
  void cadastrar(String numero, double saldoInicial);
  Conta procurar(String num);
  void remover(String num);
  void renderJuros(String num);

}