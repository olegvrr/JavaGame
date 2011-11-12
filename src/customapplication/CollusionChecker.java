/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customapplication;

/**
 *
 * @author Oleg
 */
public class CollusionChecker
{
    public static void checkCollusion(WorldEntity entity)
    {
        for(WorldEntity worldEntity : GlobalVariables.getVisibleEntities())
        {
            if(entity.location == worldEntity.location)
            {
                System.out.println("LOL!");
            }
        }
    }
}
