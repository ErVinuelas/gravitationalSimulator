package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class MovingTowardsFixedPoint implements ForceLaws{
	private double g;
	private Vector2D c;
	
	public MovingTowardsFixedPoint() {
		g = 9.81;
		c = new Vector2D(0.0, 0.0);
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
