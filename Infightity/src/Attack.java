import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GRect;

public class Attack extends GCompound implements Runnable {

	MainGUI main;
	private static final double DELAY = 10;// .000001;
	boolean running = true;
	double xMove, yMove;
	int x, y;
	int dir = 1;
	int cc;
	public Attack(MainGUI mg, int cc, int dir, GImage imgAtk) {
		
		main = mg;
		add(imgAtk);
		if (cc >= 6 && cc <= 8) {
			if (dir == 1) { xMove =  0;  yMove = -1; }
			else if (dir == 2) { xMove =  1;  yMove =  0; }
			else if (dir == 3) { xMove =  0;  yMove =  1; }
			else if (dir == 4) { xMove = -1;  yMove =  0; }
		}
		this.cc = cc;
		this.dir = dir;
		/*GRect blk = new GRect(0,0,25,25);
    	blk.setFilled(true);
    	blk.setFillColor(Color.BLACK);
    	add(blk);*/
    	
		
		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	            t.cancel();
	            running = false;
	        }
	    }, 1000, 1000);
	}
	public void run() {
		while(running) {
			move(xMove, yMove);
			pause(DELAY);
		}
		System.out.println("Shot done!");
		removeAll();
	}
	
}
