
package ball.shooting;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/***
 * this class is for the Help state
 * @author Shiam Chowdhury
 */
public class HelpState {
    
    public Rectangle back = new Rectangle(250, 340, 100,50);
    
    public void backButton(Graphics2D g2d){
        //g2d.draw(back);
       Font font1 = new Font("arial", Font.BOLD, 16);
       g2d.setFont(font1);
       g2d.setColor(Color.DARK_GRAY);
       g2d.drawString("How to Play:", 95, 80);
       g2d.drawString("Right Click on Mouse to fire a ball. Firing on green ball", 95, 98);
       g2d.drawString("increases score by one and firing on red ball decreases ", 95, 113);
       g2d.drawString("score by one. Missfiring will cause a life. ", 95, 128);
       Font font2 = new Font("arial", Font.BOLD, 22);
       g2d.setFont(font2);
       g2d.drawString("Ball Shooting", 95, 275);
       g2d.setFont(font1);
       g2d.drawString("version 1.0.0", 96, 295);
       g2d.drawString("Developed by SHIAM CHOWDHURY", 96, 313);
       g2d.drawString("Dept. of CSE,SUST", 96, 331);
    }
    
}
