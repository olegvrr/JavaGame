/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WeaponPackage;

import customapplication.*;

/**
 *
 * @author Oleg
 */
public abstract class Weapon extends WorldEntity
{
    protected int distance;
    protected WorldEntity owner;
    public Weapon(Location location, String name, int distance, WorldEntity owner)
    {
        super(location, name);
        this.distance = distance;
        this.owner = owner;
    }
    
    public void shot()
    {
        PistolBullet ammu = new PistolBullet(new Location(location.getX(), location.getY()), distance, owner);
    }
}
