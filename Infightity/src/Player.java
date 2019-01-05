import acm.graphics.GImage;

/**
 * Created by Joe on 6/18/16.
 */
public class Player {

    String name;
    int maxWisdom, maxPersuasion, maxStrength, maxReactionTime, maxHeal, maxArmor;
    double startS, startA, startH, startR, startW, startP;
    int classChar, level, expCurrent, expNeeded;
    int strength, armor, react, wisdom, persuasion;
    int maxHealth, currentHealth;
    int reactionTime;
    int reactionWins = 0, killTotal = 0, dmgTotal = 0, timesDied = 0;
    int countPS, countPM, countPL, countStr, countArm, countReact, countWis, countPer;
    int goldAmount = 25;
    String charClass;
    double pX = 0, pY = 0;
 
    // Unchangeable
    public void setName(String pName) { this.name = pName; }
    public void setClass(int classNo) {
        this.classChar = classNo;
        setAttributes();
    }
    
    public void setRT(int rt) {this.reactionTime = rt;}
    public void increaseReactionWins() { this.reactionWins = reactionWins + 1;}
    public void increaseKillCount() {this.killTotal = killTotal + 1;}
    public void increaseTotalDamageDealt(int dmg) {this.dmgTotal = dmgTotal + dmg;}

    // Affected Attributes
    public void setHealth(int health) {
        this.maxHealth = health; this.currentHealth = maxHealth;
    }

    // Skills
    public void setAttributes()
    {
    	//countArm = 2; countPS = 5; countPM = 5; countPL = 5;
        currentHealth = 20; maxHealth = 20;
        if (classChar <= 2) { // 40
            charClass = "Archer";
            maxStrength = 8; armor = 6;  maxArmor = 6; maxHeal = 6;
            maxReactionTime = 7; maxWisdom = 7; maxPersuasion = 6;  
            startS = 8; startA = 6; startH = 6; startR = 7; startW = 7; startP = 6;
        }
        else if (classChar >= 3 && classChar <= 5) { // 40
            charClass = "Spearman"; maxStrength = 9; armor = 8; maxArmor = 8;
            maxHeal = 4; maxReactionTime = 7; maxWisdom = 5; maxPersuasion = 7;   
            startS = 9; startA = 8; startH = 4; startR = 7; startW = 5; startP = 7;
        }
        else if (classChar >= 6 && classChar <= 8) { //40
            charClass = "Wizard";
            maxStrength = 8; armor = 2; maxArmor = 2; maxHeal = 9;
            maxReactionTime = 3; maxWisdom = 10; maxPersuasion = 8;   
            startS = 8; startA = 2; startH = 9; startR = 3; startW = 10; startP = 8;
        }
        else if (classChar >= 9 && classChar <= 11) { // 40
            charClass = "Knight";
            maxStrength = 10; armor = 9; maxArmor = 9; maxHeal = 1;
            maxReactionTime = 6;  maxWisdom = 5; maxPersuasion = 9; 
            startS = 10; startA = 9; startH = 1; startR = 6; startW = 5; startP = 9;
        }
        else if (classChar == 12) { // 40
            charClass = "Skeleton";
            maxStrength = 8; armor = 4;  maxArmor = 4; maxHeal = 8;
            maxReactionTime = 9; maxWisdom = 6; maxPersuasion = 5;
            startS = 8; startA = 4; startH = 8; startR = 9; startW = 6; startP = 5;
        }
        expNeeded = 150;
    }

    public void getHit(int enemyatk) {
        if (armor != 0) {
            if (armor - enemyatk > 0) {
                this.armor = armor - enemyatk;
                System.out.println(name + "'s armor = " + armor);
            }
            if (armor - enemyatk <= 0) {
                this.armor = armor - enemyatk;
                System.out.println(name + "'s armor has depleted!");
                if (armor < 0) {
                    int leftoverAtk = 0 - armor;
                    currentHealth = currentHealth - leftoverAtk;
                    System.out.println(name + " took " + leftoverAtk + " leftover damage.");
                    armor = 0;
                }
            }
        }
        else {
            currentHealth = currentHealth - enemyatk;
            if (currentHealth <= 0) {
                timesDied++;
                setAttributes();
                setHealth(maxHealth);
            }
        }
    }

    public void getHealed(int healAmount) {
        if (currentHealth + healAmount <= maxHealth)  {
            currentHealth = currentHealth + healAmount;
            System.out.println(name + " healed for " + healAmount + " points.");
        }
        else {
            currentHealth = currentHealth + healAmount;
            int leftover = currentHealth - maxHealth;
            int healedAmount = healAmount - leftover;
            System.out.println(name + " healed for " + healedAmount + " points.");
            currentHealth = maxHealth;
        }
    }
    public void getArmor(int armorAmount) {
        if (armor + armorAmount <= maxArmor) {
            armor = armor + armorAmount;
            System.out.println(name + " gained " + armorAmount + " armor.");

        }
        else {
            armor = armor + armorAmount;
            int leftover = armor - maxArmor;
            int armoredAmt = armorAmount - leftover;
            System.out.println(name + " gained " + armoredAmt + " armor.");
            armor = maxArmor;
        }
    }
    public double getHealthPercentage() {
    	//System.out.println("C: " + currentHealth + " M: " + maxHealth);
    	double percentageHealth = (double)currentHealth / maxHealth;
    	//System.out.println("%: " + percentageHealth);
    	return percentageHealth;
    }
    public void setGoldAmount(int varGold) {
        this.goldAmount = this.goldAmount + varGold;
        if (this.goldAmount < 0) {this.goldAmount = 0;}
    }
    
    public void checkLevel(int expEarned) {
    	expCurrent += expEarned;
    	if (expCurrent >= expNeeded) levelUp(1);
    }
    public void levelUp(int times) {
    	
    	for (int i = 1; i < times; i++) {
    		currentHealth += 10; maxHealth+= 10;
    		//int total = maxStrength + maxArmor + maxHeal + maxReactionTime + maxWisdom + maxPersuasion;
    		maxStrength = maxStrength + (int)Math.ceil((((startS) / 10) * startS));
	    	maxArmor = maxArmor + (int)Math.ceil((((startA) / 10) * startA));
	    	maxHeal =  maxHeal + (int)Math.ceil((((startH) / 10) * startH));
	    	maxReactionTime = maxReactionTime + (int)Math.ceil((((startR) / 10) * startR));
	    	maxWisdom = maxWisdom + (int)Math.ceil((((startW) / 10) * startW));
	    	maxPersuasion = maxPersuasion + (int)Math.ceil((((startP) / 10) * startP));

	    	System.out.println("Level: " + i + " Exp: " + expNeeded + " Health: " + maxHealth);
	    	
	    	expNeeded = expNeeded + (expNeeded / 15);
	    	System.out.println("Str: " + maxStrength + " Arm: " + maxArmor + " Heal: " + maxHeal + " React: " + maxReactionTime + " Wis: " + maxWisdom + " Per: " + maxPersuasion);
    	}
    	
    }
    public int levelSet(int le) {
    	int expTotal = 150;
    	for (int i = 1; i < le; i++) {
			System.out.print("Level: " + i + " ");
			System.out.println("Exp: " + expTotal);
			expTotal = expTotal + (expTotal / 15);
		}
    	return expTotal;
    }
    public void setStats(int lev, int cls, int str, int arm, int he, int wis, int re, int per, int exp) {
    	level = lev; classChar = cls; maxStrength = str; maxArmor = arm;
    	maxHeal = he; maxWisdom = wis; maxReactionTime = re; maxPersuasion = per;
    	expCurrent = exp;
    	expNeeded = levelSet(lev);
    }
    
    
    
}
