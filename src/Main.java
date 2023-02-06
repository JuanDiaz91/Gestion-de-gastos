
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		        //-Creando usuario-
        Usuario usuario = new Usuario();
        System.out.println("Ingrese los datos de usuario");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: "); usuario.setNombre(sc.nextLine());
        
        do {
            try { //Control de errores si la edad no es un número.
                System.out.print("Edad: ");
                usuario.setEdad(sc.nextInt());

            } catch (InputMismatchException e) {
                System.out.println("La edad debe ser un número");
            }
            sc.nextLine(); //para finalizar la lectura del int.
        }while(usuario.getEdad() <= 0);

        boolean DNIComprobar = false; //Variable de control para setDNI.
        do{
            System.out.print("DNI: ");
            String DNI = sc.nextLine();
            
            DNIComprobar = usuario.setDNI(DNI);
        }while (!DNIComprobar);

        System.out.println("Usuario creado correctamente \nDatos de Usuario");
        System.out.println(usuario.toString()); //muestro por consola los datos del usuario creado.
        
        Cuenta cuenta = new Cuenta(usuario);

        //Creo variables auxilares para no definirlas en el bucle
        int option;  //opción del menú (0 a 5) 
        double saldo;
       
        do {
            menu(); //Imprimo el menú
            option = sc.nextInt(); // Pido la opción a ejecutar
            sc.nextLine(); //leo el caracter enter que queda después del nextInt()

            String description;
            double importe;
			if (option == 1) {
            	
				System.out.print("Introduce la descripción del gasto: ");
            	description = sc.nextLine();
            	
            	System.out.print("Introduce el importe del gasto: ");            	 
            	importe = sc.nextDouble();
            	
            	saldo = cuenta.addGastos(description, importe);
            	System.out.println("Saldo restante: " + formatoEuropa(saldo));
            }else if (option==2) {
            	
            	System.out.print("Introduce la descripción del ingreso: ");
            	description = sc.nextLine();
            	
            	System.out.print("Introduce el importe del ingreso: ");
            	importe = sc.nextDouble();
            	
            	saldo = cuenta.addIngresos(description, importe);
            	System.out.println("Saldo restante: " + formatoEuropa(saldo) + "€");
            }else if (option==3) {
            	
            	System.out.println("Gastos registrados: " + cuenta.getGastos());
            	
                
            }else if (option==4) {
            	  System.out.println("Ingresos registrados: " + cuenta.getIngresos() + "€");
                 
            	
            }else if (option==5) {
            	System.out.println("\nEl saldo de la cuenta es de: " + formatoEuropa(cuenta.getSaldo()) + "€");
            	
            }else if((option <0) || (option>5)) {
            	System.out.println("Opcion incorrecta. Porfavor introduzca una opcion válida: ");
            }
            
            }while(option != 0);


        sc.close(); //Cerramos el Scanner
        System.out.println("Fin del programa.");
        System.out.println("Gracias por utilizar la aplicación de M03 en el curso 1s2223.");
        
    }

    private static void menu(){  //Creo un metodo que imprima el menu por pantalla.
        System.out.println("- Realiza una nueva acción -");
        System.out.println("1 - Introduce un nuevo gasto");
        System.out.println("2 - Introduce un nuevo ingreso");
        System.out.println("3 - Mostrar gastos");
        System.out.println("4 - Mostrar ingresos");
        System.out.println("5 - Mostrar saldo");
        System.out.println("0 - Salir");
    }
    
    public static String formatoEuropa (double valor) {
		Locale spanish = new Locale("es", "ES");
		NumberFormat europa = NumberFormat.getInstance(spanish);
		return europa.format(valor);
	}
    
}
