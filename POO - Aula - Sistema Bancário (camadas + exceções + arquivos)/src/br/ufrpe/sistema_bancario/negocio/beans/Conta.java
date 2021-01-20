package br.ufrpe.sistema_bancario.negocio.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;

import br.ufrpe.sistema_bancario.exceptions.SaldoInsuficienteException;

public class Conta implements Serializable {

  private static final long serialVersionUID = -2936766067409686658L;
  private String numero;
  protected double saldo;

  public Conta(String numero, double saldo) {
    this.setNumero(numero);
    this.setSaldo(saldo);
  }

  public String getNumero() {
    return numero;
  }

  public double getSaldo() {
    return saldo;
  }

  private void setNumero(String numero) {
    if (numero != null) {
      this.numero = numero;
    } else {
      System.out.println("Número inválido");
    }
  }

  private void setSaldo(double saldo) {
    if (saldo >= 0.0) {
      this.saldo = saldo;
    } else {
      System.out.println("Saldo inválido");
    }
  }

  public boolean creditar(double valor) {
    boolean resultado;
    if (valor > 0) {
      this.saldo = this.saldo + valor;
      resultado = true;
    } else {
      resultado = false;
    }
    return resultado;
  }

  public void debitar(double valor) throws SaldoInsuficienteException {
    if (this.saldo >= valor) {
      this.saldo = this.saldo - valor;      
    } else {
        SaldoInsuficienteException sie = new SaldoInsuficienteException(this.saldo, this.numero);
        throw sie;
    }
  }

    public static void main(String[] args) {
        
//        List<Conta> contas = new ArrayList<Conta>();
//        
//        contas.add(new Conta("1234-5", 250));
//        
//        contas.add(new Conta("999-87", 500));
//        
//        
//        File f = new File("meuArquivo.dat");
//        ObjectOutputStream ous = null;
//        try {
//            FileOutputStream fos = new FileOutputStream(f);
//            ous = new ObjectOutputStream(fos);
//            
//            ous.writeObject(contas);
//            
//            ous.close();
//            
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            if (ous != null) {
//                try {
//                    ous.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        
//        System.out.println("contas escritas no arquivo");
        
        File f = new File("meuArquivo.dat");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            List<Conta> contas = (List<Conta>) ois.readObject();
            
            for (Conta conta : contas) {
                System.out.println(conta.getNumero());
                System.out.println(conta.getSaldo());
                System.out.println("=========");
            }
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
}
