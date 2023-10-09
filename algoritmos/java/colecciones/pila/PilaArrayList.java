package colecciones.pila;

import colecciones.pila.Pila;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import javax.imageio.plugins.tiff.TIFFTagSet;

public class PilaArrayList<T> implements Pila<T> {


    private List<T> elementos;


    public PilaArrayList(){
        elementos = new ArrayList<>();
    }








    public boolean vaciar(){
        elementos.clear();
        return true;
    }

    public boolean balanceados(String cadena){
        return true;
    }

    public boolean esVacia(){
        return elementos.size() == 0;
    }

    public int tamaño(){
        return elementos.size() ;
    }

    public boolean apilar(T elem){
        elementos.add(elem);
        return true;
    }

    public T desapilar(){
        if(esVacia()){
            throw new EmptyStackException();
        }else{
            int ultimoIndice = elementos.size() - 1;
            T elemento = elementos.remove(ultimoIndice);
            return elemento;
        }
    }

    public T tope(){
        int i = elementos.size() - 1;
        T result = elementos.get(i);
        return result;
    }

    public String toString(){
        String result = "";
        for(int i = 0 ; i < elementos.size();i++){
            result += elementos.get(i) + " | ";
        }
        return result ;
    }


    @Override
    public boolean equals(Object otro){ 
        if(this == otro) return true; // hacen referencia al mismo lugar de memoria

        if(otro == null || getClass() != otro.getClass()) return false; // el objeto no es una instancia de PilaArrayList


        PilaArrayList<?> otraPila = (PilaArrayList<?>) otro;

        if(this.tamaño() != otraPila.tamaño()){
            return false; // no tienen la misma cantidad de elementos 
        }


        // en este punto no me queda otra que comparar elemento por elemento
        for(int i = 0 ; i < tamaño() ; i++){
            if(!this.desapilar().equals(otraPila.desapilar())){
                return false;
            }



        }
        return true ;

    }



    
}
