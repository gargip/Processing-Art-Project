import ddf.minim.AudioOutput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.*;
/**
 * Tone is a subclass of Processing applet.
 *    -It will initialize the applet.
 *    -Shapes and text are drawn on the screen.
 *    -Mouse and keyboard input are read in.
 */
public class Tone extends PApplet
{
    private Minim minim;
    private AudioOutput out;

    private static final int HEIGHT = 400;
    private static final int WIDTH = 400;

    private int white;
    private int black;
    private int color1;

    private String pitch;
    private float delayInBeats;
    private float durationInBeats;

    /**
     * Launch the Processing Application,
     *     Calls settings() once, then setup() once, then draw() 30 times per second.
     */
    public static void main(String args[]) {
        String packageFilename = "Tone";
        PApplet.main(new String[] { packageFilename });
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
        color1 = color(0,255,255);
        
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
        
        fill(color1);
        noStroke(); // No border on the ellipse
        ellipse(200,200,200,100); // center x, center y, width, height
        
        // Write pitch
        fill(black);
        textSize(16);
        textAlign(CENTER, CENTER);
        String output = "Pitch: " + pitch + "\nDelay: " + delayInBeats + "\nDuration: " + durationInBeats;
        text(output, 200, 200);
    }

    /**
     * Handle Key Press (Down)
     */
    public void keyPressed() {
        if(key == ' ') {
            out.playNote(delayInBeats, durationInBeats, pitch);
        }
        else if(key == 'c') {
            pitch = "C4";
        }
        // TODO 1: If a user presses the 'd' key, change the pitch to "D4"
        
        // TODO 2: 
        //    If a user presses the '1' key, increase the durationInBeats by 0.5f
        //    If a user presses the '2' key, decrease the durationInBeats by 0.5f  (do not go below 0)
        
        // TODO 3: 
        //    If a user presses the '4' key, increase the delayInBeats by 0.5f
        //    If a user presses the '5' key, decrease the delayInBeats by 0.5f (do not go below 0)
    }
}
