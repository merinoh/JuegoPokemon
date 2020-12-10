//
public class PocionVida extends Pocion {
	
	public PocionVida() {
		super();
		this.tipoPocion = "Poción Vida";
	}
	
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
		
		this.estadoPocion = "Utilizada";
	}

}
