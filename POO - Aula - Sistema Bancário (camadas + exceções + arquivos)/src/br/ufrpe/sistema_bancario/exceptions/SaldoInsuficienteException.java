package br.ufrpe.sistema_bancario.exceptions;

public class SaldoInsuficienteException extends Exception {

    private String numero;
    private double saldo;

    public SaldoInsuficienteException(double saldo, String num) {
        super("O saldo da conta de n�mero " + num + " � insuficiente "
                + "para realizar a transa�ao. Saldo atual: " + saldo);
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
