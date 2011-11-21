/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PicturePackage;

import customapplication.GlobalVariables;
import customapplication.WorldEntity;
import java.awt.*; 
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author Oleg
 */
public class Picture extends JComponent
{
    protected Graphics2D g2d;
    //Entites to draw
    private ArrayList<WorldEntity> worldEntities = new ArrayList<WorldEntity>();
    
    public Picture()
    {
        //try to add this picture to the globals
        try
        {
            GlobalVariables.setPicture(this);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(GlobalVariables.getForm(), ex.getMessage(), "Big Brother watches over you!", 0);
        }
    }
    
    public void addEntity(WorldEntity entity)
    {
        worldEntities.add(entity);
    }
    
    public void remEntity(WorldEntity entity)
    {
        worldEntities.remove(entity);
    }
    /** Method to draw any visible entity */
    @Override
    public void paint(Graphics g)
    {
      super.paint(g);
      g2d = (Graphics2D) g;
      for(WorldEntity worldEntity : worldEntities)
      {
        g2d.setColor(worldEntity.getColor());
        g2d.drawLine((int)worldEntity.getLocation().getX(), 0, (int)worldEntity.getLocation().getX(), 600);
        g2d.drawLine(0, (int)worldEntity.getLocation().getY(), 1200, (int)worldEntity.getLocation().getY());
    //    g2d.setPaint(worldEntity.getColor());
        g2d.fill(worldEntity.getPicture());
      }
    }
    
    //rubish, isn't it?
    public void paintAll()
    {
        for(WorldEntity worldEntity : worldEntities)
        {
     //     paint(worldEntity.getPicture(), worldEntity.getColor());
        }
    }
}
