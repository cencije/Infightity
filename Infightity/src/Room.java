import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class Room {

	ArrayList<ArrayList<Tile>> tilePieces = new ArrayList<ArrayList<Tile>>();
	ArrayList<ArrayList<Integer>> collisionVals = new ArrayList<ArrayList<Integer>>();
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
			mainGame.setMap(tilePieces, collisionVals);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public void addComponents(int roomID) {

		if (roomNumber == 1) {

		}
		if (roomNumber % 10 == 0) {
			//mainGame.addShop(); 
		}
	}
}
