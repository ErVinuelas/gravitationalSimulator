package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class MovingTowardsFixedPoint implements ForceLaws{
	private final static double Defaultg = 9.81;
	private final static Vector2D Defaultc = new Vector2D();
	private double g;
	private Vector2D c;
	
	public MovingTowardsFixedPoint() {
		g = Defaultg;
		c = Defaultc;
	}
	
	public MovingTowardsFixedPoint(double g, Vector2D c) {
		this.g = g;
		this.c = c;
	}

	@Override
	public void apply(List<Body> bs) {
		
		for(Body bd : bs) {
			Vector2D direction = bd.getPosition().minus(c).direction();
			
			Vector2D f = direction.scale(-g * bd.getMass());
			bd.addForce(f);
		}
	}

}
