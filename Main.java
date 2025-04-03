public class Main {
    public static void main(String[] args) {
        SimuladorColetaLixo simulador = new SimuladorColetaLixo();

        // Adicionar caminhões pequenos
        simulador.adicionarCaminhaoPequeno(new CaminhaoPequeno(2));
        simulador.adicionarCaminhaoPequeno(new CaminhaoPequeno(4));
        simulador.adicionarCaminhaoPequeno(new CaminhaoPequeno(8));
        simulador.adicionarCaminhaoPequeno(new CaminhaoPequeno(10));

        // Adicionar caminhões grandes
        simulador.adicionarCaminhaoGrande(new CaminhaoGrande());
        simulador.adicionarCaminhaoGrande(new CaminhaoGrande());

        // Iniciar a simulação
        System.out.println("Coleta Iniciada!");
        simulador.simularColeta();

        System.out.println("Coleta Finalizada!");
    }
}