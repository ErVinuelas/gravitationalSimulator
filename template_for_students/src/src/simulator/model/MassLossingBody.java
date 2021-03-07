package simulator.model;

import simulator.misc.Vector2D;

public class MassLossingBody extends Body{
	private double lossFactor; //Valor entre 0 y 1
	private double lossFrequency;
	
	private double c; //Contador del tiempo
	
	//Constructores
	
	public MassLossingBody() {
		super();
		this.lossFactor = 0.0;
		this.lossFrequency = 1.0;
		c = 0.0;
	}
	
	public MassLossingBody(double lossFactor, double lossFrequency) {
		super();
		this.lossFactor = lossFactor;
		this.lossFrequency = lossFrequency;
		c = 0.0;
	}
	
	public MassLossingBody(String id, Vector2D velocity, Vector2D position, double mass, double lossFactor, double lossFrequency) {
		super(id, velocity, position, mass);
		this.lossFactor = lossFactor;
		this.lossFrequency = lossFrequency;
		c = 0.0;
	}
	
	void move(double t) {
		Vector2D acceleration = new Vector2D();
		if(mass != 0) {
			acceleration = new Vector2D(force.scale(1/mass));
		}
		position = position.plus((velocity.scale(t)).plus(acceleration.scale(t*t/2)));
		velocity = velocity.plus(acceleration.scale(t));
		c += t;
		if(c >= lossFrequency) {
			mass = mass * (1 - lossFactor);
			c = 0.0;
		}
	}
}
