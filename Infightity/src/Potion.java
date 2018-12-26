import javax.swing.ImageIcon;

public class Potion {

	int id, value, amtHeal, amtOwned;
	ImageIcon img;
	String name, info;
	public void Potion(int potionID, int heal) {
		id = potionID;
		amtHeal = heal;
		value = amtHeal * 10;
		if (id == 0) { 
			img = new ImageIcon("Images/Weapons/Wood.png"); 
			name = "Wood"; info = "Knock on it";
		}
		if (id == 1) { 
			img = new ImageIcon("Images/Weapons/Plastic.png"); 
			name = "Plastic"; info = "Bad for the environment";
		}
		if (id == 2) { 
			img = new ImageIcon("Images/Weapons/Stone.png"); 
			name = "Stone"; info = "Kinda heavy";
		}
		if (id == 3) { 
			img = new ImageIcon("Images/Weapons/Copper.png"); 
			name = "Copper"; info = "Pennies hurt";
		}
		if (id == 4) { 
			img = new ImageIcon("Images/Weapons/Iron.png"); 
			name = "Iron"; info = "Hard on wrinkles too";
		}
		if (id == 5) { 
			img = new ImageIcon("Images/Weapons/Steel.png"); 
			name = "Steel"; info = "Reliable and durable";
		}
		if (id == 6) { 
			img = new ImageIcon("Images/Weapons/PoisonTip.png"); 
			name = "Poison Tip"; info = "If swallowed: (800)-222-1222";
		}
		if (id == 7) { 
			img = new ImageIcon("Images/Weapons/BarbedTip.png"); 
			name = "Barbed Tip"; info = "Hurts a lot";
		}
	}
}
