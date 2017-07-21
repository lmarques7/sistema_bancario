package br.ufrpe.sistema_bancario.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.sistema_bancario.negocio.beans.Conta;

/**
 * Classe de exemplo de uso de generics para implementação de repositórios
 * 
 * @author Leandro M. Nascimento
 *
 */
public class ContasArrayListDAO extends AbstractArrayListDAO<Conta> {
    
    public ContasArrayListDAO() {
        super();
        
        // Exemplo de chamada de código da super classe com tipo definido
        Conta newObj = new Conta ("8976-8", 200.50);
        this.create(newObj);
    }
    
    public List<Conta> listarContasIndadimplentes() {
        List<Conta> sublista = new ArrayList<>();
        for (Conta conta : this.elements) {
            if (conta.getSaldo() < 0) {
                sublista.add(conta);
            }
        }
        
        return sublista;
    }
}
