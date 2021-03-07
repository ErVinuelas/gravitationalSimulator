package simulator.model;


import java.util.ArrayList;
import simulator.model.Body;
import simulator.model.ForceLaws;
import org.json.JSONObject;

public class PhysicsSimulator {
	
	private double dt;
	private ArrayList<ForceLaws> laws;
	private ArrayList<Body> bodies;
	
	private double time = 0.0;
	
	
	/*Métodos*/
	
	public void advance() {
		for(Body bd : bodies)
			bd.resetForce();
		for(ForceLaws law : laws)
			law.apply(bodies);
		for(Body bd : bodies)
			bd.move(dt);
		time += dt;			
	}
	
	public void addBody(Body b) {
		for(Body bd : bodies)
			if(bd.equals(b)) {	throw new IllegalArgumentException();	}
		bodies.add(b);
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
