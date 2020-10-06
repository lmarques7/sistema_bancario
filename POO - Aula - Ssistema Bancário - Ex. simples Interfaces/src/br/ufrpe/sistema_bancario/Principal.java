package br.ufrpe.sistema_bancario;

import br.ufrpe.sistema_bancario.dados.IRepositorioContas;
import br.ufrpe.sistema_bancario.dados.RepositorioContasArray;
import br.ufrpe.sistema_bancario.negocio.Banco;
import br.ufrpe.sistema_bancario.negocio.beans.Conta;
import br.ufrpe.sistema_bancario.negocio.beans.Poupanca;

public class Principal {

  public static void main(String[] args) {
    IRepositorioContas instanciaInterface = new RepositorioContasArray(100);
    Banco bancoDoBrasil = new Banco(instanciaInterface);
    bancoDoBrasil.cadastrar(new Conta("222-1", 10.0));
    bancoDoBrasil.cadastrar(new Conta("333-1", 30.0));
    bancoDoBrasil.cadastrar(new Poupanca("555-2"));
    bancoDoBrasil.cadastrar(new Poupanca("666-7"));

    bancoDoBrasil.creditar("222-1", 152.30);
    bancoDoBrasil.creditar("333-1", 35.70);
    bancoDoBrasil.creditar("666-7", 43.50);

    bancoDoBrasil.transferir("666-7", "555-2", 23.50);
    bancoDoBrasil.transferir("222-1", "555-2", 56.50);
    double saldoTotal = bancoDoBrasil.getSaldo("222-1");
    bancoDoBrasil.debitar("222-1", saldoTotal);
  }

}