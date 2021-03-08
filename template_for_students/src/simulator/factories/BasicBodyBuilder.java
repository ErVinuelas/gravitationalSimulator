package simulator.factories;

import org.json.JSONObject;

import simulator.model.Body;

public class BasicBodyBuilder extends Builder<Body>{

	@Override
	public Body createInstance(JSONObject info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getBuilderInfo() {
		JSONObject jo = new JSONObject();
		jo.put("type", _typeTag);
	}
		
}
