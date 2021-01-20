package br.ufrpe.sistema_bancario.gui;

import br.ufrpe.sistema_bancario.dados.IRepositorioContas;
import br.ufrpe.sistema_bancario.dados.RepositorioContasArray;
import br.ufrpe.sistema_bancario.exceptions.ContaJaExisteException;
import br.ufrpe.sistema_bancario.exceptions.ContaNaoExisteException;
import br.ufrpe.sistema_bancario.exceptions.SaldoInsuficienteException;
import br.ufrpe.sistema_bancario.negocio.CadastroContas;
import br.ufrpe.sistema_bancario.negocio.beans.Conta;
import br.ufrpe.sistema_bancario.negocio.beans.Poupanca;

public class ClasseTesteCadastroContas {
    public static void main(String[] args) {
        IRepositorioContas instanciaRepositorio = RepositorioContasArray.getInstance();
        CadastroContas bancoDoBrasil = new CadastroContas(instanciaRepositorio);
        
        try {
            bancoDoBrasil.cadastrar(new Conta("222-1", 500.0));
            bancoDoBrasil.cadastrar(new Poupanca("555-2"));
            bancoDoBrasil.creditar("222-1", 152.30);
            bancoDoBrasil.creditar("555-2", 43.50);            
            bancoDoBrasil.transferir("222-1", "555-2", 56.50);
            bancoDoBrasil.transferir("666-7", "555-2", 23.50);
            
            double saldoTotal = bancoDoBrasil.getSaldo("222-1");
            bancoDoBrasil.debitar("222-1", saldoTotal);
        } catch (SaldoInsuficienteException sie) {
            System.out.println(sie.getMessage());
            System.out.println("Conta/Saldo: " + sie.getNumero() + "/" + sie.getSaldo());
        } catch (ContaNaoExisteException cne) {
            cne.printStackTrace();
        } catch (ContaJaExisteException cje) {
            cje.printStackTrace();
        }
    } 
}
