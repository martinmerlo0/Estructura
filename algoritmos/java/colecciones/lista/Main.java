package colecciones.lista;

import colecciones.lista.ListaEnlazada;
import colecciones.lista.Lista;

public class Main {
    


    public static void main(String[] args){

        Lista<Integer> cabeza = new ListaEnlazada<>();
        Lista<Integer> cabeza2 = new ListaEnlazada<>();
        Lista<Integer> cabeza3 = new ListaEnlazada<>();
        
        for(int i = 0; i < 10 ; i++){
            cabeza.agregar(i);
        }
        System.out.println("\n");
        System.out.println(cabeza.elementos());

        if(cabeza.equals(cabeza2)){
            System.out.println("las listas son iguales");
        }else{
            System.out.println("las listas son diferentes");
        }

        //cabeza.agregarTodos(cabeza2);
        //cabeza.eliminar(0);

        //cabeza3 = cabeza.subLista(1,4);
       
        //cabeza.eliminar(1);
        //cabeza.insertar(2,1);
        
        System.out.println(cabeza);
        //cabeza.vaciar();
        if(cabeza.esVacia()){
            System.out.println("lista vacia");

        }else{
            System.out.println("Lista no es vacia");
        }
        //(ListaEnlazada<Integer>)
        cabeza2 = cabeza.subLista(2, 5);
        System.out.println(cabeza2);

    }






}
