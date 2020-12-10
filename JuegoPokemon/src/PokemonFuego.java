public class PokemonFuego extends Pokemon {
	/*
	 * Atributos
	 */
	float ataqueFuego; 
	/*
	 * Constructor
	 */
	public PokemonFuego(String apodo) {
		// TODO Auto-generated constructor stub
		super(apodo);
		this.tipoPokemon = "fuego";
		this.ataqueFuego = (float)(Math.random()*50+150);
		this.estadoAtaque = "QUEMADO";
	}
	
	public PokemonFuego() {
		
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
			this.estado = enemigo.estadoAtaque;
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
		
		if(enemigo.tipoPokemon.equals("hierba")) {
			multiplicadorDanio = 2.0f;
		}else if(enemigo.tipoPokemon.equals("agua")) {
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
			System.out.println("\n\t" + this.apodo + " está " + this.estado);
		}
		
		return resultado;
	}
	
	@Override
	public float realizarSegundoAtaque(Pokemon defensor) {
		// TODO Auto-generated method stub
		float resultado = 0;
		
		if(estado.equals("OK")) {
			resultado = (this.ataqueFuego - defensor.defensa);
		}else {
			System.out.println("\n\t" + this.apodo + " está " + this.estado);
		}
		
		
		return resultado;
	}
	
	public float getAtaqueEspecial() {
		return this.ataqueFuego;
	}
	
}