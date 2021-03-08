package simulator.control;

import org.json.JSONObject;
import simulator.misc.Vector2D;

public class EpsilonEqualStates {
	
	private double eps;
	
	
	public EpsilonEqualStates(double eps) {
		this.eps = eps;
	}
	
	private boolean equals(double a, double b) {
		return Math.abs(a-b) <= eps;
	}
	
	private boolean equals(Vector2D v1, Vector2D v2) {
		return v1.distanceTo(v2) <= eps;
	}
	
	public boolean equal(JSONObject s1, JSONObject s2) {
		
		if(s1.getDouble("time") != s2.getDouble("time")) {	return false;	}
		
		
		
		return true;
	}

}
