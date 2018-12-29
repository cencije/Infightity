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
    	
        enemy1 = new Enemy(1000, 1, mainGUI);
        enemy1.name = "Morp";
        enemy1.setArmor(0);
        enemy1.setAttackMax(1);
        enemy1.setAttackMin(0);
        enemy1.setCritPoint();

        enemy2 = new Enemy(1000, 2, mainGUI);
        enemy2.name = "Peasant";
        enemy2.setArmor(2);
        enemy2.setAttackMax(7);
        enemy2.setAttackMin(1);
        enemy2.setCritPoint();

        enemy3 = new Enemy(1000, 3, mainGUI);
        enemy3.name = "Archer";
        enemy3.setArmor(5);
        enemy3.setAttackMax(10);
        enemy3.setAttackMin(1);
        enemy3.setCritPoint();
        
        enemy4 = new Enemy(1000, 4, mainGUI);
        enemy4.name = "Spearman";
        enemy4.setArmor(10);
        enemy4.setAttackMax(10);
        enemy4.setAttackMin(1);
        enemy4.setCritPoint();

    }

    
    public void setup_enemy_rooms(int roomNumber) {
    	ArrayList<ArrayList<CoordinatePair>> room1List = new ArrayList<ArrayList<CoordinatePair>>();
    	ArrayList<CoordinatePair> r1Morp = new ArrayList<CoordinatePair>();
    	r1Morp.add(new CoordinatePair(150, 150, 1)); r1Morp.add(new CoordinatePair(200, 200, 2));
    	room1List.add(r1Morp);
    	enemyArrayList.add(room1List);
    	if (roomNumber == 1) make_current_enemies(1,0,0,0);
    	else if (roomNumber == 2) make_current_enemies(1,0,0,0);
    	else if (roomNumber == 2) make_current_enemies(1,0,0,0);
    	else if (roomNumber == 2) make_current_enemies(1,0,0,0);
    	else if (roomNumber == 2) make_current_enemies(1,0,0,0);
    	else if (roomNumber == 2) make_current_enemies(1,0,0,0);
    }
    public void make_current_enemies(int morp, int peasants, int archers, int spearmen) {
    	
    	for (int m = 0; m < morp; m++) {
    		Enemy e = new Enemy(m, 1, mainGUI);
    		e.name = "Morp";
    		e.setHealth(10, 10);
    		e.setArmor(0);
            e.setAttackMax(1);
            e.setAttackMin(0);
            e.setCritPoint();
    		enemyListCurrent.add(e);
    	}
    	for (int p = 0; p < peasants; p++) {
    		Enemy e = new Enemy(p, 2, mainGUI);
    		e.name = "Peasant";
    		e.setHealth(10, 10);
    		e.setArmor(1);
            e.setAttackMax(3);
            e.setAttackMin(1);
            e.setCritPoint();
    		enemyListCurrent.add(e);
    	}
    	for (int a = 0; a < archers; a++) {
    		Enemy e = new Enemy(a, 2, mainGUI);
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
    		for (int j = 0; j < listCurrentRoom.get(j).size(); j++) {
    			Enemy e = new Enemy(enemyNumber, j+1, mainGUI);
    			enemyNumber++;
    			enemyListCurrent.add(e);
    		}
    	}
    }
    public ArrayList<Enemy> getEnemyList() { return enemyListCurrent; }
    public void clear_enemy_list() { enemyListCurrent.clear(); }


    

}
