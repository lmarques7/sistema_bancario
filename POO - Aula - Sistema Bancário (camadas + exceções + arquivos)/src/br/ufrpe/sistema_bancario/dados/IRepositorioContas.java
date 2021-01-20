package br.ufrpe.sistema_bancario.dados;

import br.ufrpe.sistema_bancario.exceptions.ContaNaoExisteException;
import br.ufrpe.sistema_bancario.negocio.beans.Conta;

public interface IRepositorioContas {

  /**
   * Cadastra uma nova conta no array de contas.
   * 
   * @param c
   *          A referência da conta a ser cadastrada
   */
  void cadastrar(Conta c);

  /**
   * Cria o objeto da conta com o número e saldo inicial passados como parâmetro
   * e cadastra a conta no array de contas. Observe o reuso entre os métodos
   * sobrecarregados "cadastrar"
   * 
   * @param numero
   *          Número da conta a ser criada e cadastrada
   * @param saldoInicial
   *          Saldo inicial da conta a ser criada e cadastrada
   */
  void cadastrar(String numero, double saldoInicial);

  /**
   * Procurar uma conta baseado no número dado como parâmetro
   * 
   * @param num
   *          O número da conta a ser procurada
   * @return A conta encontrada ou null se o número de conta passado com
   *         parâmetro não existir
 * @throws ContaNaoExisteException Exceção é levantada quando a conta procurada 
 *                                 não existe
   */
  Conta procurar(String num) throws ContaNaoExisteException;

  boolean existe(String numConta);

  /**
   * Removendo a conta cujo número é passado como parâmetro
   * 
   * @param num
   *          Número da conta a ser removida.
   * @throws ContaNaoExisteException
   */
  void remover(String num) throws ContaNaoExisteException;

  void renderJuros(String num) throws ContaNaoExisteException;

  /**
   * Método que procura por contas cujo saldo é maior do que 1000 e retorna em
   * formato de Array
   * 
   * @return Array de Conta com saldo maior do que 1000
   */
  Conta[] retornaContasVIP();

  /**
   * Método responsável por Salvar todo o repositório em um arquivo específico,
   * apagando o conteúdo salvo arteriormente no arquivo ou criando um novo
   * arquivo se o mesmo não existir.
   * 
   */
  void salvarArquivo();

}