import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;

public class MyClient extends JFrame implements KeyListener{
    static JTextArea ip;
    static JTextArea port;
    String ipcont;
    int portcont;
    Socket socket;
    MyConnection connect;
	public static void main(String args[]) {
		try {
            MyClient c = new MyClient();
            c.init_window(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    public void init_window(MyClient c){
    	//c.setLayout(null);
        c.setSize(800,600);
        c.setTitle("Client");
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setResizable(false);
        Container cont = new Container();
        JLabel bg = new JLabel(new Image(new ImageIcon("swamp.jpg")));
        bg.setBounds(0,0,800,600);
        //bg.setLocation(0,0);
        cont.setBounds(0,0,800,600);
        //cont.setLocation(0,0);
        cont.add(bg);
        ip = new JTextArea();
        port = new JTextArea();
        //first textarea: ip
        ip.setSize(200,25);
        ip.setEditable(true);
        ip.setLocation(300, 450);
        //second textarea: port
        port.setSize(200,25);
        port.setEditable(true);
        port.setLocation(300,490);
        //show frame
        c.add(ip);
        c.add(port);
        c.add(cont);
        port.addKeyListener(this);
        //c.pack();
        c.setVisible(true);
    }
    public void keyPressed(KeyEvent e){ 
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            try{
                ipcont = ip.getText();
                portcont = Integer.parseInt(port.getText());
                //System.out.println("Hello");
                socket = new Socket(ipcont,portcont);
                connect = new MyConnection(socket);
                ClientMessageSender cms = new ClientMessageSender(connect);
                ClientMessageListener cml = new ClientMessageListener(connect);
                cml.start();
                cms.start();
                this.remove(ip);
                this.remove(port);
                this.setVisible(false);
                this.setLocationRelativeTo(null);
                this.setVisible(true);
           } catch (Exception ex){
			    ex.printStackTrace();
		   }
        }
	}
  	public void keyTyped(KeyEvent e){ 
            		
	}
    public void keyReleased(KeyEvent e){ 
            		
	}
}
