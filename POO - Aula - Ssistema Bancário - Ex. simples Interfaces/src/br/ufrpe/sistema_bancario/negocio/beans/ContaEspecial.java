package br.ufrpe.sistema_bancario.negocio.beans;
public class ContaEspecial extends Conta {
    private double limite;

    public ContaEspecial(String numero) {
        super(numero, 0.0);
        this.limite = 100.0;
    }

    public void aumentarLimite(double aumento) {
        this.limite += aumento;
    }

    public double getLimite() {
        return this.limite;
    }

    public void debitar(double valor) {
        if (valor < this.saldo + this.limite) {
            this.saldo = this.saldo - valor;
        }
    }

    public void calcularJuros() {
        if (this.saldo < 0) {
            // Calculando o valor absoluto dos juros, porque n�o faz sentido
            // dos juros serem negativos e o d�bito ser feito de um valor
            // negativo torna-se-� um cr�dito
            double juros = Math.abs(this.saldo * 0.05);
            this.debitar(juros);
        }
    }

    /**
     * C�digo para teste
     * 
     * @param args
     */
    public static void main(String[] args) {
        Conta contae = new ContaEspecial("21345-8");
        contae.creditar(500.0);
        contae.debitar(550.0);
        ((ContaEspecial) contae).aumentarLimite(100.0);
        contae.debitar(75.0);
        ((ContaEspecial) contae).calcularJuros();
        System.out.println(contae.getSaldo());
        
        Conta c = new Conta("123-6", 55.0);
        c.getClass();
    }
}