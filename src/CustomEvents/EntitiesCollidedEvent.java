/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomEvents;

import java.util.EventObject;

/**
 * This Event will occur if any entity collided with any other
 * @author Oleg
 */
public class EntitiesCollidedEvent extends EventObject
{
    public EntitiesCollidedEvent(Object source)
    {
        super(source);
    }
    
    protected javax.swing.event.EventListenerList listenerList =
        new javax.swing.event.EventListenerList();
    
    //Subscribe
    public void addListener(ICollidable listener)
    {
        listenerList.add(ICollidable.class, listener);
    }
    //Unsbscribe
    public void remListener(ICollidable listener)
    {
        listenerList.remove(ICollidable.class, listener);
    }
    public void invokeEvent(ICollidable sender, ICollidable receiver) 
    {
        Object[] listeners = listenerList.getListenerList();
        // Each listener occupies two elements - the first is the listener class
        // and the second is the listener instance
        for (int i=0; i<listeners.length; i+=2)
        {
            if (listeners[i]==ICollidable.class)
            {
                ((ICollidable)listeners[i+1]).EntitiesCollided();
            }
        }
    }
}
