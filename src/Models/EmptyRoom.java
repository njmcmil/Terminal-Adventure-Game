package Models;

import java.util.Scanner;

public class EmptyRoom extends AbsRoom
{


@Override
    public void displayDescription()
{
    System.out.println("\n\nThis room appears to be empty...");
}

@Override
public void leaveCheck(Player player)
{
    System.out.println("Would you like to leave this room? Y or I for item use.");
    Scanner scanner0 = new Scanner(System.in);
    String answer = scanner0.nextLine();

    if(answer.equalsIgnoreCase("Y"))
    {
        System.out.println("You leave the empty room.");

    }else if (answer.equalsIgnoreCase("I"))
    {
        player.displayInventory();
        System.out.println("Which item would you like to use (0-X): ");
        Scanner scanner1 = new Scanner(System.in);
        int answerIndex = scanner1.nextInt();
        player.useItem(answerIndex);
        System.out.println("You leave the empty room.");
    }
}


public void interact(Player player)
{
    System.out.println("Its dark in here.");
    leaveCheck(player);
}
}
