package br.ufrpe.sistema_bancario.dados;

import br.ufrpe.sistema_bancario.negocio.beans.Conta;

/**
 * Classe vazia somente para simbolizar uma segunda classe que implementa a 
 * mesma interface IRepositorioContas
 *  
 * @author lmarq
 *
 */
public class RepositorioContasBDR implements IRepositorioContas {

    @Override
    public void cadastrar(Conta c) {
        // TODO Auto-generated method stub
    }

    @Override
    public void cadastrar(String numero, double saldoInicial) {
        // TODO Auto-generated method stub
    }

    @Override
    public Conta procurar(String num) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void remover(String num) {
        // TODO Auto-generated method stub
    }

    @Override
    public void renderJuros(String num) {
        // TODO Auto-generated method stub
    }

}
