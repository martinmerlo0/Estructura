package colecciones.lista;

import colecciones.lista.Lista;

public class ListaEnlazada<T> implements Lista<T> {
    
    private class Nodo {
        T dato;
        Nodo siguiente;

        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo cabeza;
    private int size;

    public ListaEnlazada() {
        this.cabeza = null;
        this.size = 0;
    }



/**
	* Agrega un elemento al final de la lista.
	* @param elem el elemento a agregar
	* @return {@code true} sii el elemento pudo ser agregado
	*/
	public boolean agregar(T elem){
        Nodo NuevoNodo = new Nodo(elem);
        if (esVacia()){
            cabeza = NuevoNodo;
        }else{
            Nodo aux = cabeza;
            while(aux.siguiente != null){
                aux = aux.siguiente;
            }
            aux.siguiente = NuevoNodo;
        
        }
        size++;
        return true;



    }

    /**
	* Permite evaluar si la lista no tiene elementos.
	* Este método es equivalente a:
	* <pre>lista.elementos() == 0</pre>
	* @return {@code true} sii la pila no tiene elementos
	*/
	
	public boolean esVacia(){

        return size == 0;


    }






}