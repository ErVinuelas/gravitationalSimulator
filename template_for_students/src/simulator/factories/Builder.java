package simulator.factories;

import org.json.JSONObject;

public abstract class Builder<T> {
	protected String _typeTag;
	protected String _desc;
	/*Metodos*/
	
	public T createInstance(JSONObject info) {
		if(info.has("type")) {
			if(_typeTag.equals(info.get("type"))) {
				return createTheInstance(info.getJSONObject("data"));
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		else {
			return null;
		}
	}
	
	public abstract T createTheInstance(JSONObject info);
	
	public abstract JSONObject createData();
	
	public JSONObject getBuilderInfo() {
		JSONObject jo = new JSONObject();
		jo.put("type", _typeTag);
		jo.put("data", createData());
		jo.put("desc", _desc);
		return jo;
	}
}
