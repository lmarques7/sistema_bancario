package ufrpe.notas;

public class LivroNotasArray {
    
    private double notas[];
    private int azul;
    private int qtdNotas;
    
    public LivroNotasArray(int tamanho) {
        notas = new double[tamanho];
        qtdNotas = 0;
    }
    
    public void adicionarNota(double novaNota) {
        notas[qtdNotas] = novaNota;
        qtdNotas++;
    }
    
    public double calculaMedia() {
        double media = 0;
        if (qtdNotas > 0) {
            double somaNotas = 0;
            for(int i = 0; i < qtdNotas; i++) {
                somaNotas += notas[i];
            }
            media = somaNotas / qtdNotas;
        }
        return media;
    }
    
    public double getMaiorNota() {
        double maiorNota = 0;
        for(int i = 0; i < qtdNotas; i++) {
            if (notas[i] > maiorNota) {
                maiorNota = notas[i];
            }
        }
        return maiorNota;
    }
    
    public double getMenorNota() {
        double menorNota = 0;
        
        if (qtdNotas > 0) {
            menorNota = notas[0];
        }
        
        for(int i = 0; i < qtdNotas; i++) {
            if (notas[i] < menorNota) {
                menorNota = notas[i];
            }
        }
        return menorNota;
    }
    

}
