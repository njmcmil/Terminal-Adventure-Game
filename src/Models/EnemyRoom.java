package Models;

import java.sql.SQLOutput;

public class EnemyRoom extends AbsRoom
{
    private Enemy enemy;



    public EnemyRoom()
    {
        this.enemy = new Enemy("Goblin", 20, 5);
        displayDescription();
    }

    @Override
    public void displayDescription()
    {
        System.out.println("I hear something odd...");
        System.out.println("A " + enemy.getEnemyName() + " appears with " + enemy.getHealth() + " health!");
    }


    public void interact(Player player)
    {
        System.out.println("You pull out your sword for a duel!");
        while(player.getHealth() > 0 && !enemy.isDefeated())
        {
            System.out.println("You attack the " + enemy.getEnemyName());
            enemy.takeDamage(player.getAttackDamage());
            System.out.println(enemy.getEnemyName() + " health: " + enemy.getHealth());

            if(!enemy.isDefeated())
            {
                System.out.println("The " + enemy.getEnemyName() + " attacks you!");
                player.takeDamage(enemy.getDamage());
                System.out.println("Your health: " + player.getHealth());
            }
        }

        if(enemy.isDefeated())
        {
            System.out.println("You defeated the " + enemy.getEnemyName() + "!");
        }else
        {
            System.out.println("You were defeated...");
        }
    }
}
