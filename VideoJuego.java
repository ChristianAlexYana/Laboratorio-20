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
class Ejercito {
    private Soldado[] soldados;
    private int numeroSoldados;
    private String nombreEjercito;
    private String[][] tablero;
    public Ejercito(String nombreEjercito, String[][] tablero) {
        this.nombreEjercito = nombreEjercito;
        this.soldados = new Soldado[10];
        this.numeroSoldados = 0;
        this.tablero = tablero;
        }
    public void crearSoldado(int tipoSoldado, int i) {
        Random rand = new Random();
        String nombre = "";
        int vida = 0, fila = rand.nextInt(10), columna = rand.nextInt(10);
        switch (tipoSoldado) {
            case 0://espadachin
                nombre = "E" + i + "X" + (nombreEjercito.equals("Ejército 1") ? "1" : "2");  //formato: E4X1
                vida = rand.nextInt(2) + 3;
                agregarSoldado(new Espadachin(nombre, vida, fila, columna, rand.nextInt(3) + 2));
                break;
            case 1:  //arquero
                nombre = "A" + i + "X" + (nombreEjercito.equals("Ejército 1") ? "1" : "2");  //formato: A8X2
                vida = rand.nextInt(3) + 1;
                agregarSoldado(new Arquero(nombre, vida, fila, columna, rand.nextInt(10) + 5));
                break;
            case 2:     //caballero
                nombre = "C" + i + "X" + (nombreEjercito.equals("Ejército 1") ? "1" : "2");  //formato: C1X1
                vida = rand.nextInt(3) + 3;
                agregarSoldado(new Caballero(nombre, vida, fila, columna));
                break;
        }
    }
    public void agregarSoldado(Soldado soldado) {
        if (numeroSoldados < 10) {
            soldados[numeroSoldados] = soldado;
            numeroSoldados++;
            tablero[soldado.getFila()][soldado.getColumna()] = soldado.getNombre(); //agregra nombre ne la posicion
        }
    }
    public void ordenarPorPoder() {    //burbuja
        for (int i = 0; i < numeroSoldados - 1; i++) {
            for (int j = i + 1; j < numeroSoldados; j++) {
                if (soldados[i].getPuntosVida() < soldados[j].getPuntosVida()) {
                    Soldado temp = soldados[i];
                    soldados[i] = soldados[j];
                    soldados[j] = temp;
                }
            }
        }
    
    }
    public Soldado[] getSoldados() {
        return soldados;
    }
    public String getNombreEjercito() {
        return nombreEjercito;
    }
}