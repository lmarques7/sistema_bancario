package br.ufrpe.sistema_bancario.negocio;

import br.ufrpe.sistema_bancario.dados.RepositorioContasArray;
import br.ufrpe.sistema_bancario.exceptions.ContaJaExisteException;
import br.ufrpe.sistema_bancario.exceptions.ContaNaoExisteException;
import br.ufrpe.sistema_bancario.exceptions.SaldoInsuficienteException;
import br.ufrpe.sistema_bancario.negocio.beans.Conta;

public class BancoFachada implements IBanco {

  private CadastroClientes clientes;
  private CadastroContas contas;
  private CadastroLogins logins;

  private static IBanco instance;

  private BancoFachada() {
    // Construtor privado para evitar instanciação fora da classe
    this.contas = new CadastroContas(RepositorioContasArray.getInstance());
    this.clientes = new CadastroClientes();
    this.logins = new CadastroLogins();
  }

  /**
   * Implementando padrão Singleton
   * 
   * @return A instância da desta fachada
   */
  public static IBanco getInstance() {
    if (instance == null) {
      instance = new BancoFachada();
    }
    return instance;
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.ufrpe.sistema_bancario.negocio.IFachada#cadastrarCliente()
   */
  public void cadastrarCliente() {
    this.clientes.cadastrar();
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.ufrpe.sistema_bancario.negocio.IFachada#cadastrarConta(br.ufrpe.
   * sistema_bancario.negocio.beans.Conta)
   */
  public void cadastrarConta(Conta c) throws ContaJaExisteException {
    this.contas.cadastrar(c);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * br.ufrpe.sistema_bancario.negocio.IFachada#procurarConta(java.lang.String)
   */
  public Conta procurarConta(String num) {
    return this.contas.procurar(num);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * br.ufrpe.sistema_bancario.negocio.IFachada#transferir(java.lang.String,
   * java.lang.String, double)
   */
  public void transferir(String numOrigem, String numDestino, double valor)
      throws ContaNaoExisteException, SaldoInsuficienteException {
    contas.transferir(numOrigem, numDestino, valor);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * br.ufrpe.sistema_bancario.negocio.IFachada#removerConta(java.lang.String)
   */
  public void removerConta(String num) throws ContaNaoExisteException {
    this.contas.remover(num);
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.ufrpe.sistema_bancario.negocio.IFachada#efetuarLogin()
   */
  public void efetuarLogin() {
    this.logins.efetuarLogin();
  }

}
