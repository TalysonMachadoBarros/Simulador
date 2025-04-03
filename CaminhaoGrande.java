package teste2;

public class CaminhaoGrande {
    private int capacidade;
    private int cargaAtual;

    public CaminhaoGrande() {
        this.capacidade = 20; // Capacidade fixa de 20 toneladas
        this.cargaAtual = 0;
    }

    public void carregar(int carga) {
        this.cargaAtual += carga;
    }

    public boolean estaVazio() {
        return cargaAtual == 0;
    }

    public void descarregar() {
        cargaAtual = 0;
        System.out.println("Caminhão descarregado " + cargaAtual);
    }

    public int getCargaAtual() {
        return cargaAtual;
    }
}
