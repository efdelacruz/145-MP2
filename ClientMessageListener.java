import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ClientMessageListener extends Thread{
    MyConnection c;
    public ClientMessageListener(MyConnection c){
        this.c = c;
    }

    public void run(){
        String msg;
        try{
            while(true){
                msg = c.getMessage();
            }         
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            c.connectionSocket.close();
        }catch(Exception e){
            e.printStackTrace();
        }        
        System.exit(1);
    }
}
