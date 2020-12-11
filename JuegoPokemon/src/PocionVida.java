/**
 * 
 * @author Ailyn y Ruben
 * Clase que hereda de la clase pocion
 */
public class PocionVida extends Pocion {
	
	public PocionVida() {
		super();
		this.tipoPocion = "Poción Vida";
	}
	/**
	 *  Metodo que sobre-escribe el metodo de aplicar pocion
	 *  Aumenta la vida en un 20%
	 *  @param pokemon que recibe la pocion
	 */
	@Override
	public void aplicaPocion(Pokemon pokemon) {
		// TODO Auto-generated method stub
		
		float auxVida = pokemon.getVida();
		
		if(this.estadoPocion.equals("Llena")) {
			auxVida = (float) ((float) auxVida*1.2);
		}
		
		if(auxVida <= 250) {
			pokemon.setVida(auxVida);
		}else {
			pokemon.setVida(250);
		}
		//deshecha la pocion
		this.estadoPocion = "Utilizada";
	}

}
