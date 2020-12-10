//
public class PocionAtaque extends Pocion {
	public PocionAtaque() {
		super();
		this.tipoPocion = "Poción ataque";
	}
	
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
		
		this.estadoPocion = "Utilizada";
	}
}
