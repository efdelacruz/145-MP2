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
    static JLabel frog1, A;
    static JLabel frog2, B;
    static JLabel frog3, C;
    static JLabel frog4, D;
    String ipcont;
    int portcont, xa, xb, xc, xd, ya, yb, yc, yd;
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
        xa=50; xb=50; xc=50; xd=50;
        ya=363; yb=410; yc=455; yd=498;
        frog1 = new JLabel();
        Image frog_idle1 = new ImageIcon(getClass().getResource("frog_norm.png")).getImage();
        frog1.setIcon(new ImageIcon(frog_idle1.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
        frog1.setBounds(xa,ya,72, 72);
        frog2 = new JLabel();
        frog2.setIcon(new ImageIcon(frog_idle1.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
        frog2.setBounds(xb,yb,72, 72);
        frog3 = new JLabel();
        frog3.setIcon(new ImageIcon(frog_idle1.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
        frog3.setBounds(xc,yc,72, 72);
        frog4 = new JLabel();
        frog4.setIcon(new ImageIcon(frog_idle1.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
        frog4.setBounds(xd,yd,72, 72);
        //set letters ABCD
        A = new JLabel();
        B = new JLabel();
        C = new JLabel();
        D = new JLabel();
        Image imgA = new ImageIcon(getClass().getResource("A.png")).getImage();
        Image imgB = new ImageIcon(getClass().getResource("B.png")).getImage();
        Image imgC = new ImageIcon(getClass().getResource("C.png")).getImage();
        Image imgD = new ImageIcon(getClass().getResource("D.png")).getImage();
        A.setIcon(new ImageIcon(imgA.getScaledInstance(60, 60, Image.SCALE_AREA_AVERAGING)));
        A.setBounds(5,380,60, 60);
        B.setIcon(new ImageIcon(imgB.getScaledInstance(60, 60, Image.SCALE_AREA_AVERAGING)));
        B.setBounds(5,430,60, 60);
        C.setIcon(new ImageIcon(imgC.getScaledInstance(60, 60, Image.SCALE_AREA_AVERAGING)));
        C.setBounds(5,476,60, 60);
        D.setIcon(new ImageIcon(imgD.getScaledInstance(60, 60, Image.SCALE_AREA_AVERAGING)));
        D.setBounds(5,515,60, 60);
        //show frame
        c.add(ip);
        c.add(port);
        c.add(frog1); c.add(A);
        c.add(frog2); c.add(B);
        c.add(frog3); c.add(C);
        c.add(frog4); c.add(D);
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
                FrogMover fm = new FrogMover(frog1,frog2,frog3,frog4, xa, xb, xc, xd, ya, yb, yc, yd);
                fm.start();
                ClientListener cl = new ClientListener(fm, connect);
                cl.start();
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
