public class ListaSobreArreglos<T extends Comparable> {
    private static final int MAX_LIST = 10000;
    private T items [];
    private int numItems;


    public ListaSobreArreglos(){
        items = (T[]) new Comparable[MAX_LIST];
        numItems = 0;
    }

    public boolean agregar(T elem){
        if(numItems ==  MAX_LIST) return false;

        items[numItems] = elem;
        numItems++;
        return true;
    }

    
    public String toString(){

        String result = "";

        for(int i = 0; i< numItems;i++){
            result += items[i] + "|";
        }
        return result;
    }

    public int tamaño(){
        return numItems;
    }

    public Integer buscar(T elem,int min,int max){

   

        int mitad = min +(max - min) / 2;
        Comparable<T> midValue = (Comparable<T>) items[mitad]; 

        int comparar = midValue.compareTo(elem);
    if(items[numItems-1] == elem) return numItems -1; // si entra por este caso el tiempo es constante

        if(comparar == 0){
            return mitad;
        }

        if(comparar < 0){ // el elemento esta en la parte derecha del arreglo
           return buscar(elem, mitad + 1, max); 
        }

        if(comparar > 0){ // el elemento esta en la parte izq del arreglo
            return buscar(elem,min,mitad-1);
        }
        return -1;
    }

    public T elemento(int index){
        return items[index];
    }


    public static void main(String[] args){  


        ListaSobreArreglos<Integer> arr = new ListaSobreArreglos<>();
        ListaSobreArreglos<Integer> arr2 = new ListaSobreArreglos<>();
        for(int i = 0 ; i < MAX_LIST;i++){
            arr.agregar(i);
        }
        System.out.println(arr);
        System.out.println((arr.tamaño()));
        Integer pos = arr.buscar(9998,0, MAX_LIST);
        System.out.println(pos);
        System.out.println(arr.elemento(pos));
        //arr2.agregar(0);
        //System.out.println(arr2.buscar(1, 0, arr2.tamaño()));







    }
}
