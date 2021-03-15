package simulator.factories;

import org.json.JSONException;
import org.json.JSONObject;

import simulator.control.EpsilonEqualStates;
import simulator.control.StateComparator;

public class EpsilonEqualStatesBuilder extends Builder<StateComparator>{
	
	private static final double DefaultEps = 0.0;

	public EpsilonEqualStatesBuilder() {
		_typeTag = "epseq";
		_desc = "epsilon comparator";
	}
	
	@Override
	public StateComparator createTheInstance(JSONObject info) throws IllegalArgumentException{
		try {
		double eps;
		if(info.has("eps")) {
			eps = info.getDouble("eps");
		}
		else {
			eps = DefaultEps;
		}
		return new EpsilonEqualStates(eps);
		} catch(JSONException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public JSONObject createData() {
		double eps = DefaultEps;
		JSONObject jo = new JSONObject();
		jo.put("eps", eps);
		return jo;
	}
	
}
