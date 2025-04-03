public class CaminhaoPequeno {
    private int capacidade;
    private int cargaAtual;
    private int viagensRealizadas;

    public CaminhaoPequeno(int capacidade) {
        this.capacidade = capacidade;
        this.cargaAtual = 0;
        this.viagensRealizadas = 0;
    }

    public void carregar(int carga) {
        this.cargaAtual += carga;
    }

    public boolean estaCheio() {
        return cargaAtual >= capacidade;
    }

    public void descarregar() {
        cargaAtual = 0;
        viagensRealizadas++;
    }

    public int getCargaAtual() {
        return cargaAtual;
    }

    public int getViagensRealizadas() {
        return viagensRealizadas;
    }

    public int getCapacidade() {
        return capacidade;
    }
}