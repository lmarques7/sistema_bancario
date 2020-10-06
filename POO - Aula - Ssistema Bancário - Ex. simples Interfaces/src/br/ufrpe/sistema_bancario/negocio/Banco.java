package br.ufrpe.sistema_bancario.negocio;

import br.ufrpe.sistema_bancario.dados.IRepositorioContas;
import br.ufrpe.sistema_bancario.negocio.beans.Conta;
import br.ufrpe.sistema_bancario.negocio.beans.Poupanca;

/**
 * Esta classe simula um controlador que acessa os serviços do repositório 
 * através da uma interface.
 * 
 * @author lmarq
 *
 */
public class Banco {

    IRepositorioContas repositorio;
    
    public Banco(IRepositorioContas instanciaInterface) {
        this.repositorio = instanciaInterface; 
    }
    
    public void cadastrar(String numero, double saldoInicial) {
        this.repositorio.cadastrar(numero, saldoInicial);
    }
    
    public void cadastrar(Conta c) {
        this.repositorio.cadastrar(c);
    }

    public Conta procurar(String num) {
        return this.repositorio.procurar(num);
    }

    public void remover(String num) {
        this.repositorio.remover(num);
    }

    /**
     * Procura a conta cujo número é passado como parâmetro e credita o valor
     * também passado como parâmetro
     * 
     * @param num Número da conta a ser procurada
     * @param valor Valor a ser creditado na conta encontrada
     */
    public void creditar(String num, double valor) {
        Conta contaCredito = this.repositorio.procurar(num);
        if (contaCredito != null) {
            contaCredito.creditar(valor);
        }
    }
    
    /**
     * Procura a conta cujo número é passado como parâmetro e debita o valor
     * também passado como parâmetro. Note que não é preciso testar se o saldo é
     * válido para realizar o débito porque o método "debitar" da classe Conta
     * já testa essa situação
     * 
     * @param num Número da conta a ser procurada
     * @param valor Valor a ser debitado na conta encontrada
     */
    public void debitar(String num, double valor) {
        Conta contaDebito = this.repositorio.procurar(num);
        if (contaDebito != null) {
            contaDebito.debitar(valor);
        }
    }
    
    /**
     * Realiza transferência de valores entre as duas contas a partir dos
     * números das contas passados como parâmetro
     * 
     * @param numOrigem Número da conta origem
     * @param numDestino Número da conta destino
     * @param valor Valor a ser transferido
     */
    public void transferir(String numOrigem, String numDestino, double valor) {
        Conta origem = this.repositorio.procurar(numOrigem);
        Conta destino = this.repositorio.procurar(numDestino);
        if (origem != null && destino != null && origem.getSaldo() >= valor) {
            origem.debitar(valor);
            destino.creditar(valor);
            System.out.println("Transferência realizada com sucesso");
        } else {
            System.out.println("Impossível realizar transferência");
        }
    }
    
    public double getSaldo(String num) {
        Conta c = this.repositorio.procurar(num);
        return c.getSaldo();
    }
    
    public static final double TAXA_JUROS = 0.01;
    
    public void renderJuros(String num) {
        Conta c = this.repositorio.procurar(num);
        if (c instanceof Poupanca) {
            ((Poupanca) c).renderJuros(TAXA_JUROS);    
        } else {
            System.out.println("Poupança inexistente");
        }
    }
}
