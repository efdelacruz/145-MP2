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
    Vector<GameObject> gameobjects = new Vector<GameObject>();
    static JTextArea ip;
    static JTextArea port;
    String ipcont;
    int portcont;
    Socket socket;
    MyConnection connect;
    Canvas canvas;
	BufferStrategy buffer;
	GraphicsEnvironment ge;
	GraphicsDevice gd;
	GraphicsConfiguration gc; 
	
	BufferedImage bi;
    Frog frog;
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
        c.setSize(490,490);
        c.setTitle("Client");
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setResizable(false);
        Container cont = new Container();
        JLabel bg = new JLabel(new ImageIcon("swamp.jpg"));
        bg.setBounds(0,0,489,450);
        //cont.setBounds(0,0,800,600);
        cont.add(bg);
        ip = new JTextArea("127.0.0.1");
        port = new JTextArea("8888");
        //first textarea: ip
        ip.setSize(200,25);
        ip.setEditable(true);
        ip.setLocation(150, 125);
        //second textarea: port
        port.setSize(200,25);
        port.setEditable(true);
        port.setLocation(150,165);
        //show frame
        Graphics2D g;
        Object froglock = new Object();
        frog = new Frog(froglock, 350, 500);
        c.add(frog);
        c.add(ip);
        c.add(port);
        c.add(cont);
        port.addKeyListener(this);
        //c.pack();
        c.setVisible(true);
        // getting the graphics configuration
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd = ge.getDefaultScreenDevice();
		gc = gd.getDefaultConfiguration();
    }
    
    public void draw() {
		@SuppressWarnings("unused")
		Random rand = new Random();
		Graphics graphics = null;
		Graphics2D g2d = null;
		Color background = Color.BLACK;
				
		while(true) {
			try {				
				// clear back buffer
				g2d = bi.createGraphics();
				g2d.setColor(background);
				g2d.fillRect(0,0,640,675);
				
				// draw stuff
				for (GameObject go : gameobjects) {		
					go.paint(g2d);
				}
				
				// placing the back buffer in front
				graphics = buffer.getDrawGraphics();
				graphics.drawImage(bi,0,0,null);
				if (!buffer.contentsLost()) {
					buffer.show();
				}				
				Thread.yield();			
			} finally {
				if (graphics != null) {
					graphics.dispose();
				}
				if (g2d != null) {
					g2d.dispose();
				}
			
			}
		}
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
                this.draw();
                //Object froglock = new Object();
                //this.add(new Frog(froglock, 425, 500));
           } catch (Exception ex){
			    ex.printStackTrace();
		   }
        }
	}
	
    public void add(GameObject go) {
        gameobjects.add(go);
    }
    
  	public void keyTyped(KeyEvent e){ 
            		
	}
    public void keyReleased(KeyEvent e){ 
            		
	}
}
