package simulator.factories;

import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.NoForce;

public class NoForceBuilder extends Builder<ForceLaws>{
	public NoForceBuilder() {
		_typeTag = "nf";
		_desc = "no force is applied";
	}
	@Override
	public ForceLaws createTheInstance(JSONObject info) {
		return new NoForce();
	}

	@Override
	public JSONObject createData() {
		return new JSONObject();
	}
	
}
