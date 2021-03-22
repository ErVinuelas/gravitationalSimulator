package simulator.model;

import simulator.misc.Vector2D;

public class MassLossingBody extends Body{
	private double lossFactor; //Valor entre 0 y 1
	private double lossFrequency;
	
	private double c; //Contador del tiempo
	
	//Constructor por defecto
	public MassLossingBody() {
		super();
		this.lossFactor = 0.0;
		this.lossFrequency = 1.0;
		c = 0.0;
	}
	
	//Constructor con valores heredados de BasicBody por defecto y con lossFactor y lossFrequency especificos
	public MassLossingBody(double lossFactor, double lossFrequency) {
		super();
		this.lossFactor = lossFactor;
		this.lossFrequency = lossFrequency;
		c = 0.0;
	}
	
	//Cosntructor con valores especificos de cada campo
	public MassLossingBody(String id, Vector2D velocity, Vector2D position, double mass, double lossFactor, double lossFrequency) {
		super(id, velocity, position, mass);
		this.lossFactor = lossFactor;
		this.lossFrequency = lossFrequency;
		c = 0.0;
	}
	
	//Devuelve el estado del cuerpo, es decir, el valor de sus atributos, en forma de JSONObject
	void move(double t) {
		Vector2D acceleration = new Vector2D();
		if(mass != 0) { //Si la masa es 0 la aceleracion es nula
			acceleration = new Vector2D(force.scale(1/mass));
		}
		position = position.plus((velocity.scale(t)).plus(acceleration.scale(t*t*0.5))); //Variamos la posicion y la velocidad atendiendo a la aceleracion
		velocity = velocity.plus(acceleration.scale(t));
		c += t; //Aumentamos el contador
		if(c >= lossFrequency) { //Y si sobrepasa la frecuencia lo reiniciamos y variamos la masa
			mass = mass * (1 - lossFactor);
			c = 0.0;
		}
	}
}
