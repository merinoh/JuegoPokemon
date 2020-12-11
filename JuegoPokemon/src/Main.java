import java.util.Scanner;

public class Main {
//
	public static void main(String [] args) {
		/**
		 * Variables 
		 */
		Scanner sc = new Scanner(System.in);
		String jugadorA, jugadorB;
		/**
		 * Introducimos el nombre de los jugadores
		 */
		System.out.println("Nombre del jugador A: ");
		jugadorA = sc.next();
		System.out.println("Nombre del jugador B: ");
		jugadorB = sc.next();
		
		
		Batalla batalla = new Batalla(jugadorA, jugadorB);
		/**
		 * Preparativos para la batalla
		 * Los jugadores seleccionan los pokemones de la lista del gimnasio que van a participar
		 */
		batalla.elegirPokemon(sc);
		
		/**
		 * Inicia la batalla
		 */
		batalla.iniciarLucha(sc);
		
	}
}
