/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WorldObjectPackage;

import customapplication.Location;
import customapplication.WorldEntity;
import java.awt.Color;

/**
 *
 * @author Oleg
 */
public abstract class WorldObject extends WorldEntity
{
    public boolean isTransparent = false;
    public boolean isOpened = false;
    
    protected WorldObject(int width, int height, Location location, String name)
    {
        super(location, name);
        this.width = width;
        this.height = height;
        color = Color.RED;
    } 
}
