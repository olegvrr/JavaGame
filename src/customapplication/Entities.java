/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customapplication;

import java.util.ArrayList;

/**
 *
 * @author Oleg
 */
public class Entities
{
    //Entities that allocated on Form
    private static ArrayList<WorldEntity> visibleEntities = new ArrayList<WorldEntity>();
    public static ArrayList<WorldEntity> getVisibleEntities()
    {
        return visibleEntities;
    }
    public static void addVisibleEntity(WorldEntity entity)
    {
        visibleEntities.add(entity);
        allEntities.add(entity);
        GlobalVariables.getPicture().addEntity(entity);
    }
    public static void remVisibleEntity(WorldEntity entity)
    {
        visibleEntities.remove(entity);
        allEntities.remove(entity);
        GlobalVariables.getPicture().remEntity(entity);
    }
    
    //All Entities
    private static ArrayList<WorldEntity> allEntities = new ArrayList<WorldEntity>();
    public static ArrayList<WorldEntity> getAllEntities()
    {
        return allEntities;
    }
    public static void addEntity(WorldEntity entity)
    {
        allEntities.add(entity);
    }
    public static void remEntity(WorldEntity entity)
    {
        allEntities.remove(entity);
    }
}
