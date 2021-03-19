package simulator.model;

import simulator.misc.Vector2D;
import org.json.*;

public class Body { //Representa una entidad física
	protected String id;
	protected Vector2D velocity;
	protected Vector2D force;
	protected Vector2D position;
	protected double mass;
	
	//Constructor
	public Body() {
		this.id = "";
		this.velocity = new Vector2D();
		this.position = new Vector2D();
		this.force = new Vector2D();
		this.mass = 0.0;
	}
	public Body(String id, Vector2D velocity, Vector2D position, double mass) {
		this.id = id;
		this.velocity = velocity;
		this.position = position;
		this.force = new Vector2D();
		this.mass = mass;
	}
	
	
	/*Getters y setters*/
	
	public String  getId() {
		return id;
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
		Vector2D acceleration = new Vector2D();
		if(mass != 0) {
			acceleration = new Vector2D(force.scale(1/mass));
		}
		position = position.plus((velocity.scale(t)).plus(acceleration.scale(t*t*0.5)));
		velocity = velocity.plus(acceleration.scale(t));
	}
	
	public JSONObject getState() {
		JSONObject state = new JSONObject();
		double aux[] = new double[2];
		state.put("id", id);
		state.put("m", mass);
		aux[0] = position.getX();
		aux[1] = position.getY();
		state.put("p", aux);
		aux[0] = velocity.getX();
		aux[1] = velocity.getY();
		state.put("v", aux);
		aux[0] = force.getX();
		aux[1] = force.getY();
		state.put("f", aux);
		return state;
	}
	
	public String toString() {
		return getState().toString();
	}
	
}
