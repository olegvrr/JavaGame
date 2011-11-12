/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitPackage;

import customapplication.*;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Oleg
 */
public class Player extends Unit
{
    private int rank;
    public Player(String name, Location location, int speed, int rank)
    {
        super(name,location,speed);
        this.rank = rank;
        switch(rank)
        {
            case 0: shape = new Ellipse2D.Float(location.getX(), location.getY(), 30, 30);
                color = Color.BLUE;
                break;
            default: JOptionPane.showMessageDialog(GlobalVariables.getForm(), "Wrong rank specified in constructor!", "Big Brother watches over you!", 0);
        }
    }
    
    public String getRank()
    {
        switch(rank)
        {
            case 0: return "Private";
            default: JOptionPane.showMessageDialog(GlobalVariables.getForm(), "Wrong rank specified in constructor!", "Big Brother watches over you!", 0);
                return null;
            
        }
    }
    
    @Override
    public void Move()
    {
        super.Move();
        shape = new Ellipse2D.Float(location.getX(), location.getY(), 30, 30);
    }
}
