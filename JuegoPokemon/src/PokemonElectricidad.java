 /**
  *  @author Ailyn y Diego
  */
public class PokemonElectricidad extends Pokemon {
	//---------------------------------------------
	//					Atributos
	//---------------------------------------------
	/**
	 * Valor distinto al ataque base que es especifico del pokemon de fuego
	 */
	float ataqueElectricidad; 
	//-----------------------------------------------------------------
    // 					Constructor
    //-----------------------------------------------------------------
	public PokemonElectricidad(String apodo) {
		// TODO Auto-generated constructor stub
		super(apodo);
		this.tipoPokemon = "electrico";
		this.ataqueElectricidad = (float)(Math.random()*50+150);
		this.estadoAtaque = "PARALIZADO";
	}
	
	public PokemonElectricidad() {
		
	}
	//-----------------------------------------------------------------
    // 					METODOS ABSTRACTOS
    //-----------------------------------------------------------------
	/**
	 * Metodo sobre-escrito que recibe el ataque del pokemon enemigo
	 * 
	 * @param enemigo modifica la vida del pokemon atacado
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
	/**
	 * Metodo sobre-escrito que recibe el ataque especial del pokemon enemigo
	 * 
	 * @param enemigo modifica la vida del pokemon atacado y posiblemnte su estado
	 * dependiendo de una probabilidad definida se cambia el estado del pokemon
	 */
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
	/**
	 * Metodo sobre-escrito que recibe el ataque del pokemon enemigo
	 * @return el multiplicador de daño dependiendo del tipo de enemigo
	 */
	@Override
	public float multiplicadorDanio(Pokemon enemigo) {
		float multiplicadorDanio = 0;
		
		if(enemigo.tipoPokemon.equals("agua")) {
			multiplicadorDanio = 2.0f;
		}else if(enemigo.tipoPokemon.equals("hierba")) {
			multiplicadorDanio = 0.5f;
		}else if(enemigo.tipoPokemon.equals("electrico")) {
			multiplicadorDanio = 0.5f;
		}else if(enemigo.tipoPokemon.equals("fuego")) {
			multiplicadorDanio = 1.0f;
		}
		
		return multiplicadorDanio;
	}
	/**
	 * Metodo sobre-escrito que calcula el ataque dependiendo del pokemon que se ataca
	 * @param atacado pokemon que recibe el ataque
	 * @return el valor del daño que realiza
	 */
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
	/**
	 * Metodo sobre-escrito que realiza el ataque especial dependiendo del tipo de pokemon
	 * calcula el valor del daño que se realiza al cpontrincante
	 * @param defensor pokemon que recibe el ataque
	 * @return el valor del ataque 
	 */
	@Override
	public float realizarSegundoAtaque(Pokemon defensor) {
		// TODO Auto-generated method stub
		float resultado = 0;
		
		if(estado.equals("OK")) {
			resultado = (this.ataqueElectricidad - defensor.defensa);
		}else {
			System.out.println("\n\t" + this.apodo + " está " + this.estado);
		}
		
		
		return resultado;
	}
	/**
	 * 
	 * @return el valor del ataque especial del pokemon
	 */
	public float getAtaqueEspecial() {
		return this.ataqueElectricidad;
	}
	
}