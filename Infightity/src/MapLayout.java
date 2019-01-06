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
		room3.add(0);room3.add(0);room3.add(5);room3.add(4);room3.add(2);
		ArrayList<Integer> room4 = new ArrayList<Integer>();
		room4.add(0);room4.add(3);room4.add(0);room4.add(0);room4.add(0);
		ArrayList<Integer> room5 = new ArrayList<Integer>();
		room5.add(0);room5.add(0);room5.add(6);room5.add(0);room5.add(3);
		ArrayList<Integer> room6 = new ArrayList<Integer>();
		room6.add(0);room6.add(0);room6.add(7);room6.add(0);room6.add(5);
		ArrayList<Integer> room7 = new ArrayList<Integer>();
		room7.add(0);room7.add(8);room7.add(0);room7.add(0);room7.add(6);
		ArrayList<Integer> room8 = new ArrayList<Integer>();
		room8.add(0);room8.add(9);room8.add(0);room8.add(7);room8.add(0);
		ArrayList<Integer> room9 = new ArrayList<Integer>();
		room9.add(0);room9.add(10);room9.add(0);room9.add(8);room9.add(12);
		ArrayList<Integer> room10 = new ArrayList<Integer>();
		room10.add(0);room10.add(0);room10.add(0);room10.add(4);room10.add(6);
		
		mapRooms.add(room0);
		mapRooms.add(room1);
		mapRooms.add(room2);
		mapRooms.add(room3);
		mapRooms.add(room4);
		mapRooms.add(room5);
		mapRooms.add(room6);
		mapRooms.add(room7);
		mapRooms.add(room8);
		mapRooms.add(room9);
		mapRooms.add(room10);
	}
	public int getRoom(int curRoom, int dir) {
		int newRoom = mapRooms.get(curRoom).get(dir);
		
		System.out.println("Room In: " + curRoom + " Going to Room: " + newRoom);
		
		if (curRoom == 9 && newRoom == 8) {
			mainGUI.musicCave.stop();
			//mainGUI.music
		}
		else if (curRoom == 8 && newRoom == 9) {
			mainGUI.musicSnowTravel.stop();
			mainGUI.musicCave.loop();
		}
		else if (curRoom == 2 && newRoom == 3) {
			mainGUI.musicSnowTravel.loop();
		}
		else if (curRoom == 3 && newRoom == 2) {
			mainGUI.musicSnowTravel.stop();
		}
	
		return newRoom;
	}
}
