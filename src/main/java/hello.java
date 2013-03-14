import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class hello{


    public static void main(String args[]){
         GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        Font[] allFonts = ge.getAllFonts();

        for (int i = 0; i < allFonts.length; i++) {
            Font f = allFonts[i].deriveFont(10.0f);
            System.out.println(f.getFontName());

        }
    }

}