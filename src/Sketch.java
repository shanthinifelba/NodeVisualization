
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;

import processing.core.*;

//basic sketch drawing a grid. Right now grid is not based on the json file
public class Sketch extends PApplet {
	private int numberOfNodes;
	private int gridWidth; 
	private int gridHeight;
	private int DrawingSpaceWidth;
	private int DrawingSpaceHeight;
	private int OffSetX = 20;
	private int OffSetY = 20;
	private ArrayList<RoughNodes> nodes = new ArrayList<>();
	
	
	public void setup() {
		settings();
		background(102);
		DrawingSpaceWidth = width -OffSetX*2;
		DrawingSpaceHeight = height - OffSetY*2;
		try {
			Gson gson = new Gson();
			
			RoughBase myTypes = gson.fromJson(new FileReader("C:/Users/Administrator/workspace/NodeVisualization/simulatorJSON/grids.json"), RoughBase.class);
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
		//System.out.println(gridspace);
		drawBasicGrid(gridWidth,gridHeight); //draws the basic grid 
		drawNodes(numberOfNodes);
	//	drawNodes(numberOfNodes); //places the nodes on the grid intersection
	
	}

	

	public void settings() 
	{
		  size(800, 800);
	}
	
	public  void drawBasicGrid(int gridWidth,int gridHeight)
	{
		 for (int i = 0; i < 5; i++) {
			  int startX = i * gridWidth + OffSetX;
			  line (startX, OffSetY, startX, DrawingSpaceHeight+OffSetY);
			}
			for (int i = 0; i < 5; i++) {
			  int startY = i * gridHeight + OffSetY;
			  line (OffSetX, startY, DrawingSpaceWidth+OffSetX, startY);
			}
	}
	
	
	
	public void drawNodes(int number)
	{
		stroke(0);
	  
	
	    		 for (int j=0; j <numberOfNodes; j++) {
	    			 int type = nodes.get(j).getType ();
	    			if(type == 0){
	    			 int StartX = gridWidth*j + OffSetX; 
		    			for (int k=0; k < numberOfNodes; k++) 
		    			{
		    						int StartY = gridHeight*k + OffSetY;
		    			  ellipse(StartX,StartY,25,25);
		    			  fill(50,50,255);
			    			
		    			 }
	    			}
	    			else if(type == 1){
	    			int StartX = gridWidth*j + OffSetX; 
	    			for (int k=0; k < numberOfNodes; k++) 
	    			{
	    						int StartY = gridHeight*k + OffSetY;
	    			  ellipse(StartX,StartY,25,25);
	    			  fill(150,150,255);
		    			
	    			 }
	    		 }
	    		
	    		
	    		else{
	    		System.out.println("Node type cannot be identified");
	    		}
	    		
	   
	    }
	
	}
	
}
	
	
	
	
	
	
	
	
	
	
	







