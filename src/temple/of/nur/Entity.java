/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package temple.of.nur;

/**
 *
 * @author Abulele
 */
public class Entity {

    public String Name;
    public int Level = 0;
    public int Balance = 0;//# of coins
    public int x;
    public int y;
    public int width;
    public int height;
    public int speed = 3;
    public Statistic Vitality = new Statistic("Vitality", 8);
    public Statistic Arcana = new Statistic("Arcana", 8);
    public Statistic Attack = new Statistic("Attack", 8);
    public Statistic Intelligence = new Statistic("Intelligence", 8);
    public Statistic Defense = new Statistic("Defense", 8);
    public Statistic Luck = new Statistic("Luck", 8);
    public Inventory Inventory;
    public Status[] StatusSlots;

    public Entity(String Name, int x, int y, int width, int height) {
        this.Name = Name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}

class Player extends Entity {

    public String Password;
    public Denomination Denomination;

    public Player(String Name, String Password, Denomination Denomination) {
        super(Name, 0, 0, 50, 50);
        this.Name = Name;
        this.Password = Password;
        this.Denomination = Denomination;
    }
    public void DisplayPlayerInformation(){
        System.out.printf("=".repeat(30)+"\nName: "+this.Name
                +"\n"+"=".repeat(30)
                +"\nLevel: "+this.Level
                +"\nDenomination: "+this.Denomination
                +"\nBalance: "+ this.Balance
                +"\n"+"=".repeat(30)
                +"\nStatistics: \n"+"=".repeat(30)
                +"\n"+this.Vitality.Name+": " +this.Vitality.Amount
                +"\n"+this.Arcana.Name+": " +this.Arcana.Amount
                +"\n"+this.Attack.Name+": " +this.Attack.Amount
                +"\n"+this.Intelligence.Name+": " +this.Intelligence.Amount
                +"\n"+this.Defense.Name+": " +this.Defense.Amount
                +"\n"+this.Luck.Name+": " +this.Luck.Amount
                +"\n"+"=".repeat(30)+"\n"
                );
    }
}

enum Denomination {
    Mage,
    Gish,
    Knight,
    Barbarian
}
