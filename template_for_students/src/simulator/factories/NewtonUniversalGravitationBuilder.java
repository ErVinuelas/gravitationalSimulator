package simulator.factories;

import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.NewtonUniversalGravitation;

public class NewtonUniversalGravitationBuilder extends Builder<ForceLaws>{

	@Override
	public ForceLaws createTheInstance(JSONObject info) {
		double G = info.getDouble("G");
		return new NewtonUniversalGravitation(G);
	}

	@Override
	public JSONObject createData() {
		double G = 6.67e-11;
		JSONObject jo = new JSONObject();
		jo.put("G", G);
		return jo;
	}
	
}
