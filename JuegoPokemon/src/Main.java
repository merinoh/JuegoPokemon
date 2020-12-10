import java.util.Scanner;

public class Main {
//
	public static void main(String [] args) {
		
		/*
		 * Crear Batalla
		 */
		Scanner sc = new Scanner(System.in);
		Batalla batalla = new Batalla("Ailyn", "Ruben");
		
		batalla.elegirPokemon(2, 1, sc);
		
		batalla.iniciarLucha(sc);
		
	}
}
