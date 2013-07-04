import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Matter represents matter floating in space, gravitating toward other matter.
 * 
 * @author Keshav Saharia 
 * @version 2.5
 */
public class Matter extends Actor
{
    private Vector velocity;
    private Vector position;
    
    /**
     * Constructor for Matter.
     */
    public Matter()
    {
        velocity = new Vector();
    }
    
    /**
     * Matter's act method, where it gravitates to other Matter objects by changing its velocity
     * vector, then changes its position according to its new velocity.
     */
    public void act() 
    {
        gravitate();
        changePosition();
        
    }
    public boolean atWorldEdge()
    {
        int x = getX();
        int y = getY();
        
        if ( x < 10 ) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Changes the position of the Matter object by adding the velocity vector to the position vector.
     */
    private void changePosition() {
        if (position == null) {
            position = new Vector(getX(), getY());
        }
        if (atWorldEdge()){
            velocity = velocity.invert();
            position.add(velocity);
        }
        position.add(velocity);
        setLocation((int) position.getX(), (int) position.getY());
        
    }
    
    /**
     * Uses the law of universal gravitation to adjust the velocity of this matter according to
     * the position of all other matter, using the static functions in the Gravity class.
     */
    private void gravitate()
    {
        // get all matter in the world as a List
        SpaceWorld world = (SpaceWorld) getWorld();
        List <Matter> allMatter = world.getObjects(Matter.class);
        
        // netForce is a vector that stores the net force acting on this mass
        Vector netForce = new Vector();
        // iterate through all objects in the world, and modify netForce
        
        for (int i=0;i<allMatter.size(); i++){
            Matter other = allMatter.get(i);
            if (this != allMatter.get(i) && !(isTouching(other)) ){
            Vector f = Gravity.getGravitationalForce(this,allMatter.get(i));
            netForce.add(f);
        }}
        // create a new vector called acceleration, by the F = ma law.
        Vector acceleration = netForce.scale(this.getMass());
        velocity.add(acceleration);
    }
    
    /**
     * Returns true if this Matter is touching the provided Matter object.
     */
    private boolean isTouching(Matter other) {
        if (Gravity.distanceBetween(this, other) < this.getRadius() + other.getRadius()) {
            return true;
        }
        else {
            return false;
        }
    }
    public Vector invert() {
        return new Vector(getX() *-1,getY() *-1);
    }
    /**
     * Returns the mass of this matter.
     */
    public double getMass() {
        return 1;
    }
    
    /**
     * Returns the radius of this matter.
     */
    public double getRadius() {
        return 1;
    }
    public Vector getPosition() {
        return position;
    }
}


