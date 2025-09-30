
import java.util.Scanner;
import java.util.Random;




public class FinalProject {
    public static void main(String[] args) {

        Character wplayer = new Warrior("Warrior", 10, 10, 1, 1, 10, 10, 5);
        info(wplayer.toString());
        
        /*Character mplayer = new Mage("Mage", 10, 10, 1, 1, 10, 10, 5);
        check(mplayer);*/

        Character enemy = new Enemy("Goblin", 100, 100, 1, 1, 0, 0, 2);

        /*System.out.println(enemy.getXp());

        info(enemy.toString());
        System.out.println("--Testing player attacking enemy--");*/
        enemy.setHealth((enemy.getHealth() - damage(wplayer.stab(enemy.getDefense()), enemy.getDefense())));
        info(enemy.toString());
        /*enemy.setHealth((enemy.getHealth() + enemy.getDefense()) - wplayer.stab(enemy.getDefense()));
        info(enemy.toString());
        enemy.setHealth((enemy.getHealth() + enemy.getDefense()) - wplayer.Crush());
        info(enemy.toString());

        System.out.println("--Testing enemy attacking player--");
        wplayer.setHealth(wplayer.getHealth() - enemy.attack());
        info(wplayer.toString());

        wplayer.heal();
        wplayer.refill();
        info(wplayer.toString());
        wplayer.heal();
        wplayer.refill();

        /*Town town = new Town();

        System.out.println("\n--Testing Town Class--");
        town.setRep(99999);
        town.repChecker();
        town.setRep(-9999);
        town.repChecker();

        town.shop(null);
        System.out.println("\n--Testing Warrior Class--");
        info(wplayer.skills());

        System.out.println("\n--Testing Leveling Up--");
        info(wplayer.toString());
        wplayer.addxp(10);
        wplayer.levelup();
        info(wplayer.toString());*/
        


    }


    public static abstract class Character {
        protected String charName;
        protected int maxHealth;
        protected int strength;
        protected int intelligence;
        protected int mana;
        protected int maxMana;
        protected int defense;
        protected int health;
        protected int hPotion = 1;
        protected int mPotion = 1;
        protected int MAX = 5;
        protected int xp = 0;
        protected int gold = 0;
        protected int level = 1;
        
    

        public Character(String charName, int maxHealth, int health, int strength, int intelligence, int mana, int maxMana, int defense) {
            this.charName = charName;
            this.maxHealth = maxHealth;
            this.strength = strength;
            this.intelligence = intelligence;
            this.defense = defense;
            this.mana = mana;
            this.health = health;
            this.maxMana = maxMana;

        }

        public abstract int attack();

        public String toString() {
            return "Name: " + charName + "\nLevel: " + level +  "\nHealth: " + health + "/" + maxHealth + "\nStrength: " + strength + "\nIntelligence: " + intelligence + "\nMana: " + mana + "/" + maxMana + "\nDefense: " + defense;
        }

        public abstract String skills();

        public void setHealth(int health) {
            this.health = health;
            if (this.health > maxHealth) {
                this.health = maxHealth;
            }
        }

        public int getHealth() {
            return health;
        }

        public abstract int stab(int eDefense);
        public abstract int Crush();
        public abstract void Rage();
        public abstract void Drain(int eMana);
        public abstract int Ignite();
        public abstract void Destroy();
        public abstract int getXp();
        public abstract int getGold();

        public int getDefense() {
            return defense;
        }
        public void heal() {
            if (hPotion <= 0) {
                System.out.println("No health potions left!");
                return;
            }
            System.out.println("You used a health potion!");
            hPotion = hPotion - 1;
            this.health = maxHealth;
        }

        public void refill() {
            if (mPotion <= 0) {
                System.out.println("No mana potions left!");
                return;
            }
            System.out.println("You used a mana potion!");
            mPotion = mPotion - 1;
            this.mana = maxMana;
        }

        public void addhPot() {
            if (hPotion >= MAX) {
                System.out.println("You cant carry any more health potions!");
                return;
            }
            hPotion = hPotion + 1;
            System.out.println("You picked up a health potion! You now have " + hPotion + " health potions.");
        }

        public void addmPot() {
            if (mPotion >= MAX) {
                System.out.println("You cant carry any more mana potions!");
                return;
            }
            mPotion = mPotion + 1;
            System.out.println("You picked up a mana potion! You now have " + mPotion + " mana potions.");
        }

        public void addxp(int e) {this.xp = this.xp + e;}

        public abstract void levelup();



    }
    
    public static class Enemy extends Character {
        private int xpReward = strength + defense;
        private int goldReward = strength + maxHealth;

        public Enemy(String charName, int maxHealth, int health, int strength, int intelligence, int mana, int maxMana, int defense) {
            super(charName, maxHealth, health, strength, intelligence, mana, maxMana, defense);
        }

        public String skills() {
            return "The enemy has no special skills.";
        }

        public int attack()
        {
            System.out.println(charName + " attacks for " + strength + " damage!");
            return strength;
        }

        public int stab(int eDefense) {return 0;}
        public int Crush() {return 0;}
        public void Rage() {}
        public void Drain(int eMana) {}
        public int Ignite() {return 0;}
        public void Destroy() {}

        public String toString() {
            return "Name: " + charName + "\nHealth: " + health + "/" + maxHealth + "\nDamage: " + strength + "\nMana: " + mana + "/" + maxMana + "\nDefense: " + defense;
        }

        public int getXp() {
            return xpReward;
        }

        public int getGold() {
            return goldReward;
        }

        public void levelup() {}

        public void resetStats() {
            this.health = maxHealth;
            this.mana = maxMana;
        }
        

    }

    public static class Warrior extends Character {

        public Warrior(String charName, int maxHealth, int health, int strength, int intelligence, int mana, int maxMana, int defense) {
            super(charName, maxHealth, health, strength, intelligence, mana, maxMana, defense);
        }

        public String skills() {
            return "1. Stab (Cost: 2 Mana) - Ignores enemy defense\n2. Crush (Cost: 5 Mana) - Has a chance to deal 3x damage, or miss causing self damage\n3. Rage (Cost: 10 Mana) - Temporarily doubles defense and damage";
        }

        public int attack()
        {
            System.out.println(charName + " attacks for " + strength + " damage!");
            return strength;
        }

        //Level 1 special attack: Ignores defense Cost: 2 mana
        
        public int stab(int eDefense) {
            //Adds enemy defense to strength so it cancells out
            if (mana < 2) {
                System.out.println("Not enough mana to use Stab!");
                return 0;
            }
            System.out.println("Stab used! Ignoring enemy defense!");
            mana = mana - 2;
            return strength + eDefense;
        }

        //Level 10 special attack: Has a chance to deal 3x damage, or miss causing self damage cost 5 mana
        public int Crush() {
            Random random = new Random();
            if (mana < 5) {
                System.out.println("Not enough mana to use Crush!");
                return 0;
            }

            int chance = random.nextInt(9);
            mana = mana - 5;

            if (chance == 1 || chance == 3 || chance == 8) {
                System.out.println("Crush has landed!");
                return strength * 3;
            }
            else {
                health = health - strength;
                System.out.println("Crush has missed! You hit yourself doing " + strength + " damage!");
                return 0;
            }  
        
        }

        //Level 20 special attack: Temporarily doubles defense and damage Cost: 10 mana
        public void Rage() {
            //Implement
            if (mana < 10) {
                System.out.println("Not enough mana to use Rage!");
                return;
            }
            System.out.println("You are enraged! Strength and Defense doubled!");
            mana = mana - 10;
            strength = strength * 2;
            defense = defense * 2;

        }

        public void levelup() {
            int REQ = level * 10;
            //warrior
            if (xp >= REQ) {
            level = level + 1;
            maxHealth = maxHealth + 5;
            health = maxHealth;
            strength = strength + 2;
            intelligence = intelligence + 1;
            maxMana = maxMana + 2;
            mana = maxMana;
            defense = defense + 3;
            xp = xp - REQ;
            System.out.println("You leveled up! You are now level " + level + "!");
            toString();
            }
        }        

        public void Drain(int eMana) {}
        public int Ignite() {return 0;}
        public void Destroy() {}
        public int getXp() {return 0;}
        public int getGold() {return 0;}
        

    }

    public static class Mage extends Character {

        public Mage(String charName, int maxHealth, int health, int strength, int intelligence, int mana, int maxMana, int defense) {
            super(charName, maxHealth, health, strength, intelligence, mana, maxMana, defense);
        }

        public String skills() {
            return "1. Drain (Cost: 0 Mana) - Steals enemy mana\n2. Ignite (Cost: 5 Mana) - Sets enemy on fire dealing damage over time\n3. Destroy (Cost: 10 Mana) - Deal double damage for 5 turns";
        }

        public int attack()
        {
            System.out.println(charName + " attacks for " + intelligence + " damage!");
            return intelligence;
        }

        //Level 1 special attack: Steals enemy mana Cost: 0
        public void Drain(int eMana) {
            //Implement
            if (eMana <= 0) {
                System.out.println("Enemy has no mana to drain!");
                return;
            }
            System.out.println("Draining the enemy!");
            mana = mana + eMana;
        }

        //Level 10 special attack: Sets enemy on fire dealing damage over time Cost: 5
        public int Ignite() {
            //Inplement
            if (mana < 5) {
                System.out.println("Not enough mana to use Ignite!");
                return 0;
            }
            System.out.println("Igniting te enemy for 3 turns!"); 
            return intelligence + 2;
        }

        //Level 20 special attack: Deal double damage for 5 turns Cost: 10
        public void Destroy() {
            //Implement
            if (mana < 10) {
                System.out.println("Not enough mana to use Destroy!");
                return;
            }
            System.out.println("You feel the mana overflowing! Intelligence doubled for 5 turns!");
            mana = mana - 10;
            intelligence = intelligence * 2;
            
        }

        public void levelup() {
            int REQ = level * 10;
            //mage
            if (xp >= REQ) {
            level = level + 1;
            maxHealth = maxHealth + 3;
            health = maxHealth;
            strength = strength + 1;
            intelligence = intelligence + 3;
            maxMana = maxMana + 5;
            mana = maxMana;
            defense = defense + 1;
            xp = xp - REQ;
            System.out.println("You leveled up! You are now level " + level + "!");
            toString();
            }
        } 

        public int stab(int eDefense) {
            return 0;
        }

        public int Crush() {
            return 0;
        }

        public void Rage() {
        }
        public int getXp() {return 0;}
        public int getGold() {return 0;}
        
        

    }

    public static class Town {
        private int rep = 100;

        public void repChecker() {
            if (rep >= 100) {
                System.out.println("The townsfolk love you!");
            }
            else if (rep >= 80) {
                System.out.println("The townsfolk like you!");
            }
            else if (rep >= 50) {
                System.out.println("The townsfolk dont mind you!");
            }
            else if (rep >= 30) {
                System.out.println("The townsfolk dont like you!");
            }
            else if (rep <= 0) {
                System.out.println("The townsfolk hate you! They probably want you dead...");
            }
        }
        public void setRep(int num) {
            this.rep = num;
            System.out.println("rep = " + rep);
        }

        public void shop(Character player) {
            System.out.println("Welcome to the shop! What would you like to buy?\n1. Health Potion (Restores 10 health)\n2. Mana Potion (Restores 10 mana)\n3. Exit\n=>");
        }
        
    }

    public static class Weapon {
        private String name;
        private int damage;

        public Weapon(String name, int damage) {
            this.name = name;
            this.damage = damage;
        }
    }

    public void battle(Character player, Character enemy) {
        //Battle begins

        System.out.println(enemy.charName + "approaches! \n1. Attack\n2.Item\n3. Flee\n=>");
        Scanner choice = new Scanner(System.in);
        int input = choice.nextInt();
        switch (input) {
            case 1:
                int damage = player.attack();
                enemy.setHealth(enemy.getHealth() - damage);
                System.out.println(enemy.charName + " has " + enemy.getHealth() + " health remaining!");
                break;
            case 2:
                //Open inventory
                break;
            case 3:
                System.out.println("You fled the battle!");
                break;
            default:
                System.out.println("Invalid input, try again.");
                break;
        }

    }

    public static void info(String s) {
        System.out.println(s);
    }

    public static int damage(int pred, int prey) {

        int raw = 0;

        raw = pred - prey;

        if (raw < 0) {
            return 0;
        }
        return raw;
    }
}



