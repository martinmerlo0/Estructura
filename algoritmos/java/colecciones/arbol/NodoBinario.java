package colecciones.arbol;

/**
 * Clase auxiliar para diccionarios implementados con nodos encadenados.
 */
public class NodoBinario<T>  {
    private T valor;
    private NodoBinario<T> izquierdo;
    private NodoBinario<T> derecho;
    private int altura;


    NodoBinario(T valor, NodoBinario<T> izquierdo, NodoBinario<T> derecho) {
        this.valor = valor;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public NodoBinario(){
        this.valor = null;
        izquierdo = null;
        derecho = null;
    }

    public NodoBinario(T valor){
        this.valor = valor;
        izquierdo = null;
        derecho = null;
    }


    T getValor() {
        return valor;
    }

    void setValor(T nuevoValor) {
        valor = nuevoValor;
    }

    NodoBinario<T> getIzquierdo() {
        return izquierdo;
    }

    void setIzquierdo(NodoBinario<T> nuevoIzquierdo) {
        this.izquierdo = nuevoIzquierdo;
    }

    NodoBinario<T> getDerecho() {
        return derecho;
    }

    void setDerecho(NodoBinario<T> nuevoDerecho) {
        this.derecho = nuevoDerecho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }


}
