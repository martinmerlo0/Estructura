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

    /**
	* Retorna una representación como {@code String} de esta lista. La representación como {@code String} consiste de los elementos en esta lista, en el orden correspondiente a la implementación de la misma, encerrados entre corchetes ("[]"). 
	* Elementos adyacentes están separados mediante los caractéres ", " (coma y espacio). Los elementos son convertidos mediante {@code String.valueOf(Object)}.
	* @return una representación como {@code String} de esta lista
	*/
	
	@Override
	public String toString(){
        Nodo aux = cabeza;
        String result = "Valores\n";
        while(aux.siguiente != null){
            result += aux.dato + "\n";
            aux = aux.siguiente;
        }   
        result += aux.dato + "\n";

        return result;




    }
 
    /**
	* Remueve todos los elementos en la lista.
	*/
	
	public void vaciar(){
        cabeza = null;
        size = 0 ;
    }


    /**
	* Agrega todos los elementos de otra lista, al final de esta lista.
	* @param otraLista lista conteniendo todos los elementos a agregar al final de esta lista
	* @return {@code true} sii todos los elementos en {@code otraLista} fueron agregados
	*/
	
	public boolean agregarTodos(Lista<T> otraLista){

        if (otraLista.elementos() == 0) return false;

        for (int i = 0; i < otraLista.elementos() ; i++){
            this.agregar(otraLista.obtener(i));
        }
        return true ;



    }


    public T obtener(int indice) {
        if (indice < 0 || indice >= size) throw new IndexOutOfBoundsException(indice + " está fuera de rango.");

        Nodo temp = cabeza;

        for (int i = 0; i < indice; i++) {
            temp = temp.siguiente;
        }

        return temp.dato;
    }

    /**
	* Retorna la cantidad de elementos agregados a la lista.
	* @return cantidad de elementos en la lista
	*/
	
	public int elementos(){

     return size;

    }


    /**
	* Elimina un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a eliminar
	* @return el elemento eliminado
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	
	public T eliminar(int indice){

        if (indice < 0 || indice >= size) throw new IndexOutOfBoundsException(indice + " está fuera de rango.");


        Nodo temp = cabeza;
        T valor = cabeza.dato;
        if(indice == 0){
            valor = cabeza.dato;
            cabeza = cabeza.siguiente;
        }else{

            for(int i = 0; i < indice -1 ; i++){
                temp = temp.siguiente; // me paro uno antes del indice a eliminar
            }
            valor =temp.siguiente.dato;
            temp.siguiente = temp.siguiente.siguiente; // desp el nodo lo elimina el recolector
        }
        size--;
        return valor;









    }


    /**
	* Agrega un elemento en una posicion particular de la lista.
	* @param elem el elemento a agregar
	* @param indice el indice donde se agrega el elemento
	* @return {@code true} sii el elemento pudo ser agregado
	* @throws IndexOutOfBoundsException si {@code indice} &lt; {@code 0}
	*/
	
	public boolean insertar(T elem, int indice){
        if (indice < 0 || indice >= size) throw new IndexOutOfBoundsException(indice + " está fuera de rango.");

        Nodo nuevoNodo = new Nodo(elem);
        Nodo temp = cabeza;
        if (indice == 0){
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        }else{

            for(int i = 0; i < indice -1;i++){

                temp = temp.siguiente;
            }
            nuevoNodo.siguiente = temp.siguiente;
            temp.siguiente = nuevoNodo;
            size++;
        }


   return true; 

    }


    public Lista<T> subLista(int desdeInd, int hastaInd){
        if (desdeInd < 0 || hastaInd > size || desdeInd > hastaInd) throw new IndexOutOfBoundsException("Los índices están fuera de rango.");

        Lista<T> subLista = new ListaEnlazada<>();

        Nodo temp = cabeza;
            for (int i = 0; i < hastaInd ;i++){
                if(i >= desdeInd){
                    subLista.agregar(temp.dato);
                }
                temp = temp.siguiente;
            }

            return subLista;







    }

    public boolean repOK(){

        if(size < 0){
            return false ;
        }

        T elem = null;

        String cadena1 = this.toString();
        this.agregar(elem);
        this.eliminar(size-1);
        String cadena2 = this.toString();

        if (!(cadena1.equals(cadena2))) return false;

        int cantVieja = size;
        this.agregar(elem);
        if(cantVieja >= size){
            return false;
        }



        this.eliminar(size-1);
        return true ;
    }


    /**
	* Evalúa igualdad entre esta y otra lista. La igualdad considera que el tamaño de ambas listas es el mismo, y que los elementos de ambas listas son iguales considerando el orden de los mismos de acuerdo a la implementación de cada lista.
	* La igualdad entre elementos se realiza considerando si ambos son {@code null} o, en caso contrario, mediante el método {@code equals(Object)}.
	* @return {@code true} sii ambas listas tienen los mismos elementos.
	*/
	
	@Override
	public boolean equals(Object otro){
        if (otro == null) return false;

        if(otro == this){
            return true;
        }


        Lista<T> listaComparar = (Lista<T>) otro;
        if (this.size != listaComparar.elementos()){
            return false;
        }

        for (int i = 0 ; i < size ; i++){
            if(!this.obtener(i).equals(listaComparar.obtener(i))) return false;

        }
        return true;

    }



}