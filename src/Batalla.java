 /**
  *  @author Ailyn y Diego
  */
import java.util.Scanner;
/**
 * Gimnasio de batalla pokemon
 */

public class Batalla {
	//---------------------------------------------
	//					Atributos
	//---------------------------------------------
	/*
	 * Lista de pokemones a elegir  en el gimnasio
	 */
	public Pokemon [] pokemones = new Pokemon[12]; 
	/**
	 * Jugadores 
	 */
	public Jugador jugadorA;
	public Jugador jugadorB;
	
	//-----------------------------------------------------------------
    // 					Constructor
    //-----------------------------------------------------------------

    /**
     * Inicializa los atributos de la batalla
     * El gimnasio Pokemon cuanta con un arreglo de 12 pokemones 
     * se tienen 3 pokemones de cada tipo 
     * @param nombreA nombre del primer jugador
     * @param nombreB nombre del segundo jugador
     */
	Batalla(String nombreA, String nombreB){
		pokemones[0] = new PokemonAgua("Articuno");
		pokemones[1] = new PokemonAgua("Squirtle");
		pokemones[2] = new PokemonAgua("Poliwhirl");
		pokemones[3] = new PokemonFuego("Charmander");
		pokemones[4] = new PokemonFuego("Charizard");
		pokemones[5] = new PokemonFuego("Moltres");
		pokemones[6] = new PokemonElectricidad("Pikachu");
		pokemones[7] = new PokemonElectricidad("Ampharos");
		pokemones[8] = new PokemonElectricidad("Zapdos");
		pokemones[9] = new PokemonHierba("Bulbasaur");
		pokemones[10] = new PokemonHierba("Oddish");
		pokemones[11] = new PokemonHierba("Chikorita");
		
		jugadorA = new Jugador(nombreA);
		jugadorB = new Jugador(nombreB);	
		
	}
	
	//-----------------------------------------------------------------
    // 					Metodos
    //-----------------------------------------------------------------

	/**
	 * El jugador llena su lista de pokemones.
	 * <b>post: </b> Puede tener hasta 6 pokemones.
	 * <b>post: </b> Los puede elegir el propio jugador o se le pueden asignar de forma aleatoria.
	 * @param sc - objeto de la clase scanner para leer las opciones del usuario
	 * <b>post: </b>  El jugador elige 1 si quiere elegir a sus pokemones o 0 en caso contrario
	 */
	
	public void elegirPokemon(Scanner sc){
		//variable para asignar aleatoriamente un pokemon
		int rnd;
		//Pokemon que se asigna a la lista del jugador
		Pokemon pokemon;
		//numero de pokemones que tendra cada jugador
		int numPokemon; 
		//variablke para saber si el jugador elige sus pokemones
		int elegir;
		
		try {
			System.out.println("\n¿Quieres elegir a tus pokemones? ");
			elegir = sc.nextInt();
			if(elegir != 0 && elegir != 1) {
				throw new OpcionInvalida();
			}else {
				try {
					System.out.println("\n¿Con cuantos pokemones van a combatir? ");
					numPokemon = sc.nextInt();
					
					if(numPokemon > 6) {
						throw new NumeroDePokemon();
					}else {
						if(elegir == 0) {
							//Asignando pokemonnes de forma aleatoria
							for(int i = 0; i < numPokemon; i++) {
								rnd = (int)Math.floor(Math.random()*12);
							    pokemon = pokemones[rnd];
								jugadorA.llenarListaPokemon(pokemon, i);
								rnd = (int)Math.floor(Math.random()*12);
							    pokemon = pokemones[rnd];
								jugadorB.llenarListaPokemon(pokemon, i);
							 }
						}else {
							//El judar elige los pokemones 
							System.out.println("\n\t✯ ✯ ✯  Elegir Pokemon ✯ ✯ ✯ ");
							imprimirLista();
							for(int i = 0; i < numPokemon; i++) {
								System.out.println("\nJugador " + jugadorA.nombre + " elegir Pokemon [" + i + "] >>");
								rnd = sc.nextInt();
							    pokemon = pokemones[rnd];
								jugadorA.llenarListaPokemon(pokemon, i);
								System.out.println("\nJugador " + jugadorB.nombre + " elegir Pokemon [" + i + "] >>");
								rnd = sc.nextInt();
							    pokemon = pokemones[rnd];
								jugadorB.llenarListaPokemon(pokemon, i);
							}
						}
					}
				}catch(NumeroDePokemon e) {
					System.out.println(e.getMessage());
					elegirPokemon(sc);
				}
			}
		}catch(OpcionInvalida e) {
			System.out.println(e.getMessage());
			elegirPokemon(sc);
		}		
	}
	
	/**
	 * Metodo que imprime los pokemones del gimnasio
	 */
	public void imprimirLista() {
		for(int i = 0; i < pokemones.length; i++) {
			System.out.println("\t-----------------------------");
			pokemones[i].mostrarInfo();
		}
	}
	
	/**
	 * Metodo para iniciar batalla 
	 * @param sc para leer las opciones del usuario
	 */
	public void  iniciarLucha(Scanner sc) {
		//pokemones contrincantes
		Pokemon pokemon1, pokemon2;
		//posiciones de los pokemones que van a combatir para cada jugador
		int pos, posPok;
		//variable para el numero de ataque que va a utilizar cada jugador
		int ataqueA, ataqueB; 
		//numero de pocion que elege el jugador
		int pocion;
		//iterador para mostrar el numero de ronda
		int i=1;
		//Notifica si ambos jugadores tienen al menos un pokemon para pelear
		boolean availableA = false, availableB = false;

		
		do {
			System.out.println("\n");
			System.out.println("\t ★ ★ ★ Round " + i + " ★ ★ ★");
			jugadorA.listarPokemones();
			
			try {
				//El jugador A elige el pokemon con el que va a luchar
				System.out.println("\n\t" + jugadorA.nombre + " con qué pokemon quieres luchar: ");
				pos = sc.nextInt();
				if(pos > jugadorA.listaPokemon.size()-1) {
					throw new OpcionInvalida();
				}else {
					pokemon1 = jugadorA.elegirPokemon(pos);
					jugadorB.listarPokemones();
					try {
						//El jugador A elige el pokemon con el que va a luchar
						System.out.println("\n\t" +jugadorB.nombre + " con qué pokemon quieres luchar: ");
						posPok = sc.nextInt();
						if(posPok > jugadorB.listaPokemon.size()-1) {
							throw new OpcionInvalida();
						}else {
							pokemon2 = jugadorB.elegirPokemon(posPok);
							try {
								//Opcion para el jugador A de elegir una pocion
								System.out.println("\n\t" + jugadorA.nombre + " ¿Deseas utilizar una poción?: ");
								pocion = sc.nextInt();
								if(pocion > 1 || pocion < 0) {
									throw new OpcionInvalida();
								}else {
									if(pocion == 1 ) {
										jugadorA.utilizarPocion(sc, pos);
									}
										try {
											    //Opcion para el jugador B de elegir una pocion
												System.out.println("\n\t" +jugadorB.nombre + " ¿Deseas utilizar una poción?: ");
												pocion = sc.nextInt();
												if(pocion != 0 && pocion != 1) {
													throw new OpcionInvalida();
												}else {
													if(pocion == 1) {
														jugadorB.utilizarPocion(sc, posPok);
													}
														int velocidadP1 = pokemon1.velocidad;
													    int velocidadP2 = pokemon2.velocidad;
													    System.out.println("\t--------------------");
														jugadorA.listaPokemon.get(pos).mostrarInfo();
													    try {
															//El jugador A elige entre ataque base y ataque especial
															System.out.println("\n\t" + jugadorA.nombre + " qué ataque quieres utilizar: ");
															ataqueA = sc.nextInt();
															if(ataqueA > 1 || ataqueA < 0) {
																throw new OpcionInvalida();
															}else {
																try {
																	System.out.println("\t--------------------");
																	jugadorB.listaPokemon.get(posPok).mostrarInfo();
																	//El jugador B elige entre ataque base y ataque especial
																	System.out.println("\n\t" + jugadorB.nombre + " qué ataque quieres utilizar: ");
																	ataqueB = sc.nextInt();
																	if(ataqueB > 1 || ataqueB < 0) {
																		throw new OpcionInvalida();
																	}else {
																		//Compara las velocidades de los pokemones 
																		//El pokemon que tenga mayor velocidad ataca primero 
																		 if(velocidadP1 > velocidadP2) {
																			 	//Batalla cuando empieza el pokemon 1
																		    	System.out.println("\n\t✪ ✪ ✪ COMIENZA POKEMON 1 ✪ ✪ ✪");
																		    	if(ataqueA == 0) {//ATAQUE BASE
																		    		pokemon2.recibirAtaque(pokemon1);
																		    		System.out.println("\n\t----------------------");
																					pokemon2.mostrarInfo();
																		    	}else {
																		    		pokemon2.recibirAtaqueEspecial(pokemon1);
																		    		System.out.println("\n\t----------------------");
																					pokemon2.mostrarInfo();
																		    	}
																		    	
																		    	if(ataqueB == 0) {
																		    		pokemon1.recibirAtaque(pokemon2);
																		    		System.out.println("\n\t----------------------");
																			    	pokemon1.mostrarInfo();
																		    	}else {
																		    		pokemon1.recibirAtaqueEspecial(pokemon2);
																		    		System.out.println("\n\t----------------------");
																			    	pokemon1.mostrarInfo();	
																		    	}	
																			
																		    }else {
																		    	//batalla cuando comienza el pokemon 2
																		    	System.out.println("\n\t ✪ ✪ ✪ COMIENZA POKEMON 2 ✪ ✪ ✪");
																		    	if(ataqueB == 0) {
																		    		pokemon1.recibirAtaque(pokemon2);
																		    		System.out.println("\n\t----------------------");
																			    	pokemon1.mostrarInfo();
																		    	}else {
																		    		pokemon1.recibirAtaqueEspecial(pokemon2);
																		    		System.out.println("\n\t----------------------");
																			    	pokemon1.mostrarInfo();	
																		    	}
																		    	
																		    	if(ataqueA == 0) {//ATAQUE BASE
																		    		pokemon2.recibirAtaque(pokemon1);
																		    		System.out.println("\n\t----------------------");
																					pokemon2.mostrarInfo();
																		    	}else {
																		    		pokemon2.recibirAtaqueEspecial(pokemon1);
																		    		System.out.println("\n\t----------------------");
																					pokemon2.mostrarInfo();
																		    	}
																		    	
																		    }
																		    //Verifica que los jugadores tengan pokemones disponibles para continuar luchando
																		    availableA = jugadorA.pokemonesDisponibles();
																		    availableB = jugadorB.pokemonesDisponibles();
																		    
																		    i++;
																	}
																}catch(OpcionInvalida e) {
																	System.out.println(e.getMessage());
																	iniciarLucha(sc);
																}
															}
														}catch(OpcionInvalida e) {
															System.out.println(e.getMessage());
															iniciarLucha(sc);
														}
													
												}
											}catch(OpcionInvalida e) {
												System.out.println(e.getMessage());
												iniciarLucha(sc);
											}
										
								  }
							}catch(OpcionInvalida e) {
								System.out.println(e.getMessage());
								iniciarLucha(sc);
							}
						}
					}catch(OpcionInvalida e) {
						System.out.println(e.getMessage());
						iniciarLucha(sc);
					}
				}
			}catch(OpcionInvalida e) {
				System.out.println(e.getMessage());
				iniciarLucha(sc);
			}
		   //Si los dos jugadores tienen pokemones disponibles
		   // La pelea continua
		}while(availableA && availableB);
		//Verificando al jugador ganador
		if(availableA) {
			System.out.println("\n\t" + jugadorA.nombre + " ✯  W I N N E R ✯ ");
		}else {
			System.out.println("\n\t" + jugadorB.nombre + " ✯  W I N N E R ✯ ");
		}
	}
}
