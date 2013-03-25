import java.net.*;
import java.util.*;

public class ClientListener extends Thread{
    FrogMover fm;
    MyConnection c;
    String msg;
    
    public ClientListener(FrogMover fm, MyConnection c){
        this.fm = fm;
        this.c = c;
    }

    public void run(){
        try{
            while (true) {
			    	msg = c.getMessage();
                	System.out.println(msg);
                	if(msg.startsWith("GAME START!")){
                		fm.winner = c.getMessage(); System.out.println(fm.jump);
                		fm.jump = 1;System.out.println(fm.winner + "JUMP " + fm.jump);
                	}
		    }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            c.connectionSocket.close();
        }catch(Exception e){
            e.printStackTrace();
        }      
    }
}
