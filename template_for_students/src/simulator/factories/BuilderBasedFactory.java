package simulator.factories;

import org.json.JSONObject;
import java.util.List;

public class BuilderBasedFactory<T> implements Factory<T>{
		
	BuilderBasedFactory(List<Builder<T>> list){
		
	}
	
	public T createInstance(JSONObject json){
		
	}
	
	public List<JSONObject>getInfo(){
		
	}
}
