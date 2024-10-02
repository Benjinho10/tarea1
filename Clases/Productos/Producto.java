package Productos;

public abstract class Producto {
    private int numSerie;
    private Precio_Serie precio;

    public Producto(int numSerie, Precio_Serie precio) {
        this.numSerie = numSerie;
        this.precio = precio;
    }

    public int getSerie() {
        return numSerie;
    }

    public Precio_Serie getPrecio() {
        return precio;
    }

    public abstract String consumir();
}
