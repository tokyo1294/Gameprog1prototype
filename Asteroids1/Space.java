import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Space. Something for rockets to fly in...
 * 
 * @author Michael Kölling
 * @version 2.0
 */
public class Space extends World
{
    private boolean portalSpawned = false;
    /**
     * Create the space world with black background and stars.
     */
    public Space() 
    {
        super(800, 600, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        createStars(300);
        Explosion.initialiseImages();
        prepare();
    }

    public void act()
    {
        if (!portalSpawned && getObjects(Asteroid.class).isEmpty())
        {
            addObject(new Portal(), getWidth()/2, getHeight()/2);
            portalSpawned = true;
        }
        
    }

    /**
     * Create some random stars in the world
     */
    private void createStars(int number) 
    {
        GreenfootImage background = getBackground();             
        for (int i=0; i < number; i++) {            
            int x = Greenfoot.getRandomNumber( getWidth() );
            int y = Greenfoot.getRandomNumber( getHeight() );
            int color = 150 - Greenfoot.getRandomNumber(120);
            background.setColorAt(x, y, new Color(color,color,color));
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Asteroid asteroid = new Asteroid();
        addObject(asteroid,492,122);
        Asteroid asteroid2 = new Asteroid();
        addObject(asteroid2,566,455);
        Rocket rocket = new Rocket();
        addObject(rocket,86,257);
        removeObject(asteroid2);
        asteroid.setLocation(612,257);
    }
}