import java.applet.AudioClip;
//import java.applet.*;
import java.awt.Color;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Fight extends GraphicsProgram implements Runnable {

	int width, height;
	private static final double DELAY = 1;
	AudioClip gameMusic = getAudioClip(getCodeBase(),"../Music/Snowball_Fight.wav"); 
	private RandomGenerator rand = new RandomGenerator();
	GOval[] weather = new GOval[200];
	GRect revealBlock;
	int condition = 1;
	Color menuColor = new Color(52, 63, 71);
	Color sand = new Color(145, 101, 34);
	
	public void init() {
		this.setSize(580,300);
		System.out.println("HOWDY init");
		setBackground(menuColor);
		width = getWidth();
	    height = getHeight();
	    revealBlock = new GRect(-50,-1, 700, 350);
	    revealBlock.setFillColor(Color.BLACK); revealBlock.setColor(Color.BLACK); revealBlock.setFilled(true);
	    add(revealBlock);
	    drawWeather(condition);
	    gameMusic.loop();
	}
	public void run() {
		//this.gameMusic.play();
		while (true) {
			
			revealBlock.move(1,0);
			for (int i = 0 ; i < 200 ; i++) {
				if (condition == 1) {
					weather[i].move(.05, .1);
					if (weather[i].getY() >= 310) weather[i].setLocation(rand.nextDouble(-200, 600), rand.nextDouble(-10, -100)); 
				}
				else if (condition == 2) {
					weather[i].move(.05, .4);
					if (weather[i].getY() >= 310) weather[i].setLocation(rand.nextDouble(-80, 600), rand.nextDouble(-10, -100));
				}
				else if (condition == 3) {
					weather[i].move(.4, .02);
					if (weather[i].getX() >= 600) weather[i].setLocation(rand.nextDouble(-10, -500), rand.nextDouble(-100, 250));
				}
			}
			if (revealBlock.getX() > 610) remove(revealBlock);
			pause(DELAY); 
		}
	}
	public void drawWeather(int cond) {
		condition = cond;
		if (condition == 1) {
			for (int i = 0 ; i < 200 ; i++) {
			      weather[i] = new GOval(0,0); weather[i].setSize(3, 3);  weather[i].setFilled(true);  weather[i].setFillColor(Color.WHITE);
			      weather[i].setColor(Color.BLACK); add(weather[i], rand.nextDouble(-200, 550), rand.nextDouble(-10, -400));  
			}
		}
		if (condition == 2) {
			for (int i = 0 ; i < 200 ; i++) {
			      weather[i] = new GOval(0,0); weather[i].setSize(3, 4); weather[i].setFilled(true);  weather[i].setFillColor(Color.CYAN);
			      weather[i].setColor(Color.BLACK); add(weather[i], rand.nextDouble(-80, 550), rand.nextDouble(-10, -300));  
			}
		}
		if (condition == 3) {
			for (int i = 0 ; i < 200 ; i++) {
			      weather[i] = new GOval(0,0); weather[i].setSize(3, 3); weather[i].setFilled(true); weather[i].setFillColor(sand);
			      weather[i].setColor(Color.BLACK); add(weather[i], rand.nextDouble(-800, 0), rand.nextDouble(-100, 250));  
			}
		}
	}
}
