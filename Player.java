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
    WeaponButton weaponButton;
    SuperPower superPower;
    int superTimer;
    GreenfootSound gunSound = new GreenfootSound("mixkit-game-gun-shot-1662-[AudioTrimmer.com].mp3");
    public Player()
    {
        getImage().scale(80,80);
    }
    /* creates yellow circle as our player
     * author: kylin
     * date: Dec 20
     */ 
    public Player(WeaponButton weaponButton, SuperPower superPower)
    {
        this.superPower = superPower;
        this.weaponButton = weaponButton;
        getImage().scale(80,80);
    }
    public void act()
    {
        time++;
        turnAround();
        moveAround();
        fireProjectile();
        superPowerUsed();
        hitByZombie();
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
        if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 1){
            gunSound.play();
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY()+19);
            projectile.setRotation(getRotation());
            projectile.move(25);
            
        }
        /* allows character to fire projectile when mouse is pressed by player
         * creates new projectile every time the player presses their mouse
         * author: kylin
         * date: Dec 20
         */
        if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 2){
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY()+19);
            projectile.setRotation(getRotation() - 10);
            projectile.move(20);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY()+19);
            projectile2.setRotation(getRotation() + 10);
            projectile2.move(20);
            /* adds another projectile when player shoots as second upgrade
             * author: kylin
             * date: Jan 13
             */
        }
        if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 3){
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY()+19);
            projectile.setRotation(getRotation() - 10);
            projectile.move(20);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY()+19);
            projectile2.setRotation(getRotation() + 10);
            projectile2.move(5);
            Projectile projectile3 = new Projectile();
            getWorld().addObject(projectile3, getX(), getY()+19);
            projectile3.setRotation(getRotation());
            projectile3.move(20);
            /* adds a third projectile when players shoot as third upgrade
             * author: kylin
             * date: Jan 13
             */
        }
    
    }
    public void superPowerUsed()
    {
        if(superPower.superCount > 99 && superTimer < 30)
        {
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 60);
            projectile.move(20);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 60);
            projectile2.move(20);
            Projectile projectile3 = new Projectile();
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(20);
            Projectile projectile1 = new Projectile();
            getWorld().addObject(projectile1, getX(), getY());
            projectile1.setRotation(getRotation() - 180);
            projectile1.move(20);
            Projectile projectile21 = new Projectile();
            getWorld().addObject(projectile21, getX(), getY());
            projectile21.setRotation(getRotation() + 120);
            projectile21.move(20);
            Projectile projectile31 = new Projectile();
            getWorld().addObject(projectile31, getX(), getY());
            projectile31.setRotation(getRotation() - 120);
            projectile31.move(20);
            superTimer++;
            /* shoots a circle of projectiles around the player for their super power
             * author: kylin
             * date: Jan 13
             */
        }
        if(superTimer>29)
        {
            superPower.superCount = 0;
            superTimer = 0;
        }
    }
       
    
        
    public boolean hitByZombie()
    {
        Actor zombie = getOneObjectAtOffset(0,0, Zombie.class);
        if(zombie!=null)
        {
            return true;
        }
        else
        return false;
    }
}

