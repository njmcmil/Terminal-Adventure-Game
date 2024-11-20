package Models;

import java.util.Random;
import java.util.Scanner;

public class TrapRoom extends AbsRoom
{


    @Override
    public void displayDescription()
    {
        System.out.println("\n\nOh no, this room has booby traps!");
    }

    @Override
    public void leaveCheck(Player player)
    {
        System.out.println("Would you like to leave this room? Y or I for item use.");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        if(answer.equalsIgnoreCase("Y"))
        {
            System.out.println("You leave the trap room.");

        }else if (answer.equalsIgnoreCase("I"))
        {
            player.displayInventory();
            System.out.println("Which item would you like to use (0-X): ");
            Scanner scanner1 = new Scanner(System.in);
            int answerIndex = scanner1.nextInt();
            player.useItem(answerIndex);
            System.out.println("You leave the trap room.");
        }
    }


    public void interact(Player player)
    {
        System.out.println("\nAHHHH");
        System.out.println("You have been shot with a poison arrow.");

        //Reduce player health by random amount
        Random random = new Random();
        int damage = random.nextInt(10) + 5;
        player.setHealth(player.getHealth() - damage);

        System.out.println("\nYou took " + damage + " damage.");
        System.out.println("Your health is now: " + player.getHealth() + "\n");
        leaveCheck(player);

        if(player.getHealth() <= 0)
        {
            System.out.println("You have succumbed to your injuries...game over.");
        }
    }
}
