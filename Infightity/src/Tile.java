import acm.graphics.GCompound;
import acm.graphics.GImage;

public class Tile extends GCompound {

	GImage img;
	int id;
	int width, height;
	boolean canPass = true;

	public Tile(int x, int y, int type) {
		id = type;
		if (type <= 10) { canPass = false; }
		else canPass = true;
		if (type == 0)        img = new GImage("../Images/Top_Sprites/Tiles/Wall_Block.png"); 
		else if (type == 1)   img = new GImage("../Images/Top_Sprites/Tiles/Wall_Block.png"); 
		else if (type == 2)   img = new GImage("../Images/Top_Sprites/Tiles/Wall_HT.png"); 
		else if (type == 3)   img = new GImage("../Images/Top_Sprites/Tiles/Wall_VR.png"); 
		else if (type == 4)   img = new GImage("../Images/Top_Sprites/Tiles/Wall_HB.png"); 
		else if (type == 5)   img = new GImage("../Images/Top_Sprites/Tiles/Wall_VL.png");
		else if (type == 6)   img = new GImage("../Images/Top_Sprites/Tiles/Wall_CTL.png"); 
		else if (type == 7)   img = new GImage("../Images/Top_Sprites/Tiles/Wall_CTR.png"); 
		else if (type == 8)   img = new GImage("../Images/Top_Sprites/Tiles/Wall_CBL.png"); 
		else if (type == 9)   img = new GImage("../Images/Top_Sprites/Tiles/Wall_CBR.png");
		else if (type == 21)  img = new GImage("../Images/Top_Sprites/Tiles/Grass_1.png");
		else if (type == 22)  img = new GImage("../Images/Top_Sprites/Tiles/Grass_2.png");
		else if (type == 23)  img = new GImage("../Images/Top_Sprites/Tiles/Grass_3.png");
		else if (type == 24)  img = new GImage("../Images/Top_Sprites/Tiles/Grass_4.png");
		else if (type == 31)  img = new GImage("../Images/Top_Sprites/Tiles/Snow_0.png");
		else if (type == 32)  img = new GImage("../Images/Top_Sprites/Tiles/Snow_1.png");
		else if (type == 90)  img = new GImage("../Images/Top_Sprites/Tiles/Water_1.gif");
		else if (type == 100) img = new GImage("../Images/Top_Sprites/Tiles/Wood_2.png");
		width = x; height = y;
		img.setSize(width, height);
		add(img);
	}
	public void setTile(int type) {
		id = type;
		if (type <= 10)       { canPass = false; }
		else canPass = true;
		if (type == 1)        { img.setImage("../Images/Top_Sprites/Tiles/Wall_Block.png"); }
		else if (type == 2)   { img.setImage("../Images/Top_Sprites/Tiles/Wall_HT.png"); } 
		else if (type == 3)   { img.setImage("../Images/Top_Sprites/Tiles/Wall_VR.png"); }
		else if (type == 4)   { img.setImage("../Images/Top_Sprites/Tiles/Wall_HB.png"); }
		else if (type == 5)   { img.setImage("../Images/Top_Sprites/Tiles/Wall_VL.png"); }
		else if (type == 6)   { img.setImage("../Images/Top_Sprites/Tiles/Wall_CTL.png"); } 
		else if (type == 7)   { img.setImage("../Images/Top_Sprites/Tiles/Wall_CTR.png"); }
		else if (type == 8)   { img.setImage("../Images/Top_Sprites/Tiles/Wall_CBL.png"); }
		else if (type == 9)   { img.setImage("../Images/Top_Sprites/Tiles/Wall_CBR.png"); }
		else if (type == 21)  { img.setImage("../Images/Top_Sprites/Tiles/Grass_1.png"); }
		else if (type == 22)  { img.setImage("../Images/Top_Sprites/Tiles/Grass_2.png"); }
		else if (type == 23)  { img.setImage("../Images/Top_Sprites/Tiles/Grass_3.png"); }
		else if (type == 24)  { img.setImage("../Images/Top_Sprites/Tiles/Grass_4.png"); }
		else if (type == 31)  { img.setImage("../Images/Top_Sprites/Tiles/Snow_0.png"); }
		else if (type == 32)  { img.setImage("../Images/Top_Sprites/Tiles/Snow_1.png"); }
		else if (type == 90)  { img.setImage("../Images/Top_Sprites/Tiles/Water_1.gif"); }
		else if (type == 100) { img.setImage("../Images/Top_Sprites/Tiles/Wood_2.png"); }

	}
}
