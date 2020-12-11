abstract class Pocion {
	//---------------------------------------------
	//					Atributos
	//---------------------------------------------
	/**
	 * Existen tres tipos diferentes de pociones
	 * 1. Los que aumentan la vida
	 * 2. Los que aumentan la defensa
	 * 3. Los que aumentan el ataque
	 */
	String tipoPocion;
	/**
	 * Muestra si la pocion se ha utilizado o no
	 */
	String estadoPocion;
	//---------------------------------------------
	//					CONSTRUCTOR
	//---------------------------------------------
	public Pocion() {
		this.estadoPocion = "Llena";
	}
	
	//---------------------------------------------
	//				METODO ABSTRACTO
	//---------------------------------------------
	
	/**
	 * 
	 * @param pokemon al que se le aplica la pocion
	 */
	public abstract void aplicaPocion(Pokemon pokemon);
}
