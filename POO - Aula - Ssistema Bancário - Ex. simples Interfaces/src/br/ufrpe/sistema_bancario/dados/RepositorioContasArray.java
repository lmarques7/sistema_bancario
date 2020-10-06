package br.ufrpe.sistema_bancario.dados;

import br.ufrpe.sistema_bancario.negocio.beans.Conta;
import br.ufrpe.sistema_bancario.negocio.beans.Poupanca;

public class RepositorioContasArray implements IRepositorioContas {

    private double taxaDeJuros = 0.65;
    private Conta[] contas;
    private int proxima;

    /**
     * Construtor p�blico
     * @param tamanho Tamanho inicial do array de contas a ser constru�do
     */
    public RepositorioContasArray(int tamanho) {
        this.contas = new Conta[tamanho];
        this.proxima = 0;
    }

    /**
     * Cadastra uma nova conta no array de contas.
     * 
     * @param c A refer�ncia da conta a ser cadastrada
     */
    public void cadastrar(Conta c) {
        this.contas[this.proxima] = c;
        this.proxima = this.proxima + 1;
        if (this.proxima == this.contas.length) {
            this.duplicaArrayContas();
        }
        System.out.println("LOG: Nova conta cadastrada de n�mero: " + c.getNumero());
    }

    /**
     * Cria o objeto da conta com o n�mero e saldo inicial passados como
     * par�metro e cadastra a conta no array de contas. Observe o reuso entre os
     * m�todos sobrecarregados "cadastrar"
     * 
     * @param numero N�mero da conta a ser criada e cadastrada
     * @param saldoInicial Saldo inicial da conta a ser criada e cadastrada
     */
    public void cadastrar(String numero, double saldoInicial) {
        Conta c = new Conta(numero, saldoInicial);
        this.cadastrar(c);
    }
    
    /**
     * Procurar uma conta baseado no n�mero dado como par�metro
     * 
     * @param num O n�mero da conta a ser procurada
     * @return A conta encontrada ou null se o n�mero de conta passado com
     *         par�metro n�o existir
     */
    public Conta procurar(String num) {
        int i = this.procurarIndice(num);
        Conta resultado = null;
        if (i != this.proxima) {
            resultado = this.contas[i];
        }
        return resultado;
    }

    /**
     * Removendo a conta cujo n�mero � passado como par�metro
     * 
     * @param num N�mero da conta a ser removida.
     */
    public void remover(String num) {
        int i = this.procurarIndice(num);
        if (i != this.proxima) {
            this.contas[i] = this.contas[this.proxima - 1];
            this.contas[this.proxima - 1] = null;
            this.proxima = this.proxima - 1;
            System.out.println("LOG: Conta " + num + " removida");
        } else {
            System.out.println("LOG: Conta com n�mero " + num + " n�o existe.");
        }
    }

    /**
     * M�todo auxiliar para procurar o �ndice de uma conta no array.
     * 
     * @param num N�mero da conta da qual deseja-se encontrar o �ndice no array
     *        de contas
     * @return Um inteiro correspondente ao �ndice da conta encontrada.
     */
    private int procurarIndice(String num) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)) {
            if (num.equals(this.contas[i].getNumero())) {
                achou = true;
            } else {
                i = i + 1;
            }
        }
        return i;
    }

    private void duplicaArrayContas() {
        if (this.contas != null && this.contas.length > 0) {
            Conta[] arrayDuplicado = new Conta[this.contas.length * 2];
            for (int i = 0; i < this.contas.length; i++) {
                arrayDuplicado[i] = this.contas[i];
            }
            this.contas = arrayDuplicado;
        }
    }
    
    public void renderJuros(String num) {
        Conta c = this.procurar(num);
        if (c instanceof Poupanca) {
            ((Poupanca) c).renderJuros(this.taxaDeJuros);
        }
    }

}
