package simulator.factories;

import org.json.JSONObject;

import simulator.control.MassEqualStates;
import simulator.control.StateComparator;

public class MassEqualStatesBuilder extends Builder<StateComparator>{

	@Override
	public StateComparator createTheInstance(JSONObject info) {
		return new MassEqualStates();
	}

	@Override
	public JSONObject createData() {
		return new JSONObject();
	}

}
