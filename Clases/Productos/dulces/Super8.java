package Productos.dulces;


import Productos.Precio_Serie;

public class Super8 extends Dulce {
    public Super8() {
        super(Precio_Serie.SUPER8.getNumSerie(), Precio_Serie.SUPER8);
    }

    @Override
    public String consumir() {
        return "super8";
    }
}

