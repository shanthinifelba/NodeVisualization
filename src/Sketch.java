
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import com.google.gson.Gson;

import processing.core.PApplet;

//basic sketch drawing a grid. Right now grid is not based on the json file
public class Sketch extends PApplet {
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
	private int sourceX,sourceY,destinationX,destinationY;
	private ArrayList<NodeCoordinates> nodeCoordinates = new ArrayList<NodeCoordinates>();
	private ArrayList<Car> cars = new ArrayList<Car>();
	
	public void setup() {
		settings();
		background(152);
		DrawingSpaceWidth = width -OffSetX*2;
		DrawingSpaceHeight = height - OffSetY*2;
		
		 
		try {
			Gson gson = new Gson();
			
			RoughBase myTypes = gson.fromJson(new FileReader("C:/Users/rajendr/Documents/GitHub/NodeVisualization/simulatorJSON/grids.json"), RoughBase.class);
			//total number of nodes from ArrayList<nodes>
			System.out.println(myTypes.nodes.size());
			numberOfNodes = myTypes.nodes.size();
			nodes = myTypes.nodes;
			
			System.out.println(myTypes.nodes.get(0).toString());
			System.out.println(myTypes.edges.get(1).toString());
			
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void draw() {
		
		gridWidth = (int)((DrawingSpaceWidth)/Math.sqrt(numberOfNodes));
		gridHeight = (int)((DrawingSpaceHeight)/Math.sqrt(numberOfNodes));
		
		drawBasicGrid(gridWidth,gridHeight); //draws the basic grid 
		drawNodes(numberOfNodes);
		if(runonce){
			for(int i=0; i<numberOfCars; i++){
				
				
				drawCar(cars.get(i));
			
			}
			runonce = false;
		}
		moveCar(sourceX,sourceY,destinationX,destinationY);
		
	
	}

	

	

	

	private void moveCar(int sourcex,int sourcey, int destinationx, int destinationy) {
	
	}

	private void drawCar(Car car) {
		Random Rand = new Random();
		int startX = Rand.nextInt(DrawingSpaceWidth)+1;
		int startY = Rand.nextInt(DrawingSpaceHeight)+1;
		
		noStroke();
			fill(153,0,76);
			rect(startX, startY, 20, 10);
			ellipse(startX+5, startY+10, 5, 5);
			ellipse(startX+15, startY+10, 5, 5);
		
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
		//add objects into arrsylist
		for (int n=0; n<numberOfNodes;n++){
			nodeCoordinates.add(new NodeCoordinates());
			nodeCoordinates.get(n).setName(nodes.get(n).name);
			
			cars.add(new Car());
			
		}
	  
	    for (int j=0; j <numberOfNodes; j++) {
	    	
	    	
	    	int type = nodes.get(j).getType ();
	    	
	    	if(type == 0){ //regular nodes
	    	int StartX = gridWidth*j + OffSetX; 
	    	nodeCoordinates.get(j).Nodex = StartX;
		    	for (int k=0; k < numberOfNodes; k++) 
		    		{
		    		int StartY = gridHeight*k + OffSetY;
		    		nodeCoordinates.get(j).Nodey = StartY;
		    		ellipse(StartX,StartY,25,25);
		    		fill(255,223,11);
			    			
		    			 }
	    			}
	    			else if(type == 1){ //traffic signals
	    			int StartX = gridWidth*j + OffSetX; 
	    			nodeCoordinates.get(j).Nodex = StartX;
	    			for (int k=0; k < numberOfNodes; k++) 
	    			{
	    						int StartY = gridHeight*k + OffSetY;
	    						nodeCoordinates.get(j).Nodey = StartY;
	    			  ellipse(StartX,StartY,25,25);
	    			  fill(51,51,255);
		    			
	    			 }
	    		 }
	    		
	    		
	    		else{
	    		System.out.println("Node type cannot be identified");
	    		}
	    		
	    //	System.out.println("Node coordinates for node" + " " + nodeCoordinates.get(j).name+" "+ "x:"+ nodeCoordinates.get(j).Nodex+" "+ "y:"+ nodeCoordinates.get(j).Nodey);
	    		
	    }
	
	}
	
}
	

	
	
	
	
	
	
	
	







