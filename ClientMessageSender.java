import java.net.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class ClientMessageSender extends Thread implements KeyListener{
    MyConnection c;
    boolean end=false;

    public ClientMessageSender(MyConnection c){
        this.c = c;
    }

    public void run(){
        String msg;
        while(end!=true){
            //System.out.println(1);
        }
        System.exit(1);
    }

    public void keyPressed(KeyEvent e){ 
    
	}
  	public void keyTyped(KeyEvent e){ 
            		
	}
    public void keyReleased(KeyEvent e){ 

	}
}
