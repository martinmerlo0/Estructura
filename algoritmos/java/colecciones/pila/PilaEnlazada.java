package colecciones.pila;

import colecciones.pila.Pila;


public class PilaEnlazada<T> implements Pila<T> {


    public class Nodo{

        private T dato;
        private Nodo siguiente;

        public Nodo(T elem){
            dato = elem;
            siguiente = null;
        }

        
    }

    private Nodo cabeza;
    private int cantidad;

    public PilaEnlazada() {
        this.cabeza = null;
        this.cantidad = 0;
    }

    public boolean vaciar(){
        this.cabeza = null; // pierdo la referencia a la lista completa, desp el recolector de memoria se encarga de toda la memoria
        return true ; 
    }




    public int elementos(){
        return cantidad;
    }

    public boolean esVacia(){
        return cantidad == 0;
    }

    public boolean apilar(T elem){

        Nodo nuevoNodo = new Nodo(elem);

        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        cantidad++;
        return true;

    }

    public T desapilar(){
        T result =null;
        if(esVacia()){
            return result;
        }else{
            result = cabeza.dato;
            cabeza = cabeza.siguiente;
            cantidad--;
            return result;


        }



    }

    public T tope(){
        return cabeza.dato;

    }


    public boolean balanceados(String cadena){

        PilaEnlazada<Character> pila = new PilaEnlazada<>();
        char caracter;
        for(int i = 0 ; i < cadena.length();i++){

            caracter = cadena.charAt(i);
            System.out.println(caracter);
            if(caracter == '('){
                pila.apilar(caracter);
            }else{
                if(pila.esVacia()){
                    return false;
                }else{
                    pila.desapilar();
                }
            }



        }
        if(pila.esVacia()){ // si despues de toda la ejecucion la pila es vacia significa que los parentesis estan bien balanceados
            return true;
        }else{
            return false;
        }
        



    }

    public String toString() {
        String result = "Tope -> ";
        Nodo cursor = cabeza;
        while (cursor != null) {
            result += cursor.dato + "|";
            cursor = cursor.siguiente;
        }
        return result;
    }
    
    

    public boolean equals(Object otro){
        return true ;
    }
}
