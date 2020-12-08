//
public class PocionDefensa extends Pocion {
	public PocionDefensa() {
		super();
	}
	
	@Override
	public void aplicaPocion(Pokemon pokemon) {
		// TODO Auto-generated method stub
		float auxDefensa = (float) ((float) pokemon.getDefensa()*1.1);
		
		if(auxDefensa <= 200) {
			pokemon.setDefensa(auxDefensa);
		}else {
			pokemon.setDefensa(200);
		}
	}
}

