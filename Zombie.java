import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int animateImage = 0;
    int animateSpeed = 5;
    //lower the animate speed for faster animation
    int count;
    int health = 1;
    Player player;
    Counter counter;
    public Zombie(Player mainPlayer,Counter counter)
    {
        this.counter = counter;
        player = mainPlayer;
        setImage("skeleton-idle_16.png");
        getImage().scale(80,80);
        /* added zombie monster to our game
         * author: kylin zhao
         * date: Jan 9
         */
    }
    public void act()
    {
        count++;
        animate();
        moveAround();
        hitByProjectile();
    }
    //animate our zombie
    public void animate()
    {
        if(count % animateSpeed == 0)
        {
            if(animateImage > 16){
                animateImage = 0;
            }
            setImage("skeleton-move_" + animateImage + ".png");
            animateImage++;
            getImage().scale(80,80);
        }
    }
    public void moveAround()
    {
        move(1);
        turnTowards(player.getX(), player.getY());
        /* has zombies target player from spawn
         * author: kylin zhao
         * date: Jan 9
         */
    }
    public void hitByProjectile()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if(projectile != null)
        {
            health--;
            getWorld().removeObject(projectile);
            
        }
        if(health == 0)
        {
            counter.score++;
            counter.money+=5;
            getWorld().removeObject(this);
            /* removes the objectile that hits the zombie
             * author: kylin zhao
             * date: Jan 9
             */
        }
    } 
}
