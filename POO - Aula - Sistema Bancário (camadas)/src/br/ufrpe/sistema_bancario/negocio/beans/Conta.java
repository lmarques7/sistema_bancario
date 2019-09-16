package br.ufrpe.sistema_bancario.negocio.beans;

public class Conta {

	private String numero;
	private double saldo;
	
	public Conta(String numero, double saldo){
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
			// Possivel exce��o a ser levantada
		}
	}

	private void setSaldo(double saldo) {
		if (saldo >= 0.0) {
			this.saldo = saldo;	
		}else{
		  // Possivel exce��o a ser levantada
		}
	}
	
	public void creditar (double valor) {
	    // Um cr�dito negativo seria um d�bito
		if (valor > 0 ) {
			this.saldo = this.saldo + valor;
		} else {
		  // Possivel exce��o a ser levantada		
		}
	}
	
	public void debitar (double valor) {
		if (valor > 0 && this.saldo >= valor) {
			this.saldo = this.saldo - valor;
		} else {
		  // Possivel exce��o a ser levantada
		}
	}
	
	public String toString() {
	  String resultado = "************************************\n";
	  resultado += String.format("* %16s %15s *\n", "N�mero da conta:", this.numero);
	  resultado += String.format("* %16s %15.2f *\n", "Saldo atual:", this.saldo);
	  resultado += "************************************\n";
	  return resultado;
	}
	
	public static void main(String[] args) {
	  Conta c1 = new Conta("456789-95", 154657867);
	  String texto = c1.toString();
	  System.out.println(texto);
	  System.out.println(c1); // Mesmo resultado da linha acima
  }
}
