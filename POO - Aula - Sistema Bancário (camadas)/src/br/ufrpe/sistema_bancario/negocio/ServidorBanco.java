package br.ufrpe.sistema_bancario.negocio;

import br.ufrpe.sistema_bancario.negocio.beans.Conta;


public class ServidorBanco {
    
    // Atributos como referências para os cadastros
	private ControladorClientes clientes;
	private ControladorContas contas;
	private ControladorLogins logins;
	
	private static ServidorBanco instance;
	
	private ServidorBanco () {
	    // Construtor privado para evitar instanciação fora da classe
	    this.clientes = new ControladorClientes();
	    this.contas = new ControladorContas();
	    this.logins = new ControladorLogins();
	}
	
	/**
	 * Implementando padrão Singleton
	 * 
	 * @return A instância da desta fachada
	 */
	public static ServidorBanco getInstance() {
        if (instance == null) {
            instance = new ServidorBanco();
        }
        return instance;
    }

    /**
     * 
     * @see br.ufrpe.sistema_bancario.negocio.ControladorClientes#cadastrarCliente()
     */
    public void cadastrarCliente() {
        clientes.cadastrarCliente();
    }

    /**
     * 
     * @see br.ufrpe.sistema_bancario.negocio.ControladorClientes#removerCliente()
     */
    public void removerCliente() {
        clientes.removerCliente();
    }

    /**
     * @param c
     * @see br.ufrpe.sistema_bancario.negocio.ControladorContas#cadastrar(br.ufrpe.sistema_bancario.negocio.beans.Conta)
     */
    public void cadastrarConta(Conta c) {
        contas.cadastrar(c);
    }

    /**
     * @param numConta
     * @see br.ufrpe.sistema_bancario.negocio.ControladorContas#descadastrar(java.lang.String)
     */
    public void descadastrarConta(String numConta) {
        contas.descadastrar(numConta);
    }

    /**
     * @param num
     * @return
     * @see br.ufrpe.sistema_bancario.negocio.ControladorContas#procurar(java.lang.String)
     */
    public Conta procurarConta(String num) {
        return contas.procurar(num);
    }

    /**
     * @param numConta
     * @return
     * @see br.ufrpe.sistema_bancario.negocio.ControladorContas#existe(java.lang.String)
     */
    public boolean existeConta(String numConta) {
        return contas.existe(numConta);
    }

    /**
     * @param num
     * @see br.ufrpe.sistema_bancario.negocio.ControladorContas#remover(java.lang.String)
     */
    public void removerConta(String num) {
        contas.remover(num);
    }

    /**
     * @param num
     * @param valor
     * @see br.ufrpe.sistema_bancario.negocio.ControladorContas#creditar(java.lang.String, double)
     */
    public void creditarEmConta(String num, double valor) {
        contas.creditar(num, valor);
    }

    /**
     * @param num
     * @param valor
     * @see br.ufrpe.sistema_bancario.negocio.ControladorContas#debitar(java.lang.String, double)
     */
    public void debitarDaConta(String num, double valor) {
        contas.debitar(num, valor);
    }

    /**
     * @param numOrigem
     * @param numDestino
     * @param valor
     * @see br.ufrpe.sistema_bancario.negocio.ControladorContas#transferir(java.lang.String, java.lang.String, double)
     */
    public void transferirEntreContas(String numOrigem, String numDestino, double valor) {
        contas.transferir(numOrigem, numDestino, valor);
    }

    /**
     * @param num
     * @return
     * @see br.ufrpe.sistema_bancario.negocio.ControladorContas#getSaldo(java.lang.String)
     */
    public double getSaldoDaConta(String num) {
        return contas.getSaldo(num);
    }

    /**
     * @param login
     * @param senha
     * @return
     * @see br.ufrpe.sistema_bancario.negocio.ControladorLogins#efetuarLogin(java.lang.String, java.lang.String)
     */
    public boolean efetuarLogin(String login, String senha) {
        return logins.efetuarLogin(login, senha);
    }

    /**
     * @param login
     * @param senha
     * @see br.ufrpe.sistema_bancario.negocio.ControladorLogins#cadastrarNovoUsuario(java.lang.String, java.lang.String)
     */
    public void cadastrarNovoUsuario(String login, String senha) {
        logins.cadastrarNovoUsuario(login, senha);
    }
	
	
}
