/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customapplication;

import PicturePackage.Picture;
import UnitPackage.*;
import WorldObjectPackage.Wall;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import org.jdesktop.application.*;
/**
 *
 * @author Oleg
 */
public class MainPanel extends FrameView implements ITimable
{
    Location location;
    Picture picture;
    ArrayList<WorldEntity> worldEntities = new ArrayList<WorldEntity>();
    ArrayList<Unit> units = new ArrayList<Unit>();
    JPanel form;
    Private private1;
    Player player;
    Wall wall1;
    public MainPanel(SingleFrameApplication app)
    {
        super(app);
        private1 = new Private("Vasja", new Location(150, 150), 10); 
        wall1 = new Wall(10, 20, new Location(50, 50), "Wall1");
        player = new Player("Player1", new Location(1200/2, 600/2), 5, 0);
        
        InitializeComponents();
        SubscribeEvents();
        form.setFocusable(true);
        form.setVisible(true);
        form.setSize(1200,600);
        form.setLocation(50,100);

        GlobalVariables.setFormSize(form.getWidth(), form.getHeight());
        launchTimer();
        GlobalVariables.initializeTimers();
    } 
    
    public void addComponents()
    {
        componentTimer.cancel();
        componentTimer = null;
        picture.setVisible(true);
        picture.setSize(1200, 600);
        form.add(picture);
        form.repaint();
    }
    
    private void InitializeComponents()
    {
        form = new javax.swing.JPanel();
        form.setName("Form1");        
        setComponent(form);
        try
        {
            GlobalVariables.setForm(form);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(form, ex.getMessage(), "Big Brother watches over you!", 0);
        }
        worldEntities.add(private1);
        units.add(private1);
        worldEntities.add(wall1);
        worldEntities.add(player);
        picture = new Picture(worldEntities);     
    }
    
    private void SubscribeEvents()
    {
        form.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {keyPressedHandler(evt);} 
            public void keyReleased(java.awt.event.KeyEvent evt) {keyReleasedHandler(evt);} 
        });
        form.addMouseListener(new MouseInputAdapter() {
            public void mousePressed(java.awt.event.MouseEvent mEvt) {mousePressedHandler(mEvt);}
        });
    }    
    
    private void mousePressedHandler(java.awt.event.MouseEvent mEvt)
    {
        GlobalVariables.mouseLocation = new Location(mEvt.getX(), mEvt.getY());
        player.shot();
    }
    
    private ArrayList<String> keysPressed = new ArrayList<String>();
    private void keyPressedHandler(java.awt.event.KeyEvent evt)
    {
        String keyPressed ="";
        keyPressed += evt.getKeyChar();
        if (!keysPressed.contains(keyPressed))
        keysPressed.add(keyPressed);
        checkDirection();
    }
    
    private void checkDirection()
    {
        if (keysPressed.contains("w"))
        {
            player.changeDirection("up");
        }           
        if (keysPressed.contains("a"))
        {
            player.changeDirection("left");
        }
        if (keysPressed.contains("d"))
        {
            player.changeDirection("right");
        }
        if (keysPressed.contains("s"))
        {
            player.changeDirection("down");
        }
                
        if (keysPressed.contains("w") && keysPressed.contains("d"))
        {
            player.changeDirection("upRight");
        }
        if (keysPressed.contains("w") && keysPressed.contains("a") )
        {
            player.changeDirection("upLeft");
        }  
        if (keysPressed.contains("s") && keysPressed.contains("d"))
        {
            player.changeDirection("downRight");
        }
        if (keysPressed.contains("s") && keysPressed.contains("a"))
        {
            player.changeDirection("downLeft");
        }
        if(keysPressed.isEmpty())
        player.changeDirection("stay");
    }
    
    private void keyReleasedHandler(java.awt.event.KeyEvent evt)
    {
        String keyReleased = "";
        keyReleased += evt.getKeyChar();
        keysPressed.remove(keyReleased);
        checkDirection();
    }
    
    java.util.Timer componentTimer = new java.util.Timer("Timer 1");
    private void launchTimer()
    {   
        componentTimer.schedule(new java.util.TimerTask(){public void run(){addComponents();}},1000, 500);
        GlobalVariables.subscribeTimer(this, 1);
    }

    @Override
    public void handleTimerTick()
    {
        for (Unit unit : units)
        {
            unit.Move();
        }
        player.Move();
        form.repaint();
    }
}
