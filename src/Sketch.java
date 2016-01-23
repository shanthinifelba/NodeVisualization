
import processing.core.*;

//basic sketck drawing a grid. Right now grid is not based on the json file
public class Sketch extends PApplet {
	

	public void setup() {
		settings();
		background(102);
	    
	}

	public void draw() {
		
		int grid = 120; // change this number to 20 or 50, etc., if you want fewer grid lines
		
		 for (int i = 0; i < width; i+=grid) {
		  line (i, 0, i, height);
		}
		for (int i = 0; i < height; i+=grid) {
		  line (0, i, width, i);
		}

	  
	}

	public void settings() {
		  size(800, 800);
		}
	 
	   

}
