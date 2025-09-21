package JavaFinalProject;
import java.util.Scanner;

public class FinalProject {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("What class would you like?\n1. Warrior\n2. Mage\n=>");
        int choice = -1;
        choice = input.nextInt();
        input.nextLine();

        System.out.print("What is your characters name?\n=>");
        String pName;
        pName = input.nextLine();

        switch (choice) {
            case 1:
                Character player = new Warrior(pName, 10, 10, 10, 10, 10);
                break;
            case 2:
                Character player = new Mage(pName, 10, 10, 10, 10, 10);
                break;
        }
        


    }


    public abstract class Character {
        protected String charName;
        protected int maxHealth;
        protected int strength;
        protected int intelligence;
        protected int mana;
        protected int defense;
        protected int health;

        public Character(String charName, int maxHealth, int health, int strength, int intelligence, int mana, int defense) {
            this.charName = charName;
            this.maxHealth = maxHealth;
            this.strength = strength;
            this.intelligence = intelligence;
            this.defense = defense;
            this.mana = mana;
            health = maxHealth;
        }

        public int attack()
        {
            return strength;
        }
    }

    public class Warrior extends Character {

        public Warrior(String charName, int maxHealth, int health, int strength, int intelligence, int mana, int defense) {
            super(charName, maxHealth, health, strength, intelligence, mana, defense);
        }

        //Level 1 special attack: Ignores defense
        public int stab() {
            //Implement
            return strength;
        }

        //Level 10 special attack: Has a chance to deal 3x damage, or miss causing self damage
        public int Crush() {
            //Inplement 
            return strength;
        }

        //Level 20 special attack: Temporarily raises all stats 
        public int Rage() {
            //Implement
            return strength;
        }

    }

    public class Mage extends Character {

        public Mage(String charName, int maxHealth, int health, int strength, int intelligence, int mana, int defense) {
            super(charName, maxHealth, health, strength, intelligence, mana, defense);
        }

        //Level 1 special attack: Steals enemy mana
        public int Drain() {
            //Implement
            return intelligence;
        }

        //Level 10 special attack: Sets enemy on fire dealing damage over time 
        public int Ignite() {
            //Inplement 
            return intelligence;
        }

        //Level 20 special attack: Gives 100% critical chance  
        public int Destroy() {
            //Implement
            return intelligence;
        }

    }

    public void battle() {
        //Battle begins

        System.out.println("|Enemy Name Here| Approaches! \n1. Attack\n2.Item\n3. Flee\n=>");

    }
}



