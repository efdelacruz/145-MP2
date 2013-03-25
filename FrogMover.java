import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class FrogMover extends Thread{
    JLabel frog1, frog2, frog3, frog4;
    int jump = 0, xa, xb, xc, xd, ya, yb, yc, yd;
    String winner;
    public FrogMover(JLabel frog1, JLabel frog2, JLabel frog3, JLabel frog4, int xa, int xb, int xc, int xd, int ya, int yb, int yc, int yd){
        this.frog1=frog1; this.xa = xa; this.ya = ya;
        this.frog2=frog2; this.xb = xb; this.yb = yb;
        this.frog3=frog3; this.xc = xc; this.yc = yc;
        this.frog4=frog4; this.xd = xd; this.yd = yd;
    }

    public void run(){
        String msg;
        try{
            Image frog_idle1 = new ImageIcon(getClass().getResource("frog_idle.png")).getImage();
            Image frog_idle2 = new ImageIcon(getClass().getResource("frog_norm.png")).getImage();
			Image frog_jump = new ImageIcon(getClass().getResource("frog_jump.png")).getImage();
			Image frog_win = new ImageIcon(getClass().getResource("frog_win.png")).getImage();
			Image frog_lose  = new ImageIcon(getClass().getResource("frog_lose.png")).getImage();
            while(true){
            if(jump == 0){
                Thread.sleep(500);
                frog1.setIcon(new ImageIcon(frog_idle1.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                frog2.setIcon(new ImageIcon(frog_idle1.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                frog3.setIcon(new ImageIcon(frog_idle1.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                frog4.setIcon(new ImageIcon(frog_idle1.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                Thread.sleep(500);
                frog1.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
                frog2.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
                frog3.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
                frog4.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
            }else if(jump==1){
            	Thread.sleep(500);
            	if(winner.startsWith("1")){
            		//jump
            		xa = xa+40; xb = xb+30; xc = xc+20; xd = xd+10;
            		ya = ya-30; yb=yb-30; yc=yc-30; yd=yd-30;
            		frog1.setIcon(new ImageIcon(frog_jump.getScaledInstance(90, 72, Image.SCALE_AREA_AVERAGING)));
            		frog1.setBounds(xa, ya, 90, 72);
            		frog2.setIcon(new ImageIcon(frog_jump.getScaledInstance(90, 72, Image.SCALE_AREA_AVERAGING)));
            		frog2.setBounds(xb, yb, 90, 72);
            		frog3.setIcon(new ImageIcon(frog_jump.getScaledInstance(90, 72, Image.SCALE_AREA_AVERAGING)));
            		frog3.setBounds(xc, yc, 90, 72);
            		frog4.setIcon(new ImageIcon(frog_jump.getScaledInstance(90, 72, Image.SCALE_AREA_AVERAGING)));
            		frog4.setBounds(xd, yd, 90, 72);
            		//land
            		Thread.sleep(500);
            		xa = xa+20; xb = xb+15; xc = xc+10; xd = xd+5;
            		ya = ya+30; yb=yb+30; yc=yc+30; yd=yd+30;
            		frog1.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
            		frog1.setBounds(xa, ya, 72, 72);
            		frog2.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
            		frog2.setBounds(xb, yb, 72, 72);
            		frog3.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
            		frog3.setBounds(xc, yc, 72, 72);
            		frog4.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
            		frog4.setBounds(xd, yd, 72, 72);
            	}else if(winner.startsWith("2")){
            		//jump
            		xa = xa+10; xb = xb+40; xc = xc+30; xd = xd+20;
            		ya = ya-30; yb=yb-30; yc=yc-30; yd=yd-30;
            		frog1.setIcon(new ImageIcon(frog_jump.getScaledInstance(90, 72, Image.SCALE_AREA_AVERAGING)));
            		frog1.setBounds(xa, ya, 90, 72);
            		frog2.setIcon(new ImageIcon(frog_jump.getScaledInstance(90, 72, Image.SCALE_AREA_AVERAGING)));
            		frog2.setBounds(xb, yb, 90, 72);
            		frog3.setIcon(new ImageIcon(frog_jump.getScaledInstance(90, 72, Image.SCALE_AREA_AVERAGING)));
            		frog3.setBounds(xc, yc, 90, 72);
            		frog4.setIcon(new ImageIcon(frog_jump.getScaledInstance(90, 72, Image.SCALE_AREA_AVERAGING)));
            		frog4.setBounds(xd, yd, 90, 72);
            		//land
            		Thread.sleep(500);
            		xa = xa+5; xb = xb+20; xc = xc+15; xd = xd+10;
            		ya = ya+30; yb=yb+30; yc=yc+30; yd=yd+30;
            		frog1.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
            		frog1.setBounds(xa, ya, 72, 72);
            		frog2.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
            		frog2.setBounds(xb, yb, 72, 72);
            		frog3.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
            		frog3.setBounds(xc, yc, 72, 72);
            		frog4.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
            		frog4.setBounds(xd, yd, 72, 72);
            	}else if(winner.startsWith("3")){
            		//jump
            		xa = xa+20; xb = xb+10; xc = xc+40; xd = xd+30;
            		ya = ya-30; yb=yb-30; yc=yc-30; yd=yd-30;
            		frog1.setIcon(new ImageIcon(frog_jump.getScaledInstance(90, 72, Image.SCALE_AREA_AVERAGING)));
            		frog1.setBounds(xa, ya, 90, 72);
            		frog2.setIcon(new ImageIcon(frog_jump.getScaledInstance(90, 72, Image.SCALE_AREA_AVERAGING)));
            		frog2.setBounds(xb, yb, 90, 72);
            		frog3.setIcon(new ImageIcon(frog_jump.getScaledInstance(90, 72, Image.SCALE_AREA_AVERAGING)));
            		frog3.setBounds(xc, yc, 90, 72);
            		frog4.setIcon(new ImageIcon(frog_jump.getScaledInstance(90, 72, Image.SCALE_AREA_AVERAGING)));
            		frog4.setBounds(xd, yd, 90, 72);
            		//land
            		Thread.sleep(500);
            		xa = xa+10; xb = xb+5; xc = xc+20; xd = xd+15;
            		ya = ya+30; yb=yb+30; yc=yc+30; yd=yd+30;
            		frog1.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
            		frog1.setBounds(xa, ya, 72, 72);
            		frog2.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
            		frog2.setBounds(xb, yb, 72, 72);
            		frog3.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
            		frog3.setBounds(xc, yc, 72, 72);
            		frog4.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
            		frog4.setBounds(xd, yd, 72, 72);
            	}else if(winner.startsWith("4")){
            		//jump
            		xa = xa+30; xb = xb+20; xc = xc+10; xd = xd+40;
            		ya = ya-30; yb=yb-30; yc=yc-30; yd=yd-30;
            		frog1.setIcon(new ImageIcon(frog_jump.getScaledInstance(90, 72, Image.SCALE_AREA_AVERAGING)));
            		frog1.setBounds(xa, ya, 90, 72);
            		frog2.setIcon(new ImageIcon(frog_jump.getScaledInstance(90, 72, Image.SCALE_AREA_AVERAGING)));
            		frog2.setBounds(xb, yb, 90, 72);
            		frog3.setIcon(new ImageIcon(frog_jump.getScaledInstance(90, 72, Image.SCALE_AREA_AVERAGING)));
            		frog3.setBounds(xc, yc, 90, 72);
            		frog4.setIcon(new ImageIcon(frog_jump.getScaledInstance(90, 72, Image.SCALE_AREA_AVERAGING)));
            		frog4.setBounds(xd, yd, 90, 72);
            		//land
            		Thread.sleep(500);
            		xa = xa+15; xb = xb+10; xc = xc+15; xd = xd+20;
            		ya = ya+30; yb=yb+30; yc=yc+30; yd=yd+30;
            		frog1.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
            		frog1.setBounds(xa, ya, 72, 72);
            		frog2.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
            		frog2.setBounds(xb, yb, 72, 72);
            		frog3.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
            		frog3.setBounds(xc, yc, 72, 72);
            		frog4.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
            		frog4.setBounds(xd, yd, 72, 72);  		
            	}
            }
            }
        }catch(Exception e){
            e.printStackTrace();
        }  
        System.exit(1);
    }
}
