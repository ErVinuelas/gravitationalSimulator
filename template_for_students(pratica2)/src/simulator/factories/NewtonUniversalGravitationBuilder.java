package simulator.factories;

import org.json.JSONException;
import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.NewtonUniversalGravitation;

public class NewtonUniversalGravitationBuilder extends Builder<ForceLaws>{
	
	private static final double DefaultG = 6.67e-11;

	//Constructor por defecto
	public NewtonUniversalGravitationBuilder() {
		_typeTag = "nlug";
		_desc = "a force that behaves as Newton stated";
	}
	
	
	@Override
	//Devuelve una instancia de NewtonUniversalGravitation a partir de un JSONObject si los datos introducidos son validos
	public ForceLaws createTheInstance(JSONObject info) throws IllegalArgumentException{
		try {
			double G;
			if(info.has("G")) { //Comprobamos el valor de la constante G. Si no se especifica tomamos el valor por defecto
				G = info.getDouble("G");
			}
			else {
				G = DefaultG;
			}
			return new NewtonUniversalGravitation(G);
		} catch(JSONException j) { //Si los datos introducidos no son validos lanzamos una excepcion
			throw new IllegalArgumentException(j);
		}
	}

	@Override
	public JSONObject createData() {
		double G = DefaultG;
		JSONObject jo = new JSONObject();
		jo.put("G", G);
		return jo;
	}
	
}
