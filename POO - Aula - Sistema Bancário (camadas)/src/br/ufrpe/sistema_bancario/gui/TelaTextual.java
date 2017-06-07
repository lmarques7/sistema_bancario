package br.ufrpe.sistema_bancario.gui;

import br.ufrpe.sistema_bancario.negocio.ServidorBanco;
import br.ufrpe.sistema_bancario.negocio.beans.Conta;

public class TelaTextual {

    public void executarOperacoes() {
        ServidorBanco bancoDoBrasil = ServidorBanco.getInstance();

        bancoDoBrasil.cadastrarConta(new Conta("222-1", 10.0));
        bancoDoBrasil.cadastrarConta(new Conta("333-1", 30.0));

        bancoDoBrasil.creditarEmConta("222-1", 152.30);
        bancoDoBrasil.creditarEmConta("333-1", 35.70);
        bancoDoBrasil.creditarEmConta("666-7", 43.50);

        bancoDoBrasil.transferirEntreContas("666-7", "555-2", 23.50);
        bancoDoBrasil.transferirEntreContas("222-1", "555-2", 56.50);
        double saldoTotal = bancoDoBrasil.getSaldoDaConta("222-1");
        bancoDoBrasil.debitarDaConta("222-1", saldoTotal);
    }

}
