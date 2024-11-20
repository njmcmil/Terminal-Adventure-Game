package Models;

public class EmptyRoom extends AbsRoom
{
public EmptyRoom()
{
    displayDescription();
}


@Override
    public void displayDescription()
{
    System.out.println("This room appears to be empty...");
}


}
