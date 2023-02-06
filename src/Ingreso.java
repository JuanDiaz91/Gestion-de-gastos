
public class Ingreso extends Dinero {

	public Ingreso (double ingreso, String description){ //constructor de ingreso con importe y descripción
		super.dinero = ingreso;
		super.description = description;		
     
    }

	@Override
	public String toString() {
		return "[Ingreso = " + Main.formatoEuropa(dinero) + "€" + ", descripción = " + description + "]";
	}

}
