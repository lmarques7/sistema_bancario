package ufrpe.main;

import java.util.ArrayList;

public class ArrayListTests {

    public static void main(String[] args) {
        
        ArrayList<String> nomes = new ArrayList();
        
        nomes.add("Leandro");
        nomes.add("Orientação a objetos");
        nomes.add("azul");
        
        for(String item : nomes) {
            System.out.println("Item da lista: " + item);
        }

    }

}
