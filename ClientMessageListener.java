import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ClientMessageListener extends Thread{
    MyConnection c;
    JLabel frog1;
    public ClientMessageListener(MyConnection c, JLabel frog1){
        this.c = c;
        this.frog1=frog1;
    }

    public void run(){
        String msg;
        try{
            while(true){
                //msg = c.getMessage();
                Image frog_idle1 = new ImageIcon(getClass().getResource("frog_idle.png")).getImage();
                Image frog_idle2 = new ImageIcon(getClass().getResource("frog_norm.png")).getImage();
                Thread.sleep(500);
                frog1.setIcon(new ImageIcon(frog_idle1.getScaledInstance(80, 80, Image.SCALE_AREA_AVERAGING)));
                Thread.sleep(500);
                frog1.setIcon(new ImageIcon(frog_idle2.getScaledInstance(80, 80, Image.SCALE_AREA_AVERAGING)));
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
