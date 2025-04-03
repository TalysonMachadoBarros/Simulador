import java.util.Timer;
import java.util.TimerTask;

public class SimuladorColetaLixo {
    private Lista<CaminhaoPequeno> caminhoesPequenos;
    private Lista<CaminhaoGrande> caminhoesGrandes;
    private EstacaoTransferencia estacao1;
    private EstacaoTransferencia estacao2;
    private Lista<Zona> zonas;
    private Timer timer = new Timer();
    private long startTime = System.currentTimeMillis();
    private TimerTask task;

    public SimuladorColetaLixo() {
        caminhoesPequenos = new Lista<>();
        caminhoesGrandes = new Lista<>();
        estacao1 = new EstacaoTransferencia(500);
        estacao2 = new EstacaoTransferencia(500);
        zonas = new Lista<>();
        this.inicializarZonas();

    }

    private void inicializarZonas() {
        this.zonas.add(new Zona("Norte", 10, 50));
        this.zonas.add(new Zona("Sul", 20, 50));
        this.zonas.add(new Zona("darte", 30, 50));
        this.zonas.add(new Zona("ijl", 40, 50));

    }

    public void adicionarCaminhaoPequeno(CaminhaoPequeno caminhao) {
        this.caminhoesPequenos.add(caminhao);
    }

    public void adicionarCaminhaoGrande(CaminhaoGrande caminhao) {
        this.caminhoesGrandes.add(caminhao);
    }

    public void iniciar() {
        System.out.println("Estou iniciando");
        this.task = new TimerTask() {
            @Override
            public void run() {
                long elapsedTime = System.currentTimeMillis() - startTime;
                System.out.println("Rodando: " + elapsedTime + " ms");
                try {
                    Thread.sleep(1000); // Aguarda 10 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        // Agenda a tarefa para ser executada a cada 1000 ms
        this.timer.scheduleAtFixedRate(this.task, 0, 1000);

    }

    public void pausar() {
        System.out.println("Estou pausando");
        try {
            this.timer.purge();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.continuar();
    }

    public void continuar() {
        System.out.println("Estou continuando");
        this.timer.scheduleAtFixedRate(this.task, 0, 1000);
        // timer.scheduleAtFixedRate(this.task, 0, 1000);

    }

    public void parar() {
        System.out.println("Estou parando");
        // Cancela o timer
        timer.cancel();
    }

    public void simularColeta() {
        // Simulação de coleta de lixo
        for (int i = 0; i < zonas.size(); i++) {
            System.out.println(i);
            Zona zona = zonas.remove();
            int lixoColetado = zona.getGeracaoLixo();
            System.out.println("------------------------");
            System.out.println("Lixo Gerado: " + lixoColetado);

            // Simular a coleta de lixo
            for (int j = 0; j <= caminhoesPequenos.size(); j++) {
                CaminhaoPequeno caminhao = caminhoesPequenos.remove();
                caminhao.carregar(lixoColetado - caminhao.getCapacidade());
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
                } else if (!estacao2.filaVazia()) {
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