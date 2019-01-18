import java.awt.Color;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GRect;

public class NPC extends GCompound implements Runnable {
	private static final double DELAY = 30;
	MainGUI mainGUI;
	GImage imgTop, imgProfile;
	int id, npcID;
    String name, secondaryName;
    boolean paused = false, deleted = false;

    Random rand;
    Timer t;
    int x, y;
    int xMove, yMove;
    int dir = 1;

    public void setName(String n) {this.name = n;}
    public void setSecondaryName(String n2) {this.secondaryName = n2;}
    
	public NPC(int listID, int npcID, int dir, MainGUI mainGUI) {
		rand = new Random();
    	id = listID;
    	this.dir = dir;
    	this.mainGUI = mainGUI;
    	this.npcID = npcID;
    	
    	if (npcID == 1) {
    		if (dir == 1)      { imgTop = new GImage("../Images/Top_Sprites/NPC/Chicken_SU.gif"); xMove = 0; yMove = -1; }
    		else if (dir == 2) { imgTop = new GImage("../Images/Top_Sprites/NPC/Chicken_SR.gif"); xMove = 1; yMove = 0; }
    		else if (dir == 3) { imgTop = new GImage("../Images/Top_Sprites/NPC/Chicken_SD.gif"); xMove = 0; yMove = 1; }
    		else if (dir == 4) { imgTop = new GImage("../Images/Top_Sprites/NPC/Chicken_SL.gif"); xMove = -1; yMove = 0; }
    		imgProfile = new GImage("../Images/Profiles/NPC/Chicken.gif");
    	}
    	if (npcID == 2) {
    		int dirStart = rand.nextInt(4) + 1;
    		dir = dirStart;
    		if (dir == 1)      { imgTop = new GImage("../Images/Top_Sprites/NPC/Person1_SU.gif"); xMove = 0; yMove = -2; }
    		else if (dir == 2) { imgTop = new GImage("../Images/Top_Sprites/NPC/Person1_SR.gif"); xMove = 2; yMove = 0; }
    		else if (dir == 3) { imgTop = new GImage("../Images/Top_Sprites/NPC/Person1_SD.gif"); xMove = 0; yMove = 2; }
    		else if (dir == 4) { imgTop = new GImage("../Images/Top_Sprites/NPC/Person1_SL.gif"); xMove = -2; yMove = 0; }
    		
    		imgProfile = new GImage("../Images/Profiles/NPC/Person1_Prof.gif");
    	}
    	/*GRect blk = new GRect(0,0,16,16);
    	blk.setFilled(true);
    	blk.setFillColor(Color.BLACK);
    	add(blk);*/
    	
    	t = new Timer();
    	t.scheduleAtFixedRate(new TimerTask() {
    		public void run() {
                int move = rand.nextInt(9);
                if (move == 0) {
                	move = rand.nextInt(4) + 1;
                	changeSpriteWalking(move);
                }
                else if (move == 8) { changeSpriteStanding(); }
            }
    	}, 1000, 1000);
    	
    	add(imgTop);
	}

	public void run() {
    	while (!deleted) {
    		if (!paused) {
	    		pause(DELAY);
	    		move(xMove,yMove);
	    		if (mainGUI.collision_NPC(this)) {
	    			if (npcID == 1 || npcID == 2) {
	    				if (dir == 1)      { dir = 3; } 
	    				else if (dir == 2) { dir = 4; }
	    				else if (dir == 3) { dir = 1; } 
	    				else if (dir == 4) { dir = 2; }
	    				changeSpriteWalking(dir);
	    			}
	    		}
    		}
    		else pause(DELAY);
    	}
    	if (deleted) t.cancel();
    }
	public void changeSpriteStanding() {
		if (npcID == 1) {
			xMove = 0; yMove = 0;
			if (dir == 1)      { imgTop.setImage("../Images/Top_Sprites/NPC/Chicken_SU.gif"); }
    		else if (dir == 2) { imgTop.setImage("../Images/Top_Sprites/NPC/Chicken_SR.gif"); }
    		else if (dir == 3) { imgTop.setImage("../Images/Top_Sprites/NPC/Chicken_SD.gif"); }
    		else if (dir == 4) { imgTop.setImage("../Images/Top_Sprites/NPC/Chicken_SL.gif"); }
		}
	}
	public void changeSpriteWalking(int newDir) {
		dir = newDir;
		if (newDir == 1) {
    		if (npcID == 1) {
    			xMove = 0; yMove = -1;
    			imgTop.setImage("../Images/Top_Sprites/NPC/Chicken_WU.gif");
    		}
    		if (npcID == 2) imgTop.setImage("../Images/Top_Sprites/NPC/Person1_WU.gif");
    	}
    	if (newDir == 2) {
    		if (npcID == 1) {
    			xMove = 1; yMove = 0;
    			imgTop.setImage("../Images/Top_Sprites/NPC/Chicken_WR.gif");
    		}
    		if (npcID == 2) imgTop.setImage("../Images/Top_Sprites/NPC/Person1_WR.gif");
    	}
    	if (newDir == 3) {
    		if (npcID == 1) {
    			xMove = 0; yMove = 1;
    			imgTop.setImage("../Images/Top_Sprites/NPC/Chicken_WD.gif");
    		}
    		if (npcID == 2) imgTop.setImage("../Images/Top_Sprites/NPC/Person1_WD.gif");
    	}
    	if (newDir == 4) {
    		if (npcID == 1) {
    			xMove = -1; yMove = 0;
    			imgTop.setImage("../Images/Top_Sprites/NPC/Chicken_WL.gif");
    		}
    		if (npcID == 2) imgTop.setImage("../Images/Top_Sprites/NPC/Person1_WL.gif");
    	}
	}
	
}
