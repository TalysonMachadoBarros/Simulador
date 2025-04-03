public class Zona {
    private String nome;
    private int geracaoLixo; // em toneladas
    private int distanciaEstacao; // em quilômetros
    private int tempoColeta; // em minutos

    public Zona(String nome, int geracaoLixo, int distanciaEstacao) {
        this.nome = nome;
        this.geracaoLixo = geracaoLixo;
        this.distanciaEstacao = distanciaEstacao;
        this.tempoColeta = calcularTempoColeta();
    }

    private int calcularTempoColeta() {
        // Supondo que a velocidade média do caminhão é de 30 km/h
        int velocidadeMedia = 30; // km/h
        return (int) Math.ceil((double) distanciaEstacao / velocidadeMedia * 60); // em minutos
    }

    public String getNome() {
        return nome;
    }

    public int getGeracaoLixo() {
        return geracaoLixo;
    }

    public int getDistanciaEstacao() {
        return distanciaEstacao;
    }

    public int getTempoColeta() {
        return tempoColeta;
    }
}