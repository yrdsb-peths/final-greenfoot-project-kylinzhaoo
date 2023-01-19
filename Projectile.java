import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    
    public Projectile()
    {
        setImage(new GreenfootImage(10, 2));
        getImage().setColor(Color.YELLOW);
        getImage().fillRect(0,0,10,2);
        /* created projectile for player to shoot
         * author: kylin
         * date: Dec 20
         */
    }
    public void act()
    {
        move(10);
        /* moves the projectile
         * author: kylin
         * date: Dec 20
         */
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
        /* removes projectiles if they hit the world edge
         * author: kylin
         * date: Jan 12
         */
    
    }
}
