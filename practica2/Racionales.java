public class Racionales {
    private long numerador;
    private long denominador;

    public Racionales() {
        numerador = 0;
        denominador = 1;
    }

    public Racionales(long a, long b) {
        this.numerador = a;
        this.denominador = b;
    }

    public Racionales SumarRacionales(Racionales otro) {
        long nuevoNumerador = (this.numerador * otro.denominador) + (otro.numerador * this.denominador);
        long nuevoDenominador = (this.denominador * otro.denominador);

        return new Racionales(nuevoNumerador, nuevoDenominador);
    }

    public Racionales RestarRacionales(Racionales otro) {
        long nuevoNumerador = (this.numerador * otro.denominador) - (otro.numerador * this.denominador);
        long nuevoDenominador = (this.denominador * otro.denominador);

        return new Racionales(nuevoNumerador, nuevoDenominador);
    }

    @Override
    public String toString() {
        return numerador + " / " + denominador;
    }

    
    public boolean equals(Racionales otro) {

        if (this.numerador == otro.numerador && this.denominador == otro.denominador){
            return true;
        }else{
            return false;
        }


    }


    public static void main(String[] args) {
        Racionales var1 = new Racionales(3, 2); // 3 / 2
        Racionales var2 = new Racionales(6, 3); // 6 / 3


        Racionales var3 = new Racionales(6, 3);

        Racionales suma = var1.SumarRacionales(var2);
        System.out.println("El resultado de la suma es " + suma);
        Racionales resta = var1.RestarRacionales(var2);
        System.out.println("El resultado de la resta es :" + resta);

        if (var2.equals(var1)){
            System.out.println("Los objetos son iguales");
        }else{
            System.out.println("Los objetos son diferentes");
        }
    }
}
