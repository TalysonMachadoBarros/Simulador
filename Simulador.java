public class Simulador {
    private Lista<Zona> zonas;
    private Lista<CaminhaoPequeno> pequenos;
    private Lista<CaminhaoGrande> grandes;
    private EstacaoTransferencia estacao;

    private final int DURACAO_DIA_MINUTOS = 1440; // 24 horas

    public Simulador() {
        zonas = new Lista<>();
        pequenos = new Lista<>();
        grandes = new Lista<>();
        estacao = new EstacaoTransferencia(500); // capacidade da estação em toneladas

        configurarZonas();
        configurarCaminhoes();
    }

    private void configurarZonas() {
        zonas.adicionar(new Zona("Sul", 12, 23));
        zonas.adicionar(new Zona("Norte", 12, 23));
        zonas.adicionar(new Zona("Centro", 13, 23));
        zonas.adicionar(new Zona("Leste", 12, 23));
        zonas.adicionar(new Zona("Sudeste", 12, 23));
    }

    private void configurarCaminhoes() {
        for (int i = 0; i < zonas.tamanho(); i++) {
            Zona z = zonas.obter(i);
            pequenos.adicionar(new CaminhaoPequeno(2, 6, zonas));
            pequenos.adicionar(new CaminhaoPequeno(4, 6, zonas));
            pequenos.adicionar(new CaminhaoPequeno(8, 6, zonas));
        }

        // Começa com apenas 1 caminhão grande
        grandes.adicionar(new CaminhaoGrande());
    }

    public void rodarSimulacao(int dias) {
        for (int dia = 1; dia <= dias; dia++) {
            System.out.println("\n=== DIA " + dia + " ===");

            // Resetar viagens dos pequenos no início de cada dia
            for (int i = 0; i < pequenos.tamanho(); i++) {
                pequenos.obter(i).viagensFeitas = 0;
            }

            for (int minuto = 0; minuto < DURACAO_DIA_MINUTOS; minuto++) {

                // Atualizar caminhões pequenos
                for (int i = 0; i < pequenos.tamanho(); i++) {
                    CaminhaoPequeno cp = pequenos.obter(i);

                    cp.avancarTempo(minuto);

                    if (cp.chegouNaEstacao()) {
                        cp.descarregarNaEstacao(estacao, minuto);
                    }
                }


                // Atualizar caminhões grandes
                boolean estacaoTemLixo = estacao.temLixoDisponivel();
                boolean algumDisponivel = false;

                for (int i = 0; i < grandes.tamanho(); i++) {
                    CaminhaoGrande cg = grandes.obter(i);

                    if (cg.estaDisponivel()) {
                        algumDisponivel = true;

                        if (estacaoTemLixo) {
                            cg.carregar(estacao,minuto);
                            break; // Apenas um caminhão grande coleta por minuto
                        }
                    } else {
                        cg.avancarTempo();
                    }
                }

                // Adiciona novo caminhão grande se necessário
                if (estacao.estaCheia() && !algumDisponivel) {
                    CaminhaoGrande novo = new CaminhaoGrande();
                    novo.carregar(estacao,minuto);
                    grandes.adicionar(novo);
                    System.out.println(formatarHora(minuto) + " - Novo caminhão grande adicionado por emergência.");
                }
            }

            System.out.println("Lixo restante na estação ao fim do dia: " + estacao.getLixoAcumulado() + " toneladas.");
        }

        System.out.println("\nTotal de caminhões grandes utilizados: " + grandes.tamanho());
    }

    private String formatarHora(int minuto) {
        int h = minuto / 60;
        int m = minuto % 60;
        return String.format("%02d:%02d", h, m);
    }
}