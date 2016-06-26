
package ball.shooting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



/***
 * this class write from file from highscore
 * @author Shiam Chowdhury
 */
public class HighScore {
    
 
    File file = new File("keephighscore.txt");
    public void writeHighScore(String s){
        
        try{
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            } 
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
	    bw.write(s);
            bw.close();
 
	    //.out.println("Done");
 
	}catch (IOException e) {
                e.printStackTrace();
         }
    }
}