package br.ufrpe.sistema_bancario.dados;

import br.ufrpe.sistema_bancario.exceptions.ContaNaoExisteException;
import br.ufrpe.sistema_bancario.negocio.beans.Conta;

public interface IRepositorioContas {

  /**
   * Cadastra uma nova conta no array de contas.
   * 
   * @param c
   *          A refer�ncia da conta a ser cadastrada
   */
  void cadastrar(Conta c);

  /**
   * Cria o objeto da conta com o n�mero e saldo inicial passados como par�metro
   * e cadastra a conta no array de contas. Observe o reuso entre os m�todos
   * sobrecarregados "cadastrar"
   * 
   * @param numero
   *          N�mero da conta a ser criada e cadastrada
   * @param saldoInicial
   *          Saldo inicial da conta a ser criada e cadastrada
   */
  void cadastrar(String numero, double saldoInicial);

  /**
   * Procurar uma conta baseado no n�mero dado como par�metro
   * 
   * @param num
   *          O n�mero da conta a ser procurada
   * @return A conta encontrada ou null se o n�mero de conta passado com
   *         par�metro n�o existir
 * @throws ContaNaoExisteException Exce��o � levantada quando a conta procurada 
 *                                 n�o existe
   */
  Conta procurar(String num) throws ContaNaoExisteException;

  boolean existe(String numConta);

  /**
   * Removendo a conta cujo n�mero � passado como par�metro
   * 
   * @param num
   *          N�mero da conta a ser removida.
   * @throws ContaNaoExisteException
   */
  void remover(String num) throws ContaNaoExisteException;

  void renderJuros(String num) throws ContaNaoExisteException;

  /**
   * M�todo que procura por contas cujo saldo � maior do que 1000 e retorna em
   * formato de Array
   * 
   * @return Array de Conta com saldo maior do que 1000
   */
  Conta[] retornaContasVIP();

  /**
   * M�todo respons�vel por Salvar todo o reposit�rio em um arquivo espec�fico,
   * apagando o conte�do salvo arteriormente no arquivo ou criando um novo
   * arquivo se o mesmo n�o existir.
   * 
   */
  void salvarArquivo();

}