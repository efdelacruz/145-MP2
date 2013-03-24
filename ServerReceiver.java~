import java.net.*;
import java.util.*;

public class ServerReceiver extends Thread{
    ServerSocket ssocket;
    Vector<MyConnection> connection_vector = new Vector<MyConnection>();
    int total = 0;
    public ServerReceiver(ServerSocket ssocket){
        this.ssocket = ssocket;
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
		    }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void announce(String msg){
        for(int i=0; i<connection_vector.size(); i++){
            MyConnection mc = connection_vector.get(i);
            try{
                mc.sendMessage(msg);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}
