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

	//Añade un cuerpo a la lista de cuerpos
	public void addBody(Body b) {
		for (Body bd : bodies)
			if (bd.equals(b)) { //Si el cuerpo ya esta añadido se lanza una excepcion
				throw new IllegalArgumentException();
			}
		bodies.add(b);
	}

	//Devuelve el estado del simulador en formato JSONObject
	public JSONObject getState() {
		JSONObject simulator = new JSONObject();
		simulator.put("time", time);
		ArrayList<JSONObject> jBodies = new ArrayList<JSONObject>();
		for (Body bd : bodies) {
			JSONObject jBody = bd.getState(); //Devuelve el estado de cada cuerpo y lo añade al JSONObject
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
