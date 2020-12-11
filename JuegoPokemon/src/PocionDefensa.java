/**
 * 
 * @author Ailyn y Ruben
 * Clase que hereda de la clase pocion
 */
public class PocionDefensa extends Pocion {
	public PocionDefensa() {
		super();
		this.tipoPocion = "Poción Defensa";
	}
	/**
	 *  Metodo que sobre-escribe el metodo de aplicar pocion
	 *  Aumenta la vida en un 10%
	 *  @param pokemon que recibe la pocion
	 */
	@Override
	public void aplicaPocion(Pokemon pokemon) {
		// TODO Auto-generated method stub
		float auxDefensa = pokemon.getDefensa();
		
		if(this.estadoPocion.equals("Llena")) {
			auxDefensa = (float) ((float) auxDefensa*1.1);
		}
		
		if(auxDefensa <= 200) {
			pokemon.setDefensa(auxDefensa);
		}else {
			pokemon.setDefensa(200);
		}
		//deshecha la pocion
		this.estadoPocion = "Utilizada";
	}
}

