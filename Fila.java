package teste2;

public class Fila<T> {
    private Lista<T> lista;

    public Fila() {
        lista = new Lista<>();
    }

    public void enqueue(T data) {
        lista.add(data);
    }

    public T dequeue() {
        return lista.remove();
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }

    public int size() {
        return lista.size();
    }
}