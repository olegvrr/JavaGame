/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomEvents;

import java.util.EventListener;

/**
 *
 * @author Oleg
 */
public interface ICollidable extends EventListener
{
    public void EntitiesCollided();
}
