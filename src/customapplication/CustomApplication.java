/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customapplication;

import javax.swing.JFrame;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 *
 * @author Oleg
 */
public class CustomApplication extends SingleFrameApplication
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(CustomApplication.class, args);
    }

    public static CustomApplication getApplication() {
        return Application.getInstance(CustomApplication.class);
    }
    
    @Override
    protected void startup()
    {
        show(new MainPanel(this));
    }
}
