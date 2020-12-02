
abstract class Pokemon {
/*
 * 	Atributos Pokemon
 */
	
	String apodo;
	String estado;
	String tipoPokemon;
	int vida;
	int ataque;
	int defensa;
	int multiplicadorDanio;
	
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
public void setVida(int vida) {
	
	this.vida = vida;
}
public void setAtaque(int ataque) {
	this.ataque = ataque;
}
public void setDefensa(int defensa) {
	this.defensa = defensa;
}
public void setMultiplicador(int multiplicador) {
	this.multiplicadorDanio = multiplicador;
}
	

/*  
 * Constructor
 */
	
	public Pokemon() {
		
	}
	
	public Pokemon(String apodo) {
		this.apodo = apodo;
		this.estado = "OK";
		this.tipoPokemon = "tipo";
		this.vida = (int)(Math.random()*250+150);
		this.ataque = (int)(Math.random()*200+150);
		this.defensa = (int)(Math.random()*200+150);
		this.multiplicadorDanio = 0;
		
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
	public int getVida() {
		return this.vida;
	}
	public int getAtaque() {
		return this.ataque;
	}
	public int setDefensa() {
		return this.defensa;
	}
	
/*
 * Métodos abstractos 
 */
	
	public abstract void recibirDanio();
	
	public abstract void multiplicadorDanio();

	public abstract void realizarPrimerAtaque();
	
	public abstract void realizarSegundoAtaque();
	
	
/*
 * Métodos regulares
 */
	//public void recibirPocionVida();
	
	//public void recibirPocionAtaque();
	
	//public void recibirPocionDefensa();
	

}
