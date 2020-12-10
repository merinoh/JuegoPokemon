//
public class PokemonHierba extends Pokemon {
	/*
	 * Atributos
	 */
	float ataqueHierba; 
	/*
	 * Constructor
	 */
	public PokemonHierba(String apodo) {
		// TODO Auto-generated constructor stub
		super(apodo);
		this.tipoPokemon = "hierba";
		this.ataqueHierba = (float)(Math.random()*50+150);
	}
	
	public PokemonHierba() {
		
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
			if(vida <= 0) {
				this.vida = 0;
				this.estado = "KO";
				System.out.println(this.apodo + " " + this.estado);
			}
		}
	}

	@Override
	public void recibirAtaqueEspecial(Pokemon enemigo) {
		float diferencia = enemigo.realizarSegundoAtaque(this);
		float rnd = (float)(Math.random());
		float probabilidad = 0.2f;
		
		if(enemigo.estado.equals("OK") && rnd < probabilidad) {
			this.estado = "envenena";
		}
		
		if(diferencia > 0) {
			vida -= diferencia;
			if(vida <= 0) {
				this.vida = 0;
				this.estado = "KO";
				System.out.println(this.apodo + " " + this.estado);
			}
		}
	}
	
	@Override
	public float multiplicadorDanio(Pokemon enemigo) {
		float multiplicadorDanio = 0;
		
		if(enemigo.tipoPokemon.equals("agua")) {
			multiplicadorDanio = 2.0f;
		}else if(enemigo.tipoPokemon.equals("hierba")) {
			multiplicadorDanio = 0.5f;
		}else if(enemigo.tipoPokemon.equals("fuego")) {
			multiplicadorDanio = 0.5f;
		}else if(enemigo.tipoPokemon.equals("electrico")) {
			multiplicadorDanio = 1.0f;
		}
		
		return multiplicadorDanio;
	}

	@Override
	public float realizarPrimerAtaque(Pokemon atacado) {
		// TODO Auto-generated method stub
		float resultado = 0;
		
		if(estado.equals("OK")) {
			resultado = (this.ataque - atacado.defensa)*this.multiplicadorDanio(atacado);
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
			resultado = (this.ataqueHierba - defensor.defensa);
		}else {
			System.out.println(this.apodo + " está " + this.estado);
		}
		
		
		return resultado;
	}
	
	public float getAtaqueEspecial() {
		return this.ataqueHierba;
	}
	
}