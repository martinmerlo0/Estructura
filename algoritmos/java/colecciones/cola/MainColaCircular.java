package colecciones.cola;

import colecciones.cola.Cola;
import colecciones.cola.ColaListaEnlazada;

public class MainColaCircular {
    



    public static void main(String[] args){

        ColaListaEnlazada<Integer> cabeza = new ColaListaEnlazada<Integer>();
        ColaListaEnlazada<Integer> cabeza2 = new ColaListaEnlazada<Integer>();


        cabeza.encolar(1);
        System.out.println(cabeza);
        cabeza.desencolar();
        System.out.println(cabeza);

        for(int i = 0 ; i <=5 ; i++){
            cabeza.encolar(i);
        }

        for(int i = 0 ; i <=6 ; i++){
            cabeza2.encolar(i);
        }
        if(cabeza.equals(cabeza2)){
            System.out.println("son iguales");
        }else{
            System.out.println("no son iguales");
        }


 

    }






}
