package simulator.control;

import simulator.model.PhysicsSimulator;
import simulator.model.Body;
import simulator.factories.Factory;
import java.io.InputStream;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Controller {
	
	private PhysicsSimulator simulator;
	private Factory<Body> constructor;
	
	/*Constructor*/
	
	public Controller(PhysicsSimulator simulator, Factory<Body> constructor) {
		this.constructor = constructor;
		this.simulator = simulator;
	}
	
	public void loadBodies(InputStream in) {
		JSONObject jsonInput = new JSONObject(new JSONTokener(in));
		int length = jsonInput.getJSONArray("bodies").length();
		for(int i = 0; i < length; ++i) {
			JSONObject jBd = jsonInput.getJSONArray("bodies").getJSONObject(i);
			
		}
	}
}
