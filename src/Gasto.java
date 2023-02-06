

public class Gasto extends Dinero{

	 	public Gasto (double gasto, String description){ //constructor de gasto con gasto y descripción
	 		super.dinero = gasto;
	 		super.description = description;
	        
	    }

	    @Override
		public String toString() {
			return "[Gasto = " + Main.formatoEuropa(dinero) + "€" + ", descripción = " + description + "]";
		}
}
