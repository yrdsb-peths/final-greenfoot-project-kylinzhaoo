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
    int count;
    int animateSpeed = 5;
    int animateImage = 0;
    public Player()
    {
        setImage(new GreenfootImage(70, 50));
        getImage().setColor(Color.YELLOW);
        getImage().fillOval(0, 0, 50, 50);
        getImage().setColor(Color.BLACK);
        getImage().fillRect(50, 20, 70, 10);
    }
    /* creates yellow circle as our player
     * author: kylin
     * date: Dec 20
     */ 
    public void act()
    {
        animate();
        turnAround();
        moveAround();
        fireProjectile();
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
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation());
        }
    }
        /* allows character to fire projectile when mouse is pressed by player
         * creates new projectile every time the player presses their mouse
         * author: kylin
         * date: Dec 20
         */
    public void animate()
    {
        if(count % animateSpeed == 0)
        {
            if(animateImage > 3){
                animateImage = 0;
            }
            setImage("survivor-shoot_rifle" + animateImage + ".png");
            animateImage++;
            getImage().scale(80,80);
        }
    }
}

