import java.util.Scanner;

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
		pokemones[1] = new PokemonAgua("Squirtle");
		pokemones[2] = new PokemonAgua("Poliwhirl");
		pokemones[3] = new PokemonFuego("Charmander");
		pokemones[4] = new PokemonFuego("Charizard");
		pokemones[5] = new PokemonFuego("Moltres");
		pokemones[6] = new PokemonElectricidad("Pikachu");
		pokemones[7] = new PokemonElectricidad("Ampharos");
		pokemones[8] = new PokemonElectricidad("Zapdos");
		pokemones[9] = new PokemonHierba("Bulbasaur");
		pokemones[10] = new PokemonHierba("Oddish");
		pokemones[11] = new PokemonHierba("Chikorita");
		
		jugadorA = new Jugador(nombreA);
		jugadorB = new Jugador(nombreB);	
		
	}
	
	/*
	 * Métodos
	 */
	
	public void elegirPokemon(int numPokemon, int elegir, Scanner sc){
		int rnd;
		Pokemon pokemon;
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
	
	public void imprimirLista() {
		for(int i = 0; i < pokemones.length; i++) {
			pokemones[i].mostrarInfo();
		}
	}
	
	public void  iniciarLucha(Scanner sc) {
		Pokemon pokemon1, pokemon2;
		int pos, ataqueA, ataqueB, pocion, posPok;
		boolean availableA, availableB;
		
		
		do {
			System.out.println(jugadorA.nombre + " con qué pokemon quieres luchar: ");
			pos = sc.nextInt();
			pokemon1 = jugadorA.elegirPokemon(pos);
			System.out.println(jugadorB.nombre + " con qué pokemon quieres luchar: ");
			posPok = sc.nextInt();
			pokemon2 = jugadorB.elegirPokemon(posPok);
			
			
			int velocidadP1 = pokemon1.velocidad;
			int velocidadP2 = pokemon2.velocidad;
			
			System.out.println(jugadorA.nombre + " ¿Deseas utilizar una poción?: ");
			pocion = sc.nextInt();
			if(pocion == 1) {
				jugadorA.utilizarPocion(sc, pos);
			}
	
			System.out.println(jugadorB.nombre + " ¿Deseas utilizar una poción?: ");
			pocion = sc.nextInt();
			if(pocion == 1) {
				jugadorB.utilizarPocion(sc, posPok);
			}
			
			System.out.println(jugadorA.nombre + " qué ataque quieres utilizar: ");
			ataqueA = sc.nextInt();
			System.out.println(jugadorB.nombre + " qué ataque quieres utilizar: ");
			ataqueB = sc.nextInt();
			
			
		    if(velocidadP1 > velocidadP2) {
		    	System.out.println("--------COMIENZA POKEMON 1--------");
		    	if(ataqueA == 0) {//ATAQUE BASE
		    		pokemon2.recibirAtaque(pokemon1);
		    		System.out.println("----------------");
					pokemon2.mostrarInfo();
		    	}else {
		    		pokemon2.recibirAtaqueEspecial(pokemon1);
		    		System.out.println("----------------");
					pokemon2.mostrarInfo();
		    	}
		    	
		    	if(ataqueB == 0) {
		    		pokemon1.recibirAtaque(pokemon2);
		    		System.out.println("----------------");
			    	pokemon1.mostrarInfo();
		    	}else {
		    		pokemon1.recibirAtaqueEspecial(pokemon2);
		    		System.out.println("----------------");
			    	pokemon1.mostrarInfo();	
		    	}
		    	
				
			
		    }else {
		    	
		    	System.out.println("--------COMIENZA POKEMON 2--------");
		    	if(ataqueB == 0) {
		    		pokemon1.recibirAtaque(pokemon2);
		    		System.out.println("----------------");
			    	pokemon1.mostrarInfo();
		    	}else {
		    		pokemon1.recibirAtaqueEspecial(pokemon2);
		    		System.out.println("----------------");
			    	pokemon1.mostrarInfo();	
		    	}
		    	
		    	if(ataqueA == 0) {//ATAQUE BASE
		    		pokemon2.recibirAtaque(pokemon1);
		    		System.out.println("----------------");
					pokemon2.mostrarInfo();
		    	}else {
		    		pokemon2.recibirAtaqueEspecial(pokemon1);
		    		System.out.println("----------------");
					pokemon2.mostrarInfo();
		    	}
		    	
		    }
		    
		    availableA = jugadorA.pokemonesDisponibles();
		    availableB = jugadorB.pokemonesDisponibles();
		    
		    if(!(availableA && availableB) ) {
		    	break;
		    }
		}while(true);
		
		if(availableA) {
			System.out.println(jugadorA.nombre + " ✯  W I N N E R ✯ ");
		}else {
			System.out.println(jugadorB.nombre + " ✯  W I N N E R ✯ ");
		}
	}
}
