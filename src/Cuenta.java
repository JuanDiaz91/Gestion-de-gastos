

import java.util.ArrayList;
import java.util.List;

public class Cuenta {

	private double saldo;
	private Usuario usuario;
	List<Gasto> gastos;
	List<Ingreso> ingresos;
	
	public Cuenta(Usuario usuario) {
		this.usuario = usuario;
		saldo = 0;
		gastos = new ArrayList<>();
		ingresos = new ArrayList<>();
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public double addIngresos(String description, double cantidad) {
		
		ingresos.add(new Ingreso(cantidad, description));
		this.saldo += cantidad;
		return this.saldo;
	}
	
	public double addGastos(String description, double cantidad) {
		
		try{
	           if (this.saldo < cantidad) {
	               throw new GastoException();
	           }else{
	        	   
	               gastos.add(new Gasto( cantidad, description));
	               this.saldo -= cantidad;
	           }
	       }catch (GastoException e){
	    	   System.out.println(e.getMessage());
	            // La excepción dará un mensaje de "Saldo insuficiente".
	           // También se podría agregar aquí más acciones para este caso puntual.
	      
		}
		return saldo;
	}
		
	
	public List<Ingreso> getIngresos() {
		return ingresos;
	}

	
	public List<Gasto> getGastos() {
		return gastos;
	}


	@Override
	public String toString() {
		return "Cuenta [saldo = " + Main.formatoEuropa(saldo) + "€" + ", usuario = " + usuario + ", gastos = " + gastos + "€" + 
				", ingresos = " + ingresos + "€" + "]";
	}
	
}
