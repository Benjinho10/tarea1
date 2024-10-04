package Productos.bebidas;


import Productos.Precio_Serie;

public class Fanta extends Bebida {
    public Fanta(int i) {
        super(Precio_Serie.FANTA.getNumSerie(), Precio_Serie.FANTA);
    }

    @Override
    public String consumir() {
        return "fanta";
    }
}
