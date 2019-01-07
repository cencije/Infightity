import java.util.ArrayList;

/**
 * Created by Joe on 6/30/18.
 */
public class EnemyList {
    Enemy enemy1, enemy2, enemy3, enemy4;
    MainGUI mainGUI;

    String[] genNames = {"Jimmy","Abdul", "Pat", "Benjamin", "Juan", "Gail", "Scottie", "Rocco",
    					 "Gordon", "Enrique", "Wayne", "Lou", "Milo", "Mariano", "Art",
    					 "Monroe", "Stan", "Brent", "Lazaro", "Andres", "Jamar", "Chadwick",
    					 "Kasey", "Mike", "Marshall", "Ricky", "Neville", "Ellsworth",
    					 "Leslie", "Billy", "Stuart", "Beau", "Edwin", "Matthew",
    					 "Bob", "Garth", "Mary", "Benito", "Fabian", "Larry", "Demetrius",
    					 "Scott", "Adan", "Randall", "Johnie", "Rodney", "Abraham", 
    					 "Emmanuel", "Frances" };
    
    ArrayList<ArrayList<ArrayList<CoordinatePair>>> enemyArrayList = new ArrayList<ArrayList<ArrayList<CoordinatePair>>>();
    
    ArrayList<Enemy> enemyListCurrent = new ArrayList<Enemy>();
    
    public void set_main(MainGUI mainGUI) { this.mainGUI = mainGUI; }
    public void setEnemyList(MainGUI mainGUI)
    {
    	
        enemy1 = new Enemy(1000, 1, 1, mainGUI);
        enemy1.name = "Morp";
        enemy1.setArmor(0);
        enemy1.setAttackMax(1);
        enemy1.setAttackMin(0);
        enemy1.setCritPoint();

        enemy2 = new Enemy(1000, 2, 1, mainGUI);
        enemy2.name = "Peasant";
        enemy2.setArmor(2);
        enemy2.setAttackMax(7);
        enemy2.setAttackMin(1);
        enemy2.setCritPoint();

        enemy3 = new Enemy(1000, 3, 1, mainGUI);
        enemy3.name = "Archer";
        enemy3.setArmor(5);
        enemy3.setAttackMax(10);
        enemy3.setAttackMin(1);
        enemy3.setCritPoint();
        
        enemy4 = new Enemy(1000, 4, 1, mainGUI);
        enemy4.name = "Spearman";
        enemy4.setArmor(10);
        enemy4.setAttackMax(10);
        enemy4.setAttackMin(1);
        enemy4.setCritPoint();

    }

    
    public void setup_enemy_rooms() {
    	ArrayList<ArrayList<CoordinatePair>> room0List = new ArrayList<ArrayList<CoordinatePair>>();
    	enemyArrayList.add(room0List);
    	ArrayList<ArrayList<CoordinatePair>> room1List = new ArrayList<ArrayList<CoordinatePair>>();
    	enemyArrayList.add(room1List);
    	ArrayList<ArrayList<CoordinatePair>> room2List = new ArrayList<ArrayList<CoordinatePair>>();
    	enemyArrayList.add(room2List);
    	ArrayList<ArrayList<CoordinatePair>> room3List = new ArrayList<ArrayList<CoordinatePair>>();
    	ArrayList<CoordinatePair> r3Morp = new ArrayList<CoordinatePair>();
    	r3Morp.add(new CoordinatePair(150, 150, 1)); r3Morp.add(new CoordinatePair(200, 150, 1));
    	room3List.add(r3Morp);
    	enemyArrayList.add(room3List);
    	ArrayList<ArrayList<CoordinatePair>> room4List = new ArrayList<ArrayList<CoordinatePair>>();
    	ArrayList<CoordinatePair> r4Morp = new ArrayList<CoordinatePair>();
    	r4Morp.add(new CoordinatePair(150, 150, 1)); r4Morp.add(new CoordinatePair(310, 280, 2));
    	r4Morp.add(new CoordinatePair(250, 170, 3)); r4Morp.add(new CoordinatePair(455, 170, 1));
    	room4List.add(r4Morp);
    	enemyArrayList.add(room4List);
    	ArrayList<ArrayList<CoordinatePair>> room5List = new ArrayList<ArrayList<CoordinatePair>>();
    	ArrayList<CoordinatePair> r5Morp = new ArrayList<CoordinatePair>();
    	r5Morp.add(new CoordinatePair(150, 150, 1)); r5Morp.add(new CoordinatePair(200, 200, 1));
    	room5List.add(r5Morp);
    	enemyArrayList.add(room5List);
    	ArrayList<ArrayList<CoordinatePair>> room6List = new ArrayList<ArrayList<CoordinatePair>>();
    	ArrayList<CoordinatePair> r6Morp = new ArrayList<CoordinatePair>();
    	room6List.add(r6Morp);
    	enemyArrayList.add(room6List);
    	ArrayList<ArrayList<CoordinatePair>> room7List = new ArrayList<ArrayList<CoordinatePair>>();
    	ArrayList<CoordinatePair> r7Morp = new ArrayList<CoordinatePair>();
    	room7List.add(r7Morp);
    	enemyArrayList.add(room7List);
    	ArrayList<ArrayList<CoordinatePair>> room8List = new ArrayList<ArrayList<CoordinatePair>>();
    	ArrayList<CoordinatePair> r8Morp = new ArrayList<CoordinatePair>();
    	room8List.add(r8Morp);
    	enemyArrayList.add(room7List);
    	ArrayList<ArrayList<CoordinatePair>> room9List = new ArrayList<ArrayList<CoordinatePair>>();
    	ArrayList<CoordinatePair> r9Morp = new ArrayList<CoordinatePair>();
    	room9List.add(r9Morp);
    	enemyArrayList.add(room9List);
    	ArrayList<ArrayList<CoordinatePair>> room10List = new ArrayList<ArrayList<CoordinatePair>>();
    	ArrayList<CoordinatePair> r10Morp = new ArrayList<CoordinatePair>();
    	room10List.add(r10Morp);
    	enemyArrayList.add(room10List);
    	
    }
    public void make_current_enemies(int morp, int peasants, int archers, int spearmen) {
    	
    	for (int m = 0; m < morp; m++) {
    		Enemy e = new Enemy(m, 1, 1, mainGUI);
    		e.name = "Morp";
    		e.setHealth(10, 10);
    		e.setArmor(0);
            e.setAttackMax(1);
            e.setAttackMin(0);
            e.setCritPoint();
    		enemyListCurrent.add(e);
    	}
    	for (int p = 0; p < peasants; p++) {
    		Enemy e = new Enemy(p, 2, 1, mainGUI);
    		e.name = "Peasant";
    		e.setHealth(10, 10);
    		e.setArmor(1);
            e.setAttackMax(3);
            e.setAttackMin(1);
            e.setCritPoint();
    		enemyListCurrent.add(e);
    	}
    	for (int a = 0; a < archers; a++) {
    		Enemy e = new Enemy(a, 2, 1, mainGUI);
    		e.name = "Archer";
    		e.setHealth(10, 10);
    		e.setArmor(1);
            e.setAttackMax(3);
            e.setAttackMin(1);
            e.setCritPoint();
    		enemyListCurrent.add(e);
    	}
    }
    public Enemy getEnemy(int enemyNo)
    {
        return enemyListCurrent.get(enemyNo);
    }
    public void setEnemyList(int roomNumber) {
    	clear_enemy_list();
    	int enemyNumber = 1;
    	ArrayList<ArrayList<CoordinatePair>> listCurrentRoom = enemyArrayList.get(roomNumber);
    	for (int i = 0; i < listCurrentRoom.size(); i++) {
    		for (int j = 0; j < listCurrentRoom.get(i).size(); j++) {
    			Enemy e = new Enemy(enemyNumber, i+1, listCurrentRoom.get(i).get(j).dir, mainGUI);
    			enemyNumber++;
    			enemyListCurrent.add(e);
    			e.x = listCurrentRoom.get(i).get(j).x;
    			e.y = listCurrentRoom.get(i).get(j).y;
    		}
    	}
    }
    public ArrayList<Enemy> getEnemyList() { return enemyListCurrent; }
    public void clear_enemy_list() { enemyListCurrent.clear(); }


    

}
