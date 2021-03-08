package simulator.factories;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;

public class BasicBodyBuilder extends Builder<Body>{
	public BasicBodyBuilder() {
		_typeTag = "basic";
		_desc = "a basic body";
	}
	@Override
	public Body createTheInstance(JSONObject info) {
		String id = info.getString("id");
		JSONArray jArr = info.getJSONArray("p");
		Vector2D position = new Vector2D(jArr.getDouble(0), jArr.getDouble(1));
		jArr = info.getJSONArray("v");
		Vector2D velocity = new Vector2D(jArr.getDouble(0), jArr.getDouble(1));
		double mass = info.getDouble("m");
		return new Body(id, velocity, position, mass);
	}

	@Override
	public JSONObject createData() {
		JSONObject jo = new JSONObject();
		jo.put("id", "b1");
		double aux[] = new double[2];
		aux[0] = aux[1] = 0.0E00;
		jo.put("p", new JSONArray(aux));
		aux[0] = 0.05E04;
		aux[1] = 0.0E00;
		jo.put("v", new JSONArray(aux));
		jo.put("m", 5.97E24);
		return jo;
	}

	
		
}
