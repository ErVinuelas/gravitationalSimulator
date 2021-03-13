package simulator.factories;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BuilderBasedFactory<T> implements Factory<T>{
	
	private List<Builder<T>> builders;
		
	BuilderBasedFactory(List<Builder<T>> list){
		builders = list;
	}

	@Override
	public T createInstance(JSONObject info) throws IllegalArgumentException{
		T inst = null;
		for(Builder<T> b : builders) {
			inst = b.createInstance(info);
			if(inst != null) {
				return inst;
			}
		}
		throw new IllegalArgumentException();
	}

	@Override
	public List<JSONObject> getInfo() {
		List<JSONObject> listjo = new ArrayList<>();
		for(Builder<T> b : builders) {
			listjo.add(b.getBuilderInfo());
		}
		return listjo;
	}
}
