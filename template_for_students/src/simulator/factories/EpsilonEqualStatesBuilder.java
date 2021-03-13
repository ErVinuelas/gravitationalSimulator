package simulator.factories;

import org.json.JSONObject;

import simulator.control.EpsilonEqualStates;
import simulator.control.StateComparator;

public class EpsilonEqualStatesBuilder extends Builder<StateComparator>{

	@Override
	public StateComparator createTheInstance(JSONObject info) {
		double eps = info.getDouble("eps");
		return new EpsilonEqualStates(eps);
	}

	@Override
	public JSONObject createData() {
		double eps = 0.1;
		JSONObject jo = new JSONObject();
		jo.put("eps", eps);
		return jo;
	}
	
}
