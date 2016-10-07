package ufrpe.main;

public class AppAnuncio {

    public static void main(String[] parametros) {
        if (parametros.length > 0) {
            for(int i = 0; i < parametros.length; i++) {
                System.out.println("Param " + i + ": " + parametros[i]);
            }
        }
        System.out.println("Atualizado");
    }

}
