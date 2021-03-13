package simulator.factories;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.ForceLaws;
import simulator.model.MovingTowardsFixedPoint;

public class MovingTowardsFixedPointBuilder extends Builder<ForceLaws>{

	@Override
	public ForceLaws createTheInstance(JSONObject info) throws IllegalArgumentException{
		try {
		double g = info.getDouble("g");
		JSONArray jArr = info.getJSONArray("c");
		Vector2D c = new Vector2D(jArr.getDouble(0), jArr.getDouble(1));
		return new MovingTowardsFixedPoint(g, c);
		} catch(JSONException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public JSONObject createData() {
		JSONObject jo = new JSONObject();
		jo.put("g", 9.81);
		double aux[] = new double[2];
		aux[0] = 0;
		aux[1] = 0;
		jo.put("c", new JSONArray(aux));
		return jo;
	}

}
