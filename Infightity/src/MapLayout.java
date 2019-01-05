import java.util.ArrayList;

public class MapLayout {

	ArrayList<ArrayList<Integer>> mapRooms = new ArrayList<ArrayList<Integer>>();
	MainGUI mainGUI;

	public MapLayout(MainGUI maingui) {
		mainGUI = maingui;
		makeMapRooms();
	}
	public void makeMapRooms() {
		
		ArrayList<Integer> room0 = new ArrayList<Integer>();
		room0.add(0);room0.add(0);room0.add(0);room0.add(0);room0.add(0);
		ArrayList<Integer> room1 = new ArrayList<Integer>();
		room1.add(0);room1.add(0);room1.add(0);room1.add(2);room1.add(0);
		ArrayList<Integer> room2 = new ArrayList<Integer>();
		room2.add(0);room2.add(1);room2.add(3);room2.add(0);room2.add(0);
		ArrayList<Integer> room3 = new ArrayList<Integer>();
		room3.add(0);room3.add(4);room3.add(0);room3.add(0);room3.add(2);
		ArrayList<Integer> room4 = new ArrayList<Integer>();
		room4.add(0);room4.add(5);room4.add(0);room4.add(3);room4.add(0);
		ArrayList<Integer> room5 = new ArrayList<Integer>();
		room5.add(0);room5.add(0);room5.add(0);room5.add(4);room5.add(6);
		
		mapRooms.add(room0);
		mapRooms.add(room1);
		mapRooms.add(room2);
		mapRooms.add(room3);
		mapRooms.add(room4);
		mapRooms.add(room5);
	}
	public int getRoom(int curRoom, int dir) {
		int newRoom = mapRooms.get(curRoom).get(dir);
		
		System.out.println("Room In: " + curRoom + " Going to Room: " + newRoom);
		
		if (curRoom == 3 && newRoom == 2) {
			mainGUI.musicCave.stop();
			//mainGUI.music
		}
		else if (curRoom == 4 && newRoom == 5) {
			mainGUI.musicCave.loop();
		}
		else if (curRoom == 5 && newRoom == 4) {
			mainGUI.musicCave.stop();
		}
	
		return newRoom;
	}
}
