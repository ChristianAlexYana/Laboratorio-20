import java.util.*;
class Soldado {
    private String nombre;
    private int puntosVida;
    private int fila;
    private int columna;
    public Soldado(String nombre, int puntosVida, int fila, int columna) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.fila = fila;
        this.columna = columna;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPuntosVida() {
        return puntosVida;
    }
    public int getFila() {
        return fila;
    }
    public int getColumna() {
        return columna;
    }
    @Override
    public String toString() {
        return nombre + " Vida: " + puntosVida + ", Posicion: " + fila + ", " + columna ;
    }
}
class Espadachin extends Soldado {
    private int longitudEspada;
    public Espadachin(String nombre, int puntosVida, int fila, int columna, int longitudEspada) {
        super(nombre, puntosVida, fila, columna);
        this.longitudEspada = longitudEspada;
    }
    @Override
    public String toString() {
        return super.toString() + ", Longitud de espada: " + longitudEspada;
    }
}
class Arquero extends Soldado {
    private int flechas;
    public Arquero(String nombre, int puntosVida, int fila, int columna, int flechas) {
        super(nombre, puntosVida, fila, columna);
        this.flechas = flechas;
    }
    @Override
    public String toString() {
        return super.toString() + ", Flechas disponibles: " + flechas;
    }
}
class Caballero extends Soldado {
    private String armaActual;
    private boolean montado;
    public Caballero(String nombre, int puntosVida, int fila, int columna) {
        super(nombre, puntosVida, fila, columna);
        this.armaActual = "Espada";
        this.montado = false;
    }
    @Override
    public String toString() {
        return super.toString() + ", Arma: " + armaActual + ", Montado: " + montado;
    }
}
class Lancero extends Soldado {
    private int longitudLanza;
    public Lancero(String nombre, int puntosVida, int fila, int colummna, int longitudLanza){
        super(nombre, puntosVida, fila, colummna);
        this.longitudLanza = longitudLanza;
    }
    @Override
    public String toString(){
        return super.toString()+ ", Longitud de Lanza: "+ longitudLanza;
    }
}


