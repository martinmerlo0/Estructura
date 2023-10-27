public class Probando {
    public static void main(String[] args) {
        String str1 = "Manzana";
        String str2 = "Banana";

        int result = str1.compareTo(str2);

        if (result < 0) {
            System.out.println("str1 es menor que str2");
        } else if (result > 0) {
            System.out.println("str1 es mayor que str2");
        } else {
            System.out.println("str1 y str2 son iguales");
        }
    }
}