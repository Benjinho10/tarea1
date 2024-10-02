package Productos.bebidas;

import Productos.Precio_Serie;
import Productos.Producto;

public abstract class Bebida extends Producto {
    public Bebida(int numSerie, Precio_Serie precio) {
        super(numSerie, precio);
    }

    @Override
    public abstract String consumir();
}

