import java.util.ArrayList;
import java.util.Scanner;
//
public class Jugador {
	/*
	 * Atributos
	 */
	
	String nombre;
	Pocion [] listaPocion = new Pocion[6];
	ArrayList<Pokemon> listaPokemon = new ArrayList<Pokemon>();
	
	/*
	 * Constructores
	 */
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
	
	/*
	 * Setter
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/*
	 * Getter
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/*
	 * Métodos
	 */
	
	public void llenarListaPokemon(Pokemon pokemon, int pos) {
		listaPokemon.add(pos, pokemon);
	}
	
	public void listarPokemones() {
		for(int i = 0; i < listaPokemon.size(); i++) {
			listaPokemon.get(i).mostrarInfo();
		}
	}
	
	public Pokemon elegirPokemon(int pos) {
		return this.listaPokemon.get(pos);
	}
	
}
