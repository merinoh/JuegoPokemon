//
public class PokemonAgua extends Pokemon {
	/*
	 * Atributos
	 */
	float ataqueAgua = (float)(Math.random()*50+150);;
	/*
	 * Constructor
	 */
	public PokemonAgua(String apodo) {
		// TODO Auto-generated constructor stub
		super(apodo);
		this.tipoPokemon = "agua";
		
	}
	
	public PokemonAgua() {
		
	}

	/*
	 * Métodos abstractos
	 */
	@Override
	public void recibirAtaque(Pokemon enemigo) {
		// TODO Auto-generated method stub
		float diferencia = enemigo.realizarPrimerAtaque(this);
		
		if(diferencia > 0) {
			vida -= diferencia;
		}
	}

	@Override
	public void recibirAtaqueEspecial(Pokemon enemigo) {
		float diferencia = enemigo.realizarSegundoAtaque(this);
		
		if(enemigo.estado.equals("OK")) {
			this.estado = "congelado";
		}
		
		if(diferencia > 0) {
			vida -= diferencia;
		}
	}
	
	@Override
	public float multiplicadorDanio(Pokemon enemigo) {
		float multiplicadorDanio = 0;
		
		if(enemigo.tipoPokemon.equals("fuego")) {
			multiplicadorDanio = 2.0f;
		}else if(enemigo.tipoPokemon.equals("agua")) {
			multiplicadorDanio = 0.5f;
		}else if(enemigo.tipoPokemon.equals("hierba")) {
			multiplicadorDanio = 0.5f;
		}else if(enemigo.tipoPokemon.equals("electrico")) {
			multiplicadorDanio = 1.0f;
		}
		
		return multiplicadorDanio;
	}

	@Override
	public float realizarPrimerAtaque(Pokemon defensor) {
		// TODO Auto-generated method stub
		float resultado = 0;
		
		if(estado.equals("OK")) {
			resultado = (this.ataque - defensor.defensa)*this.multiplicadorDanio(defensor);
		}else {
			System.out.println(this.apodo + " está " + this.estado);
		}
		
		return resultado;
	}
	
	@Override
	public float realizarSegundoAtaque(Pokemon defensor) {
		// TODO Auto-generated method stub
		float resultado = 0;
		
		if(estado.equals("OK")) {
			resultado = (this.ataqueAgua - defensor.defensa);
		}else {
			System.out.println(this.apodo + " está " + this.estado);
		}
		
		
		return resultado;
	}
	
}
