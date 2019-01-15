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
		else if (type == 31)  img = new GImage("../Images/Top_Sprites/Tiles/Cave_1.png"); 
		else if (type == 32)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_Rock_T.png"); 
		else if (type == 33)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_Rock_R.png"); 
		else if (type == 34)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_Rock_B.png"); 
		else if (type == 35)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_Rock_L.png"); 
		else if (type == 36)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_Rock_TLC.png"); 
		else if (type == 37)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_Rock_TRC.png"); 
		else if (type == 38)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_Rock_BLC.png"); 
		else if (type == 39)  img = new GImage("../Images/Top_Sprites/Tiles/Wall_Rock_BRC.png"); 
		else if (type == 41)  img = new GImage("../Images/Top_Sprites/Tiles/Cliff_T_G.png"); 
		else if (type == 42)  img = new GImage("../Images/Top_Sprites/Tiles/Cliff_R_G.png"); 
		else if (type == 43)  img = new GImage("../Images/Top_Sprites/Tiles/Cliff_B_G.png"); 
		else if (type == 44)  img = new GImage("../Images/Top_Sprites/Tiles/Cliff_L_G.png"); 
		else if (type == 45)  { }
		else if (type == 46)  img = new GImage("../Images/Top_Sprites/Tiles/Cliff_TLC_G.png"); 
		else if (type == 47)  img = new GImage("../Images/Top_Sprites/Tiles/Cliff_TRC_G.png"); 
		else if (type == 48)  img = new GImage("../Images/Top_Sprites/Tiles/Cliff_BLC_G.png"); 
		else if (type == 49)  img = new GImage("../Images/Top_Sprites/Tiles/Cliff_BRC_G.png"); 
		else if (type == 56)  img = new GImage("../Images/Top_Sprites/Tiles/Cliff_TLCI_G.png"); 
		else if (type == 57)  img = new GImage("../Images/Top_Sprites/Tiles/Cliff_TRCI_G.png"); 
		else if (type == 58)  img = new GImage("../Images/Top_Sprites/Tiles/Cliff_BLCI_G.png"); 
		else if (type == 59)  img = new GImage("../Images/Top_Sprites/Tiles/Cliff_BRCI_G.png"); 
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
		else if (type == 107)  img = new GImage("../Images/Top_Sprites/Tiles/Bar_1.png");
		else if (type == 108)  img = new GImage("../Images/Top_Sprites/Tiles/Bar_2.png");
		else if (type == 109)  img = new GImage("../Images/Top_Sprites/Tiles/Bar_3.png");
		else if (type == 110)  img = new GImage("../Images/Top_Sprites/Tiles/Bar_CTL1.png");
		else if (type == 111)  img = new GImage("../Images/Top_Sprites/Tiles/Bar_CTL2.png");
		else if (type == 112)  img = new GImage("../Images/Top_Sprites/Tiles/Bar_CTR1.png");
		else if (type == 113)  img = new GImage("../Images/Top_Sprites/Tiles/Bar_CTR2.png");
		else if (type == 114)  img = new GImage("../Images/Top_Sprites/Tiles/Bar_CBL1.png");
		else if (type == 115)  img = new GImage("../Images/Top_Sprites/Tiles/Bar_CBL2.png");
		else if (type == 116)  img = new GImage("../Images/Top_Sprites/Tiles/Bar_CBR1.png");
		else if (type == 117)  img = new GImage("../Images/Top_Sprites/Tiles/Bar_CBR2.png");
		else if (type == 118)  img = new GImage("../Images/Top_Sprites/Tiles/Table_1.png");
		else if (type == 119)  img = new GImage("../Images/Top_Sprites/Tiles/Table_2.png");
		else if (type == 120)  img = new GImage("../Images/Top_Sprites/Tiles/Table_3.png");
		else if (type == 121)  img = new GImage("../Images/Top_Sprites/Tiles/Table_4.png");
		else if (type == 122)  img = new GImage("../Images/Top_Sprites/Tiles/Table_5.png");
		else if (type == 123)  img = new GImage("../Images/Top_Sprites/Tiles/Table_6.png");
		else if (type == 124)  img = new GImage("../Images/Top_Sprites/Tiles/Table_7.png");
		else if (type == 301)  img = new GImage("../Images/Top_Sprites/Tiles/Cropland.png");
		else if (type == 331)  img = new GImage("../Images/Top_Sprites/Tiles/Cave_1.png");
		else if (type == 332)  img = new GImage("../Images/Top_Sprites/Tiles/Cave_2.png");
		else if (type == 333)  img = new GImage("../Images/Top_Sprites/Tiles/Cave_3.png");
		else if (type == 334)  img = new GImage("../Images/Top_Sprites/Tiles/Cave_4.png");
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
		else if (type == 31)  {  }
		else if (type == 32)  { img.setImage("../Images/Top_Sprites/Tiles/Wall_Rock_T.png"); }
		else if (type == 33)  { img.setImage("../Images/Top_Sprites/Tiles/Wall_Rock_R.png"); }
		else if (type == 34)  { img.setImage("../Images/Top_Sprites/Tiles/Wall_Rock_B.png"); }
		else if (type == 35)  { img.setImage("../Images/Top_Sprites/Tiles/Wall_Rock_L.png"); }
		else if (type == 36)  { img.setImage("../Images/Top_Sprites/Tiles/Wall_Rock_TLC.png"); }
		else if (type == 37)  { img.setImage("../Images/Top_Sprites/Tiles/Wall_Rock_TRC.png"); }
		else if (type == 38)  { img.setImage("../Images/Top_Sprites/Tiles/Wall_Rock_BLC.png"); }
		else if (type == 39)  { img.setImage("../Images/Top_Sprites/Tiles/Wall_Rock_BRC.png"); }
		else if (type == 41)  { img.setImage("../Images/Top_Sprites/Tiles/Cliff_T_G.png"); }
		else if (type == 42)  { img.setImage("../Images/Top_Sprites/Tiles/Cliff_R_G.png"); }
		else if (type == 43)  { img.setImage("../Images/Top_Sprites/Tiles/Cliff_B_G.png"); }
		else if (type == 44)  { img.setImage("../Images/Top_Sprites/Tiles/Cliff_L_G.png"); }
		else if (type == 45)  { }
		else if (type == 46)  { img.setImage("../Images/Top_Sprites/Tiles/Cliff_TLC_G.png"); }
		else if (type == 47)  { img.setImage("../Images/Top_Sprites/Tiles/Cliff_TRC_G.png"); }
		else if (type == 48)  { img.setImage("../Images/Top_Sprites/Tiles/Cliff_BLC_G.png"); }
		else if (type == 49)  { img.setImage("../Images/Top_Sprites/Tiles/Cliff_BRC_G.png"); }
		else if (type == 56)  { img.setImage("../Images/Top_Sprites/Tiles/Cliff_TLCI_G.png"); }
		else if (type == 57)  { img.setImage("../Images/Top_Sprites/Tiles/Cliff_TRCI_G.png"); }
		else if (type == 58)  { img.setImage("../Images/Top_Sprites/Tiles/Cliff_BLCI_G.png"); }
		else if (type == 59)  { img.setImage("../Images/Top_Sprites/Tiles/Cliff_BRCI_G.png"); }
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
		else if (type == 107) { img.setImage("../Images/Top_Sprites/Tiles/Bar_1.png"); }
		else if (type == 108) { img.setImage("../Images/Top_Sprites/Tiles/Bar_2.png"); }
		else if (type == 109) { img.setImage("../Images/Top_Sprites/Tiles/Bar_3.png"); }
		else if (type == 110) { img.setImage("../Images/Top_Sprites/Tiles/Bar_CTL1.png"); }
		else if (type == 111) { img.setImage("../Images/Top_Sprites/Tiles/Bar_CTL2.png"); }
		else if (type == 112) { img.setImage("../Images/Top_Sprites/Tiles/Bar_CTR1.png"); }
		else if (type == 113) { img.setImage("../Images/Top_Sprites/Tiles/Bar_CTR2.png"); }
		else if (type == 114) { img.setImage("../Images/Top_Sprites/Tiles/Bar_CBL1.png"); }
		else if (type == 115) { img.setImage("../Images/Top_Sprites/Tiles/Bar_CBL2.png"); }
		else if (type == 116) { img.setImage("../Images/Top_Sprites/Tiles/Bar_CBR1.png"); }
		else if (type == 117) { img.setImage("../Images/Top_Sprites/Tiles/Bar_CBR2.png"); }
		else if (type == 118) { img.setImage("../Images/Top_Sprites/Tiles/Table_1.png"); }
		else if (type == 119) { img.setImage("../Images/Top_Sprites/Tiles/Table_2.png"); }
		else if (type == 120) { img.setImage("../Images/Top_Sprites/Tiles/Table_3.png"); }
		else if (type == 121) { img.setImage("../Images/Top_Sprites/Tiles/Table_4.png"); }
		else if (type == 122) { img.setImage("../Images/Top_Sprites/Tiles/Table_5.png"); }
		else if (type == 123) { img.setImage("../Images/Top_Sprites/Tiles/Table_6.png"); }
		else if (type == 124) { img.setImage("../Images/Top_Sprites/Tiles/Table_7.png"); }
		else if (type == 301) { img.setImage("../Images/Top_Sprites/Tiles/Cropland.png"); }
		else if (type == 331) { img.setImage("../Images/Top_Sprites/Tiles/Cave_1.png"); }
		else if (type == 332) { img.setImage("../Images/Top_Sprites/Tiles/Cave_2.png"); }
		else if (type == 333) { img.setImage("../Images/Top_Sprites/Tiles/Cave_3.png"); }
		else if (type == 334) { img.setImage("../Images/Top_Sprites/Tiles/Cave_4.png"); }

	}
}
