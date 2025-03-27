public class Caminhao {
    String cor;
    double capacidadeMaxima;
    double cargaAtual;

    public Caminhao(String cor, double capacidadeMaxima, double cargaAtual) {
        this.cor = cor;
        this.capacidadeMaxima = capacidadeMaxima;
        this.cargaAtual = cargaAtual;
    }

     public boolean estaCheio() {
        return cargaAtual >= capacidadeMaxima;
     }

     public void carregar(double pesoLixo) {
        if (cargaAtual + pesoLixo <= capacidadeMaxima) {
            cargaAtual += pesoLixo;
        } else {
            System.out.println("Capacidade Máxima Atingida");
        }
     }
}
