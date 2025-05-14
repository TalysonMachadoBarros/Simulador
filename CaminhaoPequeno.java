public class CaminhaoPequeno {
    public int capacidade;
    public int cargaAtual;
    public int tempoRestanteViagem;
    public boolean emViagem;
    public int viagensFeitas;
    public int viagensMax;

    private Lista<Zona> zonas;
    private Zona zonaAtual;
    private int tempoColetaRestante;

    private enum Estado {
        INDO_COLETAR, COLETANDO, INDO_PARA_ESTACAO, DESCARREGANDO
    }

    private Estado estado;

    public CaminhaoPequeno(int capacidade, int viagensMax, Lista<Zona> zonas) {
        this.capacidade = capacidade;
        this.viagensMax = viagensMax;
        this.zonas = zonas;
        this.cargaAtual = 0;
        this.viagensFeitas = 0;
        this.emViagem = false;
        this.tempoRestanteViagem = 0;
        this.tempoColetaRestante = 0;
        this.estado = Estado.INDO_COLETAR;
    }

    public void avancarTempo(int minutoAtual) {
        if (estado == null) return;

        switch (estado) {
            case INDO_COLETAR:
                zonaAtual = escolherZonaComLixo();
                if (zonaAtual != null) {
                    tempoColetaRestante = 5; // tempo de preparação
                    estado = Estado.COLETANDO;
                    System.out.println(formatarHora(minutoAtual) + " - Caminhão pequeno (" + capacidade + "t) indo coletar na zona " + zonaAtual.nome);
                }
                break;

            case COLETANDO:
                if (tempoColetaRestante > 0) {
                    tempoColetaRestante--;
                } else {
                    int coletado = zonaAtual.coletarLixo(capacidade - cargaAtual);
                    cargaAtual += coletado;

                    System.out.println(formatarHora(minutoAtual) + " - Coletado " + coletado + "t de lixo na zona " + zonaAtual.nome + ". Total atual: " + cargaAtual + "t");

                    if (cargaAtual >= capacidade || !zonaAtual.temLixo()) {
                        tempoRestanteViagem = 30;
                        emViagem = true;
                        estado = Estado.INDO_PARA_ESTACAO;
                        System.out.println(formatarHora(minutoAtual) + " - Caminhão pequeno (" + capacidade + "t) indo para estação com " + cargaAtual + "t");
                    } else {
                        tempoColetaRestante = 5;
                    }
                }
                break;

            case INDO_PARA_ESTACAO:
                if (tempoRestanteViagem > 0) {
                    tempoRestanteViagem--;
                } else {
                    emViagem = false;
                    estado = Estado.DESCARREGANDO;
                }
                break;

            case DESCARREGANDO:
                break;
        }
    }

    public boolean chegouNaEstacao() {
        return estado == Estado.DESCARREGANDO;
    }

    public void descarregarNaEstacao(EstacaoTransferencia estacao, int minutoAtual) {
        estacao.receberLixo(cargaAtual);
        System.out.println(formatarHora(minutoAtual) + " - Caminhão pequeno (" + capacidade + "t) descarregou " + cargaAtual + "t na estação.");
        cargaAtual = 0;
        viagensFeitas++;

        if (viagensFeitas >= viagensMax) {
            estado = null;
            System.out.println(formatarHora(minutoAtual) + " - Caminhão pequeno (" + capacidade + "t) atingiu limite de viagens.");
        } else {
            estado = Estado.INDO_COLETAR;
        }
    }

    public boolean estaDisponivel() {
        return estado != null;
    }

    private Zona escolherZonaComLixo() {
        int tentativas = zonas.tamanho();
        while (tentativas-- > 0) {
            int index = (int) (Math.random() * zonas.tamanho());
            Zona z = zonas.obter(index);
            if (z.temLixo()) return z;
        }
        return null;
    }

    private String formatarHora(int minuto) {
        int h = minuto / 60;
        int m = minuto % 60;
        return String.format("%02d:%02d", h, m);
    }
}
