import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import acm.util.MediaTools;

public class Inventory extends JPanel implements ActionListener {
	private MainGUI mainGame;
	JFrame mainFrame;
	Color menuColor = new Color(52, 63, 71);
	Player plr;
	
	Font fHead = new Font("Serif", Font.BOLD, 16); Font fStat = new Font("Serif", Font.BOLD, 12);
	JLabel lblChoose,lblChar, lblDummy;
	JLabel lblPS, lblPM, lblPL, lblS, lblA, lblR, lblW, lblP;
	JLabel lblHealth, lblStr, lblArm, lblReact, lblWis, lblPer;
	JButton btnExit;
	ImageIcon imgPlayer;
	boolean invFrameUp = false;
	
	public void openInventory(int x, int y, int width, int height, int charClass, Player p, MainGUI game) {
		plr = p;
		mainGame = game;
		mainGame.btnNG.setEnabled(false); mainGame.btnSG.setEnabled(false); mainGame.btnLS.setEnabled(false);
		mainGame.btnINV.setEnabled(false); mainGame.btnQuit.setEnabled(false);
		invFrameUp = true;
		mainFrame = new JFrame();
		
		mainFrame.getContentPane().setBackground(menuColor);
		mainFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		mainFrame.setBounds(x,y, width,height);
		mainFrame.getContentPane().setLayout(new BorderLayout());
		mainFrame.setResizable(false);
		mainFrame.setTitle("Inventory");
		
 	    
 	    
		if (charClass == 0) imgPlayer = new ImageIcon("../Images/Profiles/Player/Archer1.png");
		if (charClass == 1) imgPlayer = new ImageIcon("../Images/Profiles/Player/Archer2.png");
		if (charClass == 2) imgPlayer = new ImageIcon("../Images/Profiles/Player/Archer3.png");
		if (charClass == 3) imgPlayer = new ImageIcon("../Images/Profiles/Player/Spearman1.png");
		if (charClass == 4) imgPlayer = new ImageIcon("../Images/Profiles/Player/Spearman2.png");
		if (charClass == 5) imgPlayer = new ImageIcon("../Images/Profiles/Player/Spearman3.png");
		if (charClass == 6) imgPlayer = new ImageIcon("../Images/Profiles/Player/Wizard1.png");
		if (charClass == 7) imgPlayer = new ImageIcon("../Images/Profiles/Player/Wizard2.png");
		if (charClass == 8) imgPlayer = new ImageIcon("../Images/Profiles/Player/Wizard3.png");
		if (charClass == 9) imgPlayer = new ImageIcon("../Images/Profiles/Player/Knight1.png");
		if (charClass == 10) imgPlayer = new ImageIcon("../Images/Profiles/Player/Knight2.png");
		if (charClass == 11) imgPlayer = new ImageIcon("../Images/Profiles/Player/Knight3.png");
		if (charClass == 12) imgPlayer = new ImageIcon("../Images/Profiles/Player/Skeleton1.png");
		JLabel lblTitle = new JLabel("Current Inventory"); lblTitle.setBounds((width/2) - 57, 5, 130, 20); 
		lblTitle.setFont(fHead);  lblTitle.setForeground(Color.WHITE); mainFrame.add(lblTitle);
 	    lblChar = new JLabel(imgPlayer); lblChar.setBounds(1, 1, 80, 80); mainFrame.add(lblChar);
 	    lblHealth = new JLabel("HP: " + plr.currentHealth + " / " + plr.maxHealth); lblHealth.setBounds(200, 30, 100, 30); 
 	    lblHealth.setFont(fStat); lblHealth.setForeground(Color.WHITE); mainFrame.add(lblHealth);
 	    
 	    lblStr = new JLabel("Strength: " + plr.strength + " / " + plr.maxStrength); lblStr.setBounds(135, 70, 170, 30); 
 	    lblStr.setFont(fStat); lblStr.setForeground(Color.WHITE); mainFrame.add(lblStr);
	    lblArm = new JLabel("Armor: " + plr.armor + " / " + plr.maxArmor); lblArm.setBounds(135, 110, 170, 30); 
	    lblArm.setFont(fStat); lblArm.setForeground(Color.WHITE); mainFrame.add(lblArm);
 	    lblReact = new JLabel("Reaction Time: " + plr.react + " / " + plr.maxReactionTime); lblReact.setBounds(135, 150, 170, 30); 
 	    lblReact.setFont(fStat); lblReact.setForeground(Color.WHITE); mainFrame.add(lblReact);
	    lblWis = new JLabel("Wisdom: " + plr.wisdom + " / " + plr.maxWisdom); lblWis.setBounds(135, 190, 170, 30); 
	    lblWis.setFont(fStat); lblWis.setForeground(Color.WHITE); mainFrame.add(lblWis);
 	    lblPer = new JLabel("Persuasion: " + plr.persuasion + " / " + plr.maxPersuasion); lblPer.setBounds(135, 230, 170, 30); 
 	    lblPer.setFont(fStat); lblPer.setForeground(Color.WHITE); mainFrame.add(lblPer);
 	    btnExit = new JButton("Exit"); btnExit.setBounds(1, 240, 80, 30 ); btnExit.addActionListener(this); mainFrame.add(btnExit);
 	    try {
 			/*File soundFile = new File("Sounds/Potion_Use2.wav"); //you could also get the sound file with an URL
 	        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
 	       // Get a sound clip resource.
 	       Clip clip = AudioSystem.getClip();
 	       // Open audio clip and load samples from the audio input stream.
 	       clip.open(audioIn);*/
 	       
 	      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("../Sounds/Potion_Use2.wav"));
          AudioFormat af                    = audioInputStream.getFormat();
          int size                          = (int) (af.getFrameSize() * audioInputStream.getFrameLength());
          byte[] audio                      = new byte[size];
          DataLine.Info info                = new DataLine.Info(Clip.class, af, size);
          audioInputStream.read(audio, 0, size);
 	 	      
 	    lblPS = new JLabel(new ImageIcon("../Images/Items/Potion1_Small.png")); lblPS.setBounds(90, 30, 32, 32); mainFrame.add(lblPS);
 	    lblPS.addMouseListener(new MouseAdapter() { public void mouseClicked(MouseEvent e) {
 	    	if (plr.countPS > 0 && (plr.currentHealth != plr.maxHealth)) {
 	    		plr.countPS--; plr.currentHealth = plr.currentHealth + (plr.maxHeal / 5);
 	    		if (plr.currentHealth > plr.maxHealth) plr.currentHealth = plr.maxHealth;
 	    		lblHealth.setText("HP: " + plr.currentHealth + " / " + plr.maxHealth);
 	    		try {
 	    		Clip clip = (Clip) AudioSystem.getLine(info);
 	            clip.open(af, audio, 0, size);
 	            clip.start();
 	    		} catch (Exception f) {}
 	    		mainGame.spr.showHealthBar();
 	    	}}});
 	    lblPM = new JLabel(new ImageIcon("../Images/Items/Potion2_Medium.png")); lblPM.setBounds(125, 30, 32, 32); mainFrame.add(lblPM);
	    lblPM.addMouseListener(new MouseAdapter() { public void mouseClicked(MouseEvent e) {
	    	if (plr.countPM > 0 && (plr.currentHealth != plr.maxHealth)) {
 	    		plr.countPM--; plr.currentHealth = plr.currentHealth + (plr.maxHeal / 2);
 	    		if (plr.currentHealth > plr.maxHealth) plr.currentHealth = plr.maxHealth;
 	    		lblHealth.setText("HP: " + plr.currentHealth + " / " + plr.maxHealth);
 	    		try {
 	 	    		Clip clip = (Clip) AudioSystem.getLine(info);
 	 	            clip.open(af, audio, 0, size);
 	 	            clip.start();
 	 	    		} catch (Exception f) {}
 	    		mainGame.spr.showHealthBar();
 	    	}}});
	    lblPL = new JLabel(new ImageIcon("../Images/Items/Potion3_Large.png")); lblPL.setBounds(160, 30, 32, 32); mainFrame.add(lblPL);
 	    lblPL.addMouseListener(new MouseAdapter() { public void mouseClicked(MouseEvent e) {
 	    	if (plr.countPL > 0 && (plr.currentHealth != plr.maxHealth)) {
 	    		plr.countPL--; plr.currentHealth = plr.currentHealth + plr.maxHeal;
 	    		if (plr.currentHealth > plr.maxHealth) plr.currentHealth = plr.maxHealth;
 	    		lblHealth.setText("HP: " + plr.currentHealth + " / " + plr.maxHealth);
 	    		try {
 	 	    		Clip clip = (Clip) AudioSystem.getLine(info);
 	 	            clip.open(af, audio, 0, size);
 	 	            clip.start();
 	 	    		} catch (Exception f) {}
 	    		mainGame.spr.showHealthBar();
 	    	}}});
 	    lblS = new JLabel(new ImageIcon("../Images/Items/Potion4_Strength.png")); lblS.setBounds(90, 70, 32, 32); mainFrame.add(lblS);
	    lblS.addMouseListener(new MouseAdapter() { public void mouseClicked(MouseEvent e) {
	    	if (plr.countStr > 0 && (plr.strength < ((int)Math.ceil((plr.maxStrength * 1.25))))) {
 	    		plr.countStr--; plr.strength = (int) Math.ceil(plr.maxStrength * 1.25);
 	    		lblStr.setText("Strength: " + plr.strength + " / " + plr.maxStrength);
 	    		try {
 	 	    		Clip clip = (Clip) AudioSystem.getLine(info);
 	 	            clip.open(af, audio, 0, size);
 	 	            clip.start();
 	 	    		} catch (Exception f) {}
 	    	}}});
	    lblA = new JLabel(new ImageIcon("../Images/Items/Potion5_Armor.png")); lblA.setBounds(90, 110, 32, 32); mainFrame.add(lblA);
	    lblA.addMouseListener(new MouseAdapter() { public void mouseClicked(MouseEvent e) {
	    	if (plr.countArm > 0 && (plr.armor < plr.maxArmor)) {
 	    		plr.countArm--; plr.armor = plr.maxArmor;
 	    		lblArm.setText("armor: " + plr.armor + " / " + plr.maxArmor);
 	    		try {
 	 	    		Clip clip = (Clip) AudioSystem.getLine(info);
 	 	            clip.open(af, audio, 0, size);
 	 	            clip.start();
 	 	    		} catch (Exception f) {}
 	    	}}});
	    lblR = new JLabel(new ImageIcon("../Images/Items/Potion6_React.png")); lblR.setBounds(90, 150, 32, 32); mainFrame.add(lblR);
	    lblR.addMouseListener(new MouseAdapter() { public void mouseClicked(MouseEvent e) {
	    	if (plr.countReact > 0 && (plr.react < ((int)Math.ceil((plr.maxReactionTime * 1.25))))) {
 	    		plr.countReact--; plr.react = (int) Math.ceil(plr.maxReactionTime * 1.25);
 	    		lblReact.setText("Reaction Time: " + plr.react + " / " + plr.maxReactionTime);
 	    		try {
 	 	    		Clip clip = (Clip) AudioSystem.getLine(info);
 	 	            clip.open(af, audio, 0, size);
 	 	            clip.start();
 	 	    		} catch (Exception f) {}
 	    	}}});
	    lblW = new JLabel(new ImageIcon("../Images/Items/Potion7_Wisdom.png")); lblW.setBounds(90, 190, 32, 32); mainFrame.add(lblW);
	    lblW.addMouseListener(new MouseAdapter() { public void mouseClicked(MouseEvent e) {
	    	if (plr.countWis > 0 && (plr.wisdom < ((int)Math.ceil((plr.maxWisdom * 1.25))))) {
 	    		plr.countWis--; plr.wisdom = (int) Math.ceil(plr.maxWisdom * 1.25);
 	    		lblWis.setText("Wisdom: " + plr.wisdom + " / " + plr.maxWisdom);
 	    		try {
 	 	    		Clip clip = (Clip) AudioSystem.getLine(info);
 	 	            clip.open(af, audio, 0, size);
 	 	            clip.start();
 	 	    		} catch (Exception f) {}
 	    	}}});
	    lblP = new JLabel(new ImageIcon("../Images/Items/Potion8_Persuasion.png")); lblP.setBounds(90, 230, 32, 32); mainFrame.add(lblP);
	    lblP.addMouseListener(new MouseAdapter() { public void mouseClicked(MouseEvent e) {
	    	if (plr.countPer > 0 && (plr.persuasion < ((int)Math.ceil((plr.maxPersuasion * 1.25))))) {
 	    		plr.countPer--; plr.persuasion = (int) Math.ceil(plr.maxPersuasion * 1.25);
 	    		lblPer.setText("Persuasion: " + plr.persuasion + " / " + plr.maxPersuasion);
 	    		try {
 	 	    		Clip clip = (Clip) AudioSystem.getLine(info);
 	 	            clip.open(af, audio, 0, size);
 	 	            clip.start();
 	 	    		} catch (Exception f) {}
 	    	}}});
 	   	} catch (Exception e) { System.out.println("Error boys");}
 	    lblDummy = new JLabel(""); mainFrame.add(lblDummy);
 	    mainFrame.setVisible(true);
 	    mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
 	    //mainFrame.setUndecorated(true);
 	    mainFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
 	    
 	    
    	 
    }
	public void actionPerformed(ActionEvent evt) {
		 if (evt.getActionCommand().equals("Exit")) {
			 mainFrame.dispose();
			 mainGame.btnNG.setEnabled(false); mainGame.btnSG.setEnabled(true); mainGame.btnLS.setEnabled(false);
			 mainGame.btnINV.setEnabled(true); mainGame.btnQuit.setEnabled(true);
			 invFrameUp = false;
		 }
	}
	
	public void mouseClicked(MouseEvent e) {
	      
	    }
}
