/**
 *  @author Ailyn y Diego
 * Clase abstracta Pokemon
 */
abstract class Pokemon {
	//---------------------------------------------
	//					Atributos
	//---------------------------------------------
	
	/**
	 * Apodo del pokemon
	 */
	String apodo;
	/**
	 * Muestra si el pokemon esta disponible para combatir
	 * <b>post: </b> estados posibles: OK, PARALIZADO, CONGELADO, FUEFO y KO
	 */
	String estado;
	/**
	 * Existen cuatro tipos de pokemones
	 * <b>post: </b>tipos posibles: Agua, hierba, fuego y electricidad
	 */
	String tipoPokemon;
	/**
	 * Habilidad que posee un pokemon para cambiar el estado de otro pokemon
	 */
	String estadoAtaque;
	/**
	 * <b>post: </b>La vida de un pokemon tiene un maximo de 250 puntos
	 */
	float vida;
	/**
	 * <b>post: </b>El ataque de un pokemon tiene un maximo de 200 puntos
	 */
	float ataque;
	/**
	 * <b>post: </b>La defensa de un pokemon tiene un maximo de 200 puntos
	 */
	float defensa;
	/**
	 * <b>post: </b>La velocidad e de un pokemon tiene un maximo de 200 puntos
	 */
	int velocidad;

	//---------------------------------------------
	//					Setters
	//---------------------------------------------

/**
 * 
 * @param apodo inicializa un apodo
 */
public void setApodo(String apodo) {
	this.apodo = apodo;
}
/**
 * 
 * @param estado estado actual del pokemon
 */
public void setEstado(String estado) {
	this.estado = estado;
}
/**
 * 
 * @param tipo Inicializa el tipo de pokemon
 */
public void setTipoPokemon(String tipo) {
	this.tipoPokemon = tipo;
}
/**
 * 
 * @param vida inicializa la vida
 */
public void setVida(float vida) {
	
	this.vida = vida;
}
/**
 *
 * @param ataque define el valor del ataque del pokemon
 */
public void setAtaque(float ataque) {
	this.ataque = ataque;
}
/**
 * 
 * @param defensa define el valor de la defensa del pokemon
 */
public void setDefensa(float defensa) {
	this.defensa = defensa;
}

	

//---------------------------------------------
//					CONSTRUCTORES
//---------------------------------------------
	
	public Pokemon() {
		
	}
	/**
	 * 
	 * @param apodo inicializa un apodo
	 */
	public Pokemon(String apodo) {
		this.apodo = apodo;
		this.estado = "OK";
		this.vida = (float)(Math.random()*100+150);
		this.ataque = (float)(Math.random()*50+150);
		this.defensa = (float)(Math.random()*50+150);
		this.velocidad = (int)(Math.random()*100+100);
	}

//---------------------------------------------
//	 			GETTERS
//---------------------------------------------
	
/**
 * 
 * @return el apodo del pokemon
 */
	public String getApodo() {
		return this.apodo;
	}
/**
 * 
 * @return el estado del pokemon
 */
	public String getEstado() {
		return this.estado;
	}
/**
 * 
 * @return el tipo del pokemon
 */
	public String getTipoPokemon() {
		return this.tipoPokemon;
	}
/**
 * 
 * @return los puntos de vida del pokemon
 */
	public float getVida() {
		return this.vida;
	}
/**
 * 
 * @return los puntos de ataque del pokemon
 */
	public float getAtaque() {
		return this.ataque;
	}
/**
 * 
 * @return los puntos de defensa del pokemon
 */
	public float getDefensa() {
		return this.defensa;
	}
	
//---------------------------------------------
//		METODOS ABSTRACTOS
//---------------------------------------------

/**
 * 
 * @param pokemon que realiza el ataque
 */
	public abstract void recibirAtaque(Pokemon pokemon);
/**
 * 
 * @param pokemon que realiza el ataque
 */
	public abstract void recibirAtaqueEspecial(Pokemon pokemon);
/**
 * 
 * @param pokemon que realiza el ataque
 * @return el multiplicado de daño del pokemon que va a atacar
 */
	public abstract float multiplicadorDanio(Pokemon pokemon);
/**
 * 
 * @param enemigo que calcula su ataque
 * @return valor del ataque que se calcula incluyendo el multiplicador
 */
	public abstract float realizarPrimerAtaque(Pokemon enemigo);
/**
 * 
 * @param enemigo que calcula ataque especial segun el tipo de pokemon
 * @return el daño que realiza el ataque
 */
	public abstract float realizarSegundoAtaque(Pokemon enemigo);
/**
 * 
 * @return el ataque especial de cada tipo de pokemon
 */
	public abstract float getAtaqueEspecial();
	
	
//---------------------------------------------
//		METODOS REGULARES
//---------------------------------------------

/**
 * Muestra la informacion de cada pokemon
 */
	 public void mostrarInfo() {
		 System.out.println("\tApodo     : " + this.apodo);
		 System.out.println("\tVida      : " + this.vida);
		 System.out.println("\tAtaque(0) : " + this.ataque);
		 System.out.println("\tDefensa   : " + this.defensa);
		 System.out.println("\tEstado    : " + this.estado);
		 System.out.println("\tVelocidad : " + this.velocidad );
		 System.out.println("\tAtaque(1) : " + this.getAtaqueEspecial());
	 }
	 
}
