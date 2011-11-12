/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customapplication;

import CustomEvents.EntitiesCollidedEvent;
import PicturePackage.Picture;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Oleg
 */
public class GlobalVariables
{
        
    //Main Form begin
    private static JPanel form;
    public static JPanel getForm()
    {
        return form;
    }
    
    public static void setForm(JPanel mainForm) throws Exception
    {
        if (form == null)
        form = mainForm;
        else
        throw new Exception("Form has been initialized already");
    }
    
    // formSize[0] = width, formSize[1] = height
    private static int[] formSize = new int[2];
    public static int[] getFormSize()
    {
        return formSize;
    }
    
    public static void setFormSize(int width, int height)
    {
      formSize[0] = width;
      formSize[1] = height;
    }
    
    // [0] = x, [1] = y
    private static Location formCoords = new Location(0,0);
    public static Location getFormCoords()
    {
        return formCoords;
    }
    public static void setFormCoords(int x, int y)
    {
        formCoords.setX(x);
        formCoords.setY(y);
    }
    public static void changeFormCoords(int deltaX, int deltaY)
    {
        formCoords.setX(formCoords.getX()+deltaX);
        formCoords.setY(formCoords.getY()+deltaY);
    }
    //Main Form end.
    
    public static Location mouseLocation;
    
    //Drawing Component begin
    private static Picture picture;
    public static Picture getPicture()
    {
        return picture;
    }
    
    public static void setPicture(Picture picture1) throws Exception
    {
        if (picture == null)
        picture = picture1;
        else
        throw new Exception("Picture is readonly!");
    }
    private static ArrayList<WorldEntity> visibleEntities = new ArrayList<WorldEntity>();
    public static ArrayList<WorldEntity> getVisibleEntities()
    {
        return visibleEntities;
    }
    public static void addEntity(WorldEntity entity)
    {
        visibleEntities.add(entity);
        picture.addEntity(entity);
    }
    public static void remEntity(WorldEntity entity)
    {
        visibleEntities.remove(entity);
        picture.remEntity(entity);
    }
    //Drawing Component end.
    
    //Global timer begin
    private static java.util.Timer timer1 = new java.util.Timer();
    private static java.util.Timer timer2 = new java.util.Timer();
    private static java.util.Timer timer3 = new java.util.Timer();
    public static void initializeTimers()
    {
        timer1.schedule(new java.util.TimerTask(){public void run(){handleTimerTick1();}},1500, 30);
        timer2.schedule(new java.util.TimerTask(){public void run(){handleTimerTick2();}},1500, 100);
        timer3.schedule(new java.util.TimerTask(){public void run(){handleTimerTick3();}},1500, 100);
    }
    
    //Objects to execute
    private static ArrayList<ITimable> timableObjects1 = new ArrayList<ITimable>();
    private static ArrayList<ITimable> timableObjects2 = new ArrayList<ITimable>();
    private static ArrayList<ITimable> timableObjects3 = new ArrayList<ITimable>();
    public static void subscribeTimer(ITimable timableObject, int timerNo)
    {
        switch(timerNo)
        {
            case 1: timableObjects1.add(timableObject);
                break;
            case 2: timableObjects2.add(timableObject);
                break;
            case 3: timableObjects3.add(timableObject);
                break;
            default: JOptionPane.showMessageDialog(form, "Wrong timer number. Suggested numbers: 1, 2, 3", "Big Brother watches over you!", 0);
        }
    }
    
    public static void unsubscribeTimer(ITimable timableObject, int timerNo)
    {
        switch(timerNo)
        {
            case 1: timableObjects1.remove(timableObject);
                break;
            case 2: timableObjects2.remove(timableObject);
                break;
            case 3: timableObjects3.remove(timableObject);
                break;
            default: JOptionPane.showMessageDialog(form, "Wrong timer number. Suggested numbers: 1, 2, 3", "Big Brother watches over you!", 0);
        }
    }
    
    private static void handleTimerTick1()
    {
        for(ITimable timableObject : timableObjects1)
            timableObject.handleTimerTick();
        
        for(WorldEntity visibleEntity : visibleEntities)
        {
            if(!visibleEntity.IsActual())
            {
            unsubscribeTimer((ITimable)visibleEntity, 1);
            }
        }
    }
    private static void handleTimerTick2()
    {
        for(ITimable timableObject : timableObjects2)
            timableObject.handleTimerTick();
    }
    private static void handleTimerTick3()
    {
        for(ITimable timableObject : timableObjects3)
            timableObject.handleTimerTick();
    }
    //Global timer end.
    
    //Global events begin
    public static EntitiesCollidedEvent entitiesCollidedEvent = new EntitiesCollidedEvent("This is global event");
    //Global events end. 
}
