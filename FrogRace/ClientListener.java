import java.net.*;
import java.util.*;

public class ClientListener extends Thread{
    FrogMover fm;
    MyConnection c;
    String msg, winner;
    String[] bets = new String[2];
    
    public ClientListener(FrogMover fm, MyConnection c){
        this.fm = fm;
        this.c = c;
    }

    public void run(){
        try{
            while (true) {
			    	msg = c.getMessage();
                	//System.out.println(msg);
                	if(msg.startsWith("GAME START!")){
                		fm.winner = c.getMessage(); System.out.println(fm.jump);
                		bets[0] = c.getMessage();
                		bets[1] = c.getMessage();
                		fm.bet_total = Integer.parseInt(bets[0]) + Integer.parseInt(bets[1]);
                		winner = fm.winner;
                		fm.jump = 1;//System.out.println(fm.winner + "JUMP " + fm.jump);
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
