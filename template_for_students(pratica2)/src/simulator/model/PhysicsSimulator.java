package simulator.model;

import java.util.ArrayList;
import org.json.*;

public class PhysicsSimulator {

	private double dt;
	private ForceLaws law;
	private ArrayList<Body> bodies;

	private double time = 0.0;

	//Constructor
	public PhysicsSimulator(double dt, ForceLaws law) {
		this.dt = dt;
		this.law = law;
		bodies = new ArrayList<Body>();
	}

	//Metodos
	//Realiza un paso del simulador
	public void advance() {
		
		for (Body bd : bodies) { //Reinicia la fuerza sobre los cuerpos
			bd.resetForce();
		}
		law.apply(bodies); //Aplica la fuerza sobre los cuerpos
		for(Body bd : bodies) { //Mueve cada cuerpo en un tiempo equivalente a un paso
			bd.move(dt);
		}
		time += dt; //Aumenta el contador del simulador
	}

	//A�ade un cuerpo a la lista de cuerpos
	public void addBody(Body b) {
		if(bodies.contains(b)){//Si el cuerpo ya esta a�adido se lanza una excepcion
				throw new IllegalArgumentException();
		}
		bodies.add(b);
	}
	
	
	public body reset() {
	    dt = 0.0;
	    bodies.clear();
	}
	
	public setDeltaTime(double dt) {
	    if(dt > 0) {
		this.dt = dt;
	    }
	    else {
		throw new IllegalArgumentException("The DeltaTime is not greater than 0");
	    }
	}
	
	public void setForceLaws(ForceLaws forceLaws) {
	    if(!forceLaws.equals(null)) {
		this.law = forceLaws;
	    }
	    else {
		throw new IllegalArgumentException("The force laws are equal to null");
	    }
	}
	
	

	//Devuelve el estado del simulador en formato JSONObject
	public JSONObject getState() {
		JSONObject simulator = new JSONObject();
		simulator.put("time", time);
		ArrayList<JSONObject> jBodies = new ArrayList<JSONObject>();
		for (Body bd : bodies) {
			JSONObject jBody = bd.getState(); //Devuelve el estado de cada cuerpo y lo a�ade al JSONObject
			jBodies.add(jBody);
		}
		simulator.put("bodies", jBodies);

		return simulator;
	}

	//Devuelve el estado en forma de String
	public String toString() {
		return getState().toString();
	}

}
