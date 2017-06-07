package br.ufrpe.sistema_bancario.negocio.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class ContaTeste {

    public static void main(String[] args) {
        
//        if (args.length > 0) {
//            for (int i = 0; i < args.length; i++) {
//                System.out.print(args[i] + "  -  ");
//            }
//        } else {
//            System.out.println("Nenhum parâmetro informado");
//        }
        
        String teste = "Testando em sala de aula";
        char[] array = teste.toCharArray();
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'a') {
                array[i] = ' ';
            }
        }
        
        String nova = new String(array);
        System.out.println(teste);
        System.out.println(nova);
        
        ArrayList<String> nomes = new ArrayList<>();
        
//        Random seed = new Random();
//        int a = seed.nextInt(50) + 1;
//        LocalDateTime d = LocalDateTime.of(2017, 5, 19, 14, 55, 12);
//        
//        Conta c = new Conta("777-8", 559.50);
//        Conta c1 = new Conta("888-9", 100);
//        Conta c2 = new Conta("888-9", 100);
//        
//        int valor = 15;
//        c.creditar((short) valor);
//        
//        System.out.println(c);
//        System.out.println(c1.toString());
//        System.out.println(c2);
//
//        if (c1.equals(c2)) {
//            System.out.println("são iguais");
//        } else {
//            System.out.println("não são iguais");
//        }
    }

}
