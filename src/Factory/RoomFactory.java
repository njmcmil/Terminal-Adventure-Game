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

        default:
            return new EmptyRoom();
    }








}

}
