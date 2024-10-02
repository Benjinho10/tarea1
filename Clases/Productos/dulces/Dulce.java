package Productos.dulces;

import Productos.Precio_Serie;
import Productos.Producto;

public abstract class Dulce extends Producto {
    public Dulce(int numSerie, Precio_Serie precio) {
        super(numSerie, precio);
    }
}
