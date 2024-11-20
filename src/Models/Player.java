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

    public void setHealth(int health)
    {
        this.health = health;
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

    public void useItem(int index)
    {
        if (index >= 0 && index < inventory.size()) {
            String item = inventory.get(index);
            // Handle item effects
            switch (item.toLowerCase()) {
                case "health potion":
                    System.out.println("You used a Health Potion and restored 20 health!");
                    setHealth(health + 20); // Restore 20 health
                    inventory.remove(index);
                    break;
                case "fireball":
                    System.out.println("You used a Fireball! Your next attack deals extra damage.");
                    attackDamage += 10; // Boost attack damage
                    inventory.remove(index);
                    break;
                case "tool sharpener":
                    System.out.println("You sharpened your tool! Restored weapon durability.");
                    attackDamage += 5;
                    inventory.remove(index);
                    break;
                default:
                    System.out.println("The item has no effect.");
                    break;
            }
        } else {
            System.out.println("Invalid inventory slot or no items available.");
        }
    }


    public void displayInventory()
    {
        System.out.println("Inventory: " + inventory);
    }




}
