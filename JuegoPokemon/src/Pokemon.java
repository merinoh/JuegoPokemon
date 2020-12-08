
abstract class Pokemon {
/*
 * 	Atributos Pokemon
 */
	
	String apodo;
	String estado;
	String tipoPokemon;
	float vida;
	float ataque;
	float defensa;
	int velocidad;
	//Pocion pocion
	
/*
* Setters
*/
public void setApodo(String apodo) {
	this.apodo = apodo;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public void setTipoPokemon(String tipo) {
	this.tipoPokemon = tipo;
}
public void setVida(float vida) {
	
	this.vida = vida;
}
public void setAtaque(float ataque) {
	this.ataque = ataque;
}
public void setDefensa(float defensa) {
	this.defensa = defensa;
}

	

/*  
 * Constructor
 */
	
	public Pokemon() {
		
	}
	
	public Pokemon(String apodo) {
		this.apodo = apodo;
		this.estado = "OK";
		this.vida = (float)(Math.random()*100+150);
		this.ataque = (float)(Math.random()*50+150);
		this.defensa = (float)(Math.random()*50+150);
		this.velocidad = (int)(Math.random()*100+100);
	}

/*
 * Getters
 */
	public String getApodo() {
		return this.apodo;
	}
	public String getEstado() {
		return this.estado;
	}
	public String getTipoPokemon() {
		return this.tipoPokemon;
	}
	public float getVida() {
		return this.vida;
	}
	public float getAtaque() {
		return this.ataque;
	}
	public float getDefensa() {
		return this.defensa;
	}
	
/*
 * Métodos abstractos 
 */
	
	public abstract void recibirAtaque(Pokemon pokemon);
	
	public abstract void recibirAtaqueEspecial(Pokemon pokemon);
	
	public abstract float multiplicadorDanio(Pokemon pokemon);

	public abstract float realizarPrimerAtaque(Pokemon enemigo);
	
	public abstract float realizarSegundoAtaque(Pokemon enemigo);
	
	
/*
 * Métodos regulares
 */
	//public void recibirPocionVida();
	
	//public void recibirPocionAtaque();
	
	//public void recibirPocionDefensa();
	 public void mostrarInfo() {
		 System.out.println("Nombre: "+ this.apodo);
		 System.out.println("Vida "+ this.vida);
		 System.out.println("Ataque "+ this.ataque);
		 System.out.println("Defensa "+ this.defensa);
		 System.out.println("Estado " + this.estado);
	 }
	 
	 

}
