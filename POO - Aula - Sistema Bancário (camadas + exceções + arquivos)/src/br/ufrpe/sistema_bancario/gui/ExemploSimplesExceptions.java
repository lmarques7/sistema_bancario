package br.ufrpe.sistema_bancario.gui;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExemploSimplesExceptions {

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            System.out.println("Digite um valor inteiro: ");
            int valorDigitado = sc.nextInt();
            System.out.println(valorDigitado * 5);
        } catch (InputMismatchException ime) {
            System.out.println("Você digitou um valor não inteiro");
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        
        // Usando sintaxe Java 7+ com recursos do tipo Closeable (Scanner implements Closeable)
        try (Scanner sc2 = new Scanner(System.in)) {
            // Seguindo mesma estrutura do código acima
        } catch (Exception e) {
        }
        
        File f = new File("meuArquivo.dat");
        try {
            f.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
