package simulator.factories;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.ForceLaws;
import simulator.model.MovingTowardsFixedPoint;

public class MovingTowardsFixedPointBuilder extends Builder<ForceLaws>{
	
	private static final double Defaultg = 9.81;
	private static final Vector2D Defaultc = new Vector2D();

	public MovingTowardsFixedPointBuilder() {
		_typeTag = "mtfp";
		_desc = "a force that obligues to move towards a point";
	}
	
	
	@Override
	public ForceLaws createTheInstance(JSONObject info) throws IllegalArgumentException{
		double g;
		Vector2D c;
		try {
			if(info.has("g")) {
			g = info.getDouble("g");
			} 
			else {
				g = Defaultg;
			}
			if(info.has("c")) {
			JSONArray jArr = info.getJSONArray("c");
			c = new Vector2D(jArr.getDouble(0), jArr.getDouble(1));
			}
			else {
				c = Defaultc;
			}
			return new MovingTowardsFixedPoint(g, c);
		} catch(JSONException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public JSONObject createData() {
		JSONObject jo = new JSONObject();
		jo.put("g", Defaultg);
		jo.put("c", Defaultc.asJSONArray());
		return jo;
	}

}
