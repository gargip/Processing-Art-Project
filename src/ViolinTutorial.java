import ddf.minim.AudioOutput;
import java.lang.*;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.*;
/**
 * Tone is a subclass of Processing applet.
 *    -It will initialize the applet.
 *    -Shapes and text are drawn on the screen.
 *    -Mouse and keyboard input are read in.
 */
public class ViolinTutorial extends PApplet
{
    private Minim minim;
    private AudioOutput out;

    private static final int HEIGHT = 400;
    private static final int WIDTH = 400;

    private int white;
    private int black;
    private int red;

    private String pitch;
    private float delayInBeats;
    private float durationInBeats;
    private int t = 0;
    //private int A3 = 100;    
    
    
    /**
     * Launch the Processing Application,
     *     Calls settings() once, then setup() once, then draw() 30 times per second.
     */
    public static void main(String args[]) {
        String packageFilename = "ViolinTutorial";
        PApplet.main(new String[] {packageFilename});
    }
    
    /**
     * Sets the Application Properties.
     */
    public void settings() {
        size(WIDTH,HEIGHT); // Set size of screen
    }

    /**
     * Called once at the start
     */
    public void setup() {
        white = color(255,255,255); // (r, g, b) [0, 256)
        black = color(0,0,0);
        red = color(255,0,0);
        
        minim = new Minim(this);
        out = minim.getLineOut( Minim.STEREO, 2048 );
        
        pitch = "C4"; // Middle C
        delayInBeats = 0.0f;
        durationInBeats = 0.5f;
    }

    /**
     * Called repeatedly (once per frame)
     */
    public void draw() {
    	background(white); // Fill background color with white
        fill(black);
        textSize(25);
        textAlign(CENTER, CENTER);
        String output = "Welcome to Violin Tutorial! \nPress t for twinkle, or x to exit";
        text(output, 200, 200);
        
        if (key == 't' || key == 'T') {
        	drawViolin();
        } else if (key == 'x' || key == 'X') {
        	background(white);
         	text("Goodbye!", 200, 200);
        }
    }
    
    /*
     * draws the violin fingerboard
     */
    
    public void drawViolin() {
    	background(white); // Fill background color with white
     
        fill(black);
        rect(120,40,5,300); // center x, center y, width, height
        String output = "G";
        text(output, 122, 360);
        
        fill(black);
        rect(170,40,5,300); // center x, center y, width, height
        output = "D";
        text(output, 173, 360);
        
        fill(black);
        rect(220,40,5,300); // center x, center y, width, height
        output = "A";
        text(output, 224, 360);
        
        fill(black);
        rect(270,40,5,300); // center x, center y, width, height
        output = "E";
        text(output, 273, 360);
    }
    
    public void playTwinkle() {
    	out.playNote(delayInBeats, durationInBeats, "C4");
    	drawViolin();
    	System.out.println("hi");
    	
    	fill(red);
        noStroke();
        ellipse(123,110,40,40);
    	try {
    		fill(red);
            noStroke();
            ellipse(123,110,40,40); 
            
    		Thread.sleep(2000);

			drawViolin();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	drawViolin();
    }
    
    public void keyPressed() {
    	 if (key == 't' || key == 'T') {
         	playTwinkle();
         }
    }
}