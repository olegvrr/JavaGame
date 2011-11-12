/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customapplication;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Oleg
 */
public class CollusionChecker
{
    static boolean oneTime = false;
    static float first;
    public static boolean checkCollusion(WorldEntity entity, WorldEntity sender)
    {
        if (entity.getLocation().getX() <= 150 && entity.globalLocation.getY() <= 150 && !oneTime)
        {
            oneTime = true;
        }
        for(WorldEntity worldEntity : GlobalVariables.getVisibleEntities())
        {
            if(worldEntity == sender)
                continue;
            if((entity.globalLocation.getX() >= worldEntity.globalLocation.getX() && entity.globalLocation.getY() >= worldEntity.globalLocation.getY()))
            {
                if((entity.globalLocation.getX() <= worldEntity.globalLocation.getX() + worldEntity.width) && (entity.globalLocation.getY() <= worldEntity.globalLocation.getY() + worldEntity.height))
                {
                    GlobalVariables.entitiesCollidedEvent.invokeEvent(GlobalVariables.entitiesCollidedEvent);
                    oneTime = false;
                    return true;
                }
            }
        }
        return false;
    }
}
