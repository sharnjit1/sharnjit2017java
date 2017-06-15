
public class Interface {

    
    public static void main(String[] args) {
        
        
        Coc obj = new Coc();
        obj.gamename();
        obj.play();
        obj.run();
        obj.stop();
        
        
       
        
    }
    
    
    
}



abstract class game {
    
    
    String gamename = "COC";
    
    
    public void gamename() {
        
        System.out.println(gamename);
    }
    
    public abstract void run();
    public abstract void play();
    public abstract void stop();
    
    
    
}

class Coc extends game{

    @Override
    public void run() {

        System.out.println("runnning");
    }

    @Override
    public void play() {

        System.out.println("playing");
    
    }

    @Override
    public void stop() {

        System.out.println("stopping ");
    
    }
    
    
}
