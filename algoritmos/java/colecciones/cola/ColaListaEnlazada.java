package colecciones.cola;

import colecciones.cola.Cola;

import java.util.Collection;


public class ColaListaEnlazada<T> implements Cola<T> {


    private class Nodo {
        T dato;
        Nodo siguiente;

        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }


    private Nodo cabeza;
    private int cantidad;

    public ColaListaEnlazada(){
        cabeza = null;
        cantidad = 0;
    }

    public ColaListaEnlazada(Nodo otro){
        cabeza = otro;
        cantidad = 0 ;
    }



    public boolean esVacia(){
        return cantidad == 0 ;
        
    }


    public boolean encolar(T elem){
        Nodo nuevoNodo = new Nodo(elem);
        if (esVacia()){
            
            cabeza = nuevoNodo;
            nuevoNodo.siguiente = nuevoNodo; // cola circular 
            
        }else{
            nuevoNodo.siguiente = cabeza.siguiente;
            cabeza.siguiente = nuevoNodo;
            cabeza = nuevoNodo;

        }
        cantidad++;
        return true ;

        
    }


    public T desencolar(){
        Nodo aux ;
        T result = null;
        if(!esVacia()){
            aux = cabeza.siguiente; // apunta al primero 
            result = (T)aux.dato;
            cabeza.siguiente = aux.siguiente; // pierdo la referencia al primer nodo que ingreso




        }else{
            // tendria que tirar una excepcion 


        }

        cantidad--;
        return result;
    }


    public T primero(){
        if(esVacia()){
            
        }else{
           

        }
        
        return cabeza.siguiente.dato;



    }



    public void vaciar(){
        cabeza = null;
        cantidad = 0;

    }


    public int elementos(){
        return cantidad;


    }

    public boolean repOK(){
        return true ;
    }

    @Override
	public String toString(){
        if(esVacia()){
        String result = null;
        return result;    
        }else{
            String result = "";

        Nodo aux = cabeza.siguiente;

        for(int i = 0 ; i < elementos(); i++){
            result += aux.dato + " |";
            aux = aux.siguiente;
        }
        return result;
        }
        


        

    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
    
        Cola<T> otralista = (Cola<T>) other;
    
        if (this.elementos() != otralista.elementos()) return false; // si tienen menos elementos son distintos
    
        Nodo cursor = cabeza.siguiente;
        Nodo cursor2 = ((ColaListaEnlazada<T>) otralista).cabeza.siguiente;
    
        for (int i = 0; i < elementos(); i++) {
            if (!cursor.dato.equals(cursor2.dato)) return false;
            cursor = cursor.siguiente;
            cursor2 = cursor2.siguiente;
        }
    
        return true;
    }
    


    
}
