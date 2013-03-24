import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;

public class MyClient extends JFrame implements KeyListener{
    static JTextArea ip;
    static JTextArea port;
    static JLabel frog1;
    static JLabel frog2;
    static JLabel frog3;
    static JLabel frog4;
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
        c.setLocationRelativeTo(null);
        c.setResizable(false);
        JLabel bg = new JLabel();
        Image framebg = new ImageIcon(getClass().getResource("swamp.jpg")).getImage();
        bg.setIcon(new ImageIcon(framebg.getScaledInstance(800, 600, Image.SCALE_AREA_AVERAGING)));
        bg.setBounds(0,0,800,600);
        ip = new JTextArea();
        port = new JTextArea();
        //first textarea: ip
        ip.setSize(200,25);
        ip.setEditable(true);
        ip.setLocation(300, 125);
        //second textarea: port
        port.setSize(200,25);
        port.setEditable(true);
        port.setLocation(300,165);
        //set frogs
        frog1 = new JLabel();
        Image frog_idle1 = new ImageIcon(getClass().getResource("frog_norm.png")).getImage();
        frog1.setIcon(new ImageIcon(frog_idle1.getScaledInstance(80, 80, Image.SCALE_AREA_AVERAGING)));
        frog1.setBounds(10,355,80,80);
        frog2 = new JLabel();
        frog2.setIcon(new ImageIcon(frog_idle1.getScaledInstance(80, 80, Image.SCALE_AREA_AVERAGING)));
        frog2.setBounds(10,410,80,80);
        frog3 = new JLabel();
        frog3.setIcon(new ImageIcon(frog_idle1.getScaledInstance(80, 80, Image.SCALE_AREA_AVERAGING)));
        frog3.setBounds(10,465,80,80);
        frog4 = new JLabel();
        frog4.setIcon(new ImageIcon(frog_idle1.getScaledInstance(80, 80, Image.SCALE_AREA_AVERAGING)));
        frog4.setBounds(10,520,80,80);
        //show frame
        c.add(ip);
        c.add(port);
        c.add(frog1);
        c.add(frog2);
        c.add(frog3);
        c.add(frog4);
        c.add(bg);
        port.addKeyListener(this);
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
