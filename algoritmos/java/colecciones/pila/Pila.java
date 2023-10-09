package colecciones.pila;



public interface Pila<T> {

    /*
     * 
     * 
     */
    // toma una pila y la elimina 
    public boolean vaciar();


    public boolean balanceados(String cadena);

    public int tamaño();

    // devuelve true si la pila es vacia
    public boolean esVacia();



    // Toma un elemento de tipo T y lo ingresa al tope de la pila 
    public boolean apilar(T elem);


    // desapila el elemento que esta en el tope de la misma
    public T desapilar();



    // Devuelve el elemento que esta en el tope de la pila 
    public T tope();


    public String toString();



    public boolean equals(Object otro);
}
