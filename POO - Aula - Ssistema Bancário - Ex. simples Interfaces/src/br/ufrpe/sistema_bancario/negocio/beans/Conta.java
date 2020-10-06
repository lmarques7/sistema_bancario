package br.ufrpe.sistema_bancario.negocio.beans;
public class Conta {

    private String numero;
    protected double saldo;
    
    public Conta(String num, double saldoInicial) {
        this.numero = num;
        this.saldo = saldoInicial;
    }
    
    public double getSaldo() {
        return this.saldo;
    }
    
    public String getNumero() {
        return this.numero;
    }

    public void debitar(double valor) {
        if (this.saldo >= valor) {
            this.saldo = this.saldo - valor;
            System.out.println("Débito realizado na conta " + 
                    this.numero  + " valor: " + valor);
        } else {
            System.out.println("Saldo insuficiente na conta " + this.numero);
        }
    }
    
    public void creditar(double valor){
        this.saldo = this.saldo + valor;
        System.out.println("Crédito realizado na conta " + this.numero  
                + " valor: " + valor);
    }
}
