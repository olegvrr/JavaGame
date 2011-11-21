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
    //How far bullets can be launched from this gun?
    protected int distance;
    //Who own this gun, bro?
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
