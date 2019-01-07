import javax.swing.*;
import java.awt.event.*;
import java.applet.AudioClip;
import java.awt.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
public class MainGUI extends GraphicsProgram implements Runnable {
	SaveManager sm = new SaveManager();
	Inventory inv = new Inventory();
	MapLayout mapLayout = new MapLayout(this);
	EnemyList eL;
	Room room;
	AudioClip musicMenu = getAudioClip(getCodeBase(),"../Music/Main_Menu.wav"); 
	AudioClip musicSnowFight = getAudioClip(getCodeBase(),"../Music/Snowball_Fight.wav"); 
	AudioClip musicSnowTravel = getAudioClip(getCodeBase(),"../Music/Snowy_Travels.wav"); 
	AudioClip musicCave = getAudioClip(getCodeBase(),"../Music/Cave.wav"); 
	AudioClip musicFBasic = getAudioClip(getCodeBase(),"../Music/Fight_Basic.wav"); 
	AudioClip musicFWild = getAudioClip(getCodeBase(),"../Music/Fight_Wild.wav"); 
	AudioClip musicMonastery = getAudioClip(getCodeBase(),"../Music/Monastery.wav"); 
	AudioClip musicCurrent;

	int width, height;
	private static final double DELAY = 30;// .000001;
	boolean gameRunning = true;
	Font fHead = new Font("Serif", Font.BOLD, 16); Font fStat = new Font("Serif", Font.BOLD, 12);
	// 
	JFrame mainFrame;
	JButton btnNG, btnSG, btnLS, btnINV, btnQuit;
	JTextField tfWord;
	JTextArea tfEventArea;
	JScrollPane eventPane;
	JLabel dummyLabel;
	ArrayList<ArrayList<Tile>> tilePieces = new ArrayList<ArrayList<Tile>>();

	Tile[][] tiles = new Tile[10][15];

	//
	private RandomGenerator rand = new RandomGenerator();
	Color bg = new Color(209,209,209);
	Color bar = new Color(193,85,1);
	Color snow = new Color(180,212,255);
	private Color menuColor = new Color(52, 63, 71);

	EventList eventList = new EventList();
	QuoteList quoteList = new QuoteList();
	PlayerList playerList = new PlayerList();
	int numberPlayers;
	Player p;
	Sprite spr;
	Scanner reader = new Scanner(System.in);  // Reading from System.in

	// Fights
	GOval[] weather = new GOval[500];
	boolean weatherDrawn = false;
	GRect revealBlock;
	int condition = 0;
	Color sand = new Color(145, 101, 34);
	Color colTA = new Color(73,73,73);
	GImage imgTitle = new GImage("../Images/Extras/Infightity.png");
	GImage imgBG = new GImage("../Images/Extras/MountainRange.png");
	GImage imgPause = new GImage("../Images/Extras/Paused.png");
	GImage shop1 = new GImage("../Images/Top_Sprites/Comps/Shop1.gif");
	GImage shop2 = new GImage("../Images/Top_Sprites/Comps/Shop2.gif");
	ArrayList<ArrayList<Integer>> passableList = new ArrayList<ArrayList<Integer>>();

	ArrayList<Attack> attackList = new ArrayList<Attack>();
	ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	ArrayList<Component> componentList = new ArrayList<Component>();
	boolean paused = false;

	int roomNumber = 1;
	int screenNumber = 0;
	boolean screenChanged = false;
	boolean moveUp = false, moveDown = false, moveRight = false, moveLeft = false;
	boolean notHeld = true;
	boolean roomLoaded = false;
	boolean enteredCave = true;

	GLabel glblEnemy;
	GRect rectHRem, rectHBar;
	GImage imgEnemy;
	GRect rectProfile;
	public void init() {
		this.setSize(600,600); width = getWidth(); height = getHeight();
		setBackground(menuColor); 
		Frame c = (Frame)this.getParent().getParent(); c.setTitle("INFIGHTITY");
		c.setResizable(false);
		tfEventArea = new JTextArea(10, 10); tfEventArea.setLineWrap(true); tfEventArea.setWrapStyleWord(true);
		tfEventArea.setEditable(false); eventPane = new JScrollPane(tfEventArea); eventPane.setBounds(10, 440, 495, 150);
		eventPane.setBorder(BorderFactory.createCompoundBorder(
				eventPane.getBorder(), BorderFactory.createMatteBorder(5, 5, 5, 5, colTA))); 
		add(eventPane, 12, 440);
		tfEventArea.setBackground(colTA); tfEventArea.setForeground(Color.WHITE);
		tfEventArea.setText(quoteList.q0);

		btnNG = new JButton("New Game"); btnNG.setBounds(1,1,100,30);  btnNG.addActionListener(this);
		btnNG.setToolTipText("Create a New Game"); add(btnNG, 1, 1);

		btnSG = new JButton("Save File");  btnSG.setBounds(102,1,80,30);
		btnSG.addActionListener(this); add(btnSG, 102, 1); btnSG.setEnabled(false);

		btnLS = new JButton("Load File"); btnLS.setBounds(184,1,80,30);
		btnLS.addActionListener(this); add(btnLS, 184, 1);

		btnINV = new JButton("Inventory"); btnINV.setBounds(266,1,100,30);
		btnINV.addActionListener(this); add(btnINV, 266, 1); btnINV.setEnabled(false);

		btnQuit = new JButton("Quit Game"); btnQuit.setBounds(368,1,100,30);
		btnQuit.addActionListener(this); add(btnQuit, 368, 1);

		revealBlock = new GRect(-50, 30, 700, 400);
		revealBlock.setFillColor(Color.BLACK); revealBlock.setColor(Color.BLACK); revealBlock.setFilled(true); //add(revealBlock);
		GRect rectTop = new GRect(0,0,600,30); rectTop.setFilled(true); rectTop.setFillColor(bar); rectTop.setColor(bar); add(rectTop);
		GRect rectBot = new GRect(0, 430, 600, 170); rectBot.setFilled(true); rectBot.setFillColor(bar); rectBot.setColor(bar); add(rectBot);

		rectProfile = new GRect(510,441,85,85); rectProfile.setFilled(true); rectProfile.setFillColor(menuColor); 
		rectProfile.setColor(Color.WHITE); add(rectProfile);
		imgEnemy = new GImage("../Images/Enemy_Sprites/E1_Morp.gif"); imgEnemy.setVisible(false);
		add(imgEnemy, 512, 445);
		glblEnemy = new GLabel("Morp", 552, 541);
		glblEnemy.setFont(new Font("Verdana", Font.PLAIN, 13));
		glblEnemy.move(-glblEnemy.getWidth()/2, 0);
		glblEnemy.setVisible(false);
		add(glblEnemy);
		rectHRem = new GRect(510,550,85,15); rectHRem.setFilled(true); rectHRem.setFillColor(Color.RED); 
		rectHRem.setColor(Color.BLACK); add(rectHRem); rectHRem.setVisible(false);
		rectHBar = new GRect(510,550,85,15); rectHBar.setFilled(true); rectHBar.setFillColor(Color.GREEN); 
		rectHBar.setColor(Color.BLACK); add(rectHBar); rectHBar.setVisible(false);

		add(imgBG, 0, 30);
		addMouseListeners();
		addKeyListeners();

		eL = new EnemyList();
		eL.set_main(this);
		musicMenu.loop();
	}
	public void enableButtons() {
		btnINV.setEnabled(true);
		btnNG.setEnabled(true);
		btnSG.setEnabled(true);
		btnLS.setEnabled(true);
	}
	public void makeScreen(int roomNo) {
		musicMenu.stop();
		roomLoaded = false;
		eL.setup_enemy_rooms();
		remove(imgBG);
		roomNumber = roomNo;
		room = new Room();
		room.setMain(this);
		room.setUpComponents();
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 15; col++) {
				tiles[row][col] = new Tile(40,40, 0);
				add(tiles[row][col],  (col*40), (row*40) + 30);
			}
		}
		room.makeRoom("Room"+roomNumber, roomNumber, 2);
		roomLoaded = true;
		insert_enemies();
		drawWeather(condition);
	}
	public void changeScreen(int roomNo) {
		roomLoaded = false;
		while(enemyList.size() > 0) {
			remove(enemyList.get(0));
			enemyList.remove(0);
		}
		enemyList.clear();
		room.remove_components(roomNumber);
		
		roomNumber = roomNo;
		room.makeRoom("Room"+roomNumber,roomNumber,  3);
		if (spr != null) { 
			double x = spr.getX(); 
			double y = spr.getY();
			remove(spr);
			add(spr, x , y);
			p.pX = 0; p.pY = 0; 
		}
		room.add_above_components(roomNumber);
		roomLoaded = true;
		insert_enemies();
	}
	public void setMap(ArrayList<ArrayList<Tile>> tilesP, ArrayList<ArrayList<Integer>> tileVals) {
		tilePieces = tilesP; passableList = tileVals;
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 15; col++) {
				int x = tilePieces.get(row).get(col).id;
				tiles[row][col].setTile(x);
			}
		}
	}
	public void run() {

		while (true) {
			//if (screenChanged) screenChanged = false; musicCurrent.stop();
			//if (screenNumber == 0) musicMenu.loop();
			//else if (screenNumber == 1) musicFBasic.loop();
			if (paused) pause(DELAY);
			else {
				for (int attacks = 0; attacks < attackList.size(); attacks++) {
					if (!attackList.get(attacks).running) {
						remove(attackList.get(attacks));
						attackList.remove((attacks));
						attacks--;
						System.out.println(attackList.size());
					}
				}
				if (spr != null) {
					if (moveUp) {
						int ty = ((int) (spr.getY() - 10 - 30) / 40);
						if (!collide(true,ty, (int) (spr.getX()) / 40) && !collide(true,ty, (int) (spr.getX() + 24) / 40)) p.pY = -2;
						else {
							int ty2 = (int) (spr.getY() - 1 - 30) / 40;
							if (!collide(true,ty2, (int) (spr.getX()) / 40) && !collide(true,ty2, (int) (spr.getX() + 24) / 40)) p.pY = -1;
							else {
								p.pY = 0;
							}
						}
					}
					if (moveDown) {
						int ty = (int) (spr.getY() + 25 + 10 - 30) / 40;
						if (!collide(true,ty, (int) (spr.getX()) / 40) && !collide(true,ty, (int) (spr.getX() + 24) / 40)) p.pY = 2;
						else {
							int ty2 = (int) (spr.getY() + 25 + 1 - 30) / 40;
							if (!collide(true,ty2, (int) (spr.getX()) / 40) && !collide(true,ty2, (int) (spr.getX() + 24) / 40)) p.pY = 1;
							else {
								p.pY = 0;
							}
						}
					}
					if (moveRight) {
						int tx = (int) (spr.getX() + 25 + 10) / 40;	
						if (!collide(true,(int) (spr.getY() - 30) / 40, tx) && !collide(true,(int) (spr.getY() - 5) / 40, tx)) p.pX = 2; // + 24
						else {

							int tx2 = (int) (spr.getX() + 25 + 1) / 40;
							if (!collide(true,(int) (spr.getY() - 30) / 40, tx2) && !collide(true,(int) (spr.getY() - 5) / 40, tx2)) p.pX = 1;
							else {
								p.pX = 0;
							}
						}
					}
					if (moveLeft) {
						int tx = (int) (spr.getX() - 10) / 40;
						if (!collide(true,(int) (spr.getY() - 30) / 40, tx) && !collide(true,(int) (spr.getY() - 5) / 40, tx)) p.pX = -2;
						else {
							int tx2 = (int) (spr.getX() - 1) / 40;
							if (!collide(true,(int) (spr.getY() - 30) / 40, tx2) && !collide(true,(int) (spr.getY() - 5) / 40, tx2)) p.pX = -1;
							else {
								p.pX = 0;
							}
						}
					}
					//System.out.println("X: " + spr.getX() + " Y: " + spr.getY());
					spr.move(p.pX, p.pY);

					if (spr.getX() < 20) {
						tfEventArea.setText("Moved Left!");
						spr.setLocation(525, spr.getY());
						changeScreen(mapLayout.getRoom(roomNumber, 4));

					}
					if (spr.getX() + 25 > 575) {
						tfEventArea.setText("Moved Right!");
						spr.setLocation(50, spr.getY());
						changeScreen(mapLayout.getRoom(roomNumber, 2));

					}
					if (spr.getY() < 50) {
						tfEventArea.setText("Moved Up!");
						spr.setLocation(spr.getX(), 380);
						changeScreen(mapLayout.getRoom(roomNumber, 1));

					}
					if (spr.getY() + 25 > 415) {
						tfEventArea.setText("Moved Down!");
						spr.setLocation(spr.getX(), 80);
						changeScreen(mapLayout.getRoom(roomNumber, 3));

					}

					checkComponents();
					//p.pX = 0; p.pY = 0;	
				}
				revealBlock.move(1,0);
				if (condition > 0 && weatherDrawn) animateWeather();
				if (revealBlock.getX() > 610) remove(revealBlock);			
			}
			pause(DELAY); 
		}
	}
	public void animateWeather() {
		for (int i = 0 ; i < 500 ; i++) {
			if (condition == 1) {
				weather[i].move(rand.nextDouble(-.25,.8), 2);
				if (weather[i].getY() >= 420) weather[i].setLocation(rand.nextDouble(-400, 600), rand.nextDouble(-10, -100)); 
			}
			else if (condition == 2) {
				weather[i].move(.5, 3);
				if (weather[i].getY() >= 420) weather[i].setLocation(rand.nextDouble(-80, 600), rand.nextDouble(-10, -500));
			}
			else if (condition == 3) {
				weather[i].move(4, .2);
				if (weather[i].getX() >= 610) weather[i].setLocation(rand.nextDouble(-10, -500), rand.nextDouble(-10, 400));
			}
		}
	}
	public void setPlayer(Player plr) { 
		System.out.println("PLAYER SET!"); 
		p = plr; spr = new Sprite(p, this); 
		add(spr, 100, 130);
		new Thread(spr).start();		
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("New Game")) {
			sm.newFile(200, 200, 220, 220, this);
			btnINV.setEnabled(false);
			btnNG.setEnabled(false);
			btnSG.setEnabled(false);
			btnLS.setEnabled(false);
		}
		if (evt.getActionCommand().equals("Load File")) {
			sm.loadFile(200, 200, 220, 220, this);
			btnINV.setEnabled(false);
			btnNG.setEnabled(false);
			btnSG.setEnabled(false);
			btnLS.setEnabled(false);
		}
		if (evt.getActionCommand().equals("Save File")) {
			sm.saveFile(200, 200, 220, 220, this);
			btnINV.setEnabled(false);
			btnNG.setEnabled(false);
			btnSG.setEnabled(false);
			btnLS.setEnabled(false);
		}
		if (evt.getActionCommand().equals("Inventory")) {
			if (p != null) {
				inv.openInventory(150, 150, 300, 300, p.classChar, p, this);
				btnINV.setEnabled(false);
				btnNG.setEnabled(false);
				btnSG.setEnabled(false);
				btnLS.setEnabled(false);
			}
		}
	}

	public boolean collide(boolean isPlayer, int row, int col) {
		//System.out.println("Row: " + row + " Col: " + col);
		//System.out.println(passableList.get(row).get(col));
		//if (!tiles[row][col].canPass) return false;
		if (!isPlayer) {
			if (row < 0 || row > 9) return true;
			if (col < 0 || col > 14) return true;
		}
		if (passableList.get(row).get(col) == 0) return false;
		if (isPlayer) p.pX = 0; p.pY = 0;

		return true;
	}
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP: {
			if (p != null) {
				moveUp = true;
			}
			break;
		}
		case KeyEvent.VK_DOWN: {
			if (p != null) {
				moveDown = true;
			}
			break;
		}
		case KeyEvent.VK_RIGHT: {
			if (p != null) {
				moveRight = true;
			}
			break;
		}
		case KeyEvent.VK_LEFT: {
			if (p != null) {  
				moveLeft = true;
			}
			break;
		}
		case KeyEvent.VK_P: {
			if (paused) { remove(imgPause); paused = false;  btnSG.setEnabled(false); 
			for (int i = 0; i < enemyList.size(); i++) {
				enemyList.get(i).paused = false;
			}}
			else { 
				add(imgPause, 40, 200); paused = true; btnSG.setEnabled(true); 
				for (int i = 0; i < enemyList.size(); i++) {
					enemyList.get(i).paused = true;
				}
			}
			break;
		}
		case KeyEvent.VK_SPACE: {
			if (p != null) {
				if (notHeld) {
					notHeld = false;
					spr.attack();
				}
			}
			break;
		}
		case KeyEvent.VK_H: {
			spr.plrHit(5);
			break;
		}
		case KeyEvent.VK_E: {
			break;
		}
		case KeyEvent.VK_W: {

			break;
		}
		case KeyEvent.VK_S: {

			break;
		}
		case KeyEvent.VK_D: {

			break;
		}
		case KeyEvent.VK_A: {

			break;
		}
		}
	}
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP: {
			if (p != null) {
				moveUp = false;
				p.pY = 0;
			}
			break;
		}
		case KeyEvent.VK_DOWN: {
			if (p != null) {
				moveDown = false;
				p.pY = 0;
			}
			break;
		}
		case KeyEvent.VK_RIGHT: {
			if (p != null) {
				moveRight = false;
				p.pX = 0; 
			}
			break;
		}
		case KeyEvent.VK_LEFT: {
			if (p != null) {
				moveLeft = false;
				p.pX = 0; 
			}
			break;
		}
		case KeyEvent.VK_W: {
			if (p != null) spr.setSprite(1); 
			break;
		}
		case KeyEvent.VK_S: {
			if (p != null) spr.setSprite(3); 
			break;
		}
		case KeyEvent.VK_D: {
			if (p != null) spr.setSprite(2);
			break;
		}
		case KeyEvent.VK_A: {
			if (p != null) spr.setSprite(4);	
			break;
		}
		case KeyEvent.VK_SPACE: {
			notHeld = true;
			break;
		}
		}
	}
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse | X: " + e.getX() + " Y: " + e.getY());
	}
	public void insertAttack(Attack objAtk, int dir) {
		if (objAtk.cc >= 6 && objAtk.cc <= 8) {
			if (dir == 1) add(objAtk, spr.getX() + 8, spr.getY());
			if (dir == 2) add(objAtk, spr.getX() + 12, spr.getY() + 8);
			if (dir == 3) add(objAtk, spr.getX() + 8, spr.getY() + 12);
			if (dir == 4) add(objAtk, spr.getX(), spr.getY() + 8);
		}
		if (objAtk.cc == 12) {
			if (dir == 1) add(objAtk, spr.getX(), spr.getY() - 24);
			if (dir == 2) add(objAtk, spr.getX() + 24, spr.getY());
			if (dir == 3) add(objAtk, spr.getX(), spr.getY()  + 24);
			if (dir == 4) add(objAtk, spr.getX() - 24, spr.getY());
		}
		new Thread(objAtk).start();
		attackList.add(objAtk);
	}

	public void drawWeather(int cond) {
		condition = cond;
		if (condition == 1) {
			for (int i = 0 ; i < 500 ; i++) {
				weather[i] = new GOval(0,0); weather[i].setSize(3, 3);  weather[i].setFilled(true);  weather[i].setFillColor(Color.WHITE);
				weather[i].setColor(snow); add(weather[i], rand.nextDouble(-400, 550), rand.nextDouble(-10, 410));  
			}
		}
		if (condition == 2) {
			for (int i = 0 ; i < 500 ; i++) {
				weather[i] = new GOval(0,0); weather[i].setSize(3, 4); weather[i].setFilled(true);  weather[i].setFillColor(Color.CYAN);
				weather[i].setColor(Color.BLACK); add(weather[i], rand.nextDouble(-80, 550), rand.nextDouble(-200, 410));  
			}
		}
		if (condition == 3) {
			for (int i = 0 ; i < 500 ; i++) {
				weather[i] = new GOval(0,0); weather[i].setSize(3, 3); weather[i].setFilled(true); weather[i].setFillColor(sand);
				weather[i].setColor(Color.BLACK); add(weather[i], rand.nextDouble(-400, 600), rand.nextDouble(-100, 400));  
			}
		}
		weatherDrawn = true;
	}

	public void insert_enemies() {
		eL.setEnemyList(roomNumber);
		for (int i = 0; i < eL.getEnemyList().size(); i++) {
			new Thread(eL.getEnemy(i)).start();
			enemyList.add(eL.getEnemy(i));
			add(eL.getEnemy(i), eL.getEnemy(i).x,  eL.getEnemy(i).y);
		}
		//imgEnemy.setVisible(true);
		//glblEnemy.setVisible(true);
		//rectHRem.setVisible(true);
		//rectHBar.setVisible(true);
	}
	public boolean collision_Enemy(Enemy e) {
		if (e.dir == 1 && e.getY() <= 30) return true;
		if (roomLoaded) {
			if (e.enemyID == 1) {
				if (e.dir == 1) {
					int ty2 = (int) (e.getY() - 2 - 30 - 10) / 40;
					if (!collide(false,ty2, (int) (e.getX()) / 40) && !collide(false,ty2, (int) (e.getX() + 13) / 40)) return false;
					else {
						return true;
					}
				}
				else if (e.dir == 2) {
					int tx2 = (int) (e.getX() + 15 + 2) / 40;
					if (!collide(false,(int) (e.getY() - 30) / 40, tx2) && !collide(false,(int) (e.getY() - 5) / 40, tx2)) return false;
					else {
						return true;
					}
	
				}
				else if (e.dir == 3) {
					int ty2 = (int) (e.getY() + 15 + 2 - 30) / 40;
					if (!collide(false,ty2, (int) (e.getX()) / 40) && !collide(false,ty2, (int) (e.getX() + 13) / 40)) return false;
					else {
						return true;
					}
				}
				else if (e.dir == 4) {
					int tx2 = (int) (e.getX() - 2) / 40;
					if (!collide(false,(int) (e.getY() - 30) / 40, tx2) && !collide(false,(int) (e.getY() - 5) / 40, tx2)) return false;
					else {
						return true;
					}
				}
			}
			else if (e.enemyID == 2) {
				if (e.dir == 1) {
					int ty2 = (int) (e.getY() - 1 - 30 - 10) / 40;
					if (!collide(false,ty2, (int) (e.getX()) / 40) && !collide(false,ty2, (int) (e.getX() + 24) / 40)) return false;
					else {
						return true;
					}
				}
				else if (e.dir == 2) {
					int tx2 = (int) (e.getX() + 25 + 1) / 40;
					if (!collide(false,(int) (e.getY() - 30) / 40, tx2) && !collide(false,(int) (e.getY() - 5) / 40, tx2)) return false;
					else {
						return true;
					}
	
				}
				else if (e.dir == 3) {
					int ty2 = (int) (e.getY() + 25 + 1 - 30) / 40;
					if (!collide(false,ty2, (int) (e.getX()) / 40) && !collide(false,ty2, (int) (e.getX() + 24) / 40)) return false;
					else {
						return true;
					}
				}
				else if (e.dir == 4) {
					int tx2 = (int) (e.getX() - 1) / 40;
					if (!collide(false,(int) (e.getY() - 30) / 40, tx2) && !collide(false,(int) (e.getY() - 5) / 40, tx2)) return false;
					else {
						return true;
					}
				}
			}
		}
		return true;
	}

	public void checkComponents() {
		for (int comp = 0; comp < componentList.size(); comp++) {
			Component c = componentList.get(comp);
			if (c.interactable) {
				if (c.getBounds().intersects(spr.getBounds())) {
					c.altered = true;
				}
				else c.altered = false;
				c.interact_with();
			}
		}
	}
}
