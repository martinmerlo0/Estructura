package colecciones.lista;

/**
* La interface {@code Lista} representa una secuencia de objetos. El usuario de esta interface tiene control de acceso, inserción, y eliminación indexada de elementos.
* 
* Las operaciones ofrecidas por cualquier implementación de esta clase son:
* <ul>
*   <li> agregar	: Agrega un nuevo elemento al final de la lista, y retorna si la operación fue exitosa.</li>
*   <li> agregarTodos	: Agrega todos los elementos de otra lista al final de la lista, y retorna si la operación fue exitosa.</li>
*   <li> insertar	: Agrega un nuevo elemento en un índice particular, desplazando el resto de los elementos a la derecha si es necesario, y retorna si la operación fue exitosa.</li>
*   <li> eliminar	: Elimina un elemento en un ídice particular, retorna el elemento eliminado.</li>
*   <li> obtener	: Retorna el elemento en un índice particular sin eliminarlo.</li>
*   <li> subLista	: Retorna una sublista de esta lista dados dos índices particulares.</li>
*   <li> contiene	: Permite evaluar si la lista contiene un elemento particular.</li>
*   <li> vaciar		: Elimina todos los elementos de la lista dejándola vacía</li>
*   <li> elementos	: Retorna la cantidad de elementos presentes en la lista</li>
*   <li> esVacia	: Permite consultar si la lista está vacía</li>
*   <li> repOK		: Permite validar si una instancia satisface el invariante de representación</li>
*   <li> toString	: Retorna una representación en forma de cadena</li>
*   <li> equals		: Permite evaluar si otra instancia de lista es igual a esta</li>
* </ul>
* @param T : el tipo de los elementos a almacenar en la Lista.
* @version 1.1
*/
public interface Lista<T> {

	

	
	
	

	/**
	* Evalua si esta lista contiene un elemento particular, utilizando el método {@code equals(Object)}.
	* @param elem el elemento a buscar
	* @return {@code true} sii, existe un elemento {@code e} en la lista, tal que {@code e == null && elem == null || e.equals(elem)}
	*/
	
	//public boolean contiene(T elem);


	

	

	
	
}
