package arraySorter;

/**
* Provee métodos para ordenar arreglos de objetos comparables.
* Los algoritmos de ordenamiento provistos por esta clase son:
* <ul>
* <li>Bubble sort.</li>
* <li>Selection sort.</li>
* <li>Shell sort.</li>
* <li>Quick sort.</li>
* <li>Merge sort.</li>
* </ul>
* El invariante que deben cumplir todos los arreglos {@code array} para ser utilizados como argumentos de los distintos algoritmos de ordenamiento es:
* <pre>
* array != null &amp;&amp; for (T elem : array) {elem != null}
* </pre>
*/
public class ArraySorter {

   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Bubble Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
      if (array == null) throw new IllegalArgumentException("El arreglo es null, no se puede ordenar");
      boolean sorted = false;
      int n = array.length; 
      for (int pass = 1; (pass < n) && !sorted; ++pass) {
         sorted = true;
         for (int index = 0; index < n - pass; ++index) {
            int nextIndex = index + 1;
            if (array[index].compareTo(array[nextIndex]) > 0) {
               swap(array, index, nextIndex);
               sorted = false;
            }
         }
      }
   }

   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Selection Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void selectionSort(T[] array) {
      if (array == null) throw new IllegalArgumentException("array is null, can't sort");
      //last = indice del ultimo elemento de la parte no ordenada
      for (int last = array.length - 1; last >= 1; last--) {
         //largest = posicion del elemento mas grande
         int largest = indexOfLargest(array, last + 1);
         swap(array, last, largest);
      }
   }


   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Shell Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void shellSort(T[] array) {
      throw new UnsupportedOperationException("TODO: implementar");    
   }

   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Quick Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
  public static <T extends Comparable<? super T>> void quickSort(T[] array,int begin, int end) {
      if(begin < end){

         int p = partition(array,begin,end);
         // ordeno la parte izq
         quickSort(array, begin, p);
         // ordeno la parte derecha 
         quickSort(array, p+1, end);
      } 
   }


   public static <T extends Comparable<? super T>> int partition(T[] array, int begin, int end){
       T pivot = array[begin]; // elijo como pivot el primero

      int i = begin -1;
      int j = end + 1;

      while (i < j){

         do j--; while (array[j].compareTo(pivot) > 0);
         do i++; while (array[i].compareTo(pivot) < 0);
         if (i < j) {swap(array, i, j);}

      }


      return j ;


   }
   /**
   * Ordena un arreglo, usando el orden natural de sus elementos utilizando Merge Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void mergeSort(T[] array,int begin,int end) {
       int mitad = (begin + end) / 2;
       mergeSort(array, begin, mitad);
       mergeSort(array, mitad+1, end);
       merge(array,begin,mitad,end);
   }

   public static <T extends Comparable<? super T>> void merge(T[] array, int begin, int mitad, int end){
      int n1 = mitad - begin +1 ;
      int n2 = end - mitad;

      T[] izq = (T[]) new Object[n1];
      T[] der = (T[]) new Object[n2];

      for(int i = 0; i < n1; i++){
         izq[i] = array[begin +i];
      }

      for(int j = 0; i < n2 ; j++){
         der[j] = array[mitad + 1 +j];
      }

      int i = 0;
      int j = 0;

      int k = begin; 

      while(i < n1 && j < n2){

         if(izq[i] < der[j]){
            array[k] = izq[i];
            i++;
         }else{
            array[k] = der[j];
            j++;
         }
         k++;

      }



git



   }
   /* (non-Javadoc)
   * Este método intercambia dos posiciones de un arreglo.
   */ 
   private static <T extends Comparable<? super T>> void swap(T[] array, int i, int j) {
      T temp = array[i];
      array[i] = array[j];
      array[j] = temp;
   }

   /* (non-Javadoc)
   * Este método retorna el indice del elemento mas grande. 
   */
   private static <T extends Comparable<? super T>> int indexOfLargest(T[] array, int n){
      int largest = 0;
      for (int i = 1; i < n; i++){
         if (array[i].compareTo(array[largest]) > 0){
            largest = i;
         }
      }  
      return largest;
   }


}

