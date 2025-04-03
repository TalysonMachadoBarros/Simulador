public class EstacaoTransferencia {
    int armazenamento;
    private Fila<CaminhaoPequeno> filaCaminhoes;

    public EstacaoTransferencia() {
        filaCaminhoes = new Fila<>();
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
