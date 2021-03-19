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
		
		JSONArray jP = info.getJSONArray("p");//Accedemos a possicion y creamos
		Vector2D position = new Vector2D(jP.getDouble(0), jP.getDouble(1));
		
		JSONArray jV = info.getJSONArray("v");//Accedemos a la velocidad y creamos
		Vector2D velocity = new Vector2D(jV.getDouble(0), jV.getDouble(1));
		
		double mass = info.getDouble("m");//Accedemos a la masa
		
		return new Body(id, velocity, position, mass);
	}

	@Override
	public JSONObject createData() {
		JSONObject jo = new JSONObject();
		jo.put("id", "b1");
		jo.put("p", new Vector2D().asJSONArray());
		jo.put("v", new Vector2D(0.05E04, 0.0E00).asJSONArray());
		jo.put("m", 5.97E24);
		return jo;
	}

	
		
}
