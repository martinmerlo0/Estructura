#include <stdio.h>
#include <stdlib.h>
#include "lista_enteros.h"

/*
	Implementacion de lista de enteros 
	usando la estructura de nodos (listas linkables).
 */

typedef struct lista_enlazada* nodo;

struct lista_enlazada{
	int valor;
	struct lista_enlazada *siguiente;
};

/* estructura_lista es la implementacion del tipo_lista 
 declarado en lista_enteros.h.
*/
struct estructura_lista{
	nodo cabeza;
	int elementos;
};

nodo crear_nodo( int elemento ){
	nodo linkable = ( nodo ) malloc ( sizeof( struct lista_enlazada ) );

	linkable->valor = elemento;
	linkable->siguiente    = NULL;

	return linkable;
}

tipo_lista crear( void ){
	tipo_lista lista = ( tipo_lista ) malloc ( sizeof( struct estructura_lista ) );

	lista->cabeza = NULL;
	lista->elementos = 0;

	return lista;
}

int es_vacia( tipo_lista lista ){
	return ( lista->elementos == 0 );
}

tipo_lista agregar( tipo_lista lista, int elemento ){
	nodo linkable = crear_nodo( elemento );

	linkable->siguiente = lista->cabeza;
	lista->cabeza = linkable;
	lista->elementos = (lista->elementos) + 1;

	return lista;
}

int reemplazar(tipo_lista lista, int elemento,int posicion){



if ( posicion < 0 || posicion > lista->elementos ){
		return -1;
	};


nodo cursor = lista->cabeza;

for(int i=0; i < posicion; i++){
	cursor = cursor->siguiente;
	
}; // nos paramos en el nodo que queremos cambiar 
int valorant;

valorant = cursor->valor;
cursor->valor = elemento;

return valorant;


}

int ins( tipo_lista lista, int elemento, int posicion){
	if ( posicion < 0 || posicion > lista->elementos ){
		return -1;
	};

	if ( !posicion ){
		agregar( lista, elemento );
		return 0;
	}

	/* mueve el cursor a la posicion dada. */
	nodo cursor = lista->cabeza;

	for ( int i = 0; i < posicion - 1; i++ ){
		cursor = cursor->siguiente;
	};

	/* crea el nuevo nodo */
	nodo linkable = crear_nodo( elemento );

	/* enlaza los dos nodos */
	linkable->siguiente = cursor->siguiente;
	cursor->siguiente = linkable;

	/* incrementa el numero de elementos de la lista */
	lista->elementos = (lista->elementos) + 1;

	return 0;
}

tipo_lista fin( tipo_lista lista, int elemento ){
	ins( lista, elemento, lista->elementos );

	return lista;
}

int eliminar_comienzo( tipo_lista lista ){
	if ( es_vacia( lista ) ){
		return -1;
	}

	nodo cursor = lista->cabeza;
	lista->cabeza = (lista->cabeza)->siguiente;

	// libera la memoria asiganada usando malloc.
	free( cursor );

	lista->elementos = (lista->elementos) - 1;

	return 0;
}

int eliminar( tipo_lista lista, int posicion){
	if ( posicion < 0 || posicion > lista->elementos ){
		return -1;
	};

	if ( es_vacia( lista ) ){
		return -1;
	}

	if ( !posicion ){
		eliminar_comienzo( lista );

		return 0;
	}

	/* mueve el cursor a la posicion dada. */
	nodo cursor = lista->cabeza;

	for ( int i = 0; i < posicion - 1; i++ ){
		cursor = cursor->siguiente;
	};

	nodo linkable = cursor->siguiente;
	cursor->siguiente = (cursor->siguiente)->siguiente;

	// libera la memoria asiganada usando malloc.
	free( linkable );

	lista->elementos = (lista->elementos) - 1;

	return 0;
}


int obtener( tipo_lista lista, int posicion ){
	nodo cursor = lista->cabeza;

	for ( int i = 0; i < posicion ; i++ ){
		cursor = cursor->siguiente;
	};

	return cursor->valor;
}


tipo_lista reversa( tipo_lista lista ){
	tipo_lista resultado = crear();

	for ( int i = 0; i < lista->elementos ; i++ ){
		agregar( resultado, obtener( lista, i ));
	};

	return resultado;
}

tipo_lista concat( tipo_lista ini, tipo_lista cola ){
	tipo_lista resultado = crear();

	for ( int i = 0; i < ini->elementos ; i++ ){
		fin( resultado, obtener( ini, i ));
	};

	for ( int i = 0; i < cola->elementos ; i++ ){
		fin( resultado, obtener( cola, i ));
	};

	return resultado;
}

tipo_lista sub( tipo_lista lista, int c, int f ){
	tipo_lista resultado = crear();

	for ( int i = c; i < f ; i++ ){
		fin( resultado, obtener( lista, i ));
	};

	return resultado;
}

tipo_lista copia( tipo_lista lista ){
	return sub( lista, 0, lista->elementos );
}

int cabeza( tipo_lista lista ){
	return (lista->cabeza)->valor;
}

tipo_lista cola( tipo_lista lista ){
	return sub( lista, 1, lista->elementos );
}

void mostrar( tipo_lista lista ){
	printf( "[ " );

	for ( int i = 0; i < lista->elementos; i++ ){
		printf( "%i ", obtener( lista, i ) );
	};

	printf( "]" );
}



tipo_lista intercambiar(tipo_lista lista,int m,int n){

nodo cursor1 = lista->cabeza;
nodo cursor2 = lista->cabeza;


for(int i = 0; i < m ;i++){
	cursor1 = cursor1->siguiente;

};

for(int i = 0; i < n ;i++){
	cursor2 = cursor2->siguiente;

};

int aux;


aux = cursor1->valor;
cursor1->valor = cursor2->valor;
cursor2->valor = aux;

return lista ;


}


int tope(tipo_lista lista){

if(es_vacia(lista)){
return -1;
}else{
nodo cursor = lista->cabeza;
return cursor->valor;
}

}


tipo_lista apilar(tipo_lista lista,int elemento){

nodo linkable = ( nodo ) malloc ( sizeof( struct lista_enlazada ) );
linkable->valor = elemento;

	linkable->siguiente = lista->cabeza;
	lista->cabeza = linkable;
	lista->elementos = (lista->elementos) + 1;




}



tipo_lista desapilar(tipo_lista lista){

nodo aux = ( nodo ) malloc ( sizeof( struct lista_enlazada ) );

aux->siguiente = lista->cabeza;
lista->cabeza = aux->siguiente;
free(aux);
lista->elementos = lista->elementos - 1;


}


tipo_lista vaciar(tipo_lista lista){

nodo borrador = ( nodo ) malloc ( sizeof( struct lista_enlazada ) );

	borrador->siguiente = lista->cabeza;

		while(borrador != NULL){
			lista->cabeza = borrador->siguiente;
			free(borrador);
		}



}