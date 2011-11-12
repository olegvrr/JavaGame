/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customapplication;

import java.awt.Color;
import java.awt.Shape;

/**
 *
 * @author Oleg
 */
public abstract class WorldEntity
{
    //
    protected boolean isActual = true;
    protected int width;
    protected int height;
    protected Location location;
    protected Location globalLocation;
    protected Shape shape;
    protected boolean isVisible = true;
    protected Color color;
    public final String name;
    
    protected WorldEntity(Location location, String name)
    {
        this.globalLocation = location;
        this.location = Location.sub(location , GlobalVariables.getFormCoords());
        this.name = name;
    }
    
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
