import java.util.ArrayList;

public class NPCList {

	MainGUI mainGUI;
    ArrayList<ArrayList<ArrayList<CoordinatePair>>> npcArrayList = new ArrayList<ArrayList<ArrayList<CoordinatePair>>>();  
    ArrayList<NPC> npcListCurrent = new ArrayList<NPC>();
    
	public void setMain(MainGUI mainGUI) { this.mainGUI = mainGUI; }
	public ArrayList<NPC> getNPCList() { return npcListCurrent; }
    public void clear_npc_list() { npcListCurrent.clear(); }
    public NPC getNPC(int npcNo) { return npcListCurrent.get(npcNo);  }
	public void setup_npc_rooms() {
    	ArrayList<ArrayList<CoordinatePair>> room0List = new ArrayList<ArrayList<CoordinatePair>>();
    	npcArrayList.add(room0List);
    	ArrayList<ArrayList<CoordinatePair>> room1List = new ArrayList<ArrayList<CoordinatePair>>();
    	ArrayList<CoordinatePair> r1Chicken = new ArrayList<CoordinatePair>();
    	r1Chicken.add(new CoordinatePair(210, 210, 1));// r1Chicken.add(new CoordinatePair(245, 150, 1));
    	room1List.add(r1Chicken);
    	npcArrayList.add(room1List);
    	ArrayList<ArrayList<CoordinatePair>> room2List = new ArrayList<ArrayList<CoordinatePair>>();
    	npcArrayList.add(room2List);
    	ArrayList<ArrayList<CoordinatePair>> room3List = new ArrayList<ArrayList<CoordinatePair>>();
    	npcArrayList.add(room3List);
	}
	
	 public void setNPCList(int roomNumber) {
    	clear_npc_list();
    	int npcNumber = 1;
    	ArrayList<ArrayList<CoordinatePair>> listCurrentRoom = npcArrayList.get(roomNumber);
    	for (int i = 0; i < listCurrentRoom.size(); i++) {
    		for (int j = 0; j < listCurrentRoom.get(i).size(); j++) {
    			NPC n = new NPC(npcNumber, i+1, listCurrentRoom.get(i).get(j).dir, mainGUI);
    			npcNumber++;
    			npcListCurrent.add(n);
    			n.x = listCurrentRoom.get(i).get(j).x;
    			n.y = listCurrentRoom.get(i).get(j).y;
    		}
    	}
    }
}
