
public class Suma{


public static int suma1 ( int n ) {
return ( n * ( n + 1 ) / 2 ) ;
}


public static int suma ( int n ) {
 if ( n==0) return 0 ;
return (n + suma ( n - 1 ));
}

    public static void main(String[] args){

        int n = Integer.parseInt(args[0]);
        
        long principio, principio2;
        long fin, fin2;
        long diferencia, diferencia2;
      
        principio = System.nanoTime();

        int resultado = suma(n);

        fin = System.nanoTime();

        diferencia = fin - principio;   
        
        System.out.println(diferencia);


        principio2 = System.nanoTime();

        int resultado2 = suma1(n);

        fin2 = System.nanoTime();

        diferencia2 = fin2 - principio2;

        System.out.println(diferencia2);


    }







    
}

