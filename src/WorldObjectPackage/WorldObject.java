/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WorldObjectPackage;

import customapplication.Location;
import customapplication.WorldEntity;
import java.awt.Color;

/**
 * Class that represents any static (or basicly) entity. (e.g. a wall, an ammo on the ground)
 * @author Oleg
 */
public abstract class WorldObject extends WorldEntity
{
    //Determines if player can see thorugh this object
    public boolean isTransparent = false;
    //Determines if any other entity can pass through this object
    public boolean isOpened = false;
    
    protected WorldObject(int width, int height, Location location, String name)
    {
        super(location, name);
        this.width = width;
        this.height = height;
        color = Color.RED;
    } 
}
