import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import Monedas.Moneda;
import Monedas.Moneda100;
import Monedas.Moneda1000;
import Monedas.Moneda500;
import Productos.Producto;
import Productos.Precio_Serie;
import Productos.bebidas.Bebida;
import Productos.bebidas.CocaCola;
import Productos.bebidas.Sprite;
import Productos.bebidas.Fanta;
import Productos.dulces.Dulce;
import Productos.dulces.Snickers;
import Productos.dulces.Super8;

public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(5);

        ArrayList<Moneda> monedas = new ArrayList<>();

        monedas.add(new Moneda500());
        monedas.add(new Moneda1000());
        monedas.add(new Moneda500());
        monedas.add(new Moneda100());

        Collections.sort(monedas);

        for (Moneda moneda : monedas) {
            System.out.println(moneda.getValor());
        }

        Collections.reverse(monedas);

        for (Moneda moneda : monedas) {
            System.out.println(moneda.getValor());
        }

        try {
            Moneda moneda1 = new Moneda1000();
            Comprador comprador1 = new Comprador(moneda1, 5, exp);
            System.out.println("Comprador 1: " + comprador1.queConsumiste() + ", vuelto: $" + comprador1.cuantoVuelto());
        } catch (PagoInsuficienteException e) {
            System.out.println("El valor es insuficiente.");
        } catch (NoHayProductoException e) {
            System.out.println("No hay producto disponible.");
        } catch (PagoIncorrectoException e) {
            System.out.println("El valor no es valido.");
        }
    }
}

class NoHayProductoException extends Exception{
    public NoHayProductoException(){
        super();
    }
}

class PagoInsuficienteException extends Exception{
    public PagoInsuficienteException(){
        super();
    }
}

class PagoIncorrectoException extends Exception{
    public PagoIncorrectoException(){
        super();
    }
}