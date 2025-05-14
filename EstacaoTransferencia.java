public class EstacaoTransferencia {
    private int lixoAcumulado; // em toneladas
    private int capacidadeMaxima; // pode ser algo como 200 toneladas

    public EstacaoTransferencia(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.lixoAcumulado = 0;
    }

    // Caminhão pequeno descarrega lixo aqui
    public void receberLixo(int quantidade) {
        lixoAcumulado += quantidade;
        if (lixoAcumulado > capacidadeMaxima) {
            lixoAcumulado = capacidadeMaxima;
        }
    }

    // Caminhão grande coleta lixo aqui
    public int fornecerLixo(int capacidadeSolicitada) {
        int fornecido = Math.min(lixoAcumulado, capacidadeSolicitada);
        lixoAcumulado -= fornecido;
        return fornecido;
    }

    public int getLixoAcumulado() {
        return lixoAcumulado;
    }

    public boolean temLixoDisponivel() {
        return lixoAcumulado > 0;
    }

    public boolean estaCheia() {
        return lixoAcumulado >= capacidadeMaxima;
    }
}