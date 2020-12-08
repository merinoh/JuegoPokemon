public class Main {
//
	public static void main(String [] args) {
		
		/*
		 * Crear Batalla
		 */
		
		Batalla batalla = new Batalla("Ailyn", "Ruben");
		
		//batalla.imprimirLista();
		//Elige pokemon de la lista del gimnasio
		batalla.elegirPokemon(2, 1);
		//Muestra informacion de su lista de pokemon
		batalla.jugadorA.listarPokemones();
		batalla.jugadorB.listarPokemones();
		
		//Elige pokemon para combatir

		Pokemon pokemon1;
		
		//
		
		pokemon1 = batalla.jugadorA.elegirPokemon(0);
	
		//batalla.jugadorB.listaPokemon.get(posB);
		
		pokemon1.setApodo("HOLA");
		
		batalla.jugadorA.listarPokemones();
		
		
	}
}
