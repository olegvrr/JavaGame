/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customapplication;

import java.util.Calendar;
import java.util.Date;

/**
 * Static class which contains logic to check if sended object is collided with anything else
 * @author Oleg
 */
public class CollusionChecker
{
    /**
     * 
     * @param entity entity that invoked this method
     * @param sender is entity that sent current entity, lol! (e.g. bullet sended by somebody, so sombody is the sender)
     * @return boolean <- nuff' said
     */
    public static boolean checkCollusion(WorldEntity entity, WorldEntity sender)
    {
        for(WorldEntity worldEntity : Entities.getAllEntities())
        {
            if(worldEntity == sender)
                continue;
            if((entity.globalLocation.getX() >= worldEntity.globalLocation.getX() && entity.globalLocation.getY() >= worldEntity.globalLocation.getY()))
            {
                if((entity.globalLocation.getX() <= worldEntity.globalLocation.getX() + worldEntity.width) && (entity.globalLocation.getY() <= worldEntity.globalLocation.getY() + worldEntity.height))
                {
                    GlobalVariables.entitiesCollidedEvent.invokeEvent(entity, worldEntity);
                    return true;
                }
            }
        }
        return false;
    }
}
