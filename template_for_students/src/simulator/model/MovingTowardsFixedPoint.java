package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class MovingTowardsFixedPoint implements ForceLaws{
	
	private static final double g = 9.81;

	@Override
	public void apply(List<Body> bs) {
		Vector2D di = new Vector2D();
		Vector2D a = new Vector2D();
		for(Body bo : bs) {
			di = (bo.getPosition()).direction();
			a = di.scale((-1) * g);
			bo.addForce(a.scale(bo.getMass()));
		}
	}

}
