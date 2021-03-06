import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveManager extends JPanel implements ActionListener {

	MainGUI mainGame;
	Font fLabel = new Font("Serif", Font.BOLD, 14);
	JFrame newgameFrame, noNameFrame, loadFrame, saveFrame;
	JLabel dummyLabel, lblName, lblNoName;
	JLabel lblClass, lblStr, lblPer, lblArmor, lblHeal, lblReact, lblWis;
	JLabel lblCName, lblStrS, lblPerS, lblArmS, lblHealS, lblReactS, lblWisS, lblTotalS;

	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
	LocalDateTime now;
	String lastSaveDate, lastSaveTime;
	
	JLabel lblSure1, lblSure2, lblSaveDate1, lblSaveDate2, lblSaveTime1, lblSaveTime2;
	JButton btnSave, btnSaveCancel;
	JLabel lblChoose, lblDummy;
	JComboBox<String> fileBox;
	File[] listOfSaves;
	JButton btnLoadSelect, btnLoadCancel;
	JButton btnSubmit, btnNewCancel, btnOkay, btnPrev, btnNext;
	JTextField tfName;
	private Color menuColor = new Color(52, 63, 71);

	
	ArrayList<ImageIcon> charList = new ArrayList<ImageIcon>();
	ArrayList<ArrayList<Integer>> statsList = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> spearmanList = new ArrayList<Integer>();
	ArrayList<Integer> archerList = new ArrayList<Integer>();
	ArrayList<Integer> wizardList = new ArrayList<Integer>();
	ArrayList<Integer> knightList = new ArrayList<Integer>();
	ArrayList<Integer> skeletonList = new ArrayList<Integer>();
	Scanner scanner = null;
	BufferedWriter fileWriter = null;
	String currentFile = null;
	FileWriter fw = null;

	Player plr;
	JLabel currentChar = null;
	int charNum = 0;
	BufferedReader fileReader = null;
	FileReader fr = null;
	
	boolean newgameFrameUp = false, loadFrameUp = false, saveFrameUp = false;

	public void newFile(int x, int y, int width, int height, MainGUI game) {
		newgameFrameUp = true;
		mainGame = game;
		newgameFrame = new JFrame();

		newgameFrame.getContentPane().setBackground(menuColor);
		newgameFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		newgameFrame.setBounds(x,y, width,height);
		newgameFrame.getContentPane().setLayout(new BorderLayout());
		newgameFrame.setResizable(false);
		newgameFrame.setTitle("New Game");

		lblClass = new JLabel("Class:"); lblClass.setFont(fLabel);  lblClass.setForeground(Color.WHITE);
		lblClass.setBounds(105, 50, 45, 30); newgameFrame.add(lblClass);

		lblCName = new JLabel("Archer"); lblCName.setFont(fLabel);  lblCName.setForeground(Color.WHITE);
		lblCName.setBounds(145, 50, 70, 30); newgameFrame.add(lblCName);

		lblStr = new JLabel("Strength:"); lblStr.setFont(fLabel); lblStr.setForeground(Color.WHITE);
		lblStr.setBounds(105, 65, 60, 30);  newgameFrame.add(lblStr);

		lblStrS = new JLabel(statsList.get(0).get(0).toString()); lblStrS.setFont(fLabel);
		lblStrS.setForeground(Color.WHITE); lblStrS.setBounds(185, 65, 20, 30);
		newgameFrame.add(lblStrS);

		lblArmor = new JLabel("Armor:"); lblArmor.setFont(fLabel);  lblArmor.setForeground(Color.WHITE);
		lblArmor.setBounds(105, 80, 50, 30); newgameFrame.add(lblArmor);

		lblArmS = new JLabel(statsList.get(0).get(1).toString());  lblArmS.setFont(fLabel);
		lblArmS.setForeground(Color.WHITE);  lblArmS.setBounds(185, 80, 50, 30);
		newgameFrame.add(lblArmS);

		lblHeal = new JLabel("Heal:"); lblHeal.setFont(fLabel); lblHeal.setForeground(Color.WHITE);
		lblHeal.setBounds(105, 95, 45, 30); newgameFrame.add(lblHeal);

		lblHealS = new JLabel(statsList.get(0).get(2).toString());  lblHealS.setFont(fLabel);
		lblHealS.setForeground(Color.WHITE); lblHealS.setBounds(185, 95, 45, 30);
		newgameFrame.add(lblHealS);

		lblReact = new JLabel("React:"); lblReact.setFont(fLabel); lblReact.setForeground(Color.WHITE);
		lblReact.setBounds(105, 110, 50, 30); newgameFrame.add(lblReact);

		lblReactS = new JLabel(statsList.get(0).get(3).toString()); lblReactS.setFont(fLabel);
		lblReactS.setForeground(Color.WHITE);  lblReactS.setBounds(185, 110, 50, 30);
		newgameFrame.add(lblReactS);

		lblWis = new JLabel("Wisdom:");  lblWis.setFont(fLabel); lblWis.setForeground(Color.WHITE);
		lblWis.setBounds(105, 125, 55, 30);  newgameFrame.add(lblWis);

		lblWisS = new JLabel(statsList.get(0).get(4).toString()); lblWisS.setFont(fLabel);
		lblWisS.setForeground(Color.WHITE); lblWisS.setBounds(185, 125, 55, 30);
		newgameFrame.add(lblWisS);

		lblPer = new JLabel("Persuasion:"); lblPer.setFont(fLabel); lblPer.setForeground(Color.WHITE); 
		lblPer.setBounds(105, 140, 70, 30); newgameFrame.add(lblPer);

		lblPerS = new JLabel(statsList.get(0).get(5).toString()); lblPerS.setFont(fLabel);
		lblPerS.setForeground(Color.WHITE); lblPerS.setBounds(185, 140, 55, 30);
		newgameFrame.add(lblPerS);

		lblTotalS = new JLabel("Total =       40"); lblTotalS.setFont(fLabel);
		lblTotalS.setForeground(Color.WHITE); lblTotalS.setBounds(105, 155, 90, 30);
		newgameFrame.add(lblTotalS);

		lblName = new JLabel("Name:"); lblName.setFont(new Font("Serif", Font.BOLD, 16));
		lblName.setForeground(Color.WHITE);  lblName.setBounds(5, 1, 45, 30);
		newgameFrame.add(lblName);

		tfName = new JTextField("", 30); tfName.setBounds(55, 1, 140, 30);
		tfName.setEditable(true); newgameFrame.add(tfName);

		btnSubmit = new JButton("Create"); btnSubmit.setBounds(width/10, 28, 80, 30);
		btnSubmit.addActionListener(this); newgameFrame.add(btnSubmit);

		btnNewCancel = new JButton("Cancel"); btnNewCancel.setBounds(width/2, 28, 80, 30);
		btnNewCancel.addActionListener(this); newgameFrame.add(btnNewCancel);

		charNum = 0;
		currentChar = new JLabel(charList.get(0)); currentChar.setBounds(10, 60, 80, 80);
		newgameFrame.add(currentChar);

		btnPrev = new JButton("Prev"); btnPrev.setBounds(1, 150, 55, 30);
		btnPrev.addActionListener(this); newgameFrame.add(btnPrev);

		btnNext = new JButton("Next"); btnNext.setBounds(51,150, 55, 30);
		btnNext.addActionListener(this);  newgameFrame.add(btnNext);
		dummyLabel = new JLabel(""); newgameFrame.add(dummyLabel);

		newgameFrame.setVisible(true);
		newgameFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		newgameFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

	}

	public void setLists() {
		charList.clear();
		charList.add(new ImageIcon("../Images/Profiles/Player/Archer1.png"));
		charList.add(new ImageIcon("../Images/Profiles/Player/Archer2.png"));
		charList.add(new ImageIcon("../Images/Profiles/Player/Archer3.png"));
		charList.add(new ImageIcon("../Images/Profiles/Player/Spearman1.png"));
		charList.add(new ImageIcon("../Images/Profiles/Player/Spearman2.png"));
		charList.add(new ImageIcon("../Images/Profiles/Player/Spearman3.png"));
		charList.add(new ImageIcon("../Images/Profiles/Player/Wizard1.png"));
		charList.add(new ImageIcon("../Images/Profiles/Player/Wizard2.png"));
		charList.add(new ImageIcon("../Images/Profiles/Player/Wizard3.png"));
		charList.add(new ImageIcon("../Images/Profiles/Player/Knight1.png"));
		charList.add(new ImageIcon("../Images/Profiles/Player/Knight2.png"));
		charList.add(new ImageIcon("../Images/Profiles/Player/Knight3.png"));
		charList.add(new ImageIcon("../Images/Profiles/Player/Skeleton1.png"));
		spearmanList.clear();
		spearmanList.add(9); spearmanList.add(8); spearmanList.add(4);
		spearmanList.add(7); spearmanList.add(5); spearmanList.add(7);
		archerList.clear();
		archerList.add(8); archerList.add(6); archerList.add(6);
		archerList.add(7); archerList.add(7); archerList.add(6);
		wizardList.clear();
		wizardList.add(8); wizardList.add(2); wizardList.add(9);
		wizardList.add(3); wizardList.add(10); wizardList.add(8);
		knightList.clear();
		knightList.add(10); knightList.add(9); knightList.add(1);
		knightList.add(6); knightList.add(5); knightList.add(9);
		skeletonList.clear();
		skeletonList.add(8); skeletonList.add(4); skeletonList.add(8);
		skeletonList.add(9); skeletonList.add(6); skeletonList.add(5);

		statsList.clear();
		statsList.add(archerList); statsList.add(spearmanList);
		statsList.add(wizardList); statsList.add(knightList); statsList.add(skeletonList);


	}
	public void loadFile(int x, int y, int width, int height, MainGUI game) {
		loadFrameUp = true;
		mainGame = game;
		loadFrame = new JFrame();
		mainGame.btnNG.setEnabled(false); mainGame.btnSG.setEnabled(false); mainGame.btnLS.setEnabled(false);
		mainGame.btnINV.setEnabled(false); mainGame.btnQuit.setEnabled(false);
		loadFrame.getContentPane().setBackground(menuColor);
		loadFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		loadFrame.setBounds(x,y, width,height);
		loadFrame.getContentPane().setLayout(new BorderLayout());
		loadFrame.setResizable(false);
		loadFrame.setTitle("Load Game");

		fileBox = new JComboBox<String>();
		fileBox.setBounds(5, 30, 200, 30);
		loadFrame.add(fileBox);
		loadFilesInFolder();

		btnLoadSelect = new JButton("Load Game");  btnLoadSelect.setBounds(60, 60, 100, 30);
		btnLoadSelect.addActionListener(this); loadFrame.add(btnLoadSelect);

		btnLoadCancel = new JButton("Cancel"); btnLoadCancel.setBounds(60, 100, 100, 30);
		btnLoadCancel.addActionListener(this); loadFrame.add(btnLoadCancel);

		lblChoose = new JLabel("Choose a save file to load");
		lblChoose.setFont(fLabel);
		lblChoose.setForeground(Color.WHITE);  lblChoose.setBounds(25, 5, 160, 20);
		loadFrame.add(lblChoose);

		lblDummy = new JLabel("");
		loadFrame.add(lblDummy);

		loadFrame.setVisible(true);
		loadFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		loadFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

	}

	public void loadFilesInFolder() {
		File folder = new File("../Saves/");
		listOfSaves = folder.listFiles();
		for (File file : listOfSaves) {
			if (file.isFile() && file.getName().contains(".txt")) {
				System.out.println(file.getName());
				String charName = file.getName().substring(0, file.getName().length()-4);
				fileBox.addItem(charName);
			}
		}
	}

	public void createWarningBox(int x, int y, int width, int height, String issue) {
		noNameFrame = new JFrame();
		noNameFrame.setTitle("Name Error");
		noNameFrame.getContentPane().setBackground(menuColor);
		noNameFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		noNameFrame.setBounds(x, y, width, height);
		noNameFrame.getContentPane().setLayout(new BorderLayout());
		noNameFrame.setResizable(false);

		lblNoName = new JLabel(issue);
		lblNoName.setFont(new Font("Serif", Font.BOLD, 12));
		lblNoName.setForeground(Color.WHITE);
		lblNoName.setBounds(5, 1, 250, 30);
		noNameFrame.add(lblNoName);
		btnOkay = new JButton("Okay");
		btnOkay.setBounds(60, 25, 80, 30);
		btnOkay.addActionListener(this);
		noNameFrame.add(btnOkay);

		dummyLabel = new JLabel("");
		noNameFrame.add(dummyLabel);

		noNameFrame.setVisible(true);
		noNameFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		noNameFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

	}

	public void makeVisibleLogin() { newgameFrame.setVisible(true);}
	public void makeVisibleNoName() { noNameFrame.setVisible(true);}
	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("Okay")) {
			noNameFrame.dispose();
		}
		if (evt.getActionCommand().equals("Cancel")) {
			if (newgameFrameUp) {
				newgameFrameUp = false;
				newgameFrame.dispose();
				mainGame.btnNG.setEnabled(true);
				mainGame.btnLS.setEnabled(true);
				mainGame.btnQuit.setEnabled(true);
			}
			if (loadFrameUp) {
				loadFrameUp = false;
				loadFrame.dispose();
				mainGame.btnNG.setEnabled(true);
				mainGame.btnLS.setEnabled(true);
				mainGame.btnQuit.setEnabled(true);
			}
			if (saveFrameUp) {
				saveFrameUp = false;
				saveFrame.dispose();
				mainGame.btnNG.setEnabled(false); mainGame.btnSG.setEnabled(true); 
				mainGame.btnLS.setEnabled(false); mainGame.btnINV.setEnabled(true); 
				mainGame.btnQuit.setEnabled(true);
				
			}
		}
		if (evt.getActionCommand().equals("Create")) {
			String typedName = tfName.getText();
			if (typedName.trim().length() > 0 && typedName.length() <= 8) {
				if (!checkExists()) { createNewSave(); newgameFrame.dispose(); }
				else { createWarningBox(200,200,220,80, "File Already Exists"); }
			}
			else { createWarningBox(200,200,220,80, "Please write your name (Max 8 Letters)"); }

		}
		if (evt.getActionCommand().equals("Prev")) {
			charNum--; changeStats();
		}
		if (evt.getActionCommand().equals("Next")) {
			charNum++; changeStats();
		}
		if (evt.getActionCommand().equals("Load Game")) {
			if (fileBox.getSelectedItem() != null) {
				try {
					File save = new File("../Saves/" + fileBox.getSelectedItem().toString() + ".txt");
					scanner = new Scanner(save);
					plr = new Player();
					plr.name = scanner.next();
					plr.setClass(scanner.nextInt());
					plr.level = scanner.nextInt();
					plr.levelUp(plr.level);
					plr.strength = scanner.nextInt();
					plr.armor = scanner.nextInt();
					plr.maxHeal = scanner.nextInt();
					plr.react =  scanner.nextInt();
					plr.wisdom = scanner.nextInt();
					plr.persuasion = scanner.nextInt();
					scanner.next(); 
					plr.goldAmount = scanner.nextInt();
					scanner.next();
					int roomNo = scanner.nextInt();
					plr.currentRoom = roomNo;
					double xPos = scanner.nextDouble();
					double yPos = scanner.nextDouble();
					plr.xLoc = xPos; plr.yLoc = yPos;
					lastSaveDate = scanner.next();
					lastSaveTime = scanner.next();
					scanner.next();
					plr.countPS = scanner.nextInt();
					plr.countPM = scanner.nextInt();
					plr.countPL = scanner.nextInt();
					loadFrame.dispose();
					mainGame.tfEventArea.setText("Player: " + plr.countPL + " loaded!");
					mainGame.makeScreen(roomNo);
					mainGame.setPlayer(plr, xPos, yPos);
					mainGame.room.add_above_components(roomNo);
					loadFrameUp = false;
					mainGame.btnNG.setEnabled(false); mainGame.btnSG.setEnabled(false); mainGame.btnLS.setEnabled(false);
					mainGame.btnINV.setEnabled(false); mainGame.btnQuit.setEnabled(false);
				} catch (Exception e) {  System.out.println("Error Loading"); System.out.println(e); }
			}
		}
		if (evt.getActionCommand().equals("Save")) { saveGame(); }
	}

	public void changeStats() {
		if (charNum < 0) charNum = charList.size() - 1;
		if (charNum >= charList.size()) charNum = 0;
		currentChar.setIcon(charList.get(charNum));
		
		if (charNum >= 0 && charNum <= 2) {
			lblCName.setText("Archer");
			lblStrS.setText(statsList.get(0).get(0).toString()); lblArmS.setText(statsList.get(0).get(1).toString());
			lblHealS.setText(statsList.get(0).get(2).toString()); lblReactS.setText(statsList.get(0).get(3).toString());
			lblWisS.setText(statsList.get(0).get(4).toString()); lblPerS.setText(statsList.get(0).get(5).toString());

		}
		else if (charNum >= 3 && charNum <= 5) {
			lblCName.setText("Spearman");
			lblStrS.setText(statsList.get(1).get(0).toString()); lblArmS.setText(statsList.get(1).get(1).toString());
			lblHealS.setText(statsList.get(1).get(2).toString()); lblReactS.setText(statsList.get(1).get(3).toString());
			lblWisS.setText(statsList.get(1).get(4).toString()); lblPerS.setText(statsList.get(1).get(5).toString());
		}
		else if (charNum >= 6 && charNum <= 8) {
			lblCName.setText("Wizard");
			lblStrS.setText(statsList.get(2).get(0).toString()); lblArmS.setText(statsList.get(2).get(1).toString());
			lblHealS.setText(statsList.get(2).get(2).toString()); lblReactS.setText(statsList.get(2).get(3).toString());
			lblWisS.setText(statsList.get(2).get(4).toString()); lblPerS.setText(statsList.get(2).get(5).toString());
		}
		else if (charNum >= 9 && charNum <= 11) {
			lblCName.setText("Knight");
			lblStrS.setText(statsList.get(3).get(0).toString()); lblArmS.setText(statsList.get(3).get(1).toString());
			lblHealS.setText(statsList.get(3).get(2).toString()); lblReactS.setText(statsList.get(3).get(3).toString());
			lblWisS.setText(statsList.get(3).get(4).toString()); lblPerS.setText(statsList.get(3).get(5).toString());
		}
		else if (charNum == 12) {
			lblCName.setText("Skeleton");
			lblStrS.setText(statsList.get(4).get(0).toString()); lblArmS.setText(statsList.get(4).get(1).toString());
			lblHealS.setText(statsList.get(4).get(2).toString()); lblReactS.setText(statsList.get(4).get(3).toString());
			lblWisS.setText(statsList.get(4).get(4).toString()); lblPerS.setText(statsList.get(4).get(5).toString());
		}
	}

	public boolean checkExists() {
		try {
			String currentFile = "../Saves/" + tfName.getText() + ".txt";
			fileReader = new BufferedReader(new FileReader(currentFile));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void createNewSave() {
		
		try {
			String currentFile = "../Saves/" + tfName.getText() + ".txt";
			File fold = new File(currentFile);
			fold.delete();
			fileWriter = new BufferedWriter(new FileWriter(currentFile, true));
			fileWriter.write(tfName.getText().trim());
			if (charNum == 0) { fileWriter.write(" 0 1 8 6 6 7 7 6"); }
			if (charNum == 1) { fileWriter.write(" 1 1 8 6 6 7 7 6"); }
			if (charNum == 2) { fileWriter.write(" 2 1 8 6 6 7 7 6"); }
			if (charNum == 3) { fileWriter.write(" 3 1 9 8 4 7 5 7"); }
			if (charNum == 4) { fileWriter.write(" 4 1 9 8 4 7 5 7"); }
			if (charNum == 5) { fileWriter.write(" 5 1 9 8 4 7 5 7"); }
			if (charNum == 6) { fileWriter.write(" 6 1 8 2 9 3 10 8"); }
			if (charNum == 7) { fileWriter.write(" 7 1 8 2 9 3 10 8"); }
			if (charNum == 8) { fileWriter.write(" 8 1 8 2 9 3 10 8"); }
			if (charNum == 9) { fileWriter.write(" 9 1 10 9 1 6 5 9"); }
			if (charNum == 10) { fileWriter.write(" 10 1 10 9 1 6 5 9"); }
			if (charNum == 11) { fileWriter.write(" 11 1 10 9 1 6 5 9"); }
			if (charNum == 12) { fileWriter.write(" 12 1 8 4 8 9 6 5"); }
			fileWriter.write("\nGold 25\n");
			fileWriter.write("Room 1 90 125\n");
			fileWriter.write(dtf.format(LocalDateTime.now()));
			fileWriter.write("\nPotions 1 0 0\n");
			fileWriter.write("Weapons\n");
			fileWriter.write("Key_Items\n");

			fileWriter.close();
			mainGame.btnNG.setEnabled(true); mainGame.btnSG.setEnabled(false); mainGame.btnLS.setEnabled(true);
			mainGame.btnINV.setEnabled(false); mainGame.btnQuit.setEnabled(true);
		} catch (Exception e) {
			System.out.println("Exception caught."); // Prints if an error is found
			System.out.println(e);
		}
	} 

	public void saveFile(int x, int y, int width, int height, MainGUI game) {
		saveFrameUp = true;
		mainGame = game;
		saveFrame = new JFrame();

		saveFrame.getContentPane().setBackground(menuColor);
		saveFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		saveFrame.setBounds(x,y, width,height);
		saveFrame.getContentPane().setLayout(new BorderLayout());
		saveFrame.setResizable(false);
		saveFrame.setTitle("Save Game");

		lblSure1 = new JLabel("Are you sure you wish to save?");
		lblSure1.setFont(fLabel); lblSure1.setForeground(Color.WHITE); 
		lblSure1.setBounds(14, 5, width, 30); saveFrame.add(lblSure1);

		lblSure2 = new JLabel("Old Save          New Save");
		lblSure2.setFont(fLabel); lblSure2.setForeground(Color.WHITE); 
		lblSure2.setBounds(25, 30, width, 30); saveFrame.add(lblSure2);
		
		now = LocalDateTime.now();
	    String dtNow = dtf.format(now).toString();
        String dateNow = dtNow.substring(0, 10);
        String timeNow = dtNow.substring(11, dtNow.length());
        lblSaveDate1 = new JLabel(lastSaveDate);
        lblSaveDate1.setFont(fLabel); lblSaveDate1.setForeground(Color.WHITE); 
        lblSaveDate1.setBounds(25, 50, 80, 30); saveFrame.add(lblSaveDate1);
        lblSaveTime1 = new JLabel(lastSaveTime);
        lblSaveTime1.setFont(fLabel); lblSaveTime1.setForeground(Color.WHITE); 
        lblSaveTime1.setBounds(25, 70, 80, 30); saveFrame.add(lblSaveTime1);
        
        lblSaveDate2 = new JLabel(dateNow);
        lblSaveDate2.setFont(fLabel); lblSaveDate2.setForeground(Color.WHITE); 
        lblSaveDate2.setBounds(120, 50, 80, 30); saveFrame.add(lblSaveDate2);
        lblSaveTime2 = new JLabel(timeNow);
        lblSaveTime2.setFont(fLabel); lblSaveTime2.setForeground(Color.WHITE); 
        lblSaveTime2.setBounds(120, 70, 80, 30); saveFrame.add(lblSaveTime2);
        
		btnSave = new JButton("Save"); btnSave.setBounds(25, 160, 80, 30);
		btnSave.addActionListener(this); saveFrame.add(btnSave);
		btnSaveCancel = new JButton("Cancel"); btnSaveCancel.setBounds(120, 160, 80, 30);
		btnSaveCancel.addActionListener(this); saveFrame.add(btnSaveCancel);

		dummyLabel = new JLabel("");
		saveFrame.add(dummyLabel);

		saveFrame.setVisible(true);
		saveFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		saveFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
	}
	
	public void saveGame() {
		try {
			String currentFile = "../Saves/" + plr.name + ".txt";
			File fold = new File(currentFile);
			fold.delete();
			fileWriter = new BufferedWriter(new FileWriter(currentFile, false));
			fileWriter.write(plr.name + " " + " " + plr.classChar + " " + plr.level + " " + plr.strength + " " +
							 plr.armor + " " + plr.maxHeal + " " + plr.react + " " + plr.wisdom + " " + plr.persuasion);
			fileWriter.write("\nGold " + plr.goldAmount +"\n");
			fileWriter.write("Room " + plr.currentRoom + " " + plr.xLoc + " " + plr.yLoc + "\n");
			String dtNow = dtf.format(now).toString();
			lastSaveDate = dtNow.substring(0, 10);
			lastSaveTime= dtNow.substring(11, dtNow.length());
			fileWriter.write(lastSaveDate + " " + lastSaveTime);
			fileWriter.write("\nPotions " + plr.countPS + " " + plr.countPM + " " + plr.countPL + "\n");
			fileWriter.write("Weapons\n");
			fileWriter.write("Key_Items\n");
			fileWriter.close();
			saveFrame.dispose();
			saveFrameUp = false;
			
		}
		catch (Exception e) {
			System.out.println("Exception while Saving.");
			System.out.println(e);// Prints if an error is found
		} 
		
	}

}
