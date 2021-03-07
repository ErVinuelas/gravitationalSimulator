package simulator.model;


import java.util.List;
import simulator.model.Body;
import simulator.model.ForceLaws;
import org.json.JSONObject;

public class PhysicsSimulator {
	
	private double dt;
	private ArrayList<ForceLaws> laws;
	private List<Body> bodies;
	
	private double time = 0.0;
	
	
	/*Métodos*/
	
	public void advance() {
		for(Body bd : bodies)
			bd.resetForce();
		for(ForceLaws law : laws)
			law.apply(bodies);
		for(Body bd : bodies)
			bd.move(dt);
		totalTime += dt;			
	}
	
	public void addBody(Body b) {
		
	}
	
	public JSONObject getState() {
		JSONObject simulator = new JSONObject();
		simulator.add("time", time);
		JSONObject[] jBodies = new JSONObject[];
		for(Body bd : bodies) {
			JSONObject jBody = new JSONObject();
			jBody = bd.getState();
			jBodies.add(jBody);
		}
		simulator.add("bodies", jBodies);
		
		return simulator;
	}
	
	public String toString() {
		return getState().toString();
	}
	
}
