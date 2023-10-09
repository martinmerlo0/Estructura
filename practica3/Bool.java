public interface Bool {

    public Bool True();

    public Bool False();

    public Bool or(Bool b);

    public Bool imp(Bool b);

    public Bool not();

    @Override    
    public String toString();

    
}
