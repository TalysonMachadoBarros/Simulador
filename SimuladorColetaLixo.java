public class SimuladorColetaLixo {
    private Lista<CaminhaoPequeno> caminhoesPequenos;
    private Lista<CaminhaoGrande> caminhoesGrandes;
    private EstacaoTransferencia estacao1;
    private EstacaoTransferencia estacao2;
    private Lista<Zona> zonas;

    public SimuladorColetaLixo() {
        caminhoesPequenos = new Lista<>();
        caminhoesGrandes = new Lista<>();
        estacao1 = new EstacaoTransferencia();
        estacao2 = new EstacaoTransferencia();
        zonas = new Lista<>();
        inicializarZonas();
    }

    private void inicializarZonas() {
        zonas.add(new Zona("Norte", 10, 50));
        zonas.add(new Zona("Sul", 20, 50));


    }

    public void adicionarCaminhaoPequeno(CaminhaoPequeno caminhao) {
        caminhoesPequenos.add(caminhao);
    }

    public void adicionarCaminhaoGrande(CaminhaoGrande caminhao) {
        caminhoesGrandes.add(caminhao);
    }

    public void simularColeta() {
        // Simulação de coleta de lixo
        for (int i = 0; i <= zonas.size(); i++) {
            Zona zona = zonas.remove();
            int lixoColetado = zona.getGeracaoLixo();
            System.out.println("------------------------");
            System.out.println("Lixo Gerado: " + lixoColetado);

            // Simular a coleta de lixo
            for (int j = 0; j <= caminhoesPequenos.size(); j++) {
                CaminhaoPequeno caminhao = caminhoesPequenos.remove();
                caminhao.carregar(lixoColetado);
                System.out.println("-------------------------------------");
                System.out.println("Lixo Coletado " + lixoColetado);
                System.out.println(" ");
                if (caminhao.estaCheio()) {
                    if (estacao1.filaVazia()) {
                        estacao1.adicionarCaminhao(caminhao);
                        System.out.println("Caminhao Adicionado com sucesso!");
                    } else {
                        estacao2.adicionarCaminhao(caminhao);
                        System.out.println("Caminhao Adicionado com sucesso!2");
                    }
                }
                caminhoesPequenos.add(caminhao); // Re-adiciona o caminhão à lista
                System.out.println("Tempo medio de Coleta " + zona.getTempoColeta() + " Minutos");
                System.out.println(" ");
            }

            // Lógica para caminhões grandes e estatísticas
            for (int l = 0; l < caminhoesGrandes.size(); l++) {
                CaminhaoGrande caminhaoGrande = caminhoesGrandes.remove();
                if (!estacao1.filaVazia()) {
                    CaminhaoPequeno caminhaoPequeno = estacao1.removerCaminhao();
                    caminhaoGrande.carregar(caminhaoPequeno.getCargaAtual());
                    System.out.println("Caminhao Grande Carregado com sucesso!");
                    System.out.println(caminhaoGrande.getCargaAtual());
                    caminhaoPequeno.descarregar();
                    System.out.println("Caminhao Pequeno Voltou ao trabalho!");
                }else if (!estacao2.filaVazia()) {
                    CaminhaoPequeno caminhaoPequeno = estacao2.removerCaminhao();
                    caminhaoGrande.carregar(caminhaoPequeno.getCargaAtual());
                    System.out.println("Caminhao Grande Carregado com sucesso!");
                    System.out.println(caminhaoGrande.getCargaAtual());
                    caminhaoPequeno.descarregar();
                    System.out.println("Caminhao Pequeno Voltou ao trabalho!");
                }
                caminhoesGrandes.add(caminhaoGrande); // Re-adiciona o caminhão grande à lista
            }
        }
    }
}