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
    private int A3 = 30;
    
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
        
        //fill(color1);
        fill(black);
        textSize(25);
        textAlign(CENTER, CENTER);
        String output = "Welcome to Violin Tutorial! \nPress t for twinkle, or x to exit";
        text(output, 200, 200);
        
        if (key == 't' || key == 'T') {
        	drawViolin();
        	while (A3 >= 0) {
            	fill(red);
            	noStroke();
            	ellipse(123,110,40,40);
            	A3--;
            }
        } else if (key == 'x' || key == 'X') {
        	background(white);
         	text("Goodbye!", 200, 200);
        }
                
        /*
        // Write pitch
        fill(black);
        textSize(16);
        textAlign(CENTER, CENTER);
        output = "Pitch: " + pitch + "\nDelay: " + delayInBeats + "\nDuration: " + durationInBeats;
        text(output, 200, 200);
        */
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
    	c4();
    	c4();
    	g4();
    	g4();
    	a4();
    	a4();
    	durationInBeats += 0.5;
    	g4();
    	durationInBeats -= 0.5;
    	f4();
    	f4();
    	d4();
    	d4();
    	durationInBeats += 0.5;
    	c4();
    	durationInBeats -= 0.5;
    	
    }
    
    public void g3() {        out.playNote(delayInBeats, durationInBeats, "G3");    }
    public void a3() {        out.playNote(delayInBeats, durationInBeats, "A3");    }
    public void b3() {        out.playNote(delayInBeats, durationInBeats, "B3");    }
    public void c4() {        out.playNote(delayInBeats, durationInBeats, "C4");    }
    
    public void d4() {        out.playNote(delayInBeats, durationInBeats, "D4");    }
    public void e4() {        out.playNote(delayInBeats, durationInBeats, "E4");    }
    public void f4() {        out.playNote(delayInBeats, durationInBeats, "F4");    }
    public void g4() {        out.playNote(delayInBeats, durationInBeats, "G4");    }
    
    public void a4() {        out.playNote(delayInBeats, durationInBeats, "A4");    }
    public void b4() {        out.playNote(delayInBeats, durationInBeats, "B4");    }
    public void c5() {        out.playNote(delayInBeats, durationInBeats, "C5");    }
    public void d5() {        out.playNote(delayInBeats, durationInBeats, "D5");    }
    
    public void e5() {        out.playNote(delayInBeats, durationInBeats, "E5");    }
    public void f5() {        out.playNote(delayInBeats, durationInBeats, "F5");    }
    public void g5() {        out.playNote(delayInBeats, durationInBeats, "G5");    }
    public void a5() {        out.playNote(delayInBeats, durationInBeats, "A5");    }
    public void b5() {        out.playNote(delayInBeats, durationInBeats, "B5");    }
    /**
     * Handle Key Press (Down)
     */
    public void keyPressed() {
    	 if (key == 't' || key == 'T') {
         	playTwinkle();
         }
    	 //    	 
//        if(key == ' ') {
//            out.playNote(delayInBeats, durationInBeats, pitch);
//        }
//        else if(key == 'c') {
//            pitch = "C4";
//        }
//        else if(key == 'd') {
//        	pitch = "D4";
//        }
//        else if (key == '1') {
//        	durationInBeats += 0.5;
//        }
//        else if (key == '2' && durationInBeats >= 0.5) {
//        	durationInBeats -= 0.5;
//        }
//        else if (key == '4') {
//        	delayInBeats += 0.5;
//        }
//        else if (key == '5' && delayInBeats >= 0.5) {
//        	delayInBeats -= 0.5;
//        }
//        // TODO 1: If a user presses the 'd' key, change the pitch to "D4"
//        
//        // TODO 2: 
//        //    If a user presses the '1' key, increase the durationInBeats by 0.5f
//        //    If a user presses the '2' key, decrease the durationInBeats by 0.5f  (do not go below 0)
//        
//        // TODO 3: 
//        //    If a user presses the '4' key, increase the delayInBeats by 0.5f
//        //    If a user presses the '5' key, decrease the delayInBeats by 0.5f (do not go below 0)
    }
}
