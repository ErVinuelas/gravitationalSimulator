package simulator.control;

import simulator.model.PhysicsSimulator;
import simulator.model.Body;
import simulator.factories.Factory;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONArray;
import java.io.PrintStream;

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
		for (int i = 0; i < length; ++i) {
			JSONObject jBd = jsonInput.getJSONArray("bodies").getJSONObject(i);
			Body newBody = constructor.createInstance(jBd);
			simulator.addBody(newBody);
		}
	}
	
	public void run(int n, OutputStream out, InputStream expOut, StateComparator cmp) throws NonEqualStatesException {
		
		JSONArray jStates = null;
		if (expOut != null) {
			JSONObject jsonInput = new JSONObject(new JSONTokener(expOut));
			jStates = jsonInput.getJSONArray("states");
		}

		PrintStream p = new PrintStream(out);
		p.println("{");
		p.println("\"states\": [");

		JSONObject s0 = simulator.getState();
		p.println(s0);

		for (int i = 1; i <= n; ++i) {
			simulator.advance();
			JSONObject aux = simulator.getState();
			if (expOut != null) {
				if (!cmp.equal(aux, jStates.getJSONObject(i))) {
					throw new NonEqualStatesException(aux, jStates.getJSONObject(i), i);
				}
			}
			p.println("," + aux);
		}

		p.println("]");
		p.println("}");
	}
	
}
