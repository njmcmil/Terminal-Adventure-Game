package Models;

import java.util.Scanner;

public class TreasureRoom extends AbsRoom
{

    private String healthPotion;
    private String fireBall;
    private String toolSharpener;

public TreasureRoom(String healthPotion, String fireBall, String toolSharpener)
{
    this.healthPotion = healthPotion;
    this.fireBall = fireBall;
    this.toolSharpener = toolSharpener;

}

public String getHealthPotion()
{
    return healthPotion;
}

public String getFireBall(){
    return fireBall;
}

public String getToolSharpener(){
    return toolSharpener;
}

@Override
    public void displayDescription()
{
    System.out.println("\n\nhmm..this room appears to be different.");
}

@Override
public void leaveCheck(Player player)
{
    System.out.println("Would you like to leave this room? Y or I for item use.");
    Scanner scanner = new Scanner(System.in);
    String answer = scanner.nextLine();

    if(answer.equalsIgnoreCase("Y"))
    {
        System.out.println("You leave the treasure room.");

    }else if (answer.equalsIgnoreCase("I"))
    {
        player.displayInventory();
        System.out.println("Which item would you like to use (0-X): ");
        Scanner scanner1 = new Scanner(System.in);
        int answerIndex = scanner1.nextInt();
        player.useItem(answerIndex);
        System.out.println("You leave the treasure room.");
    }
}

    public void interact(Player player)
    {
        System.out.println("Its dark in here but you see treasure glinting!\n");
        System.out.println("You find the following items: ");
        System.out.println("1: " + healthPotion + "!");
        System.out.println("2: " + fireBall + "!");
        System.out.println("3: " + toolSharpener + "!");
        System.out.println("Choose one: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();



        switch(choice)
        {
            case 1:
                System.out.println("You take the " + healthPotion + "!");
                player.addItem(healthPotion);
                leaveCheck(player);
                break;
            case 2:
                System.out.println("You take the " + fireBall + "!");
                player.addItem(fireBall);
                leaveCheck(player);
                break;
            case 3:
                System.out.println("You take the " + toolSharpener + "!");
                player.addItem(toolSharpener);
                leaveCheck(player);
                break;
            default:
                leaveCheck(player);
                break;
        }
    }
}
