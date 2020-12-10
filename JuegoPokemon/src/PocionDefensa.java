//
public class PocionDefensa extends Pocion {
	public PocionDefensa() {
		super();
		this.tipoPocion = "Poción Defensa";
	}
	
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
		
		this.estadoPocion = "Utilizada";
	}
}

