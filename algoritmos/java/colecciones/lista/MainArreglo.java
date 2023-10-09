package colecciones.lista;


import colecciones.lista.Lista;
import colecciones.lista.ListaArreglos;


public class MainArreglo {


    public static void main(String[] args){

        Lista<Integer> lista = new ListaArreglos();
        Lista<Integer> lista2 = new ListaArreglos();
        Lista<Integer> lista3 = new ListaArreglos();

        for(int i = 0; i < 5 ; i++){
            lista.agregar(i);
        }

        for(int i = 0; i < 6 ; i++){
            lista2.agregar(i);
        }
     
        System.out.println(lista);
       // System.out.println(lista.elementos());
        //lista.eliminar(4);
        System.out.println(lista2);
        
        if(lista.equals(lista2)){
            System.out.println("son iguales");
        }else{
            System.out.println("no");
        }
        lista3 = ((ListaArreglos<Integer>) lista).subLista(1, 4); // hay que matchear 

            System.out.println(lista3);
     



    }















}