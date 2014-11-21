package Grafos;

import java.util.LinkedList;

/**
 * Clase de colas.
 * @author Joseph Vega Vargas
 * @author Lucía Solís Ceciliano
 * @author Miller Ruíz Urbina
 */
public class Queue {
    private LinkedList<NodoPerfil> queue = new LinkedList<>();

    /**
     * Método que añade la cola.
     * @param nodo.
     */
    public void add(NodoPerfil nodo){
        this.queue.addFirst(nodo);
    }

    /**
     *Método que remueve la cola.
     * @return
     */
    public NodoPerfil dequeue(){
        return queue.removeLast();
    }

    /**
     * Método que revisa si esta vacía
     * @return
     */
    public boolean isEmpty(){
        return queue.isEmpty();
    }

    /**
     * Método que remueve todo.
     * @param nodo
     */
    public void remove(NodoPerfil nodo){
        queue.remove(nodo);
    }

    /**
     * Método que muestra el ultimo nodo que entró
     * @return
     */
    public NodoPerfil poll(){
        return queue.pollLast();
    }
}
