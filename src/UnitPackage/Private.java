/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitPackage;

import customapplication.Location;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
/**
 *
 * @author Oleg
 */
public class Private extends Unit
{
    public Private(String name, Location location, int speed)
    {
        super(name, location, speed);
        shape = new Ellipse2D.Float(location.getX() , location.getY(), 30, 30);
        color =  Color.ORANGE;
    }
    
    public void Move()
    {
        super.Move();
        shape = new Ellipse2D.Float(location.getX() , location.getY(), 30, 30);
    }
    
}
