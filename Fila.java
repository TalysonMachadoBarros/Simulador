public class Fila<T> {
    private static class No<T> {
        T valor;
        No<T> proximo;
        No(T valor) {
            this.valor = valor;
        }
    }

    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

    public void enfileirar(T valor) {
        No<T> novo = new No<>(valor);
        if (fim != null) {
            fim.proximo = novo;
        } else {
            inicio = novo;
        }
        fim = novo;
        tamanho++;
    }

    public T desenfileirar() {
        if (inicio == null) return null;
        T valor = inicio.valor;
        inicio = inicio.proximo;
        if (inicio == null) fim = null;
        tamanho--;
        return valor;
    }

    public T frente() {
        return (inicio != null) ? inicio.valor : null;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }
}