package simulator.model;

import java.util.ArrayList;
import org.json.*;

public class PhysicsSimulator {

	private double dt;
	private ArrayList<ForceLaws> laws;
	private ArrayList<Body> bodies;

	private double time = 0.0;

	/* Constructor */

	public PhysicsSimulator(double dt, ArrayList<ForceLaws> laws) {
		this.dt = dt;
		this.laws = laws;
		bodies = new ArrayList<Body>();
	}

	/* Métodos */

	public void advance() {
		for (Body bd : bodies)
			bd.resetForce();
		for (ForceLaws law : laws)
			law.apply(bodies);
		for (Body bd : bodies)
			bd.move(dt);
		time += dt;
	}

	public void addBody(Body b) {
		for (Body bd : bodies)
			if (bd.equals(b)) {
				throw new IllegalArgumentException();
			}
		bodies.add(b);
	}

	public JSONObject getState() {
		JSONObject simulator = new JSONObject();
		simulator.append("time", time);
		ArrayList<JSONObject> jBodies = new ArrayList<JSONObject>();
		for (Body bd : bodies) {
			JSONObject jBody = new JSONObject();
			jBody = bd.getState();
			jBodies.add(jBody);
		}
		simulator.append("bodies", jBodies);

		return simulator;
	}

	public String toString() {
		return getState().toString();
	}

}
