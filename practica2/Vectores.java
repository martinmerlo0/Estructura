import javax.sound.midi.MidiChannel;

public class Vectores {

    static final int MI_CONSTANTE = 3;

    private float[] arreglo;

    public Vectores(float a, float b, float c) {
        arreglo = new float[MI_CONSTANTE];
        arreglo[0] = a;
        arreglo[1] = b;
        arreglo[2] = c;
    }

    public Vectores() {
        arreglo = new float[MI_CONSTANTE];
    }


    public static void main(String[] args){

        Vectores vector1 = new Vectores(1,2,3);




        System.out.println(vector1);
        vector1.multporescalar(2);





    }


    public String toString(){
        String result = "";

        for(int i = 0 ; i < MI_CONSTANTE ; i++){
            result +=  " , " + arreglo[i] ;
        }

        return "(" + result +")";
    }
    

    public Vectores multporescalar(float k){

        Vectores nuevo = new Vectores();
        nuevo[0] = arreglo[0];
        nuevo[1] = arreglo[1];
        nuevo[2] = arreglo[2];

        for(int i = 0 ; i < MI_CONSTANTE ; i++){
            nuevo[i] = k * nuevo[i];
        }
        return nuevo;
    }
}
