import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.imageio.*;
import java.io.*;

@SuppressWarnings("unused")
public class GameObject implements Runnable{

    public void paint(Graphics2D g) {

    }
    
    public void keyPressed(String key) {

    }
    
    public static BufferedImage getImage(String filename) {
		try {
			File fp = new File(filename);
			BufferedImage img = ImageIO.read(fp);			
			return img;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
    
    public void keyReleased(String key) {
        
    }
    
    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) { }
    }

    public void run() {
        
    }
}
