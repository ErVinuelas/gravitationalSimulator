package simulator.control;

import org.json.JSONArray;
import org.json.JSONObject;
import simulator.misc.Vector2D;

public class EpsilonEqualStates implements StateComparator{
	
	private double eps;
	
	public EpsilonEqualStates(double eps) {
		this.eps = eps;
	}
	
	private boolean equals(double a, double b) {
		return Math.abs(a-b) <= eps;
	}
	
	private boolean equals(JSONArray jV1, JSONArray jV2) {
		Vector2D v1 = new Vector2D(jV1.getInt(0), jV1.getInt(1));
		Vector2D v2 = new Vector2D(jV2.getInt(0), jV2.getInt(1));
		return v1.distanceTo(v2) <= eps;
	}
	
	public boolean equal(JSONObject s1, JSONObject s2) {
		
		if(s1.getDouble("time") != s2.getDouble("time")) {	return false;	}
		
		JSONArray jBodies1 = s1.getJSONArray("bodies");
		JSONArray jBodies2 = s2.getJSONArray("bodies");	
		
		int length = jBodies1.length();
				
		if(length != jBodies2.length()) {return false;	}
		
		for(int i = 0; i < length; ++i) {
			JSONObject bd1 = jBodies1.getJSONObject(i);
			JSONObject bd2 = jBodies2.getJSONObject(i);
			if(!bd1.getString("id").equals(bd2.getString("id"))) {	return false;	} //Comparamos identificadores
			if(!this.equals(bd1.getDouble("m"),bd2.getDouble("m"))) {	return false;	}//Comparamos masas
			if(!this.equals(bd1.getJSONArray("p"),bd2.getJSONArray("p"))) {	return false;	}//Comparamos posiciones
			if(!this.equals(bd1.getJSONArray("v"),bd2.getJSONArray("v"))) {	return false;	}//Comparamos velocidades
			if(!this.equals(bd1.getJSONArray("f"),bd2.getJSONArray("f"))) {	return false;	}//Comparamos fuerzas
		}

		return true;
	}

}
