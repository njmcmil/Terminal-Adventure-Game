package Factory;
import Models.*;
import java.util.Random;

public class RoomFactory
{
public static AbsRoom createRoom()
{
    Random random = new Random();
    int roomType = random.nextInt(4);

    switch(roomType)
    {
        case 0:
            return new EnemyRoom();

        case 1:
            return new EmptyRoom();

        case 2:
            return new TrapRoom();

        case 3:
            return new TreasureRoom("Health potion", "Fire ball", "Tool Sharpener");

        default:
            return new EmptyRoom();
    }








}

}
