package simulator.factories;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.MassLossingBody;

public class MassLosingBodyBuilder extends Builder<Body>{
	
	public MassLosingBodyBuilder() {
		_typeTag = "mlb";
		_desc = "a body that loses mass";
	}
	
	public MassLossingBody createTheInstance(JSONObject info) throws IllegalArgumentException{
		try {
		String id = info.getString("id");
		JSONArray jArr = info.getJSONArray("p");
		Vector2D position = new Vector2D(jArr.getDouble(0), jArr.getDouble(1));
		jArr = info.getJSONArray("v");
		Vector2D velocity = new Vector2D(jArr.getDouble(0), jArr.getDouble(1));
		double mass = info.getDouble("m");
		double freq = info.getDouble("freq");
		double factor = info.getDouble("factor");
		return new MassLossingBody(id, velocity, position, mass, factor, freq);
		} catch(JSONException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public JSONObject createData() {
		JSONObject jo = new JSONObject();
		jo.put("id", "b1");
		jo.put("p", new Vector2D(0.0E00, 0.0E00).asJSONArray());
		jo.put("v", new Vector2D(0.05E04, 0.0E00).asJSONArray());
		jo.put("m", 5.97E24);
		jo.put("freq", 1E3);
		jo.put("factor", 1E-3);
		return jo;
	}
}
