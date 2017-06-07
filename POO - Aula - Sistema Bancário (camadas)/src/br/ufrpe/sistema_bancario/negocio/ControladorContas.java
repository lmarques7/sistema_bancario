package br.ufrpe.sistema_bancario.negocio;
import br.ufrpe.sistema_bancario.dados.RepositorioContasArray;
import br.ufrpe.sistema_bancario.negocio.beans.Conta;

public class ControladorContas {

    private RepositorioContasArray repositorio;
    
    public ControladorContas() {
        this.repositorio = RepositorioContasArray.getInstance(); 
    }
    
    public void cadastrar(Conta c) {
        if (c == null) {
            throw new IllegalArgumentException("Parâmetro inválido");
        } else {
            if (!this.existe(c.getNumero())) {
                this.repositorio.cadastrar(c);
            } else {
                // Aqui não dever haver impressão de mensagem para o usuário, já
                // que essa não é a responsabildiade do Cadastro/Controlador.
                // O problema é resolvido com o uso de exceções
            }
        }        
    }
    
    public void descadastrar(String numConta) {
    	Conta c = this.repositorio.procurar(numConta);
    	if (c != null &&
    			c.getSaldo() == 0) {
    		this.repositorio.remover(numConta);
		} else {
		    // Aqui não dever haver impressão de mensagem para o usuário, já
            // que essa não é a responsabildiade do Cadastro/Controlador.
            // O problema é resolvido com o uso de exceções
		}
    }

    public Conta procurar(String num) {
        return this.repositorio.procurar(num);
    }
    
    public boolean existe(String numConta) {
    	return this.repositorio.existe(numConta);
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
     * @throws ContaNaoExisteException 
     * @throws SaldoInsuficienteException 
     */
    public void transferir(String numOrigem, String numDestino, double valor) {
        Conta origem = this.repositorio.procurar(numOrigem);
        Conta destino = this.repositorio.procurar(numDestino);
        if (origem != null && destino != null && origem.getSaldo() >= valor) {
            origem.debitar(valor);
            destino.creditar(valor);
        } else {
            // Aqui não dever haver impressão de mensagem para o usuário, já
            // que essa não é a responsabildiade do Cadastro/Controlador.
            // Em cada um dos casos abaixo o problema é resolvido usando exceções
            if (origem == null || destino == null) {
                // Lançar exceção correspondente
            } else if (origem.getSaldo() < valor){
                // Lançar exceção correspondente
            }
        }
    }
    
    public double getSaldo(String num) {
        Conta c = this.repositorio.procurar(num);
        return c.getSaldo();
    }
}
