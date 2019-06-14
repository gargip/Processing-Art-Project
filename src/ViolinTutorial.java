import ddf.minim.AudioOutput;

import java.awt.event.MouseEvent;
import java.lang.*;
import java.util.concurrent.TimeUnit;

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
    
    private PImage violin;
    private PImage img1;
	private PImage img2;
	private PImage img3;
	private PImage circle;
	
	private int songLocation;
	private String[] twinkleNotesAudio = {"Z1", "Z1","C4", "C4", "G4", "G4", "A4", "A4", "G4", "Z1", "F4", "F4", "E4", "E4", "D4", "D4", "C4", "Z1", "G4", "G4", "F4", "F4", "E4", "E4", "D4", "Z1", "G4", "G4", "F4", "F4", "E4", "E4", "D4", "Z1", "C4", "C4", "G4", "G4", "A4", "A4", "G4", "Z1", "F4", "F4", "E4", "E4", "D4", "D4", "C4", "Z1"};
	private String[] twinkleNotesVisual = {"Z1","C4", "C4", "G4", "G4", "A4", "A4", "G4", "Z1", "F4", "F4", "E4", "E4", "D4", "D4", "C4", "Z1", "G4", "G4", "F4", "F4", "E4", "E4", "D4", "Z1", "G4", "G4", "F4", "F4", "E4", "E4", "D4", "Z1", "C4", "C4", "G4", "G4", "A4", "A4", "G4", "Z1", "F4", "F4", "E4", "E4", "D4", "D4", "C4", "Z1"}; //ONE LESS FILLER
	
	private String[] eineKleineAudio = {"Z1", "Z1", "G4", "Z1", "Z1", "D4", "G4", "Z1", "Z1", "D4", "G4", "D4", "G4", 
			"B4", "D5", "Z1", "Z1", "Z1", "C5", "Z1", "Z1", "A4", "C5", "Z1", "Z1", "A4", "C5", "A4", "F#4", "A4", 
			"D4", "Z1", "Z1", "Z1"};
	private String[] eineKleineVisual = {"Z1", "G4", "Z1", "Z1", "D4", "G4", "Z1", "Z1", "D4", "G4", "D4", "G4", "B4", "D5", "Z1", "Z1", "Z1", "C5", "Z1", "Z1", "A4", "C5", "Z1", "Z1", "A4", "C5", "A4", "F#4", "A4", "D4", "Z1", "Z1"};
	
	public int count = 0;
	public int tempo; //1000 is equal to 60 bpm
	
	public int startTime = second();
    
    /**
     * Launch the Processing Application,
     *     Calls settings() once, then setup() once, then draw() 30 times per second.
     */
    public static void main(String args[]) {
        String packageFilename = "ViolinTutorial";
        PApplet.main(new String[] {packageFilename});
    }
       
    public void draw() { // Called repeatedly (once per frame)
    	
    	violin = loadImage("Fingerboard.PNG");
        img1 = loadImage("1.PNG");
        img2 = loadImage("2.PNG");
        img3 = loadImage("3.PNG");
        int notePosition;
        int finger;
    	background(white); // Fill background color with white
        fill(black);
        textSize(25);
        textAlign(CENTER, CENTER);
        String output = "Welcome to Violin Tutorial! \nPress 't' for Twinkle Twinkle, \n 'e' for Eine Kleine, \nor 'x' to exit";
        text(output, 200, 200);
        
        
        if (key == 't' || key == 'T') {
        	image(violin, 0, 0);
        	String currentNote = twinkleNotesVisual[songLocation];
        	char note = currentNote.charAt(0);
        	int pitch = Integer.parseInt(currentNote.substring(currentNote.length()-1));
        	//System.out.println(note+""+pitch);
        	int x = determineX(note, pitch);
        	int y = determineY(currentNote);
        	PImage img = determineFinger(currentNote);
        	char open = determineOpen(currentNote);
        	if (open == 'G') {
        		fill(red);
        		output = "G";
                text(output, 121, 361);
        	}
        	if (open == 'D') {
        		fill(red);
        		output = "D";
                text(output, 172, 361);
        	}
        	if (open == 'A') {
        		fill(red);
        		output = "A";
                text(output, 223, 361);
        	}
        	if (open == 'E') {
        		fill(red);
        		output = "E";
                text(output, 272, 361);
        	}
        	image(img, x, y);
           	playTwinkle();
           	if (twinkleNotesVisual.length <= songLocation ){
        		key = BACKSPACE;
        		songLocation=0;
        	}
        } else if (key == 'e' || key == 'E') {
        	image(violin, 0, 0);
        	String currentNote = eineKleineVisual[songLocation];
        	char note = currentNote.charAt(0);
        	int pitch = Integer.parseInt(currentNote.substring(currentNote.length()-1));
        	//System.out.println(note+""+pitch);
        	int x = determineX(note, pitch);
        	int y = determineY(currentNote);
        	PImage img = determineFinger(currentNote);
        	char open = determineOpen(currentNote);
        	if (open == 'G') {
        		fill(red);
        		output = "G";
                text(output, 121, 361);
        	}
        	if (open == 'D') {
        		fill(red);
        		output = "D";
                text(output, 172, 361);
        	}
        	if (open == 'A') {
        		fill(red);
        		output = "A";
                text(output, 223, 361);
        	}
        	if (open == 'E') {
        		fill(red);
        		output = "E";
                text(output, 272, 361);
        	}
        	image(img, x, y);
        	playEineKleine();
           	if (eineKleineVisual.length <= songLocation ){
        		key = BACKSPACE;
        		songLocation=0;
        	}
        }
        else if (key == 'x' || key == 'X') {
        	background(white);
         	text("Goodbye!", 200, 200);
        }
    }
    
    public int determineX(char note, int pitch) {
    	if (pitch == 3 || (note == 'C' && pitch == 4) ) { //G string notes
    		return 86;
    	}
    	if (pitch == 4 && (note == 'D' || note == 'E' || note == 'F' || note == 'G')) { // D string notes
    		return 137; 
    	}
    	if ((pitch == 4 && (note == 'A' || note == 'B')) || (pitch == 5 && (note == 'C' || note == 'D'))) { //A string notes
    		return 188;
    	} else if (pitch == 5) {
    		return 239;
    	}
    	if (pitch == 'Z') {
    		return 1000;
    	}
    	return 137;
    }
    
    public int determineY(String note) {
    	if (note.equals("A3") || note.equals("E4") || note.equals("B4") || note.equals("F#5")) {
    		return 70;
    	}
    	if (note.equals("b4") || note.equals("F4") || note.equals("C5") || note.equals("G5")) {
    		return 120;
    	}
    	if (note.equals("B3") || note.equals("F#4") || note.equals("C#5") || note.equals("G#5")) {
    		return 180;
    	}
    	if (note.equals("C4") || note.equals("G4") || note.equals("D5") || note.equals("A5")) {
    		return 250;
    	}
    	
    	return 1000;
    }
    
    public PImage determineFinger(String note) {
    	img1 = loadImage("1.PNG");
        img2 = loadImage("2.PNG");
        img3 = loadImage("3.PNG");
        circle = loadImage("Circle.PNG");
        if (note.equals("A3") || note.equals("E4") || note.equals("B4") || note.equals("F5")) {
    		return img1;
    	}
    	if (note.equals("b4") || note.equals("F4") || note.equals("C5") || note.equals("G5") || note.equals("B3") || note.equals("F#4") || note.equals("C#5") || note.equals("G#5")) {
    		return img2;
    	}
    	if (note.equals("C4") || note.equals("G4") || note.equals("D5") || note.equals("A5")) {
    		return img3;
    	} 
    	return circle;
    }
    
    public char determineOpen(String note) {
    	if (note.equals("G3")  || note.equals("E3")) {
    		return 'G';
    	}
    	if (note.equals("D4")) {
    		return 'D';
    	}
    	if (note.equals("A4")) {
    		return 'A';
    	}
    	if (note.equals("E5")) {
    		return 'E';
    	}
    	return 'X';
    }
    
    public void playTwinkle() {
    	out.playNote(delayInBeats, durationInBeats, twinkleNotesAudio[songLocation]);
    	songLocation++;
    	sleep(500);	
    }
    
    public void playEineKleine() {
    	out.playNote(delayInBeats, durationInBeats, eineKleineAudio[songLocation]);
    	songLocation++;
    	sleep(200);
    }
    
    private void sleep(int tempo){
    	System.out.println("Going to sleep " + second());
    	if(songLocation <1){
    		return;
    	}
    	try {
			//TimeUnit.SECONDS.sleep(time);
			Thread.sleep(tempo);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	System.out.println("Waking from sleep " + second());
    	
    }
    
    public void keyPressed() {
   	 if (key == 't' || key == 'T') {
   		playTwinkle();
     }
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
        delayInBeats = 0f;
        durationInBeats = 0.5f;
    }
            
}