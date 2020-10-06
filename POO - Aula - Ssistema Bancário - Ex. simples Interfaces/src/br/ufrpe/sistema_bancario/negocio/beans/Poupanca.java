package br.ufrpe.sistema_bancario.negocio.beans;

public class Poupanca extends Conta {

    public Poupanca(String numero){
        super(numero, 0.0);
    }
    
    public void renderJuros(double taxa) {
        this.creditar(this.getSaldo()*taxa);
    }
    
}
