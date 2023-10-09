package colecciones;

/**
 * 
 * Clase nodo simple con dos campos
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */


public class Nodo{ // defino los atributos 
 // atributos 
 // visibilidad private, public, protected, default 
    private int valor;
    private Nodo siguiente; // se inicializa con null



    //Constructores 

    public Nodo(){
        valor = 0;
        siguiente = null;
    }


    public Nodo(int valor ){
        this.valor = valor;
        siguiente = null;
    }




    public Nodo(int valor, Nodo siguiente ){
        this.valor = valor;
        this.siguiente = siguiente;
    }
     /*
    *
    Metodos: 
    visibilidad
    tipo de retorno
    nombre del metodo
    parametros con parentesis

      */

    public int getValor() {

        return valor;

    }

    public void setValor(int valor) {
        this.valor = valor; 


    }

    public Nodo getSiguiente() {
        return siguiente;

    }


    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }


}