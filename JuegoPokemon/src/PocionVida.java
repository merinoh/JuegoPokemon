//
public class PocionVida extends Pocion {
	
	public PocionVida() {
		super();
	}
	
	@Override
	public void aplicaPocion(Pokemon pokemon) {
		// TODO Auto-generated method stub
		
		float auxVida = (float) ((float) pokemon.getVida()*1.2);
		
		if(auxVida <= 250) {
			pokemon.setVida(auxVida);
		}else {
			pokemon.setVida(250);
		}
		
		
	}

}
