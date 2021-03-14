package simulator.factories;

import org.json.JSONObject;

import simulator.control.MassEqualStates;
import simulator.control.StateComparator;

public class MassEqualStatesBuilder extends Builder<StateComparator>{

	public MassEqualStatesBuilder() {
		_typeTag = "masseq";
		_desc = "mass comparator";
	}
	
	
	@Override
	public StateComparator createTheInstance(JSONObject info) throws IllegalArgumentException{
		return new MassEqualStates();
	}

	@Override
	public JSONObject createData() {
		return new JSONObject();
	}

}
