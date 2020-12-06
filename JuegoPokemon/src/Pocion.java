public interface Pocion{
    //METODOS
    public void usarPocion(Pokemon pokemon);
}

public class PocionVida{
    //ATRIBUTOS
    String tipo="Vida";
    //METODOS
    public void usarPocion(Pokemon pokemon){
        pokemon.vida+=(pokemon.vida*.20)
    }
}

public class PocionAtaque{
    //ATRIBUTOS
    String tipo="Ataque";
    //METODOS
    public void usarPocion(Pokemon pokemon){
        pokemon.ataque+=(pokemon.ataque*.10)
    }
}

public class PocionDefensa{
    //ATRIBUTOS
    String tipo="Defensa";
    //METODOS
    public void usarPocion(Pokemon pokemon){
        pokemon.defensa+=(pokemon.defensa*.10)
    }
}