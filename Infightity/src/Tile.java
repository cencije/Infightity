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
		else if (type == 21)  img = new GImage("../Images/Top_Sprites/Tiles/Grass_6.png");
		else if (type == 22)  img = new GImage("../Images/Top_Sprites/Tiles/Grass_6PH.png");
		else if (type == 23)  img = new GImage("../Images/Top_Sprites/Tiles/Grass_6PV.png");
		else if (type == 24)  img = new GImage("../Images/Top_Sprites/Tiles/Grass_6PIU.png");
		else if (type == 25)  img = new GImage("../Images/Top_Sprites/Tiles/Grass_6PID.png");
		else if (type == 26)  img = new GImage("../Images/Top_Sprites/Tiles/Grass_6PTL.png");
		else if (type == 27)  img = new GImage("../Images/Top_Sprites/Tiles/Grass_6PTR.png");
		else if (type == 28)  img = new GImage("../Images/Top_Sprites/Tiles/Grass_6PBL.png");
		else if (type == 29)  img = new GImage("../Images/Top_Sprites/Tiles/Grass_6PBR.png");
		else if (type == 31)  img = new GImage("../Images/Top_Sprites/Tiles/Grass_6.png"); 
		else if (type == 32)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_Rock_T.png"); 
		else if (type == 33)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_Rock_R.png"); 
		else if (type == 34)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_Rock_B.png"); 
		else if (type == 35)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_Rock_L.png"); 
		else if (type == 36)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_Rock_TLC.png"); 
		else if (type == 37)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_Rock_TRC.png"); 
		else if (type == 38)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_Rock_BLC.png"); 
		else if (type == 39)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_Rock_BRC.png"); 
		else if (type == 51)  img = new GImage("../Images/Top_Sprites/Tiles/Snow_0.png");
		else if (type == 52)  img = new GImage("../Images/Top_Sprites/Tiles/Snow_1.png");
		else if (type == 90)  img = new GImage("../Images/Top_Sprites/Tiles/Water_1.gif");
		else if (type == 100) img = new GImage("../Images/Top_Sprites/Tiles/Wood_2.png");
		else if (type == 101) img = new GImage("../Images/Top_Sprites/Tiles/Wall_WPV.png");
		else if (type == 102) img = new GImage("../Images/Top_Sprites/Tiles/Wall_WPH.png");
		else if (type == 103)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_WPCTL.png");
		else if (type == 104)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_WPCTR.png");
		else if (type == 105)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_WPCBL.png");
		else if (type == 106)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_WPCBR.png");
		else if (type == 301)  img = new GImage("../Images/Top_Sprites/Tiles/Cropland.png");
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
		else if (type == 21)  { img.setImage("../Images/Top_Sprites/Tiles/Grass_6.png"); }
		else if (type == 22)  { img.setImage("../Images/Top_Sprites/Tiles/Grass_6PH.png"); }
		else if (type == 23)  { img.setImage("../Images/Top_Sprites/Tiles/Grass_6PV.png"); }
		else if (type == 24)  { img.setImage("../Images/Top_Sprites/Tiles/Grass_6PIU.png"); }
		else if (type == 25)  { img.setImage("../Images/Top_Sprites/Tiles/Grass_6PID.png"); }
		else if (type == 26)  { img.setImage("../Images/Top_Sprites/Tiles/Grass_6PTL.png"); }
		else if (type == 27)  { img.setImage("../Images/Top_Sprites/Tiles/Grass_6PTR.png"); }
		else if (type == 28)  { img.setImage("../Images/Top_Sprites/Tiles/Grass_6PBL.png"); }
		else if (type == 29)  { img.setImage("../Images/Top_Sprites/Tiles/Grass_6PBR.png"); }
		else if (type == 31)  { img.setImage("../Images/Top_Sprites/Tiles/Grass_6.png"); }
		else if (type == 32)  { img.setImage("../Images/Top_Sprites/Tiles/Wall_Rock_T.png"); }
		else if (type == 33)  { img.setImage("../Images/Top_Sprites/Tiles/Wall_Rock_R.png"); }
		else if (type == 34)  { img.setImage("../Images/Top_Sprites/Tiles/Wall_Rock_B.png"); }
		else if (type == 35)  { img.setImage("../Images/Top_Sprites/Tiles/Wall_Rock_L.png"); }
		else if (type == 36)  { img.setImage("../Images/Top_Sprites/Tiles/Wall_Rock_TLC.png"); }
		else if (type == 37)  { img.setImage("../Images/Top_Sprites/Tiles/Wall_Rock_TRC.png"); }
		else if (type == 38)  { img.setImage("../Images/Top_Sprites/Tiles/Wall_Rock_BLC.png"); }
		else if (type == 39)  { img.setImage("../Images/Top_Sprites/Tiles/Wall_Rock_BRC.png"); }
		else if (type == 51)  { img.setImage("../Images/Top_Sprites/Tiles/Snow_0.png"); }
		else if (type == 52)  { img.setImage("../Images/Top_Sprites/Tiles/Snow_1.png"); }
		else if (type == 90)  { img.setImage("../Images/Top_Sprites/Tiles/Water_1.gif"); }
		else if (type == 100) { img.setImage("../Images/Top_Sprites/Tiles/Wood_2.png"); }
		else if (type == 101) { img.setImage("../Images/Top_Sprites/Tiles/Wall_WPV.png"); }
		else if (type == 102) { img.setImage("../Images/Top_Sprites/Tiles/Wall_WPH.png"); }
		else if (type == 103) { img.setImage("../Images/Top_Sprites/Tiles/Wall_WPCTL.png"); }
		else if (type == 104) { img.setImage("../Images/Top_Sprites/Tiles/Wall_WPCTR.png"); }
		else if (type == 105) { img.setImage("../Images/Top_Sprites/Tiles/Wall_WPCBL.png"); }
		else if (type == 106) { img.setImage("../Images/Top_Sprites/Tiles/Wall_WPCBR.png"); }
		else if (type == 301) { img.setImage("../Images/Top_Sprites/Tiles/Cropland.png"); }

	}
}
