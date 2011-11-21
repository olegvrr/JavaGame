/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WeaponPackage;

import customapplication.GlobalVariables;
import customapplication.Location;
import customapplication.WorldEntity;
import java.awt.Color;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Oleg
 */
public class PistolBullet extends Ammunition
{
    public PistolBullet(Location location, int distance, WorldEntity owner)
    {
        super(location, "7.92", distance, owner);
        width = 5;
        height = 5;
        velocity = 10;
        shape = new Ellipse2D.Float(location.getX()+5, location.getY()+5,width,height);
        color = Color.blue;
        //add this object to the list of all objects
        GlobalVariables.getPicture().addEntity(this);
        calcDelta();
    }
    
    protected void Move()
    {
        super.Move();
        shape = new Ellipse2D.Float(location.getX(), location.getY(),width,height);
    }
}
