package br.ufrpe.sistema_bancario.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import br.ufrpe.sistema_bancario.exceptions.ContaNaoExisteException;
import br.ufrpe.sistema_bancario.negocio.beans.Conta;
import br.ufrpe.sistema_bancario.negocio.beans.Poupanca;

public class RepositorioContasArray
    implements IRepositorioContas, Serializable {

  private double taxaDeJuros = 0.65;
  private Conta[] contas;
  private int proxima;

  private static RepositorioContasArray instance;

  /**
   * Construtor público
   * 
   * @param tamanho
   *          Tamanho inicial do array de contas a ser construído
   */
  private RepositorioContasArray(int tamanho) {
    this.contas = new Conta[tamanho];
    this.proxima = 0;
  }

  public static IRepositorioContas getInstance() {
    if (instance == null) {
      instance = lerDoArquivo();
    }
    return instance;
  }

  private static RepositorioContasArray lerDoArquivo() {
    RepositorioContasArray instanciaLocal = null;

    File in = new File("contas.dat");
    FileInputStream fis = null;
    ObjectInputStream ois = null;
    try {
      fis = new FileInputStream(in);
      ois = new ObjectInputStream(fis);
      Object o = ois.readObject();
      instanciaLocal = (RepositorioContasArray) o;
    } catch (Exception e) {
      instanciaLocal = new RepositorioContasArray(100);
    } finally {
      if (ois != null) {
        try {
          ois.close();
        } catch (IOException e) {/* Silent exception */
        }
      }
    }

    return instanciaLocal;
  }

  public void salvarArquivo() {
    if (instance == null) {
      return;
    }
    File out = new File("contas.dat");
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;

    try {
      fos = new FileOutputStream(out);
      oos = new ObjectOutputStream(fos);
      oos.writeObject(instance);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (oos != null) {
        try {
          oos.close();
        } catch (IOException e) {
          /* Silent */}
      }
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.ufrpe.sistema_bancario.dados.IRepositorio#cadastrar(br.ufrpe.
   * sistema_bancario.negocio.classes_basicas.Conta)
   */
  @Override
  public void cadastrar(Conta c) {
    this.contas[this.proxima] = c;
    this.proxima = this.proxima + 1;
    if (this.proxima == this.contas.length) {
      this.duplicaArrayContas();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * br.ufrpe.sistema_bancario.dados.IRepositorio#cadastrar(java.lang.String,
   * double)
   */
  public void cadastrar(String numero, double saldoInicial) {
    Conta c = new Conta(numero, saldoInicial);
    this.cadastrar(c);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * br.ufrpe.sistema_bancario.dados.IRepositorio#procurar(java.lang.String)
   */
  public Conta procurar(String num) {
    int i = this.procurarIndice(num);
    Conta resultado = null;
    if (i != this.proxima) {
      resultado = this.contas[i];
    }
    return resultado;
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.ufrpe.sistema_bancario.dados.IRepositorio#existe(java.lang.String)
   */
  public boolean existe(String numConta) {
    boolean existe = false;
    int indice = this.procurarIndice(numConta);
    if (indice != proxima) {
      existe = true;
    }
    return existe;
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.ufrpe.sistema_bancario.dados.IRepositorio#remover(java.lang.String)
   */
  public void remover(String num) throws ContaNaoExisteException {
    int i = this.procurarIndice(num);
    if (i != this.proxima) {
      this.contas[i] = this.contas[this.proxima - 1];
      this.contas[this.proxima - 1] = null;
      this.proxima = this.proxima - 1;
    } else {
      throw new ContaNaoExisteException(num);
    }
  }

  /**
   * Método auxiliar para procurar o índice de uma conta no array.
   * 
   * @param num
   *          Número da conta da qual deseja-se encontrar o índice no array de
   *          contas
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

  /*
   * (non-Javadoc)
   * 
   * @see
   * br.ufrpe.sistema_bancario.dados.IRepositorio#renderJuros(java.lang.String )
   */
  public void renderJuros(String num) {
    Conta c = this.procurar(num);
    if (c instanceof Poupanca) {
      ((Poupanca) c).renderJuros(this.taxaDeJuros);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.ufrpe.sistema_bancario.dados.IRepositorio#retornaContasVIP()
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

  public void metodoQualquer() {

  }

}
