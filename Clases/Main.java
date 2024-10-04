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
import Excepciones.PagoIncorrectoException;
import Excepciones.NoHayProductoException;
import Excepciones.PagoInsuficienteException;

public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(5);

        Moneda moneda1 = new Moneda1000();
        Moneda moneda2 = new Moneda100();
        Moneda moneda4 = new Moneda500();
        Moneda moneda5 = new Moneda1000();

        // Caso 1: Comprar Fanta con moneda valida.
        try {
            Comprador comprador1 = new Comprador(moneda1, 3, exp);
            System.out.println("Comprador 1: " + comprador1.queConsumiste() + ", vuelto: $" + comprador1.cuantoVuelto());
        } catch (PagoInsuficienteException e) {
            System.out.println("El valor es insuficiente.");
        } catch (NoHayProductoException e) {
            System.out.println("No hay producto disponible.");
        } catch (PagoIncorrectoException e) {
            System.out.println("El valor no es valido.");
        }

        // Caso 2: Comprar Snickers con moneda insuficiente.
        try {
            Comprador comprador2 = new Comprador(moneda2, 5, exp);
            System.out.println("Comprador 2: " + comprador2.queConsumiste() + ", vuelto: $" + comprador2.cuantoVuelto());
        } catch (PagoInsuficienteException e) {
            System.out.println("El valor es insuficiente.");
        } catch (NoHayProductoException e) {
            System.out.println("No hay producto disponible.");
        } catch (PagoIncorrectoException e) {
            System.out.println("El valor no es valido.");
        }

        // Caso 3: Comprar Fanta sin moneda (null).
        try {
            Comprador comprador3 = new Comprador(null, 3, exp);
            System.out.println("Comprador 3: " + comprador3.queConsumiste() + ", vuelto: $" + comprador3.cuantoVuelto());
        } catch (PagoInsuficienteException e) {
            System.out.println("El valor es insuficiente.");
        } catch (NoHayProductoException e) {
            System.out.println("No hay producto disponible.");
        } catch (PagoIncorrectoException e) {
            System.out.println("El valor no es valido.");
        }

        // Caso 4: Comprar un producto que no existe en el expendedor.
        try {
            Comprador comprador4 = new Comprador(moneda4, 10, exp);
            System.out.println("Comprador 4: " + comprador4.queConsumiste() + ", vuelto: $" + comprador4.cuantoVuelto());
        } catch (PagoInsuficienteException e) {
            System.out.println("El valor es insuficiente.");
        } catch (NoHayProductoException e) {
            System.out.println("No hay producto disponible.");
        } catch (PagoIncorrectoException e) {
            System.out.println("El valor no es valido.");
        }

        // Caso 5: Comprar un producto que ya se ha agotado.
        try {
            Comprador comprador5 = new Comprador(moneda5, 3, exp);
            System.out.println("Comprador 5: " + comprador5.queConsumiste() + ", vuelto: $" + comprador5.cuantoVuelto());
        } catch (PagoInsuficienteException e) {
            System.out.println("El valor es insuficiente.");
        } catch (NoHayProductoException e) {
            System.out.println("No hay producto disponible.");
        } catch (PagoIncorrectoException e) {
            System.out.println("El valor no es valido.");
        }

        // Crear una lista para almacenar las monedas
        ArrayList<Moneda> monedas = new ArrayList<>();

        // Agregar instancias de monedas a la lista
        monedas.add(new Moneda100());
        monedas.add(new Moneda500());
        monedas.add(new Moneda1000());
        monedas.add(new Moneda100());  // Agregamos otra moneda de 100 para ver cómo se ordena

        // Imprimir monedas antes de la ordenación
        System.out.println("Monedas antes de la ordenación:");
        for (Moneda moneda : monedas) {
            System.out.println("Valor de la moneda: " + moneda.getValor());
        }

        // Ordenar las monedas usando el método compareTo
        Collections.sort(monedas);

        // Imprimir las monedas después de la ordenación
        System.out.println("\nMonedas después de la ordenación:");
        for (Moneda moneda : monedas) {
            System.out.println("Valor de la moneda: " + moneda.getValor());
        }
    }
}

