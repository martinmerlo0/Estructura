package colecciones.arbol;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * Árbol binario de busqueda (ABB), es una implementación de {@code Diccionario} mediante nodos encadenados que preserva las propiedades de Diccionario.
 * @param <T> Tipo del valor asociado a los nodos del árbol, debe ser posible definir un orden total para los mismos.
 * @see NodoBinario
 */
public class ABB<T extends Comparable<T>> implements Diccionario<T> {

    private NodoBinario<T> raiz;

    /**
     * Comparador usado para mantener el orden en un ABB, o null.
     */
    private final Comparator<? super T> comparador;

    /**
     * Construye un nuevo árbol vacío ordenado acorde al comparador dado.
     * @param comparador define una forma de comparar los valores insertados en el arbol.
     */
    public ABB(Comparator<? super T> comparador) {
        this.comparador = comparador;
        this.raiz = null;
    }

    /**
     * Construye un nuevo árbol con un elemento en la raiz, ordenado acorde al comparador dado.
     * @param comparador define una forma de comparar los valores insertados en el arbol.
     * @param valor de la raiz del nuevo arbol si no es null.
     */
    public ABB(Comparator<? super T> comparador, T valor) {
        this.comparador = comparador;
        this.raiz = new NodoBinario<ABB.T>(valor);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void insertar(T elem) {

        if(!buscarRecursivamente(raiz, elem)){
            raiz = insertarRecursivamente(raiz, elem);
        }
        

    }

    
    private NodoBinario<T> insertarRecursivamente(NodoBinario<T> nodo,T elem){

        if(nodo == null){
            nodo = new NodoBinario<ABB.T>(elem); // caso arbol vacio
        }

        if(elem.compareTo(nodo.getValor()) < 0 ){ // elem es menor que el nodo actual
            nodo.setDerecho(insertarRecursivamente(nodo.getIzquierdo(), elem));
        }else{
            nodo.setIzquierdo(insertarRecursivamente(nodo.getDerecho(), elem));
        }


        return nodo;

    }


    /**
     * {@inheritDoc}
     */


    private boolean buscarRecursivamente(NodoBinario<T> nodo, T elem){
        if(nodo == null){
            return false ;
        }

        if(elem.compareTo(nodo.getValor()) == 0){
            return true;
        }


        if(elem.compareTo(nodo.getValor()) < 0){ // elem es menor al nodo 
            return buscarRecursivamente(nodo.getIzquierdo(), elem);
        }else{
            return buscarRecursivamente(nodo.getDerecho(), elem);
        }

        


    }
    public boolean pertenece(T elem) {
        return buscarRecursivamente(raiz,elem);
    
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void borrar(T elem) {
        raiz = borrarRecursivamente(raiz, elem);
    }
    
    private NodoBinario<T> borrarRecursivamente(NodoBinario<T> nodo, T elem) {
        if (nodo == null) {
            // Caso base: El elemento no se encuentra en el árbol.
            return nodo;
        }
    
        if (elem.compareTo(nodo.getValor()) < 0) {
            // Si el elemento es menor, buscar en el subárbol izquierdo.
            nodo.setIzquierdo(borrarRecursivamente(nodo.getIzquierdo(), elem));
        } else if (elem.compareTo(nodo.getValor()) > 0) {
            // Si el elemento es mayor, buscar en el subárbol derecho.
            nodo.setDerecho(borrarRecursivamente(nodo.getDerecho(), elem));
        } else {
            // Encontramos el elemento a borrar.
    
            // Caso 1: Nodo con un hijo o sin hijos.
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }
    
            // Caso 2: Nodo con dos hijos.
            nodo.setValor(encontrarMinimo(nodo.getDerecho()).getValor());
            nodo.setDerecho(borrarRecursivamente(nodo.getDerecho(), nodo.getValor()));
        }
    
        return nodo;
    }
    
    private NodoBinario<T> encontrarMinimo(NodoBinario<T> nodo) {
        NodoBinario<T> actual = nodo;
        while (actual.getIzquierdo() != null) {
            actual = actual.getIzquierdo();
        }
        return actual;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void vaciar() {
        raiz = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T raiz() {
        return raiz.getValor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Diccionario<T> subArbolIzquierdo() {
        if(raiz != null && raiz.getIzquierdo() != null){
            ABB subArbolIzq = new ABB<>(comparador);
            subArbolIzq.raiz = raiz.getIzquierdo();
            return subArbolIzq;
        }else{
            return new ABB<>(comparador);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Diccionario<T> subArbolDerecho() {
        if(raiz != null && raiz.getDerecho() != null){
            ABB subArbolDer = new ABB<>(comparador);
            subArbolDer.raiz = raiz.getDerecho();
            return subArbolDer;
        }else{
            return new ABB<>(comparador);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int elementos() {
        return contarNodos(raiz);
    }

    private int contarNodos(NodoBinario<T> nodo){
        if(nodo == null){
            return 0 ;
        }else{
            return 1 + contarNodos(nodo.getIzquierdo()) + contarNodos(nodo.getDerecho());
        }
    }
    /**
     * {@inheritDoc}
     */

    @Override
    public int altura() {
        return calcularAltura(raiz);
    }

    private int calcularAltura(NodoBinario<T> nodo){
        if(nodo == null){
            return 0;
        }

        int alturaIzq = calcularAltura(nodo.getIzquierdo());
        int alturaDer = calcularAltura(nodo.getDerecho());

        return 1 + Math.max(alturaIzq, alturaDer);

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean esVacio() {
        return raiz == null;
    }

    /**
     * {@inheritDoc}
     */

    
    public T mayorValor(){
        if(raiz == null){
            throw new NoSuchElementException("El árbol está vacío, no hay un mayor valor.");
        }else{

            NodoBinario actual = raiz ;

            while (actual.getDerecho() != null){
                actual = actual.getDerecho();
            }

            return actual.getValor();


        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T menorValor() {
        if(raiz == null){
            throw new NoSuchElementException("El árbol está vacío, no hay un menor valor.");
        }else{

            NodoBinario actual = raiz ;

            while (actual.getIzquierdo() != null){
                actual = actual.getIzquierdo();
            }

            return actual.getValor();


        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T sucesor(T elem) {
        if(raiz == null){
            throw new NoSuchElementException("ABB vacio no existe sucesor");
        }

        NodoBinario<T> actual = encontrarNodo(raiz, elem); // le asigna el nodo donde se encontaria el elemento elem 
        if(actual.getDerecho() == null){
            throw new NoSuchElementException("No existe elemento sucesor a elem");
        }else{
            return actual.getDerecho().getValor();
        }
    }

    private NodoBinario<T> encontrarNodo(NodoBinario<T> nodo,T elem){
        if (nodo == null){
            return null ; // el elemento no se encuentra 
        }

        if(elem.compareTo(nodo.getValor()) < 0){ // se busca el elemento en el subarbol izquierdo
            return encontrarNodo(nodo.getIzquierdo(), elem);
        }else
            if(elem.compareTo(nodo.getValor()) > 0){
            return encontrarNodo(nodo.getDerecho(), elem);
        }else{
            return nodo; // se encontro el elemento 
        }

        



    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T predecesor(T elem) {
         if(raiz == null){
            throw new NoSuchElementException("ABB vacio no existe sucesor");
        }

        NodoBinario<T> actual = encontrarNodo(raiz, elem); // le asigna el nodo donde se encontaria el elemento elem 
        if(actual.getIzquierdo() == null){
            throw new NoSuchElementException("No existe elemento predecesor a elem");
        }else{
            return actual.getIzquierdo().getValor();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean repOK() {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> aLista() {
        return aLista(Orden.INORDER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> aLista(Orden orden) {
        List<T> elementos = new LinkedList<>();
        switch (orden) {
            case INORDER:
                return aListaInOrder(raiz, elementos);
            case PREORDER:
                return aListaPreOrder(raiz, elementos);
            case POSTORDER:
                return aListaPostOrder(raiz, elementos);
        }
        return elementos;
    }

    /* (non-Javadoc)
     * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
     * y va llenando la lista con los elementos del árbol según un recorrido in order.
     * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
     */
    private List<T> aListaInOrder(NodoBinario<T> raiz, List<T> elementos) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /* (non-Javadoc)
     * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
     * y va llenando la lista con los elementos del árbol según un recorrido pre order.
     * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
     */
    private List<T> aListaPreOrder(NodoBinario<T> raiz, List<T> elementos) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /* (non-Javadoc)
     * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
     * y va llenando la lista con los elementos del árbol según un recorrido post order.
     * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
     */
    private List<T> aListaPostOrder(NodoBinario<T> raiz, List<T> elementos) {
        throw new UnsupportedOperationException("TODO: implementar");
    }


}
