
public class Interface {

    
    public static void main(String[] args) {
        
     
        Run obj = new Run();
        obj.a();
        obj.b();
       
        
    }
    
    
    
}


// mulitiple inheritance 



interface A {
    
    
    public void a();
    
}


interface B {
    
    public void b();
}




class Run implements A, B {

    @Override
    public void a() {

        System.out.println("This is a");
    
    }

    @Override
    public void b() {

        System.out.println("This is b");
    
    }
    
    
}