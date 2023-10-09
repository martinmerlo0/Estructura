public class ListasEnlazadas implements ColaPrioridad {

    private class Nodo {
        int dato;
        Nodo siguiente;


        Nodo(){
            this.dato = 0;
            this.siguiente = null;
        }

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }



    private Nodo cabeza;
    private int cant;
    

    @Override
    public String toString(){
        Nodo aux = new Nodo();
        
        aux = cabeza;


    }
    public ListasEnlazadas(){
        cabeza = null;
        cant = 0;
    }

    public boolean esVacia(){
        return this.cant == 0;
    }

    public int desencolar(){
        int valor = cabeza.dato;

        cabeza= cabeza.siguiente;
        cant--;
        return valor;

    }


    public boolean encolar(int elem){ // tienen prioridad los menores 
        Nodo nuevoNodo = new Nodo(elem);
        if(this.esVacia()){
            cabeza = nuevoNodo;
        }else{
            Nodo aux = new Nodo();
            Nodo anterior = new Nodo();
            aux = cabeza;
            anterior = cabeza;
            while (aux != null && aux.dato < elem){
                anterior = aux;
                aux = aux.siguiente;
            }
            nuevoNodo.siguiente = anterior;
            anterior = nuevoNodo;
        }

        cant++;
        return true;
    }
}
