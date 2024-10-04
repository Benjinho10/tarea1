package Productos.dulces;

import Productos.Precio_Serie;

public class Snickers extends Dulce {
    public Snickers(int i) {
        super(Precio_Serie.SNICKERS.getNumSerie(), Precio_Serie.SNICKERS);
    }

    @Override
    public String consumir() {
        return "snickers";
    }
}
