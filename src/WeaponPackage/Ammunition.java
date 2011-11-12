/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WeaponPackage;

import customapplication.CollusionChecker;
import customapplication.GlobalVariables;
import customapplication.ITimable;
import customapplication.Location;
import customapplication.WorldEntity;

/**
 *
 * @author Oleg
 */
public abstract class Ammunition extends WorldEntity implements ITimable
{
    protected float velocity;
    protected int distance;
    protected String name;
    protected float mouseBufferX;
    protected float mouseBufferY;
    protected float deltaX = 0;
    protected float deltaY = 0;
    private boolean isDeltaCalcd = false;
    protected Ammunition(Location location, String name, int distance)
    {
        super(location,name);
        this.distance = distance;
        GlobalVariables.getPicture().addEntity(this);
        // (mouseCoordsY - unitCoordsY) / (mouseCoordsX - unitCoordsX)
        GlobalVariables.subscribeTimer(this, 1);
    }
    
    private boolean isDone = false;
    protected void calcDelta()
    {
        mouseBufferX = GlobalVariables.mouseLocation.getX();
        mouseBufferY = GlobalVariables.mouseLocation.getY(); 
        float lenghtX = Math.abs(mouseBufferX-location.getX());
        float lenghtY = Math.abs(mouseBufferY-location.getY());
        if (lenghtX >= lenghtY)
        {
            if (mouseBufferX >= location.getX() && mouseBufferY >= location.getY() && !isDone)
            {
                deltaY = lenghtY / (lenghtX) * velocity * 1;
                deltaX = 1 * velocity;
                if(mouseBufferX == location.getX())
                {
                    deltaX = 1 * velocity;
                    deltaY = 0;
                }
                if(mouseBufferY == location.getY())
                {
                    deltaX = 1 * velocity;
                    deltaY = 0;
                }
                isDone = true;
            }
            if (mouseBufferX >= location.getX() && mouseBufferY <= location.getY() && !isDone)
            {
                deltaY = lenghtY / (lenghtX) * velocity * -1;
                deltaX = 1 * velocity;
                if(mouseBufferX == location.getX())
                {
                    deltaX = 0;
                    deltaY = -1 * velocity;
                }
                if(mouseBufferY == location.getY())
                {
                    deltaX = 0;
                    deltaY = -1 * velocity;
                }
                isDone = true;
            }
            if (mouseBufferX <= location.getX() && mouseBufferY <= location.getY() && !isDone)
            {
                deltaY = lenghtY / (lenghtX) * velocity * -1;
                deltaX = -1 * velocity;
                if(mouseBufferX == location.getX())
                {
                    deltaY = -1 * velocity;
                    deltaX = 0;
                }
                if(mouseBufferY == location.getY())
                {
                    deltaY = 0;
                    deltaX = -1 * velocity;
                }
                isDone = true;
            }
            if (mouseBufferX <= location.getX() && mouseBufferY >= location.getY() && !isDone)
            {
                deltaY = lenghtY / (lenghtX) * velocity * 1;
                deltaX = -1 * velocity;
                if(mouseBufferX == location.getX())
                {
                    deltaX = -1 * velocity;
                    deltaY = 0;
                }
                if(mouseBufferY == location.getY())
                {
                    deltaX = 0;
                    deltaY = 1 * velocity;
                }
                isDone = true;
            }
        }
        else //(mouseBufferX-location.getX() < mouseBufferY-location.getY())
        {
            if (mouseBufferX >= location.getX() && mouseBufferY >= location.getY() && !isDone)
            {
                deltaX = (lenghtX) / lenghtY * velocity * 1;
                deltaY = 1 * velocity;
                if(mouseBufferX == location.getX())
                {
                    deltaX = 0;
                    deltaY = 1 * velocity;
                }
                if(mouseBufferY == location.getY())
                {
                    deltaX = 1 * velocity;
                    deltaY = 0;
                }
                isDone = true;
            }
            if (mouseBufferX >= location.getX() && mouseBufferY <= location.getY() && !isDone)
            {
                deltaX = lenghtX / lenghtY * velocity * 1;
                deltaY = -1 * velocity;
                if(mouseBufferX == location.getX())
                {
                    deltaY = -1 * velocity;
                    deltaX = 0;
                }
                if(mouseBufferY == location.getY())
                {
                    deltaY = 0;
                    deltaX = 1 * velocity;
                }
                isDone = true;
            }
            if (mouseBufferX <= location.getX() && mouseBufferY <= location.getY() && !isDone)
            {
                deltaX = (lenghtX) / lenghtY * velocity * -1;
                deltaY = -1 * velocity;
                if(mouseBufferX == location.getX())
                {
                    deltaX = 0;
                    deltaY = -1 * velocity;
                }
                if(mouseBufferY == location.getY())
                {
                    deltaX = -1 * velocity;
                    deltaY = 0;
                }
                isDone = true;
            }
            if (mouseBufferX <= location.getX() && mouseBufferY >= location.getY() && !isDone)
            {
                deltaX = (lenghtX) / lenghtY * velocity * -1;
                deltaY = 1 * velocity;
                if(mouseBufferX == location.getX())
                {
                    deltaX = -1 * velocity;
                    deltaY = 0;
                }
                if(mouseBufferY == location.getY())
                {
                    deltaX = 0;
                    deltaY = 1 * velocity;
                }
                isDone = true;
            }
        }
        isDeltaCalcd = true;
    }
    
    public String getName()
    {
        return name;
    }
    
    protected void Move()
    {
        location.setX(location.getX()+deltaX);
        location.setY(location.getY()+deltaY);
        if(distance < 1)
            GlobalVariables.getPicture().remEntity(this);
        distance--;
        CollusionChecker.checkCollusion(this);
    }
    
    @Override
    public void handleTimerTick()
    {
        if (isDeltaCalcd)
        Move();
    }
}
