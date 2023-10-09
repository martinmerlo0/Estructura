package colecciones.lista;

import colecciones.lista.Lista;

public class ListaArreglos<T> implements Lista<T> {
    // ListaArreglos<String> lista1 = new ListaArreglo<String>();

    private final int MI_CONSTANTE = 20;
    
    private Object arreglo[];
    private int cant;

        public ListaArreglos(){
            //arreglo = (T[])new Object[capacidad]
            arreglo = new Object[MI_CONSTANTE];
            cant = 0;
        }

        public ListaArreglos(int capacidad){
            //arreglo = (T[])new Object[capacidad]
            arreglo = new Object[capacidad];
            cant = 0;
        }

    
// | 1|2 |3 |4 | 5|6 | | | | | | |
    public boolean agregar(T elem){
        if(cant == MI_CONSTANTE) return false;

        arreglo[cant] = elem;
        cant++;
        return true ;
    }

    public boolean esVacia(){

        return cant == 0 ;
    }


    public String toString(){
        String result = "";

        for (int i = 0 ; i < cant ; i++){
            result += arreglo[i] + "\n";
        }
        return result;
    }


    public void vaciar(){

        cant = 0 ;
    }



    public int elementos(){
        return cant;
    }

    public T obtener(int indice){

        if(indice < 0 || indice > MI_CONSTANTE || indice >= cant) throw new IndexOutOfBoundsException("Indice fuera de rango");

        return (T)arreglo[indice];


    }

    public boolean agregarTodos(Lista<T> otraLista){

    int elementosAgregados = 0 ; 
        
        for(int i = 0; i < otraLista.elementos();i++){
            if(agregar(otraLista.obtener(i))){
                elementosAgregados++;
            }
            
        }
        return elementosAgregados == otraLista.elementos();



    }

    public T eliminar(int indice){

       if(indice < 0 || indice > MI_CONSTANTE || indice >= cant) throw new IndexOutOfBoundsException("Indice fuera de rango");

        // me aseguro que el indice que ingreso esta en el rango de los elementos
        T valorAntiguo = (T)arreglo[indice];

        for(int i = indice; i < this.elementos(); i++){
            arreglo[i] = arreglo[i+1];


        }
        cant--;
        return valorAntiguo;

    }

    public boolean insertar(T elem, int indice){

        if(indice < 0 || indice > MI_CONSTANTE || indice > cant) throw new IndexOutOfBoundsException("Indice fuera de rango");
        T aux;

        aux = (T)arreglo[cant-1];
        for(int i = this.elementos() -1; i > indice;i--){
            arreglo[i+1] = (T)arreglo[i];


        }
      //  arreglo[this.elementos()+1] = aux;
        arreglo[indice] = elem;
        cant ++;
        return true ;


    }


    public boolean contiene(T elem){

        for(int i = 0 ; i < this.elementos();i++){
            if(this.obtener(i).equals(elem)) return true;
        }

        return false;





    }

    @Override
	public boolean equals(Object otro){
        if (otro == null) return false;

        if(otro == this){
            return true;
        }


        Lista<T> listaComparar = (Lista<T>) otro;
        if (this.cant != listaComparar.elementos()){
            return false;
        }

        for (int i = 0 ; i < cant ; i++){
            if(!this.obtener(i).equals(listaComparar.obtener(i))) return false;

        }
        return true;

    }


    public boolean repOK(){
        return true ;
    }


    public Lista<T> subLista(int desdeInd, int hastaInd){


        Lista<T> resultado = new ListaArreglos<>();


        for(int i = desdeInd ; i < hastaInd ; i++ ){
            resultado.agregar(this.obtener(i));
        }

        return resultado;






    }
}

















/*



{


Lista<String> lista = new ListaArreglos();








}


*/ 