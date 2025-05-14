public class Lista<T> {
    private No<T> inicio;
    private int tamanho;

    private static class No<T> {
        T valor;
        No<T> proximo;
        No(T valor) { this.valor = valor; }
    }

    public void adicionar(T valor) {
        No<T> novo = new No<>(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            No<T> atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
        tamanho++;
    }

    public T obter(int indice) {
        if (indice < 0 || indice >= tamanho) return null;
        No<T> atual = inicio;
        for (int i = 0; i < indice; i++) atual = atual.proximo;
        return atual.valor;
    }

    public int tamanho() {
        return tamanho;
    }
}