import java.util.Scanner;

public class Main {
//
	public static void main(String [] args) {
		/*
		 * Variables 
		 */
		Scanner sc = new Scanner(System.in);
		String jugadorA, jugadorB;
		
		System.out.println("Nombre del jugador A: ");
		jugadorA = sc.next();
		System.out.println("Nombre del jugador B: ");
		jugadorB = sc.next();
		
		
		/*
		 * Crear Batalla
		 */
		
		
		Batalla batalla = new Batalla(jugadorA, jugadorB);
		
		batalla.elegirPokemon(sc);
		
		batalla.iniciarLucha(sc);
		
	}
}
