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
		Vector2D di = new Vector2D();
		Vector2D a = new Vector2D();
		for(Body bo : bs) {
			di = (c.minus(bo.getPosition())).direction();
			a = di.scale((-1) * g);
			bo.addForce(a.scale(bo.getMass()));
		}
	}

}
