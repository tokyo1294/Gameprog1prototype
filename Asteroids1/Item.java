import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An item that sometimes appears when an asteroid is destroyed.
 * When the rocket touches it, the item is collected.
 * After 5 items, the rocket is upgraded to level 2.
 */
public class Item extends Actor
{
    /**
     * Create an item: a small yellow energy orb (drawn in code, no image file needed).
     */
    public Item()
    {
        GreenfootImage image = new GreenfootImage(20, 20);
        image.setColor(Color.YELLOW);
        image.fillOval(0, 0, 20, 20);
        image.setColor(Color.WHITE);
        image.drawOval(0, 0, 19, 19);
        setImage(image);
    }

    /**
     * If the rocket touches this item, give it to the rocket and disappear.
     */
    public void act()
    {
        Rocket rocket = (Rocket) getOneIntersectingObject(Rocket.class);
        if (rocket != null) {
            rocket.collectItem();
            getWorld().removeObject(this);
        }
    }
}
