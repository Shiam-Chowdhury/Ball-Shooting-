
package ball.shooting;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/***
 * this class controlls every action of mouse click
 * @author Shiam Chowdhury
 */
public class ClickMenu implements MouseListener {
    
    static int mx;
    static int my;

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /***
     * mouse pressed is called for clicking the mouse
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        /*
            public Rectangle playButton = new Rectangle(230, 130, 130, 50);
            public Rectangle aboutButton = new Rectangle(230, 210, 130, 50);
            public Rectangle quitButton = new Rectangle(230, 290, 130, 50);
        */
        
        //
        if((mx >= 230 && mx <= 360) && 
                (my >= 130 && my <= 180) && Game.state == Game.STATE.MENU){
            Game.state = Game.STATE.GAME;
            
        }
        else if((mx >= 230 && mx <= 360) &&
                (my >= 210 && my <= 260 ) && Game.state == Game.STATE.MENU){
            
                Game.state = Game.STATE.HELP;
        }
        else if((mx >= 230 && mx <= 360) &&
                (my >= 290 && my <= 340 ) && Game.state == Game.STATE.MENU){
            
                System.exit(0);
        }
        //250, 340, 100,50
        //
        else if(Game.state == Game.STATE.GAME)
        {
            if((mx >= 12 && mx <= 67) &&
                (my >= 358 && mx <= 413)){
                Game.state = Game.STATE.PAUSE;
                
            }
            else{
                Controller.clickflag = 0;
                
                Controller.fire();
            }
            
        }
        
        else if((mx >= 250 && mx <= 350) &&
                (my >= 340 && mx <= 390) && Game.state == Game.STATE.HELP)
        {

                Game.state = Game.STATE.MENU;
        } 
        
        //12, 358, 55,55
        /*
        else if((mx >= 12 && mx <= 67) &&
                (my >= 358 && mx <= 413) && Game.state == Game.STATE.GAME)
        {
                Game.state = Game.STATE.PAUSE;
        }
        
        */
        //173, 93, 245, 240
        else if((mx >= 173 && mx <= 418) &&
                (my >= 93 && my <= 333) && Game.state == Game.STATE.PAUSE)
        {
                Controller.clickflag = 1;
                Game.state = Game.STATE.GAME;
                
        }
        //
        else if((mx >= 30 && mx <= 160) &&
                (my >= 350 && my <= 400) && Game.state == Game.STATE.GAMEOVER)
        {
            
            
                
                //System.exit(1);
                Controller.removeCrossRedBall();
                Controller.score = 0;
                Controller.addTikCrossBall();
                Game.state = Game.STATE.GAME;
            
        }
        else if((mx >= 435 && mx <= 565) &&
                (my >= 350 && my <= 400) && Game.state == Game.STATE.GAMEOVER)
        {
            
                System.exit(0);
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
