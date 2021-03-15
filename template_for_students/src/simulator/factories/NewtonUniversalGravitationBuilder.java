package simulator.factories;

import org.json.JSONException;
import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.NewtonUniversalGravitation;

public class NewtonUniversalGravitationBuilder extends Builder<ForceLaws>{
	
	private static final double DefaultG = 6.67e-11;

	public NewtonUniversalGravitationBuilder() {
		_typeTag = "nlug";
		_desc = "a force that behaves as Newton stated";
	}
	
	
	@Override
	public ForceLaws createTheInstance(JSONObject info) throws IllegalArgumentException{
		try {
			double G;
			if(info.has("G")) {
				G = info.getDouble("G");
			}
			else {
				G = DefaultG;
			}
			return new NewtonUniversalGravitation(G);
		} catch(JSONException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public JSONObject createData() {
		double G = DefaultG;
		JSONObject jo = new JSONObject();
		jo.put("G", G);
		return jo;
	}
	
}
