import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    int count = 0;
    int spawnSpeed = 30;
    int randomSpawn;
    //Spawn speed will be faster if you lower value of spawnSpeed
    public Player mainPlayer = new Player();
    Counter counter = new Counter();
    HealthBar healthbar = new HealthBar();
    WeaponButton weaponButton = new WeaponButton(counter);
    SuperPower superPower = new SuperPower();
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        mainPlayer = new Player(weaponButton, superPower);
        addObject(mainPlayer, getWidth()/2, getHeight()/2);
        /* fills background with the color blue
         * adds character on screen
         * author: kylin
         * date: Dec 20
         */
        addObject(counter, 130, 100);
        addObject(healthbar, mainPlayer.getX() - 5, mainPlayer.getY() - 50);
        addObject(weaponButton, 900, 100);
        addObject(superPower, mainPlayer.getX() + 10, mainPlayer.getY() - 80);
    }
    
    public Player getPlayer()
    {
        return mainPlayer;
    }
    
    public void act()
    {
        count++;
        if(count % 600 == 0)
        {
            spawnSpeed--;
        }
        while(Greenfoot.isKeyDown("p")){
        Greenfoot.delay(1);
    }
        spawnZombies();
        /* spawns zombies in 8 different spots on the screen
         * author: kylin zhao
         * date: Jan 9
         */
    }
    public void spawnZombies()
    {
        if (count % spawnSpeed == 0)
        {
            randomSpawn = Greenfoot.getRandomNumber(8);
            switch(randomSpawn){
                case 0 : addObject(new Zombie(mainPlayer,counter), 0, 0); break;
                case 1 : addObject(new Zombie(mainPlayer,counter), getWidth()/2, 0); break;
                case 2 : addObject(new Zombie(mainPlayer,counter), getWidth(), 0); break;
                case 3 : addObject(new Zombie(mainPlayer,counter), 0, getHeight()/2); break;
                case 4 : addObject(new Zombie(mainPlayer,counter), getWidth(), getHeight()/2); break;
                case 5 : addObject(new Zombie(mainPlayer,counter), 0, getHeight()); break;
                case 6 : addObject(new Zombie(mainPlayer,counter), getWidth()/2, getHeight()); break;
                case 7 : addObject(new Zombie(mainPlayer,counter), getWidth(), getHeight()); break;
                
            }
        }
    }
}
