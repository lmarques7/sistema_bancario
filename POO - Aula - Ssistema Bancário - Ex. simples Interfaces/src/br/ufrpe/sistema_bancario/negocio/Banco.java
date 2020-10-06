package br.ufrpe.sistema_bancario.negocio;

import br.ufrpe.sistema_bancario.dados.IRepositorioContas;
import br.ufrpe.sistema_bancario.negocio.beans.Conta;
import br.ufrpe.sistema_bancario.negocio.beans.Poupanca;

/**
 * Esta classe simula um controlador que acessa os servi�os do reposit�rio 
 * atrav�s da uma interface.
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
     * Procura a conta cujo n�mero � passado como par�metro e credita o valor
     * tamb�m passado como par�metro
     * 
     * @param num N�mero da conta a ser procurada
     * @param valor Valor a ser creditado na conta encontrada
     */
    public void creditar(String num, double valor) {
        Conta contaCredito = this.repositorio.procurar(num);
        if (contaCredito != null) {
            contaCredito.creditar(valor);
        }
    }
    
    /**
     * Procura a conta cujo n�mero � passado como par�metro e debita o valor
     * tamb�m passado como par�metro. Note que n�o � preciso testar se o saldo �
     * v�lido para realizar o d�bito porque o m�todo "debitar" da classe Conta
     * j� testa essa situa��o
     * 
     * @param num N�mero da conta a ser procurada
     * @param valor Valor a ser debitado na conta encontrada
     */
    public void debitar(String num, double valor) {
        Conta contaDebito = this.repositorio.procurar(num);
        if (contaDebito != null) {
            contaDebito.debitar(valor);
        }
    }
    
    /**
     * Realiza transfer�ncia de valores entre as duas contas a partir dos
     * n�meros das contas passados como par�metro
     * 
     * @param numOrigem N�mero da conta origem
     * @param numDestino N�mero da conta destino
     * @param valor Valor a ser transferido
     */
    public void transferir(String numOrigem, String numDestino, double valor) {
        Conta origem = this.repositorio.procurar(numOrigem);
        Conta destino = this.repositorio.procurar(numDestino);
        if (origem != null && destino != null && origem.getSaldo() >= valor) {
            origem.debitar(valor);
            destino.creditar(valor);
            System.out.println("Transfer�ncia realizada com sucesso");
        } else {
            System.out.println("Imposs�vel realizar transfer�ncia");
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
            System.out.println("Poupan�a inexistente");
        }
    }
}
