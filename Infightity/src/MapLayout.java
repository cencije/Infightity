import java.util.ArrayList;

public class MapLayout {

	ArrayList<ArrayList<Integer>> mapRooms = new ArrayList<ArrayList<Integer>>();
	

	public MapLayout() {
		makeMapRooms();
	}
	public void makeMapRooms() {
		
		ArrayList<Integer> room0 = new ArrayList<Integer>();
		room0.add(0);room0.add(0);room0.add(0);room0.add(0);room0.add(0);
		ArrayList<Integer> room1 = new ArrayList<Integer>();
		room1.add(0);room1.add(0);room1.add(2);room1.add(0);room1.add(0);
		ArrayList<Integer> room2 = new ArrayList<Integer>();
		room2.add(0);room2.add(0);room2.add(0);room2.add(3);room2.add(1);
		ArrayList<Integer> room3 = new ArrayList<Integer>();
		room3.add(0);room3.add(2);room3.add(4);room3.add(0);room3.add(0);
		ArrayList<Integer> room4 = new ArrayList<Integer>();
		room4.add(0);room4.add(0);room4.add(2);room4.add(0);room4.add(0);
		
		mapRooms.add(room0);
		mapRooms.add(room1);
		mapRooms.add(room2);
		mapRooms.add(room3);
		mapRooms.add(room4);
	}
	public int getRoom(int curRoom, int dir) {
		int newRoom = mapRooms.get(curRoom).get(dir);
		System.out.println("Room In: " + curRoom + " Going to Room: " + newRoom);
		return newRoom;
	}
}
