import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

/**
 * Gravity consists of static methods used to calculate the gravitational force between two Matter
 * objects in the world.
 * 
 * @author Keshav Saharia
 * @version 1.4
 */
public class Gravity
{
    // The gravitational constant
    private static final double G = 3;
    
    /**
     * Returns a vector that represents the gravitational force between two Matter objects, assuming
     * that the center object is the object on which the force is being applied.
     */
    public static Vector getGravitationalForce(Matter center, Matter target)
    {
        double r = distanceBetween(center,target);
        double magnitude = (G*center.getMass()*target.getMass())/(r*r);
        double angle = angleBetween(center,target);
        
        // put it all into a vector
        Vector v = new Vector();
        v.setVector(magnitude, angle);
        return v;
    }

    /**
     * Returns the distance between two Matter objects.
     */
    public static double distanceBetween(Matter center, Matter target) {
        Vector centerPosition = center.getPosition();
        Vector targetPosition = target.getPosition();
        Vector v = new Vector(center.getX() - target.getX(), center.getY() - target.getY());
        return v.getMagnitude();
    }
    
    /**
     * Returns the angle between two Matter objects.
     */
    public static double angleBetween(Matter center, Matter target) {
        Vector d = new Vector(target.getX() - center.getX(),target.getY() - center.getY());
        return d.getAngle();
    }
}
