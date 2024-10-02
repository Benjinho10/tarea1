abstract class Producto{

    private int numSerie;
    private Precio precio;

    public Producto(int numSerie, Precio precio){
        this.numSerie = numSerie;
        this.precio = precio;
    }

    public int getSerie(){
        return numSerie;
    }

    public Precio getPrecio(){
        return precio;
    }

    abstract public String consumir();
}

enum Precio {
    SPRITE(700), COCACOLA(800), FANTA(700), SUPER8(300), SNICKERS(1000);
    private int numSerie;
    private int valor;

    Precio(int valor){
        this.valor = valor;

    }

    public  int getSerie(){
        return numSerie;
    }
    public int getValor() {
        return valor;
    }
}

abstract class Bebida extends Producto{
        public Bebida (int numSerie, Precio precio){
            super (numSerie, precio);
        }
        @Override
        public abstract String consumir();
}

class Sprite extends Bebida {
    public Sprite(int numSerie){
        super(numSerie, Precio.SPRITE);
    }
    @Override
    public String consumir() {
        return "sprite";
    }
}
class CocaCola extends Bebida {
    public CocaCola(int numSerie){
        super(numSerie, Precio.COCACOLA);
    }
    @Override
    public String consumir() {
        return "cocacola";
    }
}

class Fanta extends Bebida {
    public Fanta(int numSerie){
        super(numSerie, Precio.FANTA);
    }
    @Override
    public String consumir() {
        return "fanta";
    }
}

abstract class Dulce extends Producto{
    public Dulce(int numSerie, Precio precio){
        super(numSerie, precio);
    }
}

class Super8 extends Dulce {
    public Super8(int numSerie){
        super(numSerie, Precio.SUPER8);
    }
    @Override
    public String consumir() {
        return "super8";
    }
}

class Snickers extends Dulce {
    public Snickers (int numSerie){
        super(numSerie, Precio.SNICKERS);
    }
    @Override
    public String consumir() {
        return "snickers";
    }
}