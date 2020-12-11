/**
 * 
 * @author Ailyn y Ruben
 * Clase que hereda de la clase pocion
 */
public class PocionAtaque extends Pocion {
	public PocionAtaque() {
		super();
		this.tipoPocion = "Poción ataque";
	}
/**
 *  Metodo que sobre-escribe el metodo de aplicar pocion
 *  Aumenta el ataque en un 10%
 *  @param pokemon que recibe la pocion
 */
	@Override
	public void aplicaPocion(Pokemon pokemon) {
		// TODO Auto-generated method stub
		float auxAtaque = pokemon.getAtaque();
		
		if(this.estadoPocion.equals("Llena")) {
			auxAtaque = (float) ((float) auxAtaque*1.1);
		}
		
		if(auxAtaque <= 200) {
			pokemon.setAtaque(auxAtaque);
		}else {
			pokemon.setAtaque(200);
		}
		//deshecha la pocion
		this.estadoPocion = "Utilizada";
	}
}
