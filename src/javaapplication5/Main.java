// Interfaz base que representa un personaje
interface Personaje {
    String habilidades();
    int ataque();
}

// Implementación
class Guerrero implements Personaje {
    @Override
    public String habilidades() {
        return "Jugador 1";
    }

    @Override
    public int ataque() {
        return 10;
    }
}

// Decorador abstracto que extiende el comportamiento de un personaje
abstract class DecoradorPersonaje implements Personaje {
    protected Personaje personajeDecorado;

    public DecoradorPersonaje(Personaje personajeDecorado) {
        this.personajeDecorado = personajeDecorado;
    }

    @Override
    public String habilidades() {
        return personajeDecorado.habilidades();
    }

    @Override
    public int ataque() {
        return personajeDecorado.ataque();
    }
}

// Decorador concreto para añadir la habilidad de volar
class ConHabilidadVolar extends DecoradorPersonaje {
    public ConHabilidadVolar(Personaje personajeDecorado) {
        super(personajeDecorado);
    }

    @Override
    public String habilidades() {
        return super.habilidades() + ", puede volar";
    }

    @Override
    public int ataque() {
        return super.ataque() + 10; // Volar aumenta el ataque en 5 puntos
    }
}

// Decorador concreto para añadir la habilidad de disparar
class ConHabilidadDisparar extends DecoradorPersonaje {
    public ConHabilidadDisparar(Personaje personajeDecorado) {
        super(personajeDecorado);
    }

    @Override
    public String habilidades() {
        return super.habilidades() + ", puede disparar";
    }

    @Override
    public int ataque() {
        return super.ataque() + 20; // Disparar aumenta el ataque en 10 puntos
    }
}

// Clase principal para probar el patrón Decorator
public class Main {
    public static void main(String[] args) {
        // Creamos un personaje básico
        Personaje guerrero = new Guerrero();
        System.out.println(guerrero.habilidades() + " con ataque de " + guerrero.ataque());

        // Añadimos la habilidad de volar al guerrero
        guerrero = new ConHabilidadVolar(guerrero);
        System.out.println(guerrero.habilidades() + " con ataque de " + guerrero.ataque());

        // Añadimos la habilidad de disparar al guerrero que ya puede volar
        guerrero = new ConHabilidadDisparar(guerrero);
        System.out.println(guerrero.habilidades() + " con ataque de " + guerrero.ataque());
    }
}
