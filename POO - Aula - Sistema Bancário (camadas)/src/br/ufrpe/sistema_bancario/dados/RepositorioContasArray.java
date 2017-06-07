package br.ufrpe.sistema_bancario.dados;

import br.ufrpe.sistema_bancario.negocio.beans.Conta;

public class RepositorioContasArray {

    private static RepositorioContasArray instance;
  
    private Conta[] contas;
    private int proxima;

    public static RepositorioContasArray getInstance() {
      if (instance == null) {
        instance = new RepositorioContasArray(100);
      }
      return instance;
    }
    
    /**
     * Construtor público
     * 
     * @param tamanho Tamanho inicial do array de contas a ser construído
     */
    private RepositorioContasArray(int tamanho) {
        this.contas = new Conta[tamanho];
        this.proxima = 0;
    }

    /**
     * Cadastra uma nova conta no array de contas.
     * 
     * @param c A referência da conta a ser cadastrada
     */
    public void cadastrar(Conta c) {
        this.contas[this.proxima] = c;
        this.proxima = this.proxima + 1;
        if (this.proxima == this.contas.length) {
            this.duplicaArrayContas();
        }
    }

    /**
     * Cria o objeto da conta com o número e saldo inicial passados como
     * parâmetro e cadastra a conta no array de contas. Observe o reuso entre os
     * métodos sobrecarregados "cadastrar"
     * 
     * @param numero Número da conta a ser criada e cadastrada
     * @param saldoInicial Saldo inicial da conta a ser criada e cadastrada
     */
    public void cadastrar(String numero, double saldoInicial) {
        Conta c = new Conta(numero, saldoInicial);
        this.cadastrar(c);
    }

    /**
     * Procurar uma conta baseado no número dado como parâmetro
     * 
     * @param num O número da conta a ser procurada
     * @return A conta encontrada ou null se o número de conta passado com
     *         parâmetro não existir
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
     * Método para verificar se existe alguma com o número informado como 
     * parâmetro no Array de contas.
     * 
     * @param numConta O número da conta a ser procurada.
     * @return true se a conta existe, false caso contrário.
     */
    public boolean existe(String numConta) {
        boolean existe = false;
        int indice = this.procurarIndice(numConta);
        if (indice != proxima) {
            existe = true;
        }
        return existe;
    }

    /**
     * Removendo a conta cujo número é passado como parâmetro
     * 
     * @param num Número da conta a ser removida.
     */
    public void remover(String num) {
        int i = this.procurarIndice(num);
        if (i != this.proxima) {
            this.contas[i] = this.contas[this.proxima - 1];
            this.contas[this.proxima - 1] = null;
            this.proxima = this.proxima - 1;
        } else {
            // Aqui não dever haver impressão de mensagem para o usuário, já
            // que essa não é a responsabildiade do Repositório.
            // Neste caso, o problema é resolvido com o uso de exceções
        }
    }

    /**
     * Método auxiliar para procurar o índice de uma conta no array.
     * 
     * @param num Número da conta da qual deseja-se encontrar o índice no array
     *            de contas
     * @return Um inteiro correspondente ao índice da conta encontrada.
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

    /**
     * Método que procura por contas cujo saldo é maior do que 1000 e retorna em
     * formato de Array
     * 
     * @return Array de Conta com saldo maior do que 1000
     */
    public Conta[] retornaContasVIP() {
        Conta[] contasVIP = new Conta[this.proxima];
        int posicaoAtual = 0;
        for (int i = 0; i < this.proxima; i++) {
            if (this.contas[i].getSaldo() > 1000) {
                contasVIP[posicaoAtual] = this.contas[i];
                posicaoAtual = posicaoAtual + 1;
            }
        }
        return contasVIP;
    }

}
