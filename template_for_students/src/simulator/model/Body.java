package simulator.model;

import simulator.misc.Vector2D;
import org.json.*;



public class Body { //Representa una entidad física
	protected String identif;
	protected Vector2D velocity;
	protected Vector2D force;
	protected Vector2D position;
	protected double mass;
	
	
	/*Getters y setters*/
	
	public String  getId() {
		return identif;
	}
	public Vector2D getVelocity() {
		return velocity;
	}
	public Vector2D getForce() {
		return force;
	}
	public Vector2D getPosition() {
		return position;
	}
	public double getMass() {
		return mass;
	}
	
	/*Métodos*/
	
	void addForce(Vector2D f) {
		force = force.plus(f);
	}
	
	void resetForce() {
		force = force.scale(0);
	}
	
	void move(double t) {
		
	}
	
	public JSONObject getState() {
		JSONObject data = new JSONObject();
		JSONObject state = new JSONObject();
		state.put("type", "basic");
		data.put("p", position);
		data.put("v", velocity);
		data.put("m", mass);
		state.put("data", data);

		return data;
	}
	
	public String toString() {
		return getState().toString();
	}
	
}
