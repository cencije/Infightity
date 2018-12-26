import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Joe on 6/18/16.
 */
public class PlayerList {
    Scanner reader = new Scanner(System.in);  // Reading from System.in

    ArrayList<Player> playerArrayList = new ArrayList<Player>();
    Player player;
    public void makePlayerList(int numberPlaying)
    {
        
    }
    public void printPlayerList()
    {
        for(int i = 0; i < playerArrayList.size(); i++) {
            System.out.println("Player " + (i + 1) + " name is = " + playerArrayList.get(i).name);
            System.out.println("Class is = " + playerArrayList.get(i).charClass);
        }
    }

    public ArrayList<Player> getPlayerList()
    {
        return playerArrayList;
    }
}
