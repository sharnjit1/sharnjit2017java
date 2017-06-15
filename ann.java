
public class Interface {

    
    public static void main(String[] args) {
        
     
       A obj =  new A(){

           
           @Override
           public void a() {
               System.out.println("this is our interface ");
           
           }
            
            
        };
       
       
       obj.a();
        
    }
    
    
    
}


// mulitiple inheritance 



interface A {
    
    
    public void a();
    
}







