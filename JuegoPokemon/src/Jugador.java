import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {
	//---------------------------------------------
	//					Atributos
	//---------------------------------------------
	
	/**
	 * Nombre del jugador
	 */
	String nombre;
	/**
	 * Arreglo para guardar las pociones
	 * Un jugador puede tener hasta 6 pociones
	 * 2 pociones de cada tipo diferente
	 */
	Pocion [] listaPocion = new Pocion[6];
	ArrayList<Pokemon> listaPokemon = new ArrayList<Pokemon>();
	
	//-----------------------------------------------------------------
    // 					Constructor
    //-----------------------------------------------------------------
	public Jugador() {
		
	}
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		//Pociones
		listaPocion[0] = new PocionVida();
		listaPocion[1] = new PocionVida();
		listaPocion[2] = new PocionAtaque();
		listaPocion[3] = new PocionAtaque();
		listaPocion[4] = new PocionDefensa();
		listaPocion[5] = new PocionDefensa();
		//
	}

	//-----------------------------------------------------------------
    // 					SETTERS
    //-----------------------------------------------------------------
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//-----------------------------------------------------------------
    // 					SETTERS
    //-----------------------------------------------------------------
	public String getNombre() {
		return this.nombre;
	}
	
	//-----------------------------------------------------------------
    // 					METODOS
    //-----------------------------------------------------------------

	/**
	 * Llena la lista de pokemones del jugador
	 * @param pokemon el pokemon que se elige del gimnasio
	 * @param pos de la lista en la que se guarda el pokemon
	 */
	public void llenarListaPokemon(Pokemon pokemon, int pos) {
		if(pokemon.tipoPokemon.equals("fuego")) {
			listaPokemon.add(pos, new PokemonFuego(pokemon.apodo));
		}else if(pokemon.tipoPokemon.equals("electrico")) {
			listaPokemon.add(pos, new PokemonElectricidad(pokemon.apodo));
		}else if(pokemon.tipoPokemon.equals("agua")) {
			listaPokemon.add(pos, new PokemonAgua(pokemon.apodo));
		}else if(pokemon.tipoPokemon.equals("hierba")) {
			listaPokemon.add(pos, new PokemonHierba(pokemon.apodo));
		}
		
	}

/**
 * Lista los pokemones del jugador
 */
	public void listarPokemones() {
		System.out.println("\t• • Lista de " + this.nombre + " • •");
		for(int i = 0; i < listaPokemon.size(); i++) {
			System.out.println("\t--------------------");
			listaPokemon.get(i).mostrarInfo();
		}
	}
/**
 * 
 * @param pos del pokemon que quiere luchar
 * @return el pokemon que va a luchar
 */
	public Pokemon elegirPokemon(int pos) {

		return this.listaPokemon.get(pos);
	}
	
/**
 * Metodo que verifica que el jugador todavia tiene pokemones para pelear
 * @return verdadero si hay al menos un pokemon con estado "OK"para pelear
 */
	public boolean pokemonesDisponibles() {
		for(int i = 0; i < listaPokemon.size(); i++) {
			if(listaPokemon.get(i).estado.equals("OK")) {
				return true;
			}
		}
		return false;
	}
/**
 * Lista las pociones del usuario
 */
	public void listarPocion() {
		for(int i = 0; i < listaPocion.length; i++) {
			System.out.println("\tPoción " + i + " " + 
		    listaPocion[i].tipoPocion + " " + 
			listaPocion[i].estadoPocion);
		}
	}
/**
 * 
 * @param sc lee los datos de entrada por teclado
 * @param posPok posicion del pokemon al que se le aplica la pocion
 */
	public void utilizarPocion(Scanner sc, int posPok) {
		int numPos;
		listarPocion();
		try {
			System.out.println("\n\tQué poción quieres utilizar: ");
			numPos = sc.nextInt();
			if(numPos > this.listaPocion.length-1) {
				throw new OpcionInvalida();
			}else {
				listaPocion[numPos].aplicaPocion(listaPokemon.get(posPok));
			}
			
		}catch(OpcionInvalida e) {
			System.out.println(e.getMessage());
			utilizarPocion(sc, posPok);
		}
		
	}
	
	
}
