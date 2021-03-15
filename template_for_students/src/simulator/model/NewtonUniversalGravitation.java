package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class NewtonUniversalGravitation implements ForceLaws{
	private double G;
	
	public NewtonUniversalGravitation() {
		G = 6.67E-11;
	}
	
	public NewtonUniversalGravitation(double G) {
		this.G = G;
	}
	
	public Vector2D NewtonForce(Body b1, Body b2) {
		Vector2D dij = new Vector2D(b2.getPosition().minus(b1.getPosition()));
		if(dij.magnitude() != 0) {
			double fij = G * ((b1.getMass() * b2.getMass())/(Math.pow(dij.magnitude(), 2)));
			return dij.scale(fij);
		}
		else {
			return new Vector2D(0.0, 0.0);
		}
	}

	@Override
	public void apply(List<Body> bs) {
		Vector2D Fij = new Vector2D();
		for(int i = 0; i < bs.size(); ++i) {
			for(int j = i; j < bs.size(); ++j) {
				Fij = NewtonForce(bs.get(i), bs.get(j));
				bs.get(i).addForce(Fij);
				bs.get(j).addForce(Fij);
			}
		}
	}

}
