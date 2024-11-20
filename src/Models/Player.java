package Models;

import java.util.ArrayList;
import java.util.List;

public class Player implements IPlayer
{
    private int health;
    private int attackDamage;
    private List<String> inventory;

    public Player(int health, int attackDamage)
    {
        this.health = health;
        this.attackDamage = attackDamage;
        this.inventory = new ArrayList<>();
    }

    @Override
    public int getHealth()
    {
        return health;
    }

    @Override
    public void takeDamage(int damage)
    {
        health -= damage;
    }

    @Override
    public int getAttackDamage()
    {
        return attackDamage;
    }

    @Override
    public void addItem(String item)
    {
        inventory.add(item);
    }

    public void displayInventory()
    {
        System.out.println("Inventory: " + inventory);
    }




}
