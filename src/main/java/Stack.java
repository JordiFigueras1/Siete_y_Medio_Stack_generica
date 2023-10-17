import Exceptions.FullStackException;
import Exceptions.EmptyStackException;

/**
 * Contracte que determina el contracte d'una pila
 * @param <E> element del contenidor lineal
 */

public interface Stack<E> {


    /**
     * Mètode que afegeix un element a la Pila
     * @param e l'element a afegir
     * @throws FullStackException llença una excepció en cas que
     * la pila estigui plena
     */
    public void push(E e) throws FullStackException;

    /**
     * Mètode que retorna l'element que està a la cima pila i l'elimina
     * @return retorna l'element que està a la cima de la pila
     * @throws EmptyStackException llença l'excepció en cas que la pila estigui buida
     */
    public E pop() throws EmptyStackException;

    /**
     * Mètode que proporciona l'element que està a la cima de la pila
     * @return retorna l'element que està a la cima de la pila
     */
    public E peek();

    /**
     * Mètode que proporciona el nombre d'elements de la pila
     * @return retorna el nombre d'elements de la pila
     */
    public int size();
}
