package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class NewtonUniversalGravitation implements ForceLaws{
	private final static double DefaultG = 6.67E-11;
	private double G;
	
	public NewtonUniversalGravitation() {
		G = DefaultG;
	}
	
	public NewtonUniversalGravitation(double G) {
		this.G = G;
	}
	
	public Vector2D NewtonForce(Body b1, Body b2) {
		Vector2D difPosic = new Vector2D(b2.getPosition().minus(b1.getPosition()));
		double distancia = b2.getPosition().distanceTo(b1.getPosition());
		if(distancia != 0.0) {
			double fij = (G * b1.getMass() * b2.getMass())/(distancia*distancia);
			return difPosic.direction().scale(fij);
		}
		else {
			return new Vector2D(0.0, 0.0);
		}
	}

	@Override
	public void apply(List<Body> bs) {
		for(int i = 0; i < bs.size(); ++i) {
			for(int j = 0; j < bs.size(); ++j) {
				if(i != j) {
					bs.get(i).addForce(NewtonForce(bs.get(i), bs.get(j)));
				}
			}
		}
	}

}
