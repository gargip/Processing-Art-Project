import ddf.minim.AudioOutput;

import java.awt.event.MouseEvent;
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
public class TryWithPNG extends PApplet
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
    
    private PImage img1;
    private PImage violin;
	private PImage img2;
	
	private static int count = 0;
	private java.util.Date currentTime;
	private int songLocation;
	
	private int noteTime;
    
    /**
     * Launch the Processing Application,
     *     Calls settings() once, then setup() once, then draw() 30 times per second.
     */
    public static void main(String args[]) {
        String packageFilename = "TryWithPNG";
        PApplet.main(new String[] {packageFilename});
    }
    
    public void settings() { // Sets the Application Properties.
        size(WIDTH,HEIGHT); // Set size of screen
    }

    public void setup() { // Called once at the start
        white = color(255,255,255); // (r, g, b) [0, 256)
        black = color(0,0,0);
        red = color(255,0,0);
        
        minim = new Minim(this);
        out = minim.getLineOut( Minim.STEREO, 2048 );
        
        pitch = "C4"; // Middle C
        delayInBeats = 0.0f;
        durationInBeats = 0.5f;
    }
   
    public void draw() { // Called repeatedly (once per frame)
    	
    	background(white); // Fill background color with white
        fill(black);
        textSize(25);
        textAlign(CENTER, CENTER);
        String output = "Welcome to Violin Tutorial! \nPress t for twinkle, or x to exit";
        text(output, 200, 200);
        
        if (songLocation == 0 && noteTime == second()){
        	img1 = loadImage("1.PNG");
        	image(img1, 0, 0);
        	
        }
        if (songLocation == 1 && noteTime == second()){
        	img1 = loadImage("1.PNG");
        	image(img1, 100, 100);
        	
        }
        if (songLocation == 2 && noteTime == second()){
        	img1 = loadImage("1.PNG");
        	image(img1, 200, 200);
        	
        }
        if (songLocation == 3 && noteTime == second()){
        	img1 = loadImage("1.PNG");
        	image(img1, 300, 300);
        	
        }
        if (key == 't' || key == 'T') {
        	violin = loadImage("Fingerboard.PNG");
        	image(violin, 0, 0);
//        	String mouse = "x: " + mouseX + "y :" + mouseY;
//        	textSize(15);
//        	text(mouse, 350, 350);
        } else if (key == 'x' || key == 'X') {
        	background(white);
         	text("Goodbye!", 200, 200);
        }
    }
        
    public void drawViolin() { // draws the violin fingerboard
    	background(white); // Fill background color with white
//    	img1 = loadImage("Circle.PNG");
//    	image(img1, 86, 110);
    	System.out.println("Drawing Violin");
        fill(black);
        rect(120,40,5,300); // center x, center y, width, height
        String output = "G";
        text(output, 122, 360);
        
        fill(black);
        rect(170,40,5,300); // center x, center y, width, height
        output = "D";
        text(output, 173, 360);
        System.out.println("Drawing Violin");
        fill(black);
        rect(220,40,5,300); // center x, center y, width, height
        output = "A";
        text(output, 224, 360);
        
        fill(black);
        rect(270,40,5,300); // center x, center y, width, height
        output = "E";
        text(output, 273, 360);
    }
    
    public void showNote() {
    }
    
    public void playTwinkle() {
    	songLocation = 0;
    	System.out.println("Playing Twinkle");
    	noteTime = second();
    	out.playNote(delayInBeats, durationInBeats, "C4");
    	songLocation++;
    	img1 = loadImage("1.PNG");
    	image(img1, 0, 0);

    	out.playNote(delayInBeats, durationInBeats, "G4");
    	songLocation++;
    	image(img1, 100, 100);
    	
    	out.playNote(delayInBeats, durationInBeats, "A4");
    	songLocation++;
    	
    	image(img1, 200, 200);
    	out.playNote(delayInBeats, durationInBeats, "E4");
    	image(img1, 300, 300);
    	
    }
    
    public void keyPressed() {
    	 if (key == 't' || key == 'T') {
    		playTwinkle();
         	showNote();
         }
    }
}