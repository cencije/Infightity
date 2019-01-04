import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import acm.graphics.GImage;
public class Room {

	ArrayList<ArrayList<Tile>> tilePieces = new ArrayList<ArrayList<Tile>>();
	ArrayList<ArrayList<Integer>> collisionVals = new ArrayList<ArrayList<Integer>>();
	ArrayList<GImage> componentList = new ArrayList<GImage>();
	MainGUI mainGame;
	int roomNumber = 0;
	Scanner sc = null;
	public void setMain(MainGUI mainGUI) {
		mainGame = mainGUI;
	}


	public void makeRoom(String roomFile, int roomStyle) {
		System.out.println("YAH!");
		tilePieces.clear();
		collisionVals.clear();
		File file = new File("../Layouts/" + roomFile + ".txt"); 
		try {
			sc = new Scanner(file);
			int row = -1;
			int rowCounter = 0;
			for (int x = 0; x < 11; x++) {
				tilePieces.add(new ArrayList<Tile>());
				collisionVals.add(new ArrayList<Integer>());
			}
			while (sc.hasNextLine()) {


				String word = sc.next();
				if (rowCounter % 15 == 0) row++;
				rowCounter++;
				if (word.equals("0")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 0)); }
				else if (word.equals("1")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 1)); }
				else if (word.equals("2")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 2)); }
				else if (word.equals("3")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 3)); }
				else if (word.equals("4")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 4)); }
				else if (word.equals("5")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 5)); }
				else if (word.equals("6")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 6)); }
				else if (word.equals("7")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 7)); }
				else if (word.equals("8")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 8)); }
				else if (word.equals("9")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 9)); }
				else if (word.equals("w")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 90)); }
				else if (word.equals("-")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 100)); }
				else if (word.equals("V")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 101)); }
				else if (word.equals("H")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 102)); }
				else if (word.equals("^")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 103)); }
				else if (word.equals("&")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 104)); }
				else if (word.equals("*")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 105)); }
				else if (word.equals("(")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 106)); }
				else if (word.equals("g")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 21)); }
				else if (word.equals("p")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 22)); }
				else if (word.equals("P")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 23)); }
				else if (word.equals("©")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 24)); }
				else if (word.equals("†")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 25)); }
				else if (word.equals("§")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 26)); }
				else if (word.equals("¶")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 27)); }
				else if (word.equals("•")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 28)); }
				else if (word.equals("ª")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 29)); }
				else if (word.equals("f")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 301)); }
				else if (word.equals("x")) { 
					if (roomStyle == 1) {
						tilePieces.get(row).add(new Tile (40,40, 100)); 
						collisionVals.get(row).add(0);
					}
					if (roomStyle == 2) {
						tilePieces.get(row).add(new Tile (40,40, ThreadLocalRandom.current().nextInt(21, 25))); 
						collisionVals.get(row).add(0);
					}
					else if (roomStyle == 3) {
						tilePieces.get(row).add(new Tile (40,40, ThreadLocalRandom.current().nextInt(31, 33)));
						collisionVals.get(row).add(0);
					}
				}
				else if (word.equals("d")) {
					if (roomStyle == 2) {
						tilePieces.get(row).add(new Tile (40,40, ThreadLocalRandom.current().nextInt(21, 25))); 
						collisionVals.get(row).add(2);
					}
					else if (roomStyle == 3) {
						tilePieces.get(row).add(new Tile (40,40, ThreadLocalRandom.current().nextInt(31, 33)));
						collisionVals.get(row).add(2);
					}
				}
			}

			sc.close();
			addComponents(roomFile);
			mainGame.setMap(tilePieces, collisionVals);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public void addComponents(String roomFile) {
		System.out.println("PRE LOOP Component list size: " + componentList.size());
		for (int i = 0; i < componentList.size(); i++) {
			System.out.println("YEET: " + i);
			mainGame.remove(componentList.get(i));
		}
		componentList.clear();
		if (roomFile.equals("Room1")) {
			System.out.println("Room 1 has been componentized");
			GImage imgBed1 = new GImage("../Images/Top_Sprites/Comps/Bed.png");
			mainGame.add(imgBed1, 110, 70); componentList.add(imgBed1);
			GImage imgTable1 = new GImage("../Images/Top_Sprites/Comps/SideTable.gif");
			mainGame.add(imgTable1, 140, 70); componentList.add(imgTable1);
			GImage imgRug1 = new GImage("../Images/Top_Sprites/Comps/Rug_2.png");
			mainGame.add(imgRug1, 60, 150); componentList.add(imgRug1);
			System.out.println("POST Component list size 1: " + componentList.size());
		}
		else if (roomFile.equals("Room2")) {
			System.out.println("Room 2 has been componentized");
			GImage imgRug1 = new GImage("../Images/Top_Sprites/Comps/Rug_2_V.png");
			mainGame.add(imgRug1, 160, 250); componentList.add(imgRug1);
			GImage imgFenceV1 = new GImage("../Images/Top_Sprites/Comps/Fence_V.png");
			mainGame.add(imgFenceV1, 355, 70); componentList.add(imgFenceV1);
			GImage imgFenceV2 = new GImage("../Images/Top_Sprites/Comps/Fence_V.png");
			mainGame.add(imgFenceV2, 355, 110); componentList.add(imgFenceV2);
			GImage imgFenceV3 = new GImage("../Images/Top_Sprites/Comps/Fence_V.png");
			mainGame.add(imgFenceV3, 355, 150); componentList.add(imgFenceV3);
			GImage imgFenceV4 = new GImage("../Images/Top_Sprites/Comps/Fence_HLO.png");
			mainGame.add(imgFenceV4, 355, 189); componentList.add(imgFenceV4);
			GImage imgDoor2 = new GImage("../Images/Top_Sprites/Comps/Fence_HLO.png");
			mainGame.add(imgDoor2, 355, 189); componentList.add(imgFenceV4);
			System.out.println("POST Component list size 2: " + componentList.size());
		}
	}
}
