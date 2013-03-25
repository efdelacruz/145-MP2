import java.net.*;
import java.util.*;

public class ServerReceiver extends Thread{
    ServerSocket ssocket;
    Vector<MyConnection> connection_vector = new Vector<MyConnection>();
    int total = 0, rand_winner = 0;
    String winnner;
    public ServerReceiver(ServerSocket ssocket){
        this.ssocket = ssocket;
    }
     public void announce(String msg){ System.out.println("ANNOUNCE");
        for(int i=0; i<connection_vector.size(); i++){
            MyConnection mc = connection_vector.get(i);
            try{
                mc.sendMessage(msg); Thread.sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
    public void startGame(){
		    this.announce("GAME START!");
		    rand_winner = 1 + (int)(Math.random() * 4);
		    String winner = Integer.toString(rand_winner);
		    this.announce(winner); System.out.println("Frog winner: " + winner);
	}

    public void run(){
        try{
            while (true) {
			        System.out.println("Server: Waiting for connections...");
			        Socket socket = ssocket.accept();
                    MyConnection connect = new MyConnection(socket);
                    connection_vector.add(connect);
			        System.out.println("Server: " + socket.getInetAddress() + 
				        " connected!");
				    System.out.println(connection_vector.toString());
				    total = total + 1;
				    if(total == 2) startGame();
		    }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
   
}
