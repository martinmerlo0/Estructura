public class Booleanos implements Bool{
    

   private int value;

   public Booleanos(int value){
    this.value = value;
   }

   public Bool True(){
    return new Booleanos(0);
   }


   public Bool False(){
    return new Booleanos(1);
   }

   public Bool not(){
    this.value = this.value + 1;
    return this;
   }


   public Bool or(Bool b){
    Booleanos bool2 = (Booleanos) b;
    Booleanos nuevo = new Booleanos(this.value * bool2.value);
    return nuevo;
    

   }

   public Bool imp(Bool b){
    Booleanos aux = new Booleanos(this.value);
    aux.not();
    Booleanos bool1 = (Booleanos) b;
    return new Booleanos(aux.value * bool1.value);


   }

   @Override    
    public String toString(){

        if(this.value % 2 == 0){
            return "True";
        }else{
            return "False";
        }



    }
}
