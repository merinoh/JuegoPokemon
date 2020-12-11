/**
 * 
 * @author Ailyn y Diego
 * Clase para notificar al usuario que no puede exeder 6 pokemones
 */
public class NumeroDePokemon extends Exception{
	public NumeroDePokemon() {
		super("\nEl maximo a elegir son 6 pokemones\n");
	}
}
