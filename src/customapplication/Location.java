/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customapplication;

/**
 *
 * @author Oleg
 */
public class Location
{
    private float x;
    private float y;
    
    public Location(float x, float y)
    {
        this.x = x;
        this.y = y;
    }
    
    public float getX()
    {
        return x;
    }
    public void setX(float x)
    {
        this.x = x;
    }
    
    public float getY()
    {
        return y;
    }
    public void setY(float y)
    {
        this.y = y;
    }
    
    public static Location sum(Location l1, Location l2)
    {
        return new Location(l1.getX()+l2.getX(),l1.getY()+l2.getY());
    }
    
    public static Location sub(Location l1, Location l2)
    {
        return new Location(l1.getX()-l2.getX(),l1.getY()-l2.getY());
    }
    
}
