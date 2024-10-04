package Productos;

public enum Precio_Serie {
    SPRITE(700, 1),
    COCACOLA(800, 2),
    FANTA(700, 3),
    SUPER8(900, 4),
    SNICKERS(1000, 5);

    private int valor;
    private int numSerie;

    Precio_Serie(int valor, int numSerie) {
        this.valor = valor;
        this.numSerie = numSerie;
    }

    public int getValor() {
        return valor;
    }

    public int getNumSerie() {
        return numSerie;
    }
}
