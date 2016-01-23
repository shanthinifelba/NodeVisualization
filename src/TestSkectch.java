import java.io.FileReader;

import com.google.gson.Gson;

import processing.core.PApplet;

public class TestSkectch {

	
	public static void main(String[] args) {
		try {
			Gson gson = new Gson();
			
			RoughBase myTypes = gson.fromJson(new FileReader("C:/Users/Administrator/workspace/NodeVisualization/simulatorJSON/grids.json"), RoughBase.class);
			
			System.out.println(myTypes.nodes.get(0).toString());
			System.out.println(myTypes.edges.get(1).toString());
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   PApplet.main(new String[] { "Sketch" });

	}

}
