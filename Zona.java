public class Zona {
    String nomeZona;
    int tempoGerLixo;
    double pesoLixo;

    public Zona(String nomeZona, int tempoGerLixo) {
        this.nomeZona = nomeZona;
        this.tempoGerLixo = tempoGerLixo;
    }

    public void gerarLixo() {
        pesoLixo += 10;
    }
}

