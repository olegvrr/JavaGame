/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomEvents;

import java.util.EventObject;

/**
 *
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
    
    public void addListener(IListener listener)
    {
        listenerList.add(IListener.class, listener);
    }
    public void remListener(IListener listener)
    {
        listenerList.remove(IListener.class, listener);
    }
    public void invokeEvent(EntitiesCollidedEvent evt) 
    {
        Object[] listeners = listenerList.getListenerList();
        // Each listener occupies two elements - the first is the listener class
        // and the second is the listener instance
        for (int i=0; i<listeners.length; i+=2)
        {
            if (listeners[i]==IListener.class)
            {
                ((IListener)listeners[i+1]).EntitiesCollided(evt);
            }
        }
    }
}
