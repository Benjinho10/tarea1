package Productos.bebidas;

import Productos.Precio_Serie;

public class Sprite extends Bebida {
    public Sprite(int i) {
        super(Precio_Serie.SPRITE.getNumSerie(), Precio_Serie.SPRITE);
    }

    @Override
    public String consumir() {
        return "sprite";
    }
}
