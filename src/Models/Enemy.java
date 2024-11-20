package Models;

public class Enemy
{
    private String enemyName;
    private int health;
    private int damage;

    public Enemy(String enemyName, int health, int damage)
    {
        this.enemyName = enemyName;
        this.health = health;
        this.damage = damage;

    }
    //Reduces health of enemy
    public void takeDamage(int playerDamage)
    {
        health -= playerDamage;
    }
    //Checks if enemy health is less than or equal to 0, yes? isDefeated = true
    public boolean isDefeated()
    {
        return health <= 0;
    }


    //Getters
    public String getEnemyName()
    {
        return enemyName;
    }

    public int getHealth()
    {
        return health;
    }

    public int getDamage()
    {
        return damage;
    }





}
