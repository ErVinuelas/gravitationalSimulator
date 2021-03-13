package simulator.factories;

import org.json.JSONObject;
import java.util.List;

public class BuilderBasedFactory<T> implements Factory<T>{
		
	BuilderBasedFactory(List<Builder<T>> list){
		
	}

	@Override
	public T createInstance(JSONObject info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JSONObject> getInfo() {
		// TODO Auto-generated method stub
		return null;
	}
}
