package br.ufrpe.sistema_bancario.gui;

import br.ufrpe.sistema_bancario.exceptions.ContaJaExisteException;
import br.ufrpe.sistema_bancario.exceptions.ContaNaoExisteException;
import br.ufrpe.sistema_bancario.exceptions.SaldoInsuficienteException;
import br.ufrpe.sistema_bancario.negocio.BancoFachada;
import br.ufrpe.sistema_bancario.negocio.IBanco;
import br.ufrpe.sistema_bancario.negocio.beans.Conta;
import br.ufrpe.sistema_bancario.negocio.beans.Poupanca;

public class TelaTextual {

  public void executarOperacoes() {
    IBanco fachada = BancoFachada.getInstance();
        try {
            fachada.cadastrarConta(new Conta("222-1", 500.0));
            fachada.cadastrarConta(new Conta("333-1", 30.0));
            fachada.cadastrarConta(new Poupanca("555-2"));
            Poupanca p = new Poupanca("666-7");
            p.creditar(800);
            fachada.cadastrarConta(p);
            
            System.out.println("Antes da exceção");
            
            fachada.cadastrarConta(p);
            
            System.out.println("Depois da exceção");
            
        } catch (ContaJaExisteException e) {
            // Tratando erro
            System.out.println(e.getMessage());
            
            e.printStackTrace();
        }

        try {
            fachada.transferir("666-7", "555-2", 40);
            fachada.transferir("222-1", "555-2", 1500);
        } catch (ContaNaoExisteException | SaldoInsuficienteException e) {
            // Apresentando mensagem para o usuário
            System.out.println(e.getMessage());
        } 
//    double saldoAtual = fachada.procurarConta("222-1").getSaldo();
//    System.out.println(saldoAtual);
//
//    saldoAtual = fachada.procurarConta("333-1").getSaldo();
//    System.out.println(saldoAtual);
//
//    saldoAtual = fachada.procurarConta("555-2").getSaldo();
//    System.out.println(saldoAtual);
//
//    saldoAtual = fachada.procurarConta("666-7").getSaldo();
//    System.out.println(saldoAtual);
  }

}
