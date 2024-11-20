package Models;

import java.sql.SQLOutput;
import java.util.Scanner;

public class EnemyRoom extends AbsRoom
{
    private Enemy enemy;



    public EnemyRoom()
    {
        this.enemy = new Enemy("Goblin", 20, 5);
    }
    @Override
    public void displayDescription()
    {
        System.out.println("\n\nI hear something odd...");
        System.out.println("A " + enemy.getEnemyName() + " appears with " + enemy.getHealth() + " health!\n");
    }

    @Override
    public void leaveCheck(Player player)
    {
        System.out.println("Would you like to leave this room? Y or I for item use.");
        Scanner scanner0 = new Scanner(System.in);
        String answer = scanner0.nextLine();

        if(answer.equalsIgnoreCase("Y"))
        {
            System.out.println("You leave the enemy room.");

        }else if (answer.equalsIgnoreCase("I"))
        {
            player.displayInventory();
            System.out.println("Which item would you like to use (0-X): ");
            Scanner scanner1 = new Scanner(System.in);
            int answerIndex = scanner1.nextInt();
            player.useItem(answerIndex);
            System.out.println("You leave the enemy room.");
        }
    }





    public void interact(Player player)
    {
        System.out.println("You pull out your sword for a duel!");

        //battle
        while(player.getHealth() > 0 && !enemy.isDefeated())
        {
            System.out.println("\nWould you like to attack the enemy? Y or N || I for using an item.");
            player.displayInventory();
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();

            if(answer.equalsIgnoreCase("I"))
            {
                System.out.println("Type the inventory index (0-X): ");
                int answerIndex = scanner.nextInt();
               player.useItem(answerIndex);
            } else if(answer.equalsIgnoreCase("Y"))
            {
                System.out.println("You attack the " + enemy.getEnemyName());
                enemy.takeDamage(player.getAttackDamage());
                System.out.println(enemy.getEnemyName() + " health: " + enemy.getHealth());
            }else if(answer.equalsIgnoreCase("N"))
            {
                System.out.println("You chose not to attack the enemy.");
            }

            if(!enemy.isDefeated())
            {
                System.out.println("\nThe " + enemy.getEnemyName() + " attacks you!");
                player.takeDamage(enemy.getDamage());
                System.out.println("Your health: " + player.getHealth());
            }
        }

        if(enemy.isDefeated())
        {
            System.out.println("\nYou defeated the " + enemy.getEnemyName() + "!");
            leaveCheck(player);
        }else
        {
            System.out.println("You were defeated...");
        }
    }
}
