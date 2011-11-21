/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitPackage;

import WeaponPackage.*;
import customapplication.*;

/**
 *
 * @author Oleg
 */
public abstract class Unit extends WorldEntity implements ITimable
{
    protected Unit(String name, Location location, int speed)
    {
        super(location, name);
        health = 100;
        direction = "stay";
        this.speed = speed;
        width = 30;
        height = 30;
        weapon = new Pistol(location, name, 40, this);
    }
    
    protected String direction;
    protected int speed;
    protected Weapon weapon;
    
    public int health;
    
    public void changeSpeed(float delta)
    {
        speed += delta;
    }
    
    public void Move()
    {
        if (direction == "up")
        {
            location.setY(location.getY()-speed);
        }
        if (direction == "upLeft")
        {
            location.setY(location.getY()-speed);
            location.setX(location.getX()-speed);
        }
        if (direction == "upRight")
        {
            location.setY(location.getY()-speed);
            location.setX(location.getX()+speed);
        }
        if (direction == "down")
        {
            location.setY(location.getY()+speed);
        }
        if (direction == "downLeft")
        {
            location.setY(location.getY()+speed);
            location.setX(location.getX()-speed);
        }
        if (direction == "downRight")
        {
            location.setY(location.getY()+speed);
            location.setX(location.getX()+speed);
        }
        if (direction == "left")
        {
            location.setX(location.getX()-speed);
        }
        if (direction == "right")
        {
            location.setX(location.getX()+speed);
        }
        globalLocation = Location.sum(GlobalVariables.getFormCoords(), location);
    }

    public void changeDirection(String newDirection)
    {
        direction = newDirection;
    }
    
    public void shot()
    {
        weapon.shot();
    }
    
}
