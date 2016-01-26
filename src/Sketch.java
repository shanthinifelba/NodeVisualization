
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import com.google.gson.Gson;

import processing.core.PApplet;
import processing.core.PVector;

//basic sketch drawing a grid. Right now grid is not based on the json file
public class Sketch extends PApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numberOfNodes;
	private int gridWidth; 
	private int gridHeight;
	private int DrawingSpaceWidth;
	private int DrawingSpaceHeight;
	private int OffSetX = 20;
	private int OffSetY = 20;
	private int numberOfCars = 10; // number of cars;
	private ArrayList<RoughNodes> nodes = new ArrayList<>();
	private boolean runonce = true;
	private PVector location;
	private PVector velocity;
	private ArrayList<Car> cars = new ArrayList<Car>();
	
	public void setup() {
		settings();
		background(152);
		DrawingSpaceWidth = width -OffSetX*2;
		DrawingSpaceHeight = height - OffSetY*2;
		
		 
		try {
			Gson gson = new Gson();
			
			RoughBase myTypes = gson.fromJson(new FileReader("C:/Users/Administrator/workspace/NodeVisualization/simulatorJSON/grids.json"), RoughBase.class);
			//total number of nodes from json file
			numberOfNodes = myTypes.nodes.size();
			nodes = myTypes.nodes;
			gridWidth = (int)((DrawingSpaceWidth)/Math.sqrt(numberOfNodes));
			gridHeight = (int)((DrawingSpaceHeight)/Math.sqrt(numberOfNodes));
			
			System.out.println(myTypes.nodes.get(0).toString());
			System.out.println(myTypes.edges.get(1).toString());
			
			populateCoordinates(numberOfNodes);
			populateVehicles(numberOfCars);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void populateVehicles(int numberOfCars2) {
		for(int j=0; j<numberOfCars; j++){
			Car cars = new Car();
			cars.carid = j;
			//System.out.println("Created car"+" "+ cars.carid);
		}
		
	}

	private void populateCoordinates(int number) {
		 
		 for(int j=0; j<Math.sqrt(number);j++)
		 {
			 int y = gridWidth*j + OffSetY;
			 
			 for (int k=0; k<Math.sqrt(number); k++) 
			 {
			 	int x = gridHeight*k + OffSetX;
			 	int calc =  (int) (Math.sqrt(number)*j + k);
			 	nodes.get(calc).setNodex(x);
			 	nodes.get(calc).setNodey(y);
			 	//System.out.println("coodrinate" + x + " " + y);
			 	//System.out.println(nodes.get(calc).getNodex() + " " + nodes.get(calc).getNodey());
			 }
			 
		 }
		 
		 
		
	}

	public void draw() {
		
	
		
		drawBasicGrid(gridWidth,gridHeight); //draws the basic grid 
		drawNodes(numberOfNodes);
		if(runonce==true){
		drawCars(numberOfCars);
		}
		runonce = false;
		
		moveCar(location,velocity);
	
	}

	public void settings() 
	{
		  size(800, 800);
	}
	
	public  void drawBasicGrid(int gridWidth,int gridHeight)
	{
		 int startX = 0,startY = 0;
		 for (int i = 0; i < 5; i++) {
			   startX = i * gridWidth + OffSetX;
			  line (startX, OffSetY, startX, DrawingSpaceHeight+OffSetY);
			  
			}
			for (int i = 0; i < 5; i++) {
			   startY = i * gridHeight + OffSetY;
			  line (OffSetX, startY, DrawingSpaceWidth+OffSetX, startY);
			}
			
			
	}

	public void drawNodes(int number)
	{
		stroke(0);
		
	  
	    for (int j=0; j <numberOfNodes; j++) 
	    {
	    	
	    	
	    	int type = nodes.get(j).getType ();
	    	
	    	int StartX = nodes.get(j).getNodex();
	    	int StartY = nodes.get(j).getNodey();
	    	 switch(type)
	         {
	            case 0 :
	            	//regular nodes
			    	rect(StartX,StartY,25,25,7);
			    	fill(255,223,11); //yellow
	               break;
	            case 1 :
	            	//traffic signal	
		    		rect(StartX,StartY,25,25,7);
		    		fill(51,51,255); //blue
		               break;
	            default:
	            	System.out.println("Invalid node type");
	         }
	       
	    		
	 //  	System.out.println("Node coordinates for node" + " " + nodes.get(j).name+" "+ "x:"+ nodes.get(j).Nodex+" "+ "y:"+ nodes.get(j).Nodey);
	    		
	    }
	
	}

	private void drawCars(int number) {
		
		for(int n = 0; n<number; n++)
		{
		Random Rand = new Random();
	
		int startX = Rand.nextInt(DrawingSpaceWidth)+1;
		int startY = Rand.nextInt(DrawingSpaceHeight)+1;
		
		noStroke();
			fill(153,0,76);
			ellipse(startX, startY, 15, 15);
			
		}
	}
	

	private void moveCar(PVector location,PVector velocity) {
		//get car's current Location
		
		// Add the current speed to the location.
		  location.add(velocity);

		  // We still sometimes need to refer to the individual components of a PVector 
		  // and can do so using the dot syntax (location.x, velocity.y, etc.)
		  if ((location.x > width) || (location.x < 0)) {
		    velocity.x = velocity.x * -1;
		  }
		  if ((location.y > height) || (location.y < 0)) {
		    velocity.y = velocity.y * -1;
		  }

		  // Display circle at x location
		  stroke(0);
		  fill(175);
		  ellipse(location.x,location.y,16,16);
		
		
	}

	
	
//	private void drawCar() {
//	Random Rand = new Random();
//	int startX = Rand.nextInt(DrawingSpaceWidth)+1;
//	int startY = Rand.nextInt(DrawingSpaceHeight)+1;
//	
//	noStroke();
//		fill(153,53,76);
//		ellipse(startX, startY,  20, 20);
//		//ellipse(startX+5, startY+10, 5, 5);
//		//ellipse(startX+15, startY+10, 5, 5);
//	
//}

	
	
	
	
	
	
	
}
	

	
	
	
	
	
	
	
	







