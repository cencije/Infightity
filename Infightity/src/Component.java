import java.applet.AudioClip;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import acm.graphics.GCompound;
import acm.graphics.GImage;

public class Component extends GCompound implements Runnable {

	CoordinatePair cp;
	boolean interactable = false;
	int id, x, y;
	GImage imgTop;
	boolean altered = false;
	boolean above = false;

	public Component(int id, boolean above, boolean inter, int x, int y) {
		this.id = id; interactable = inter;
		this.x = x; this.y = y;
		this.above = above;
		if (id == 1) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Door_UC.png");
			//sfx = getAudioClip(getCodeBase(),"../Sounds/Door_Sfx.wav"); 
		}
		else if (id == 2) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Door_RC.png");
		}
		else if (id == 3) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Door_DC.png");
		}
		else if (id == 4) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Door_LC.png");
		}
		else if (id == 5) {

		}
		else if (id == 6) {

		}
		else if (id == 7) {

		}
		else if (id == 8) {

		}
		else if (id == 9) {

		}
		else if (id == 10) {

		}
		else if (id == 11) {

		}
		else if (id == 12) {

		}
		else if (id == 13) {

		}
		else if (id == 14) {

		}
		else if (id == 15) {

		}
		else if (id == 201) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Bed.png");
		}
		else if (id == 202) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/SideTable.gif");
		}
		else if (id == 250) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Rug_1.png");
		}
		else if (id == 251) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Rug_1_V.png");
		}
		else if (id == 252) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Rug_2.png");
		}
		else if (id == 253) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Rug_2_V.png");
		}
		else if (id == 254) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Rug_3.png");
		}
		else if (id == 255) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Rug_3_V.png");
		}
		else if (id == 256) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Rug_4.png");
		}
		else if (id == 257) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Rug_4_V.png");
		}
		else if (id == 258) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Rug_5.png");
		}
		else if (id == 259) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Rug_5_V.png");
		}
		else if (id == 300) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Fence_V.png");
		}
		else if (id == 301) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Fence_V_T1.png");
		}
		else if (id == 302) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Fence_H_T1.png");
		}
		else if (id == 303) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Fence_V2.png");
		}
		else if (id == 401) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Tree1_G.png");
		}
		else if (id == 402) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Tree2_G.png");
		}
		else if (id == 403) {
			imgTop = new GImage("../Images/Top_Sprites/Comps/Tree3_G.png");
		}
		add(imgTop);
	}
	public void interact_with() {
		if (interactable) {
			if (altered) {
				altered = false;
				if (id == 1) imgTop.setImage("../Images/Top_Sprites/Comps/Door_UO.png");
				if (id == 2) imgTop.setImage("../Images/Top_Sprites/Comps/Door_RO.png");
				if (id == 3) imgTop.setImage("../Images/Top_Sprites/Comps/Door_DO.png");
				if (id == 4) imgTop.setImage("../Images/Top_Sprites/Comps/Door_LO.png");
			}
			else {
				altered = false;
				if (id == 1) imgTop.setImage("../Images/Top_Sprites/Comps/Door_UC.png");
				if (id == 2) imgTop.setImage("../Images/Top_Sprites/Comps/Door_RC.png");
				if (id == 3) imgTop.setImage("../Images/Top_Sprites/Comps/Door_DC.png");
				if (id == 4) imgTop.setImage("../Images/Top_Sprites/Comps/Door_LC.png");
			}
		}
	}
	public void run() {

	}
}
