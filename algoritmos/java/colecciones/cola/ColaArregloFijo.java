package colecciones.cola;

import java.util.Collection;

/**
* Implementación basada en arreglos de tamaño fijo de la interfaz {@code Cola}.
* @see colecciones.cola.Cola
*/
public class ColaArregloFijo<T> implements Cola<T> {

	/**
	* Capacidad máxima por defecto ({@value #CAPACIDAD_POR_DEFECTO})
	*/
	public static final int CAPACIDAD_POR_DEFECTO = 20;
	private Object[] arreglo;
	private int elementos = 0;

	/**
	* Construye una nueva cola vacía con una capacidad máxima de {@value #CAPACIDAD_POR_DEFECTO}.
	*/
	public ColaArregloFijo() {
		this(CAPACIDAD_POR_DEFECTO);
	}

	/**
	* Construye una nueva cola vacía con una capacidad determinada mayor a 0.
	* @param capacidad la capacidad de la cola
	* @throws IllegalArgumentException si {@code capacidad} es menor o igual a 0 
	*/
	public ColaArregloFijo(int capacidad) {
		if (capacidad <= 0)
			throw new IllegalArgumentException("la capacidad debe ser un numero positivo (" + capacidad + ")");
		arreglo = new Object[capacidad];
	}

	/**
	* Construye una cola a partir de elementos en una colección.
	* Los elementos en la colección se encolan de izquierda a derecha.
	* La capacidad de la cola va a ser suficiente para por lo menos contener todos los elementos de la colección.
	* @param elems los elementos a agregar a la cola
	*/
	public ColaArregloFijo(Collection<T> elems) {
		if (elems == null)
			throw new IllegalArgumentException("elems es null");
		arreglo = new Object[Math.max(elems.size(), CAPACIDAD_POR_DEFECTO)];
		for (T e : elems) {
			encolar(e);	
		}
	}

	@Override
	public boolean esVacia() {
		return elementos == 0;	
	}

	@Override
	public int elementos() {
		return elementos;
	}

	@Override
	public boolean encolar(T elem) {
		if (elementos == CAPACIDAD_POR_DEFECTO) return false ;
		
		for(int i = this.elementos() - 1 ; i >= 0 ; i--){
			arreglo[i+1] = arreglo[i];

		}

		arreglo[0] = elem;
		elementos++;
		return true ;
	}

	@Override
	public T desencolar() {
		if(esVacia()) throw new IllegalStateException("Cola vacia");


		T result = (T)arreglo[elementos-1];
		elementos--;
		return result; // elemento desencolado
	}

	@Override
	public T primero() {
		if(esVacia()) throw new IllegalStateException("Cola vacia");
			T result = (T)this.arreglo[elementos-1];
		return result;
	}

	@Override
	public void vaciar() {
		elementos = 0;	
	}

	@Override
	public boolean repOK() {
		return true ;	
	}

	@Override
	public String toString() {
		
		String result = "";


		for(int i=0 ; i < elementos ; i++){
			result += arreglo[i] + "|";


		}

		return result;




	}

	@Override
	public boolean equals(Object other) {
		if (other == null) return false;
		
		



		if(other == this) return true ;

		if(this.elementos() != ((Cola<T>) other).elementos()) return false ;


		
		T aux ;
		for(int i = this.elementos()-1; i > 0;i--){

			if(!arreglo[i].equals(aux = ((Cola<T>) other).desencolar())){
				return false;
			}
			((Cola<T>) other).encolar(aux);
		}
		return true ;
	}

	/**
	* Permite obtener un elemento del arreglo en un indice determinado realizando el casteo necesario.
	* @param index el indice del elemento a obtener
	*/
	@SuppressWarnings("unchecked")
   	private T elemento(int index) {
        	return (T) arreglo[index];
    	}

}
