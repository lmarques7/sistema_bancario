package br.ufrpe.sistema_bancario.exceptions;

public class SaldoInsuficienteException extends Exception {

    private String numero;
    private double saldo;

    public SaldoInsuficienteException(double saldo, String num) {
        super("O saldo da conta de número " + num + " é insuficiente "
                + "para realizar a transaçao. Saldo atual: " + saldo);
        this.numero = num;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

}
