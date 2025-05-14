public class Zona {
    public String nome;
    public int lixoMin;
    public int lixoMax;
    public int lixoDisponivel;

    public Zona(String nome, int lixoMin, int lixoMax) {
        this.nome = nome;
        this.lixoMin = lixoMin;
        this.lixoMax = lixoMax;
        this.lixoDisponivel = gerarLixo();
    }

    public int gerarLixo() {
        return lixoMin + (int)(Math.random() * (lixoMax - lixoMin + 1));
    }

    public int coletarLixo(int capacidade) {
        int coletado = Math.min(capacidade, lixoDisponivel);
        lixoDisponivel -= coletado;
        return coletado;
    }

    public boolean temLixo() {
        return lixoDisponivel > 0;
    }
}
