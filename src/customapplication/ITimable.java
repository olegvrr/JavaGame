/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customapplication;

/**
 * This interface created to specify behavior of an object which 
 * can listen to the timer;
 * @author Oleg
 */
public interface ITimable
{
    public abstract void handleTimerTick();
    public boolean IsActual();
}
