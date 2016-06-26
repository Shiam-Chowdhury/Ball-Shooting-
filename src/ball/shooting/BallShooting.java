
package ball.shooting;

import javax.swing.JFrame;

/**
 * this in starting file of project
 * @author Shiam Chowdhury
 */
public class BallShooting {
    
    public static final int WIDTH = 600 , HEIGHT = 450;
    public static final String TITLE = "Ball Shooting";
    
    public static void main(String[] args) {
        
        Frame();
        
    }
    
    public static void Frame()
    {
        JFrame frame = new JFrame(BallShooting.TITLE);
        frame.pack();
        frame.setSize(WIDTH,HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(new Game());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        /*String str = "10";
        int y = Integer.parseInt(str);
        y+=5;
        System.out.println("str to int: "+y);*/
        
    }
    
    
}
