

import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;


public class MultipleBounce extends Application {

    
    private Pane centerPane;
    private Text statusText;
    private Character player;

    @Override
    public void start(Stage primaryStage) {

    BorderPane root = new BorderPane();
    centerPane = new Pane();
    root.setCenter(centerPane);

    
    statusText = new Text("Create your character to begin!");
    statusText.setWrappingWidth(360); 

    
    showStartScreen();

    Scene scene = new Scene(root, 400, 300);
    primaryStage.setTitle("M5A3");
    primaryStage.setScene(scene);
    primaryStage.show();

   }

    //Create a character screen
    private void showStartScreen() {
        centerPane.getChildren().clear();

        Text prompt = new Text("Enter name and choose class:");
        TextField nameField = new TextField();
        nameField.setPromptText("Your name");

        RadioButton rbA = new RadioButton("Warrior");
        RadioButton rbB = new RadioButton("Mage");
        ToggleGroup group = new ToggleGroup();
        rbA.setToggleGroup(group);
        rbB.setToggleGroup(group);

        Button createBtn = new Button("Create Character");
        createBtn.setOnAction(e -> {
            String name = nameField.getText().trim();
            if (rbA.isSelected()) {
                statusText.setText("Welcome " + (name.isEmpty() ? "Stranger" : name) + " the Warrior!");
                player = new Warrior(name, 10, 10, 1, 1, 5, 5, 2);
                statusText.setFill(Color.RED);
                showMainMenu();
            } else if (rbB.isSelected()) {
                statusText.setText("Welcome " + (name.isEmpty() ? "Stranger" : name) + " the Mage!");
                player = new Mage(name, 8, 8, 1, 2, 10, 10, 1);
                statusText.setFill(Color.BLUE);
                showMainMenu();
            } else {
                statusText.setText("Please select a class.");
                statusText.setFill(Color.BLACK);
            }
        });

        VBox startScreen = new VBox(8, prompt, nameField, new HBox(10, rbA, rbB), createBtn, statusText);
        startScreen.setPadding(new Insets(12));
        centerPane.getChildren().add(startScreen);
    }

    //Main menu
    private void showMainMenu() {
        centerPane.getChildren().clear();

        

        Button adv = new Button("Adventure");
        adv.setOnAction(e -> {
            statusText.setText("You venture forth...");
            battleScreen();
            /*player.addxp(10);
            if (player.xp >= player.level * 10) {
                player.levelup();
                statusText.setText("You leveled up! You are now level " + player.level + "!");
            }*/
            
            
        });

        Button chck = new Button("Check Stats");
        chck.setOnAction(e -> {
            statusText.setText(player.toString());
        });

        Button shp = new Button("Shop");
        shp.setOnAction(e -> {
            showShop();
        });

        Button back = new Button("Quit");
        back.setOnAction(e -> System.exit(0));

        VBox menu = new VBox(10, statusText, adv, chck, shp, back);
        menu.setPadding(new Insets(12));
        centerPane.getChildren().add(menu);

        if (player.level > 20) {
            statusText.setText("Congratulations! You have reached the maximum level and completed the game!");
            return;
        }
    }

    private void showShop() {
         centerPane.getChildren().clear();

         statusText.setText("Welcome to the shop! \nGold: " + player.gold);

        Button adv = new Button("Health Potion - 10 Gold");
        adv.setOnAction(e -> {
            if (player.gold < 10) {
                statusText.setText("Not enough gold! \nGold: " + player.gold);
                return;
            }
            else if (player.hPotion >= player.MAX) {
                statusText.setText("You can't carry any more health potions! \nGold: " + player.gold);
                return;
            }
            player.gold -= 10;
            player.addhPot();
            statusText.setText("You bought the Health Potion! You have " + player.hPotion + " health potions. \nGold: " + player.gold);
            
        });

        Button chck = new Button("Mana Potion - 8 Gold \nGold: " + player.gold);
        chck.setOnAction(e -> {
            if (player.gold < 8) {
                statusText.setText("Not enough gold! \nGold: " + player.gold);
                return;
            }
            else if (player.mPotion >= player.MAX) {
                statusText.setText("You can't carry any more Mana potions! \nGold: " + player.gold);
                return;
            }
            player.gold -= 8;
            player.addmPot();
            statusText.setText("You bought the Mana Potion! You have " + player.mPotion + " mana potions. \nGold: " + player.gold);
        });

        Button back = new Button("Back");
        back.setOnAction(e -> {
            showMainMenu();
        });

        VBox shopLayout = new VBox(10, statusText, adv, chck, back);
        shopLayout.setPadding(new Insets(12));
        centerPane.getChildren().add(shopLayout);
    }

    private void battleScreen() {
        centerPane.getChildren().clear();

        Character enemy;

        enemy = new Enemy("Goblin", 6, 6, 1, 0, 0, 0, 1);

        Button atk = new Button("attack");
        atk.setOnAction(e -> {
            
            
        });

        Button chck = new Button("Check Enemy");
        chck.setOnAction(e -> {
            statusText.setText(enemy.toString());
        });

        Button itm = new Button("Item");
        itm.setOnAction(e -> {
            itemScreen();
        });

        Button flee = new Button("Flee");
        flee.setOnAction(e -> {
            Random random = new Random();

            int fleeChance = random.nextInt(3);
            if (fleeChance == 1) {
                statusText.setText("You failed to flee!");
                return;
            }
            statusText.setText("You fled the battle!");
            showMainMenu();
        });

        VBox menu = new VBox(10, statusText, atk, chck, itm, flee);
        menu.setPadding(new Insets(12));
        centerPane.getChildren().add(menu);


    }
    
    private void itemScreen() {
        centerPane.getChildren().clear();


        Button hp = new Button("Health Potion - " + player.hPotion + " left");
        hp.setOnAction(e -> {
            player.heal();
            statusText.setText("You used a health potion! Health restored to max!");
            battleScreen();
            
        });

        Button mp = new Button("Mana Potion - " + player.mPotion + " left");
        mp.setOnAction(e -> {
            player.refill();
            statusText.setText("You used a mana potion! Mana restored to max!");
            battleScreen();
        });

        Button back = new Button("Back");
        back.setOnAction(e -> {
            battleScreen();
        });

        

        VBox menu = new VBox(10, statusText, hp, mp, back);
        menu.setPadding(new Insets(12));
        centerPane.getChildren().add(menu);


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
        protected int gold = 100;
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