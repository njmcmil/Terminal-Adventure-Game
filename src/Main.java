
import Factory.RoomFactory;
import Models.AbsRoom;
import Models.Player;

import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        Player player = new Player(50, 10);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Dungeon Adventure!");
        System.out.println("Would you like to play? Y or N");
        String answer;
        answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("Y"))
        {
           boolean gameRunning = true;
           while(gameRunning && player.getHealth() > 0)
           {
                AbsRoom room = RoomFactory.createRoom();
                room.displayDescription();
                room.interact(player);








           }

        }else
        {
            System.out.println("Shutting program down..");
        }








    }
}