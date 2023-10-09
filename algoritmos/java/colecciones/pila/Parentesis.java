package colecciones.pila;

import colecciones.pila.PilaEnlazada;
import colecciones.pila.Pila;



public class Parentesis {


     

            
        

    public static void main(String[] args){




        String cadena = args[0];
        System.out.println(cadena);
        PilaEnlazada<Character> lista = new PilaEnlazada<>();

        
        if(lista.balanceados(cadena)){
            System.out.println("estan balanceados los parentesis");
        }else{
            System.out.println("no estan balanceados los parentesis");
        }
            

    }
    
}

