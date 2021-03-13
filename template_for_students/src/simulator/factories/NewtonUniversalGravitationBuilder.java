package simulator.factories;

import org.json.JSONException;
import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.NewtonUniversalGravitation;

public class NewtonUniversalGravitationBuilder extends Builder<ForceLaws>{

	@Override
	public ForceLaws createTheInstance(JSONObject info) throws IllegalArgumentException{
		try {
		double G = info.getDouble("G");
		return new NewtonUniversalGravitation(G);
		} catch(JSONException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public JSONObject createData() {
		double G = 6.67e-11;
		JSONObject jo = new JSONObject();
		jo.put("G", G);
		return jo;
	}
	
}
