package simulator.view;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import simulator.control.Controller;
import simulator.model.Body;
import simulator.model.SimulatorObserver;

public class ControlPanel extends JPanel implements SimulatorObserver {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1696025726243841820L;
	// ...
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JTextField _d_time;
	private Controller _ctrl;
	private boolean _stopped;
	
	ControlPanel(Controller ctrl) {
		_ctrl = ctrl;
		_stopped = true;
		initGUI();
		_ctrl.addObserver(this);
	}
	
	private void initGUI() {
		// TODO build the tool bar by adding buttons, etc.
		//setLayout(new FlowLayout());
		button1 = new JButton(new ImageIcon("resources/icons/open.png"));
		button2 = new JButton(new ImageIcon("resources/icons/physics.png"));
		button3 = new JButton(new ImageIcon("resources/icons/run.png"));
		button4 = new JButton(new ImageIcon("resources/icons/stop.png"));
		button5 = new JButton(new ImageIcon("resources/icons/exit.png"));
		JLabel lbl1 = new JLabel("Steps:");
		JSpinner scrl1 = new JSpinner(new SpinnerNumberModel(10000, 1, 1000000, 1));
		JLabel lbl2 = new JLabel("Delta-Time:");
		_d_time = new JTextField("2500.0");
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(lbl1);
		add(scrl1);
		add(lbl2);
		add(_d_time);
		add(button5);
	}
	
	// other private/protected methods
	// ...
	private void run_sim(int n) {
		if ( n>0 && !_stopped ) {
		try {
		_ctrl.run(1);
		} catch (Exception e) {
		// TODO show the error in a dialog box
		// TODO enable all buttons
		_stopped = true;
		return;
		}
		SwingUtilities.invokeLater( new Runnable() {
			@Override
			public void run() {
			run_sim(n-1);
			}
		});
			} else {
			_stopped = true;
			// TODO enable all buttons
			}
	}
	// SimulatorObserver methods
	// ...

	@Override
	public void onRegister(List<Body> bodies, double time, double dt, String fLawsDesc) {
		// TODO Auto-generated method stub
		Double aux = new Double(dt);
		_d_time = new JTextField(aux.toString());
	}

	@Override
	public void onReset(List<Body> bodies, double time, double dt, String fLawsDesc) {
		// TODO Auto-generated method stub
		Double aux = new Double(dt);
		_d_time = new JTextField(aux.toString());
	}

	@Override
	public void onBodyAdded(List<Body> bodies, Body b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAdvance(List<Body> bodies, double time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDeltaTimeChanged(double dt) {
		// TODO Auto-generated method stub
		Double aux = new Double(dt);
		_d_time = new JTextField(aux.toString());
	}

	@Override
	public void onForceLawsChanged(String fLawsDesc) {
		// TODO Auto-generated method stub
		
	}
}