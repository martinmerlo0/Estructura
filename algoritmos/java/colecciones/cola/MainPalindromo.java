package colecciones.cola;


import colecciones.cola.Cola;
import colecciones.cola.ColaArregloFijo;


public class MainPalindromo {
    

// java Main Hola Chau
// args = ["Hola","Chau"]
    public static void main(String[] args){
      
        Cola<Character> cola1 = new ColaArregloFijo<>();
        Cola<Character> cola2 = new ColaArregloFijo<>();
        System.out.println(args[0]);
        String result = args[0];
        for(int i = 0;i < result.length() ; i++){  
            cola1.encolar(result.charAt(i));

        }
        
        for(int i = result.length()-1  ; i >= 0; i--){
            cola2.encolar(result.charAt(i));
        }


        System.out.println(cola1);
        System.out.println(cola2);

        if(cola1.equals(cola2)){
            System.out.println("es palindromo");
        }else{
            System.out.println("no es palindromo");
        }


    }












}