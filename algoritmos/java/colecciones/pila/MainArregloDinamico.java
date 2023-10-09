package colecciones.pila;

import colecciones.pila.Pila;
import colecciones.pila.PilaArrayList;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import javax.imageio.plugins.tiff.TIFFTagSet;

public class MainArregloDinamico {



    public static void main(String[] args){
        Pila<Integer> lista = new PilaArrayList<>();
        Pila<Integer> lista2 = new PilaArrayList<>();
        for(int i = 0 ; i <= 10 ; i++){
            lista.apilar(i);
            lista2.apilar(i);
        }
        //lista2.desapilar();

        System.out.println(lista.equals(lista2));
        
        
    }
    
}
