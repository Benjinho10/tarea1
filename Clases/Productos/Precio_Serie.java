package Productos;

public enum Precio_Serie {
    SPRITE(1000, 1),
    COCACOLA(1000, 2),
    FANTA(1000, 3),
    SUPER8(500, 4),
    SNICKERS(500, 5);

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
