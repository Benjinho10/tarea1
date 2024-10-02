abstract class Producto {
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

    abstract public String consumir();
}

enum Precio_Serie {
    SPRITE(700, 1),
    COCACOLA(800, 2),
    FANTA(700, 3),
    SUPER8(300, 4),
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

abstract class Bebida extends Producto {
    public Bebida(int numSerie, Precio_Serie precio) {
        super(numSerie, precio);
    }

    @Override
    public abstract String consumir();
}

class Sprite extends Bebida {
    public Sprite() {
        super(Precio_Serie.SPRITE.getNumSerie(), Precio_Serie.SPRITE);
    }

    @Override
    public String consumir() {
        return "sprite";
    }
}

class CocaCola extends Bebida {
    public CocaCola() {
        super(Precio_Serie.COCACOLA.getNumSerie(), Precio_Serie.COCACOLA);
    }

    @Override
    public String consumir() {
        return "cocacola";
    }
}

class Fanta extends Bebida {
    public Fanta() {
    super(Precio_Serie.FANTA.getNumSerie(), Precio_Serie.FANTA);
    }

    @Override
    public String consumir() {
        return "fanta";
    }
}

abstract class Dulce extends Producto {
    public Dulce(int numSerie, Precio_Serie precio) {
        super(numSerie, precio);
    }
}

class Super8 extends Dulce {
    public Super8() {
        super(Precio_Serie.SUPER8.getNumSerie(), Precio_Serie.SUPER8);
    }

    @Override
    public String consumir() {
        return "super8";
    }
}

class Snickers extends Dulce {
    public Snickers() {
        super(Precio_Serie.SNICKERS.getNumSerie(), Precio_Serie.SNICKERS);
    }

    @Override
    public String consumir() {
        return "snickers";
    }
}
