public interface ColaPrioridad {



    public boolean encolar(int elem);

    public int desencolar();
    
    public boolean esVacia();


    @Override
    public String toString();
}
