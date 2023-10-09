package colecciones.pila;

import colecciones.pila.PilaEnlazada;
import colecciones.pila.Pila;


public class MainPila {

    public static void main(String[] args) {
        PilaEnlazada<Integer> lista = new PilaEnlazada<>();
        PilaEnlazada<Integer> lista2 = new PilaEnlazada<>();

        for (int i = 0; i < 5; i++) {
            lista.apilar(i);
        }

        System.out.println("Pila lista: " + lista);

        int aux = lista.elementos();
        System.out.println("El valor de aux es: " + aux);

        while (!lista.esVacia()) {
            lista2.apilar(lista.desapilar());
        }

        System.out.println("Pila lista2 (invertida): " + lista2);
    }
}
