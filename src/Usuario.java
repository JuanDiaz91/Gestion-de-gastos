

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {
	//Atributos
	private String nombre;
	private int edad;
	private String DNI;
	
	public Usuario() {
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDNI() {
		return DNI;
	}
	
	public boolean setDNI(String DNI) {
		
        String errorMsg = "DNI incorrecto. Vuelva a intentarlo";
        if (DNI.length() == 9) {
            Pattern p = Pattern.compile("[0-9]{8}-?[A-Z]"); //Utilizo un patron de expresión regular, para validar 8 números  y 
            												//1 letra mayúscula de la (A-Z), el guión es opcional.
            Matcher m = p.matcher(DNI);

            if (!m.matches()) {
                System.out.println(errorMsg);
                return false;
            } else {
                this.DNI = DNI; //si cumple el patrón asignado guardo el DNI ingresado por teclado en el DNI de este usuario.
                return true;
            }
        }else{
            System.out.println(errorMsg);
            return false;
            }
	}

	@Override
	public String toString() {
		return "Usuario [nombre = " + nombre + ", edad = " + edad + ", DNI = " + DNI + "]";
	}
	
}
