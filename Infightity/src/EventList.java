import java.util.*;

/**
 * Created by Joe on 6/18/16.
 */
public class EventList {
    QuoteList quoteList = new QuoteList();

    ArrayList<Player> playerArrayList = new ArrayList<Player>();
    Scanner reader = new Scanner(System.in);  // Reading from System.in
    Random rand;

    public void givePlayerList(ArrayList<Player> pAList)
    {
        this.playerArrayList = pAList;
    }
    public void makeEnemies()
    {
        //enemyList.setEnemyList();
    }

    public void fight(int numPlayers, String enemyIntro, String enemyName, int enemyValue, int enemyDifficulty, String secondName)
    {
        rand = new Random(System.currentTimeMillis());
        System.out.println(quoteList.q50);
        System.out.println(enemyIntro);
        System.out.println("It's " + secondName + ".");

        /*Enemy enemy = enemyList.getEnemy(enemyValue);
        Enemy enemyTemp;
        enemyTemp = enemy;
        enemyTemp.setLevel(enemyDifficulty);
        enemyTemp.setName(enemyName);
        enemyTemp.setHealth(50, 50);
        enemyTemp.setSecondaryName(secondName);

        int killer = 0;

        ArrayList<Player> turnList = new ArrayList<Player>();

        //for (int i = 0; i < numPlayers; i++) {turnList.add(new Player());}
        for (int i = 0; i < numPlayers; i++)
        {
            System.out.println(quoteList.q8);
            System.out.println(playerArrayList.get(i).name + ", roll reaction time.");
            int rt = reader.nextInt();
            playerArrayList.get(i).reactionTime = rt;
            if (rt == 0) { playerArrayList.get(i).reactionWins++; }
            turnList.set(rt, playerArrayList.get(i));
        }

        while (!enemyTemp.isDead)
        {
            for (int i = 0; i <= (numPlayers-1); i++)
            {
                if (!enemyTemp.isDead)
                {
                    int damageDone;
                    for (int j = 0; j <= (numPlayers-1); j++)
                    {
                        System.out.println();
                        System.out.print("Name: " + playerArrayList.get(j).name);
                        System.out.print(" | Health: " + playerArrayList.get(j).currentHealth  + "/" + playerArrayList.get(j).maxHealth);
                        System.out.print(" | Armor: " + playerArrayList.get(j).armor + "/" + playerArrayList.get(j).maxArmor);
                    }
                    System.out.println();
                    System.out.println(turnList.get(i).name + "'s turn to act");
                    if (turnList.get(i).classChar == 1 ||
                            turnList.get(i).classChar == 2)
                    {
                        System.out.println("Damage done?");
                        System.out.println("Max possible damage = " + turnList.get(i).maxStrength);
                        damageDone = reader.nextInt();
                        enemyTemp.takeDamage(damageDone);
                        turnList.get(i).increaseTotalDamageDealt(damageDone);
                        killer = i;
                    }
                    else if (turnList.get(i).classChar == 3 || turnList.get(i).classChar == 5)
                    {
                        System.out.println("What do you wish to do?\n" +
                                            "(1 = Attack, 2 = Heal)");
                        System.out.println("Max possible damage = " + turnList.get(i).maxStrength);

                        System.out.println("Max heal = " +turnList.get(i).maxHeal);
                        int choice  = reader.nextInt();
                        if (choice == 1)
                        {
                            System.out.println("Damage done?");
                            damageDone = reader.nextInt();
                            enemyTemp.takeDamage(damageDone);
                            turnList.get(i).increaseTotalDamageDealt(damageDone);
                            killer = i;
                        }
                        else
                        {
                            System.out.println("Heal amount?");
                            int healAmount = reader.nextInt();
                            System.out.println("Heal who? (Enter player number from 0-" + (numPlayers-1) + ")");
                            int healChoice = reader.nextInt();
                            playerArrayList.get(healChoice).getHealed(healAmount);
                        }
                    }
                    else
                    {
                        System.out.println("What do you wish to do?\n" +
                                "(1 = Attack, 2 = Armor)");
                        System.out.println("Max possible damage = " + turnList.get(i).maxStrength);
                        System.out.println("Max armor = " + turnList.get(i).maxArmor);
                        int choice  = reader.nextInt();
                        if (choice == 1)
                        {
                            System.out.println("Damage done?");
                            damageDone = reader.nextInt();
                            enemyTemp.takeDamage(damageDone);
                            turnList.get(i).increaseTotalDamageDealt(damageDone);
                            killer = i;
                        }
                        else
                        {
                            System.out.println("Armor amount?");
                            int armorAmount = reader.nextInt();
                            System.out.println("Give armor to who? (Enter player number from 0-" + (numPlayers-1) + ")");
                            int armorChoice = reader.nextInt();
                            playerArrayList.get(armorChoice).getArmor(armorAmount);
                        }
                    }
                }
                else {break;}
            }
            int enemyatk = enemyTemp.attack();
            int attackedPlayer = rand.nextInt(numPlayers);
            playerArrayList.get(attackedPlayer).getHit(enemyatk);
            System.out.println(enemyTemp.name + " attacked " +
                                playerArrayList.get(attackedPlayer).name + " for " + enemyatk + " points.");
        }
        System.out.println("Finishing blow dealt by: " + turnList.get(killer).name);
        turnList.get(killer).increaseKillCount();
        System.out.println("Total Damage dealt:");
        for (int i = 0; i <= (numPlayers-1); i++)
        {
            System.out.println();
            System.out.println("Name: " + playerArrayList.get(i).name);
            System.out.print(" | Health: " + playerArrayList.get(i).currentHealth);
            System.out.print(" | Armor: " + playerArrayList.get(i).armor);
            System.out.print(" Damage Dealt: " + playerArrayList.get(i).dmgTotal);
            System.out.print(" | Reaction wins: " + playerArrayList.get(i).reactionWins);
            System.out.print(" | Total kills: " + playerArrayList.get(i).killTotal);
        }
        System.out.println();*/
    }

    public boolean persuasionCheck(int numPlayers, String npcIntro, String npcName, int pVal)
    {
        boolean passed = false;
        System.out.println(npcIntro);
        System.out.println("PERSUASIAON CHECK (" + pVal +"): Everyone roll dice values.");
        for (int i = 0; i < numPlayers; i++)
        {
            int rolledPVal = reader.nextInt();
            if (rolledPVal >= pVal) {
                passed = true;
                System.out.println("PASSED." + playerArrayList.get(i).name +
                    ", convince " + npcName + ".");
                break;
            }
        }
        return passed;
    }
}

