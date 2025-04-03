public class EstacaoTransferencia {
    private int armazenamento;
    private Fila<CaminhaoPequeno> filaCaminhoes;

    public EstacaoTransferencia(int armazenamento) {
        filaCaminhoes = new Fila<>();
        this.armazenamento = armazenamento;
    }

    public void adicionarCaminhao(CaminhaoPequeno caminhao) {
        filaCaminhoes.enqueue(caminhao);
    }

    public CaminhaoPequeno removerCaminhao() {
        return filaCaminhoes.dequeue();
    }

    public boolean filaVazia() {
        return filaCaminhoes.isEmpty();
    }
}
