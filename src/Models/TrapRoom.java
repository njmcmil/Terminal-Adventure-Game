package Models;

public class TrapRoom extends AbsRoom
{
    public TrapRoom()
    {
        displayDescription();
    }



    @Override
    public void displayDescription()
    {
        System.out.println("Oh no, this room has booby traps!");
    }
}
