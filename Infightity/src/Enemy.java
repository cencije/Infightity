
import java.awt.Color;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GRect;

/**
 * Created by Joe on 6/21/16.
 */
public class Enemy extends GCompound implements Runnable {
	private static final double DELAY = 30;
	MainGUI mainGUI;
	GImage imgTop, imgProfile;
	int id, enemyID;
    String name, secondaryName;
    int healthTotal, healthCurrent, armor;
    int attackMin, attackMax;
    int level = 1;
    boolean critPoint = false, isDead = false;

    int x, y;
    int xMove, yMove;
    int dir = 1;
    
    Random rand;
    
    public void setName(String n) {this.name = n;}
    public void setSecondaryName(String n2) {this.secondaryName = n2;}
    public void setHealth(int hTotal, int health){ this.healthTotal = hTotal; this.healthCurrent = health;}
    public void setArmor(int armor){this.armor = armor;}
    public void setAttackMin(int attackMin){this.attackMin = attackMin;}
    public void setAttackMax(int attackMax){this.attackMax = attackMax;}
    public void setCritPoint() {this.critPoint = true;}
    
    public Enemy(int listID, int enemyID, int dir, MainGUI mainGUI) {
    	rand = new Random();
    	id = listID;
    	this.dir = dir;
    	this.mainGUI = mainGUI;
    	this.enemyID = enemyID;
    	if (enemyID == 1) {
    		if (dir == 1)      { imgTop = new GImage("../Images/Top_Sprites/Enemy/Morp_U.gif"); xMove = 0; yMove = -1; }
    		else if (dir == 2) { imgTop = new GImage("../Images/Top_Sprites/Enemy/Morp_R.gif"); xMove = 1; yMove = 0; }
    		else if (dir == 3) { imgTop = new GImage("../Images/Top_Sprites/Enemy/Morp_D.gif"); xMove = 0; yMove = 1; }
    		else if (dir == 4) { imgTop = new GImage("../Images/Top_Sprites/Enemy/Morp_L.gif"); xMove = -1; yMove = 0; }
    		imgProfile = new GImage("../Images/Enemy_Sprites/E1_Morp.gif");
    	}
    	if (enemyID == 2) {
    		int dirStart = rand.nextInt(4) + 1;
    		dir = dirStart;
    		if (dir == 1)      { imgTop = new GImage("../Images/Top_Sprites/Enemy/Peasant_U.gif"); xMove = 0; yMove = -2; }
    		else if (dir == 2) { imgTop = new GImage("../Images/Top_Sprites/Enemy/Peasant_R.gif"); xMove = 2; yMove = 0; }
    		else if (dir == 3) { imgTop = new GImage("../Images/Top_Sprites/Enemy/Peasant_D.gif"); xMove = 0; yMove = 2; }
    		else if (dir == 4) { imgTop = new GImage("../Images/Top_Sprites/Enemy/Peasant_L.gif"); xMove = -2; yMove = 0; }
    		
    		imgProfile = new GImage("../Images/Enemy_Sprites/E2_Peasant.png");
    	}
    	if (enemyID == 4) {
    		imgTop = new GImage("../Images/Top_Sprites/Enemy/WizE_Down");
    		imgProfile = new GImage("../Images/Enemy_Sprites/E4_Wizard.png");
    	}
    	else if (enemyID == 9) {
    		imgTop = new GImage("../Images/Top_Sprites/Enemy/BBones_D");
    		imgProfile = new GImage("../Images/Enemy_Sprites/E9_BloodyBones.png");
    		setHealth(10,10); setArmor(0);
    		setAttackMin(1); setAttackMax(5);
    	}
    	
    	add(imgTop);
    }
    public void takeDamage(int dmg)
    {
        this.healthCurrent = healthCurrent - dmg;
        if (healthCurrent > 0) {
            float percentage = (((this.healthCurrent * 100) / healthTotal));
            System.out.println();
            System.out.print("HEALTH {");
            for (int i = 0; i < (int)percentage; i++) {
                System.out.print("#");
            }
            System.out.print(" " + (int)percentage + "%}");
            System.out.println();
            System.out.println(name + " health is now " + healthCurrent);
        }
        else
        {
            System.out.println(name + " has been slayed!");
            isDead = true;
        }
    }

    public void run() {
    	while (!isDead) {
    		pause(DELAY);
    		move(xMove,yMove);
    		if (mainGUI.collision_Enemy(this)) {
    			if (enemyID == 1 || enemyID == 2) {
    				xMove = xMove * -1; yMove = yMove * -1;
    				if (dir == 1)      { dir = 3; } 
    				else if (dir == 2) { dir = 4; }
    				else if (dir == 3) { dir = 1; } 
    				else if (dir == 4) { dir = 2; }
    				changeSprite(dir);
    			}
    		}
    	}
    	showDead();
    }
    public int attack()
    {
        rand = new Random(System.currentTimeMillis());
        int damageCalculation = (((rand.nextInt(attackMax)+1) * level));
        return damageCalculation;
    }
    public void setLevel(int lvl) {this.level = lvl;}

    public void changeSprite(int newDir) {
    	if (newDir == 1) {
    		if (enemyID == 1) imgTop.setImage("../Images/Top_Sprites/Enemy/Morp_U.gif");
    		if (enemyID == 2) imgTop.setImage("../Images/Top_Sprites/Enemy/Peasant_U.gif");
    		if (enemyID == 4) imgTop.setImage("../Images/Top_Sprites/Enemy/WizE_Up.png");
    	}
    	if (newDir == 2) {
    		if (enemyID == 1) imgTop.setImage("../Images/Top_Sprites/Enemy/Morp_R.gif");
    		if (enemyID == 2) imgTop.setImage("../Images/Top_Sprites/Enemy/Peasant_R.gif");
    		if (enemyID == 4) imgTop.setImage("../Images/Top_Sprites/Enemy/WizE_Right.png");
    	}
    	if (newDir == 3) {
    		if (enemyID == 1) imgTop.setImage("../Images/Top_Sprites/Enemy/Morp_D.gif");
    		if (enemyID == 2) imgTop.setImage("../Images/Top_Sprites/Enemy/Peasant_D.gif");
    		if (enemyID == 4) imgTop.setImage("../Images/Top_Sprites/Enemy/WizE_Down.png");
    	}
    	if (newDir == 4) {
    		if (enemyID == 1) imgTop.setImage("../Images/Top_Sprites/Enemy/Morp_L.gif");
    		if (enemyID == 2) imgTop.setImage("../Images/Top_Sprites/Enemy/Peasant_L.gif");
    		if (enemyID == 4) imgTop.setImage("../Images/Top_Sprites/Enemy/WizE_Left.png");
    	}
    }
    public void showDead() {
    	imgTop.setImage("");
    	
    	Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {
			int deathTimer = 5;
	        public void run() {
	        	deathTimer--;
	        	if (deathTimer == 0) t.cancel(); removeAll();
	        }
	    }, 0, 1000);
    }
    public void delete() {
    	removeAll();
    }
}
