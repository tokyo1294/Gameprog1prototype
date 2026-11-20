import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    private boolean portalSpawned = false;
    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();

        // Example Asteroids
        addObject(new Asteroid(), 300, 100);
        addObject(new Asteroid(), 450, 200);
        addObject(new Asteroid(), 250, 300);
    }

    public void act()
    {
        if(!portalSpawned && getObjects(Asteroid.class).isEmpty()){
            Portal portal = new Portal();
            addObject(portal, getWidth()/2,getHeight()/2);
            portalSpawned = true;
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Rocket rocket = new Rocket();
        addObject(rocket,108,256);
    }
}
