import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import acm.graphics.GImage;
public class Room {

	ArrayList<ArrayList<Tile>> tilePieces = new ArrayList<ArrayList<Tile>>();
	ArrayList<ArrayList<Integer>> collisionVals = new ArrayList<ArrayList<Integer>>();
	ArrayList<ArrayList<Component>> componentList = new ArrayList<ArrayList<Component>>();
	MainGUI mainGame;
	int roomNumber = 0;
	Scanner sc = null;
	public void setMain(MainGUI mainGUI) {
		mainGame = mainGUI;
	}


	public void makeRoom(String roomFile, int roomNumber, int roomStyle) {
		//System.out.println("YAH!");
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
				if (word.equals("0")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 0));        }
				else if (word.equals("1")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 1));   }
				else if (word.equals("2")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 2));   }
				else if (word.equals("3")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 3));   }
				else if (word.equals("4")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 4));   } 
				else if (word.equals("5")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 5));   }
				else if (word.equals("6")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 6));   }
				else if (word.equals("7")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 7));   }
				else if (word.equals("8")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 8));   } 
				else if (word.equals("9")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 9));   }
				else if (word.equals("w")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 90));  }
				else if (word.equals("-")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 100)); }
				else if (word.equals("V")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 101)); }
				else if (word.equals("H")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 102)); }
				else if (word.equals("^")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 103)); }
				else if (word.equals("&")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 104)); }
				else if (word.equals("*")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 105)); }
				else if (word.equals("(")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 106)); }
				else if (word.equals("g")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 21));  }
				else if (word.equals("p")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 22));  }
				else if (word.equals("P")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 23));  }
				else if (word.equals("©")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 24));  }
				else if (word.equals("†")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 25));  }
				else if (word.equals("§")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 26));  }
				else if (word.equals("¶")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 27));  }
				else if (word.equals("•")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 28));  }
				else if (word.equals("ª")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 29));  }
				else if (word.equals("c1")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 331));  }
				else if (word.equals("c2")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 332));  }
				else if (word.equals("c3")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 333));  }
				else if (word.equals("c4")) { collisionVals.get(row).add(0); tilePieces.get(row).add(new Tile (40,40, 334));  }
				else if (word.equals("™")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 32));  }
				else if (word.equals("£")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 33));  }
				else if (word.equals("¢")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 34));  }
				else if (word.equals("∞")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 35));  }
				else if (word.equals("œ")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 36));  }
				else if (word.equals("´")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 37));  }
				else if (word.equals("∑")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 38));  }
				else if (word.equals("®")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 39));  }
				else if (word.equals("ct")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 41)); }
				else if (word.equals("cr")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 42)); }
				else if (word.equals("cb")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 43)); }
				else if (word.equals("cl")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 44)); }
				else if (word.equals("ctl")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 46)); }
				else if (word.equals("ctr")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 47)); }
				else if (word.equals("cbl")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 48)); }
				else if (word.equals("cbr")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 49)); }
				else if (word.equals("ctli")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 56)); }
				else if (word.equals("ctri")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 57)); }
				else if (word.equals("cbli")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 58)); }
				else if (word.equals("cbri")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 59)); }
				else if (word.equals("-1")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 107)); }
				else if (word.equals("-2")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 108)); }
				else if (word.equals("-3")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 109)); }
				else if (word.equals("-tl1")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 110)); }
				else if (word.equals("-tl2")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 111)); }
				else if (word.equals("-tr1")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 112)); }
				else if (word.equals("-tr2")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 113)); }
				else if (word.equals("-bl1")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 114)); }
				else if (word.equals("-bl2")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 115)); }
				else if (word.equals("-br1")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 116)); }
				else if (word.equals("-br2")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 117)); }
				else if (word.equals("tab1")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 118)); }
				else if (word.equals("tab2")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 119)); }
				else if (word.equals("tab3")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 120)); }
				else if (word.equals("tab4")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 121)); }
				else if (word.equals("tab5")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 122)); }
				else if (word.equals("tab6")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 123)); }
				else if (word.equals("tab7")) { collisionVals.get(row).add(1); tilePieces.get(row).add(new Tile (40,40, 124)); }
				
				
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
			addComponents(roomNumber);
			mainGame.setMap(tilePieces, collisionVals);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public void setUpComponents() {
		ArrayList<Component> listR0 = new ArrayList<Component>();
		componentList.add(listR0);
		ArrayList<Component> listR1 = new ArrayList<Component>();
		Component cBed1_1 = new Component(201, false, true, 110, 70); listR1.add(cBed1_1);
		Component cTable1_1 = new Component(202, false, false, 140, 70); listR1.add(cTable1_1);
		Component cRug1_1 = new Component(252, false, false, 60, 150); listR1.add(cRug1_1);
		Component cDoor1_1 = new Component(1, false, true, 80, 190); listR1.add(cDoor1_1);
		Component cDoor1_2 = new Component(1, false, true, 480, 190); listR1.add(cDoor1_2);
		Component cFenceV1_1 = new Component(301, false, false, 355, 267); listR1.add(cFenceV1_1);
		Component cFenceH1_1 = new Component(302, false, false, 355, 267); listR1.add(cFenceH1_1);
		Component cTree1_1 = new Component(401, true, true, 240, 300); listR1.add(cTree1_1);
		Component cTree1_2 = new Component(402, true, true, 330, 200); listR1.add(cTree1_2);
		Component cTree1_3 = new Component(403, true, true, 225, 170); listR1.add(cTree1_3);
		componentList.add(listR1);
		
		ArrayList<Component> listR2 = new ArrayList<Component>();
		Component cRug2_1 = new Component(253, false, false, 165, 250); listR2.add(cRug2_1);
		Component cFenceV2_1 = new Component(301, false, false, 355, 70); listR2.add(cFenceV2_1);
		Component cFenceH2_1 = new Component(302, false, false, 355, 189); listR2.add(cFenceH2_1);
		Component cDoor2_1 = new Component(2, false, true, 200, 270); listR2.add(cDoor2_1);
		Component cTree2_1 = new Component(401, true, true, 280, 325); listR2.add(cTree2_1);
		Component cTree2_2 = new Component(402, true, true, 310, 220); listR2.add(cTree2_2);
		Component cTree2_3 = new Component(403, true, true, 465, 310); listR2.add(cTree2_3);
		Component mooseH2_1 = new Component(218, true, false, 170, 185); listR2.add(mooseH2_1);
		Component chairU2_1 = new Component(204, false, false, 50, 230); listR2.add(chairU2_1); //
		Component chairL2_1 = new Component(207, false, false, 80, 200); listR2.add(chairL2_1); //
		Component chairD2_1 = new Component(206, false, false, 50, 170); listR2.add(chairD2_1); // 
		Component chairU2_2 = new Component(204, false, false, 50, 310); listR2.add(chairU2_2);
		Component chairL2_2 = new Component(207, false, false, 80, 280); listR2.add(chairL2_2);
		Component chairD2_2 = new Component(206, false, false, 50, 250); listR2.add(chairD2_2);
		Component chairU2_3 = new Component(204, false, false, 130, 270); listR2.add(chairU2_3);
		Component chairL2_3 = new Component(207, false, false, 160, 240); listR2.add(chairL2_3);
		Component chairD2_3 = new Component(206, false, false, 130, 210); listR2.add(chairD2_3);
		Component chairR2_3 = new Component(205, false, false, 100, 240); listR2.add(chairR2_3);
		Component stool2_1 = new Component(203, false, false, 55, 70); listR2.add(stool2_1);
		Component stool2_2 = new Component(203, false, false, 55, 95); listR2.add(stool2_2);
		Component stool2_3 = new Component(203, false, false, 55, 120); listR2.add(stool2_3);
		Component stool2_4 = new Component(203, false, false, 90, 155); listR2.add(stool2_4);
		Component stool2_5 = new Component(203, false, false, 115, 155); listR2.add(stool2_5);
		Component stool2_6 = new Component(203, false, false, 140, 155); listR2.add(stool2_6);
		Component stool2_7 = new Component(203, false, false, 165, 155); listR2.add(stool2_7);
		Component barrack2_1 = new Component(219, false, false, 130, 65); listR2.add(barrack2_1);
		
		
		
		componentList.add(listR2);
		ArrayList<Component> listR3 = new ArrayList<Component>();
		componentList.add(listR3);
		ArrayList<Component> listR4 = new ArrayList<Component>();
		componentList.add(listR4);
		ArrayList<Component> listR5 = new ArrayList<Component>();
		componentList.add(listR5);
		ArrayList<Component> listR6 = new ArrayList<Component>();
		componentList.add(listR6);
		ArrayList<Component> listR7 = new ArrayList<Component>();
		componentList.add(listR7);
		ArrayList<Component> listR8 = new ArrayList<Component>();
		componentList.add(listR8);
		ArrayList<Component> listR9 = new ArrayList<Component>();
		Component cFenceV9_1 = new Component(303, false, false, 435, 147); listR9.add(cFenceV9_1);
		Component cFenceV9_2 = new Component(303, false, false, 475, 147); listR9.add(cFenceV9_2);
		componentList.add(listR9);
		ArrayList<Component> listR10 = new ArrayList<Component>();
		componentList.add(listR10);

	}
	public void remove_components(int roomNumber) {
		for (int i = 0; i < componentList.get(roomNumber).size(); i++) {
			mainGame.remove(componentList.get(roomNumber).get(i));
		}
		//System.out.println(componentList);
		mainGame.componentList.clear();
	}
	public void addComponents(int roomNumber) {
		//System.out.println("PRE LOOP Component list size: " + componentList.get(roomNumber).size());
		for (int i = 0; i < componentList.get(roomNumber).size(); i++) {
			if (!componentList.get(roomNumber).get(i).above) {
				mainGame.add(componentList.get(roomNumber).get(i), componentList.get(roomNumber).get(i).x,
																   componentList.get(roomNumber).get(i).y);
				mainGame.componentList.add(componentList.get(roomNumber).get(i));
			}
		}
	}
	public void add_above_components(int roomNumber) {
		for (int i = 0; i < componentList.get(roomNumber).size(); i++) {
			if (componentList.get(roomNumber).get(i).above) {
				mainGame.add(componentList.get(roomNumber).get(i), componentList.get(roomNumber).get(i).x,
																   componentList.get(roomNumber).get(i).y);
				mainGame.componentList.add(componentList.get(roomNumber).get(i));
			}
		}
	}
}
