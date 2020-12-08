import java.util.Scanner;
//
public class Batalla {
	/*
	 * Atributos
	 */
	
	public Pokemon [] pokemones = new Pokemon[12];
	public Jugador jugadorA;
	public Jugador jugadorB;
	
	/*
	 * Constructor
	 */
	Batalla(String nombreA, String nombreB){
		pokemones[0] = new PokemonAgua("Articuno");
		pokemones[1] = new PokemonAgua("Pikachu");
		pokemones[2] = new PokemonAgua("Charmander");
		pokemones[3] = new PokemonAgua("Moltres");
		pokemones[4] = new PokemonAgua("Gengar");
		pokemones[5] = new PokemonAgua("Zapdos");
		pokemones[6] = new PokemonAgua("Snorlax");
		pokemones[7] = new PokemonAgua("Lapras");
		pokemones[8] = new PokemonAgua("Charizard");
		pokemones[9] = new PokemonAgua("Tyranitar");
		pokemones[10] = new PokemonAgua("Poliwhirl");
		pokemones[11] = new PokemonAgua("Oddish");
		
		jugadorA = new Jugador(nombreA);
		jugadorB = new Jugador(nombreB);	
		
	}
	
	/*
	 * Métodos
	 */
	
	public void elegirPokemon(int numPokemon, int elegir){
		int rnd;
		Pokemon pokemon;
		try (Scanner sc = new Scanner(System.in)) {
			if(elegir == 0) {
				//aleatorio
				for(int i = 0; i < numPokemon; i++) {
					rnd = (int)Math.floor(Math.random()*12);
				    pokemon = pokemones[rnd];
					jugadorA.llenarListaPokemon(pokemon, i);
					rnd = (int)Math.floor(Math.random()*12);
				    pokemon = pokemones[rnd];
					jugadorB.llenarListaPokemon(pokemon, i);
				}
			}else {
				//elige Pokemon
				System.out.println("Elegir Pokemon");
				imprimirLista();
				for(int i = 0; i < numPokemon; i++) {
					System.out.println("Jugador " + jugadorA.nombre + " elegir Pokemon [" + i + "] >>");
					rnd = sc.nextInt();
				    pokemon = pokemones[rnd];
					jugadorA.llenarListaPokemon(pokemon, i);
					System.out.println("Jugador " + jugadorB.nombre + " elegir Pokemon [" + i + "] >>");
					rnd = sc.nextInt();
				    pokemon = pokemones[rnd];
					jugadorB.llenarListaPokemon(pokemon, i);
				}
			}
		}
	}
	
	public void imprimirLista() {
		for(int i = 0; i < pokemones.length; i++) {
			pokemones[i].mostrarInfo();
		}
	}
	
	
}
