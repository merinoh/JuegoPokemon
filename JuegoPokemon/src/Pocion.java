//
abstract class Pocion {
	/*
	 * Atributos
	 */
	String tipoPocion;
	String estadoPocion;
	/*
	 * Constructor
	 */
	public Pocion() {
		this.estadoPocion = "Llena";
	}
	
	/*
	 * Método abstracto
	 */
	
	public abstract void aplicaPocion(Pokemon pokemon);
}
