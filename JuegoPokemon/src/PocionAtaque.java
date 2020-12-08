//
public class PocionAtaque extends Pocion {
	public PocionAtaque() {
		super();
	}
	
	@Override
	public void aplicaPocion(Pokemon pokemon) {
		// TODO Auto-generated method stub
		float auxAtaque = (float) ((float) pokemon.getAtaque()*1.1);
		
		if(auxAtaque <= 200) {
			pokemon.setAtaque(auxAtaque);
		}else {
			pokemon.setAtaque(200);
		}
		
	}
}
