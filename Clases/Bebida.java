abstract class Bebida{

    private int numSerie;

    public Bebida(int numSerie){
        this.numSerie = numSerie;
    }

    public int getSerie(){
        return numSerie;
    }

    public abstract String beber();
}

class Sprite extends Bebida{
    public Sprite(int numSerie){
        super(numSerie);
    }
    @Override
    public String beber() {
        return "sprite";
    }
}

class CocaCola extends Bebida{
    public CocaCola(int numSerie){
        super(numSerie);
    }
    @Override
    public String beber() {
        return "cocacola";
    }
}

class Fanta extends Bebida{
    public Fanta(int numSerie){
        super(numSerie);
    }
    @Override
    public String beber() {
        return "fanta";
    }
}
