import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveManager extends JPanel implements ActionListener {

	MainGUI mainGame;
	Font fLabel = new Font("Serif", Font.BOLD, 14);
	JFrame mainFrame, noNameFrame, loadFrame, saveFrame;
	JLabel dummyLabel, lblName, lblNoName;
	JLabel lblClass, lblStr, lblPer, lblArmor, lblHeal, lblReact, lblWis;
	JLabel lblCName, lblStrS, lblPerS, lblArmS, lblHealS, lblReactS, lblWisS, lblTotalS;

	JLabel lblSure;
	JButton btnSave, btnCancelSave;
	JLabel lblChoose, lblDummy;
	JComboBox<String> fileBox;
	File[] listOfSaves;
	JButton btnLoadSelect, btnLoadClose;
	JButton btnSubmit, btnCancel, btnOkay, btnPrev, btnNext;
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

	public void newFile(int x, int y, int width, int height, MainGUI game) {
		setLists();

		mainGame = game;
		mainFrame = new JFrame();

		mainFrame.getContentPane().setBackground(menuColor);
		mainFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		mainFrame.setBounds(x,y, width,height);
		mainFrame.getContentPane().setLayout(new BorderLayout());
		mainFrame.setResizable(false);
		mainFrame.setTitle("New Game");

		lblClass = new JLabel("Class:"); lblClass.setFont(fLabel);  lblClass.setForeground(Color.WHITE);
		lblClass.setBounds(105, 50, 45, 30); mainFrame.add(lblClass);

		lblCName = new JLabel("Archer"); lblCName.setFont(fLabel);  lblCName.setForeground(Color.WHITE);
		lblCName.setBounds(145, 50, 70, 30); mainFrame.add(lblCName);

		lblStr = new JLabel("Strength:"); lblStr.setFont(fLabel); lblStr.setForeground(Color.WHITE);
		lblStr.setBounds(105, 65, 60, 30);  mainFrame.add(lblStr);

		lblStrS = new JLabel(statsList.get(0).get(0).toString()); lblStrS.setFont(fLabel);
		lblStrS.setForeground(Color.WHITE); lblStrS.setBounds(185, 65, 20, 30);
		mainFrame.add(lblStrS);

		lblArmor = new JLabel("Armor:"); lblArmor.setFont(fLabel);  lblArmor.setForeground(Color.WHITE);
		lblArmor.setBounds(105, 80, 50, 30); mainFrame.add(lblArmor);

		lblArmS = new JLabel(statsList.get(0).get(1).toString());  lblArmS.setFont(fLabel);
		lblArmS.setForeground(Color.WHITE);  lblArmS.setBounds(185, 80, 50, 30);
		mainFrame.add(lblArmS);

		lblHeal = new JLabel("Heal:"); lblHeal.setFont(fLabel); lblHeal.setForeground(Color.WHITE);
		lblHeal.setBounds(105, 95, 45, 30); mainFrame.add(lblHeal);

		lblHealS = new JLabel(statsList.get(0).get(2).toString());  lblHealS.setFont(fLabel);
		lblHealS.setForeground(Color.WHITE); lblHealS.setBounds(185, 95, 45, 30);
		mainFrame.add(lblHealS);

		lblReact = new JLabel("React:"); lblReact.setFont(fLabel); lblReact.setForeground(Color.WHITE);
		lblReact.setBounds(105, 110, 50, 30); mainFrame.add(lblReact);

		lblReactS = new JLabel(statsList.get(0).get(3).toString()); lblReactS.setFont(fLabel);
		lblReactS.setForeground(Color.WHITE);  lblReactS.setBounds(185, 110, 50, 30);
		mainFrame.add(lblReactS);

		lblWis = new JLabel("Wisdom:");  lblWis.setFont(fLabel); lblWis.setForeground(Color.WHITE);
		lblWis.setBounds(105, 125, 55, 30);  mainFrame.add(lblWis);

		lblWisS = new JLabel(statsList.get(0).get(4).toString()); lblWisS.setFont(fLabel);
		lblWisS.setForeground(Color.WHITE); lblWisS.setBounds(185, 125, 55, 30);
		mainFrame.add(lblWisS);

		lblPer = new JLabel("Persuasion:"); lblPer.setFont(fLabel); lblPer.setForeground(Color.WHITE); 
		lblPer.setBounds(105, 140, 70, 30); mainFrame.add(lblPer);

		lblPerS = new JLabel(statsList.get(0).get(5).toString()); lblPerS.setFont(fLabel);
		lblPerS.setForeground(Color.WHITE); lblPerS.setBounds(185, 140, 55, 30);
		mainFrame.add(lblPerS);

		lblTotalS = new JLabel("Total =       40"); lblTotalS.setFont(fLabel);
		lblTotalS.setForeground(Color.WHITE); lblTotalS.setBounds(105, 155, 90, 30);
		mainFrame.add(lblTotalS);

		lblName = new JLabel("Name:"); lblName.setFont(new Font("Serif", Font.BOLD, 16));
		lblName.setForeground(Color.WHITE);  lblName.setBounds(5, 1, 45, 30);
		mainFrame.add(lblName);

		tfName = new JTextField("", 30); tfName.setBounds(55, 1, 140, 30);
		tfName.setEditable(true); mainFrame.add(tfName);

		btnSubmit = new JButton("Create"); btnSubmit.setBounds(width/10, 28, 80, 30);
		btnSubmit.addActionListener(this); mainFrame.add(btnSubmit);

		btnCancel = new JButton("Cancel"); btnCancel.setBounds(width/2, 28, 80, 30);
		btnCancel.addActionListener(this); mainFrame.add(btnCancel);

		charNum = 0;
		currentChar = new JLabel(charList.get(0)); currentChar.setBounds(10, 60, 80, 80);
		mainFrame.add(currentChar);

		btnPrev = new JButton("Prev"); btnPrev.setBounds(1, 150, 55, 30);
		btnPrev.addActionListener(this); mainFrame.add(btnPrev);

		btnNext = new JButton("Next"); btnNext.setBounds(51,150, 55, 30);
		btnNext.addActionListener(this);  mainFrame.add(btnNext);
		dummyLabel = new JLabel(""); mainFrame.add(dummyLabel);

		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//mainFrame.setUndecorated(true);
		mainFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

	}

	public void setLists() {
		charList.clear();
		charList.add(new ImageIcon("../Images/Player_Sprites/Archer1.png"));
		charList.add(new ImageIcon("../Images/Player_Sprites/Archer2.png"));
		charList.add(new ImageIcon("../Images/Player_Sprites/Archer3.png"));
		charList.add(new ImageIcon("../Images/Player_Sprites/Spearman1.png"));
		charList.add(new ImageIcon("../Images/Player_Sprites/Spearman2.png"));
		charList.add(new ImageIcon("../Images/Player_Sprites/Spearman3.png"));
		charList.add(new ImageIcon("../Images/Player_Sprites/Wizard1.png"));
		charList.add(new ImageIcon("../Images/Player_Sprites/Wizard2.png"));
		charList.add(new ImageIcon("../Images/Player_Sprites/Wizard3.png"));
		charList.add(new ImageIcon("../Images/Player_Sprites/Knight1.png"));
		charList.add(new ImageIcon("../Images/Player_Sprites/Knight2.png"));
		charList.add(new ImageIcon("../Images/Player_Sprites/Knight3.png"));
		charList.add(new ImageIcon("../Images/Player_Sprites/Skeleton1.png"));
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
		mainGame = game;
		loadFrame = new JFrame();

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

		btnLoadClose = new JButton("Close"); btnLoadClose.setBounds(60, 100, 100, 30);
		btnLoadClose.addActionListener(this); loadFrame.add(btnLoadClose);

		lblChoose = new JLabel("Choose a save file to load");
		lblChoose.setFont(fLabel);
		lblChoose.setForeground(Color.WHITE);  lblChoose.setBounds(25, 5, 160, 20);
		loadFrame.add(lblChoose);

		lblDummy = new JLabel("");
		loadFrame.add(lblDummy);

		loadFrame.setVisible(true);
		//loadFrame.setUndecorated(true);
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
		btnOkay = new JButton("My B");
		btnOkay.setBounds(60, 25, 80, 30);
		btnOkay.addActionListener(this);
		noNameFrame.add(btnOkay);

		dummyLabel = new JLabel("");
		noNameFrame.add(dummyLabel);

		noNameFrame.setVisible(true);
		noNameFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//oNameFrame.setUndecorated(true);
		noNameFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

	}

	public void makeVisibleLogin() { mainFrame.setVisible(true);}
	public void makeVisibleNoName() { noNameFrame.setVisible(true);}
	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("My B")) {
			//main.showScreen(0);
			noNameFrame.dispose();
		}
		if (evt.getActionCommand().equals("Cancel")) {
			//main.showScreen(0);
			mainFrame.dispose();
			mainGame.enableButtons();
		}
		if (evt.getActionCommand().equals("Cancel")) {
			if (loadFrame.isVisible()) loadFrame.dispose();
			if (saveFrame.isVisible()) saveFrame.dispose();
		}
		if (evt.getActionCommand().equals("Create")) {
			String typedName = tfName.getText();
			if (typedName.trim().length() > 0 && typedName.length() <= 8) {
				if (!checkExists()) { createNewSave(); mainFrame.dispose(); mainGame.enableButtons();}
				else {
					createWarningBox(200,200,220,80, "File Already Exists");
				}
			}
			else {
				createWarningBox(200,200,220,80, "Please write your name (Max 8 Letters)");
			}

		}
		if (evt.getActionCommand().equals("Prev")) {
			charNum--;
			if (charNum < 0) charNum = charList.size() - 1;
			System.out.println(charNum);
			currentChar.setIcon(charList.get(charNum));
			changeStats();
		}
		if (evt.getActionCommand().equals("Next")) {
			charNum++;
			if (charNum >= charList.size()) charNum = 0;
			System.out.println(charNum);
			currentChar.setIcon(charList.get(charNum));
			changeStats();
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
					scanner.next();
					plr.countPS = scanner.nextInt();
					plr.countPM = scanner.nextInt();
					plr.countPL = scanner.nextInt();
					loadFrame.dispose();
					mainGame.tfEventArea.setText("Player: " + plr.countPL + " loaded!");
					mainGame.makeScreen(roomNo);
					mainGame.setPlayer(plr);
					mainGame.room.add_above_components(roomNo);
					mainGame.enableButtons();
				} catch (Exception e) { System.out.println("ERROR");}
			}
		}
		if (evt.getActionCommand().equals("Close")) {
			//main.showScreen(0);
			loadFrame.dispose();
			mainGame.enableButtons();
		}
	}

	public void changeStats() {
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
			fileWriter.write("Room 1\n");
			fileWriter.write("Potions 1 0 0\n");
			fileWriter.write("Weapons\n");
			fileWriter.write("Key_Items\n");

			fileWriter.close();
		} catch (Exception e) {
			System.out.println("Exception caught."); // Prints if an error is found
		}
	} 

	public void saveFile(int x, int y, int width, int height, MainGUI game) {
		mainGame = game;
		saveFrame = new JFrame();

		saveFrame.getContentPane().setBackground(menuColor);
		saveFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		saveFrame.setBounds(x,y, width,height);
		saveFrame.getContentPane().setLayout(new BorderLayout());
		saveFrame.setResizable(false);
		saveFrame.setTitle("Save Game");

		lblSure = new JLabel("Are you sure you wish to Save?\n This will overwrite your current save."); 
		lblSure.setFont(fLabel); lblSure.setForeground(Color.WHITE); 
		lblSure.setBounds(width - lblSure.getWidth()/2, 10, lblSure.getWidth(), 60); saveFrame.add(lblSure);


		btnCancel = new JButton("Cancel"); btnCancel.setBounds(width/2, 28, 80, 30);
		btnCancel.addActionListener(this); saveFrame.add(btnCancel);


		dummyLabel = new JLabel("");
		saveFrame.add(dummyLabel);

		saveFrame.setVisible(true);
		saveFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		saveFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
	}

}
