public class MainBool {

    public static void main(String[] args){

        Bool bool1 = new Booleanos(0); // True 
        Bool bool2 = new Booleanos(1); // False 

       // Bool result1 = bool1.not();
        Bool result2 = bool1.or(bool2); 
        Bool result3 = bool1.imp(bool2);


       // System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }





}
