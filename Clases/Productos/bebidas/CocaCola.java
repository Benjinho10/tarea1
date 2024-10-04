package Productos.bebidas;

import Productos.Precio_Serie;

public class CocaCola extends Bebida {
    public CocaCola(int i) {
        super(Precio_Serie.COCACOLA.getNumSerie(), Precio_Serie.COCACOLA);
    }

    @Override
    public String consumir() {
        return "cocacola";
    }
}
