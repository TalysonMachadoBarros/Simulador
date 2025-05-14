public class CaminhaoGrande {
    public final int capacidadeMax = 20;
    public int cargaAtual = 0;
    public boolean emViagem = false;
    public int tempoRestanteViagem = 0;

    private final int tempoViagemCompleto = 60;

    public boolean podeCarregar(EstacaoTransferencia estacao) {
        return !emViagem && estacao.temLixoDisponivel();
    }

    public void carregar(EstacaoTransferencia estacao, int minutoAtual) {
        cargaAtual = estacao.fornecerLixo(Math.min(capacidadeMax, estacao.getLixoAcumulado()));
        emViagem = true;
        tempoRestanteViagem = tempoViagemCompleto;
        System.out.println(formatarHora(minutoAtual) + " - Caminhão grande saiu com " + cargaAtual + " toneladas.");
    }

    public void avancarTempo() {
        if (emViagem) {
            tempoRestanteViagem--;
            if (tempoRestanteViagem <= 0) {
                descarregarNoLixao();
            }
        }
    }

    private void descarregarNoLixao() {
        System.out.println("Caminhão grande descarregou " + cargaAtual + " toneladas no Lixao e ja esta disponivel para a proxima viagem");
        cargaAtual = 0;
        emViagem = false;
    }

    public boolean estaDisponivel() {
        return !emViagem;
    }

    private String formatarHora(int minuto) {
        int h = minuto / 60;
        int m = minuto % 60;
        return String.format("%02d:%02d", h, m);
    }
}