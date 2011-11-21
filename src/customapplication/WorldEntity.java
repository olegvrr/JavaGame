/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customapplication;

import CustomEvents.ICollidable;
import java.awt.Color;
import java.awt.Shape;

/**
 * Bottom level of program's hierarchy
 * @author Oleg
 */
public abstract class WorldEntity implements ICollidable
{
    //Determines if this object needed in this program or not
    protected boolean isActual = true;
    //Each object has it size
    protected int width;
    protected int height;
    //Location according to the game field
    protected Location location;
    //Location according to the whole world, lol
    protected Location globalLocation;
    //Shape that visually represents entity
    protected Shape shape;
    protected boolean isVisible = true;
    protected Color color;
    public final String name;
    
    protected WorldEntity(Location location, String name)
    {
        this.globalLocation = location;
        this.location = Location.sub(location , GlobalVariables.getFormCoords());
        this.name = name;
        //Every entity have to listen to the Entities Collided Event. This Event will occur if any enity collides with other
        GlobalVariables.entitiesCollidedEvent.addListener(this);
    }
    
    /**Determines if this object needed in this program or not */
    public boolean IsActual()
    {
        return isActual;
    }
    
    public Location getLocation()
    {
        return globalLocation;
    }
    public Location getFormLocation()
    {
        return location;
    }
    
    public void setLocation(Location location)
    {
        this.globalLocation = location;
        this.location = Location.sub(location , GlobalVariables.getFormCoords());
    } 
    
    public Shape getPicture()
    {
        return shape;
    }
    
    public void setVisible(boolean isVisible)
    {
        this.isVisible = isVisible;
    }
    
    public void changeColor(Color newColor)
    {
        color = newColor;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public void changeSize(int deltaWidth, int deltaHeight)
    {
        width += deltaWidth;
        height += deltaHeight;
    }
    
}
