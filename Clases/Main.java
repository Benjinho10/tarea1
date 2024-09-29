import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Expendedor exp = new Expendedor(4, 1000);
        Moneda m = new Moneda1000();
        Comprador c = new Comprador(m, Expendedor.SPRITE, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());
    }
}