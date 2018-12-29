import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GRect;

public class Sprite extends GCompound implements Runnable {

	Player plr;
	GImage sprite;
	int dir = 0;
	int prevDir = 0;
	MainGUI mainGame;
	int cc;
	
	GRect hfill, hb;
	double healthRemaining;
	boolean invincibleHit = false;
	public Sprite(Player p, MainGUI game) {
		plr = p; 
		mainGame = game;
		cc = plr.classChar;
		sprite = new GImage("");
    	sprite.setSize(25,25);
    	setSprite(1);
    	add(sprite);
    	
    	/*
    	GRect blk = new GRect(0,0,25,25);
    	blk.setFilled(true);
    	blk.setFillColor(Color.BLACK);
    	add(blk);
    	*/
	}
	
    public void setSprite(int id) {
    	
    	if (id != dir) {
    		prevDir = dir;
    		dir = id;
    		if (cc == 6) {
	    		if (dir == 1) sprite.setImage("../Images/Top_Sprites/Plr/Wiz1_Up.png");
	    		else if (dir == 2) sprite.setImage("../Images/Top_Sprites/Plr/Wiz1_Right.png");
	    		else if (dir == 3) sprite.setImage("../Images/Top_Sprites/Plr/Wiz1_Down.png");
	    		else if (dir == 4) sprite.setImage("../Images/Top_Sprites/Plr/Wiz1_Left.png");
    		}
    		else if (cc == 7) {
	    		if (dir == 1) sprite.setImage("../Images/Top_Sprites/Plr/Wiz2_Up.png");
	    		else if (dir == 2) sprite.setImage("../Images/Top_Sprites/Plr/Wiz2_Right.png");
	    		else if (dir == 3) sprite.setImage("../Images/Top_Sprites/Plr/Wiz2_Down.png");
	    		else if (dir == 4) sprite.setImage("../Images/Top_Sprites/Plr/Wiz2_Left.png");
    		}
    		else if (cc == 8) {
	    		if (dir == 1) sprite.setImage("../Images/Top_Sprites/Plr/Wiz3_Up.png");
	    		else if (dir == 2) sprite.setImage("../Images/Top_Sprites/Plr/Wiz3_Right.png");
	    		else if (dir == 3) sprite.setImage("../Images/Top_Sprites/Plr/Wiz3_Down.png");
	    		else if (dir == 4) sprite.setImage("../Images/Top_Sprites/Plr/Wiz3_Left.png");
    		}
    		else if (cc == 12) {
	    		if (dir == 1) sprite.setImage("../Images/Top_Sprites/Plr/Skeleton_Up.png");
	    		else if (dir == 2) sprite.setImage("../Images/Top_Sprites/Plr/Skeleton_Right.png");
	    		else if (dir == 3) sprite.setImage("../Images/Top_Sprites/Plr/Skeleton_Down.png");
	    		else if (dir == 4) sprite.setImage("../Images/Top_Sprites/Plr/Skeleton_Left.png");
    		}
    		sprite.setSize(25,25);
    		
    		hfill = new GRect(-2, -5, 29, 3);
        	hfill.setFillColor(Color.RED); hfill.setColor(Color.BLACK);
        	hfill.setFilled(true); add(hfill);
        	
        	healthRemaining = plr.getHealthPercentage();
        	hb = new GRect(-2, -5, 29, 3);
        	hb.setFillColor(Color.GREEN); hb.setColor(Color.BLACK);
        	hb.setFilled(true); add(hb);
        	hb.setBounds(-2, -5, 29 * healthRemaining, 3);
        	showHealthBar();
    	}
    }
    public void prev_Dir() {
    	if (dir != prevDir) {
    		dir = prevDir;
	    	if (cc == 6) {
	    		if (dir == 1) sprite.setImage("../Images/Top_Sprites/Plr/Wiz1_Up.png");
	    		else if (dir == 2) sprite.setImage("../Images/Top_Sprites/Plr/Wiz1_Right.png");
	    		else if (dir == 3) sprite.setImage("../Images/Top_Sprites/Plr/Wiz1_Down.png");
	    		else if (dir == 4) sprite.setImage("../Images/Top_Sprites/Plr/Wiz1_Left.png");
			}
			else if (cc == 7) {
				if (dir == 1) sprite.setImage("../Images/Top_Sprites/Plr/Wiz2_Up.png");
				else if (dir == 2) sprite.setImage("../Images/Top_Sprites/Plr/Wiz2_Right.png");
				else if (dir == 3) sprite.setImage("../Images/Top_Sprites/Plr/Wiz2_Down.png");
				else if (dir == 4) sprite.setImage("../Images/Top_Sprites/Plr/Wiz2_Left.wpng");
			}
			else if (cc == 8) {
	    		if (dir == 1) sprite.setImage("../Images/Top_Sprites/Plr/Wiz3_Up.png");
	    		else if (dir == 2) sprite.setImage("../Images/Top_Sprites/Plr/Wiz3_Right.png");
	    		else if (dir == 3) sprite.setImage("../Images/Top_Sprites/Plr/Wiz3_Down.png");
	    		else if (dir == 4) sprite.setImage("../Images/Top_Sprites/Plr/Wiz3_Left.png");
			}
			else if (cc == 12) {
	    		if (dir == 1) sprite.setImage("../Images/Top_Sprites/Plr/Skeleton_Up.png");
	    		else if (dir == 2) sprite.setImage("../Images/Top_Sprites/Plr/Skeleton_Right.png");
	    		else if (dir == 3) sprite.setImage("../Images/Top_Sprites/Plr/Skeleton_Down.png");
	    		else if (dir == 4) sprite.setImage("../Images/Top_Sprites/Plr/Skeleton_Left.png");
			}
	    	sprite.setSize(25,25);
    	}
    }
    public void attack() {
    	
    	if (cc >= 6 && cc <= 8) {
    		GImage wizShot = new GImage("../Images/Projectiles/Atk_W_UD.gif");
    		if (dir == 2 || dir == 4) wizShot.setImage("../Images/Projectiles/Atk_W_LR.gif");
    		Attack a = new Attack(mainGame, cc, dir, wizShot);
    		mainGame.insertAttack(a, a.dir);
    	}
    	if (cc == 12) {
    		GImage atkSwing = new GImage("../Images/Projectiles/Swing_U.gif"); 
    		if (dir == 2) atkSwing.setImage("../Images/Projectiles/Swing_R.gif");
    		else if (dir == 3) atkSwing.setImage("../Images/Projectiles/Swing_D.gif");
    		else if (dir == 4) atkSwing.setImage("../Images/Projectiles/Swing_L.gif");
    		Attack a = new Attack(mainGame, cc, dir, atkSwing);
    		mainGame.insertAttack(a, a.dir);
    	}
    }
    public void plrHit(int amtHurt) {
    	if (!invincibleHit) {
    		invincibleHit = true;
        	plr.getHit(amtHurt);
        	showHealthBar();
        	Timer t = new Timer();
        	t.scheduleAtFixedRate(new TimerTask() {
        		int invincibleTimer = 50;
    	        public void run() {
    	        	if (sprite.isVisible()) {
    	        		sprite.setVisible(false);
    	        	}
    	        	else sprite.setVisible(true);
    	        	invincibleTimer--;
    	        	if (invincibleTimer == 0) {
    	        		invincibleHit = false;
    	        		t.cancel(); 
    	        	}
    	        }
        	}, 0, 100);
    	}
    	
    	
    }
    public void showHealthBar() {
    	healthRemaining = plr.getHealthPercentage();
    	hb.setBounds(-2, -5, 29 * healthRemaining, 3);
   	
    }
    
    public void run() {

    }
}
