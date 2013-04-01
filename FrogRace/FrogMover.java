import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class FrogMover extends Thread{
    JLabel frog1, frog2, frog3, frog4, win;
    int jump = 0, xa, xb, xc, xd, ya, yb, yc, yd, bet_total, ctr = 1;
    String winner, bet_on, bet_amt;
    public FrogMover(JLabel frog1, JLabel frog2, JLabel frog3, JLabel frog4, int xa, int xb, int xc, int xd, int ya, int yb, int yc, int yd, String bet_on, String bet_amt, JLabel win){
        this.frog1=frog1; this.xa = xa; this.ya = ya;
        this.frog2=frog2; this.xb = xb; this.yb = yb;
        this.frog3=frog3; this.xc = xc; this.yc = yc;
        this.frog4=frog4; this.xd = xd; this.yd = yd;
        this.bet_on = bet_on; this.bet_amt = bet_amt; this.win = win;
    }
	
	public void check(){
	if(ctr == 1){
		if(winner.startsWith("1") && (bet_on.startsWith("A") || bet_on.startsWith("a")) ){
			JOptionPane.showMessageDialog(null, "You win " + bet_total + " for betting on FROG A!");
		}else if(winner.startsWith("2") && (bet_on.startsWith("B") || bet_on.startsWith("b")) ){
			JOptionPane.showMessageDialog(null, "You win " + bet_total + " for betting on FROG B!");
		}else if(winner.startsWith("3") && (bet_on.startsWith("C") || bet_on.startsWith("c")) ){
			JOptionPane.showMessageDialog(null, "You win " + bet_total + " for betting on FROG C!");
		}else if(winner.startsWith("4") && (bet_on.startsWith("D") || bet_on.startsWith("d")) ){
			JOptionPane.showMessageDialog(null, "You win " + bet_total + " for betting on FROG D!");
		}else{
			JOptionPane.showMessageDialog(null, "You lose your bet for betting on FROG "+ bet_on +"! Better luck next time.");
		}
		ctr++;
	}else{
		return;
	}
	}
	
    public void run(){
        String msg;
        try{
            Image frog_idle1 = new ImageIcon(getClass().getResource("frog_idle.png")).getImage();
            Image frog_idle2 = new ImageIcon(getClass().getResource("frog_norm.png")).getImage();
			Image frog_jump = new ImageIcon(getClass().getResource("frog_jump.png")).getImage();
			Image frog_win = new ImageIcon(getClass().getResource("frog_win.png")).getImage();
			Image frog_lose  = new ImageIcon(getClass().getResource("frog_lose.png")).getImage();
			Image Awin = new ImageIcon(getClass().getResource("AWin.png")).getImage();
			Image Bwin = new ImageIcon(getClass().getResource("BWin.png")).getImage();
			Image Cwin = new ImageIcon(getClass().getResource("CWin.png")).getImage();
			Image Dwin = new ImageIcon(getClass().getResource("DWin.png")).getImage();
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
            		if(xa >= 600){
            			frog1.setIcon(new ImageIcon(frog_win.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog2.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog3.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog4.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
            			jump = 2;
            		}else{
            		//jump
            		xa = xa+40; xb = xb+20; xc = xc+10; xd = xd+30;
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
            		xa = xa+20; xb = xb+10; xc = xc+5; xd = xd+15;
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
            	}else if(winner.startsWith("2")){
            		if(xb >= 600){
            			frog1.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog2.setIcon(new ImageIcon(frog_win.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog3.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog4.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
            			jump = 2;
            		}else{
            		//jump
            		xa = xa+30; xb = xb+40; xc = xc+10; xd = xd+20;
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
            		xa = xa+15; xb = xb+20; xc = xc+5; xd = xd+10;
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
            	}else if(winner.startsWith("3")){
            		if(xc >= 600){
            			frog1.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog2.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog3.setIcon(new ImageIcon(frog_win.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog4.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
            			jump = 2;
            		}else{
            		//jump
            		xa = xa+30; xb = xb+20; xc = xc+40; xd = xd+10;
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
            		xa = xa+15; xb = xb+10; xc = xc+20; xd = xd+5;
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
            	}else if(winner.startsWith("4")){
            		if(xd >= 600){
            			frog1.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog2.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog3.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog4.setIcon(new ImageIcon(frog_win.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
            			jump = 2;
            		}else{
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
            }else if(jump == 2){
            	Thread.sleep(500);
            	if(winner.startsWith("1")){
					win.setIcon(new ImageIcon(Awin.getScaledInstance( 285, 85, Image.SCALE_AREA_AVERAGING)));
            		frog1.setIcon(new ImageIcon(frog_win.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog2.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog3.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog4.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                Thread.sleep(500);
                frog1.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
                frog2.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
                frog3.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
                frog4.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
				}else if(winner.startsWith("2")){
					win.setIcon(new ImageIcon(Bwin.getScaledInstance( 285, 85, Image.SCALE_AREA_AVERAGING)));
            		frog1.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog2.setIcon(new ImageIcon(frog_win.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog3.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog4.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                Thread.sleep(500);
                frog1.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
                frog2.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
                frog3.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
                frog4.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
				}else if(winner.startsWith("3")){
					win.setIcon(new ImageIcon(Cwin.getScaledInstance( 285, 85, Image.SCALE_AREA_AVERAGING)));
            		frog1.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog2.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog3.setIcon(new ImageIcon(frog_win.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog4.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                Thread.sleep(500);
                frog1.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
                frog2.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
                frog3.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
                frog4.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
				}else if(winner.startsWith("4")){
					win.setIcon(new ImageIcon(Dwin.getScaledInstance( 285, 85, Image.SCALE_AREA_AVERAGING)));
            		frog1.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog2.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog3.setIcon(new ImageIcon(frog_lose.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                	frog4.setIcon(new ImageIcon(frog_win.getScaledInstance(72, 60, Image.SCALE_AREA_AVERAGING)));
                Thread.sleep(500);
                frog1.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
                frog2.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
                frog3.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
                frog4.setIcon(new ImageIcon(frog_idle2.getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING)));
				}
				win.setBounds(300, 145, 285, 85);
				check();
            }
            }
        }catch(Exception e){
            e.printStackTrace();
        }  
        System.exit(1);
    }
}
