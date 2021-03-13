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
		
		JSONObject jData = info.getJSONObject("data"); //Accedemos al JSONObject data
		
		JSONArray jP = jData.getJSONArray("p");//Accedemos a possicion y creamos
		Vector2D position = new Vector2D(jP.getDouble(0), jP.getDouble(1));
		
		JSONArray jV = jData.getJSONArray("v");//Accedemos a la velocidad y creamos
		Vector2D velocity = new Vector2D(jV.getDouble(0), jV.getDouble(1));
		
		double mass = jData.getDouble("m");//Accedemos a la masa
		
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
