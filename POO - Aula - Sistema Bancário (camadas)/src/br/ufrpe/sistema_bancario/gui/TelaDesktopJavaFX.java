package br.ufrpe.sistema_bancario.gui;

import javax.swing.JFrame;

import br.ufrpe.sistema_bancario.negocio.ServidorBanco;
import br.ufrpe.sistema_bancario.negocio.beans.Conta;

public class TelaDesktopJavaFX extends JFrame {
    
    public TelaDesktopJavaFX () {
        super("Meu frame de cadastro de clientes");
        
        Conta c = new Conta("1234-5", 100);
        ServidorBanco.getInstance().cadastrarConta(c);
        
    }

}
