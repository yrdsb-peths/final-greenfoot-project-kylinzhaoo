import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 3;
    int time = 0;
    public Player()
    {
        getImage().scale(80,80);
    }
    /* creates yellow circle as our player
     * author: kylin
     * date: Dec 20
     */ 
    public void act()
    {
        time++;
        turnAround();
        moveAround();
        fireProjectile();
        youLose();
    }
    public void turnAround()
    {
        if(Greenfoot.getMouseInfo() !=null)
            turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
        /* points your character wherever your mouse is located
         * author: kylin
         * date: Dec 20
         */
    }
    public void moveAround()
    {
        if(Greenfoot.isKeyDown("w"))
            setLocation(getX(),getY() - speed);
        if(Greenfoot.isKeyDown("a"))
            setLocation(getX() - speed, getY());
        if(Greenfoot.isKeyDown("s"))
            setLocation(getX(), getY() + speed);
        if(Greenfoot.isKeyDown("d"))
            setLocation(getX() + speed, getY());
        /* programs "wasd" controls to move your character around
         * author: kylin
         * date: Dec 20
         */
    }
    public void fireProjectile()
    {
        if(Greenfoot.mousePressed(null))
        {
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY()+19);
            projectile.setRotation(getRotation());
        }
        /* allows character to fire projectile when mouse is pressed by player
         * creates new projectile every time the player presses their mouse
         * author: kylin
         * date: Dec 20
         */
    }
        
    public void youLose()
    {
        if(isTouching(Zombie.class))
        {
            getWorld().showText("You Lose! - You lasted " + (time/60) + " seconds", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}

