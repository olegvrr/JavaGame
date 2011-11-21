/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WorldObjectPackage;

import customapplication.Location;
import java.awt.Color;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Oleg
 */
public class Wall extends WorldObject
{
    
    public Wall(int width, int height, Location location, String name)
    {
        super(width, height, location, name);
        shape = new Rectangle2D.Float(location.getX() , location.getY(), width, height);
        color = Color.RED;
    }

    @Override
    public void EntitiesCollided()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
