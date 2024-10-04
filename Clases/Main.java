import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import Monedas.Moneda;
import Monedas.Moneda100;
import Monedas.Moneda1000;
import Monedas.Moneda500;
import Productos.Precio_Serie;
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
       /* try {
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
        }*/

        System.out.println("Escenario 1: Monedas nulas ");
        try {
            List<Moneda> monedas0 = null; // Se mantiene como nula
            // Intentar comprar Fanta (700) con monedas nulas
            Comprador comprador1 = new Comprador(monedas0, Precio_Serie.FANTA.getNumSerie(), exp);
        } catch (PagoIncorrectoException e) {
            System.out.println("Error: Pago incorrecto. No se pueden usar monedas nulas.");
        } catch (NoHayProductoException e) {
            System.out.println("Error: Producto no disponible.");
        } catch (PagoInsuficienteException e) {
            System.out.println("Error: Pago insuficiente.");
        }

        // 2. Intentar comprar un producto que cuesta 700 con menos de 700
        System.out.println("\nEscenario 2: Pago insuficiente");
        try {
            // Definir monedas para comprar (2 monedas de 100)
            List<Moneda> monedas1 = new ArrayList<>();
            monedas1.add(new Moneda100()); // 100
            monedas1.add(new Moneda100()); // 200
            // Intentar comprar Fanta (700) con 200
            Comprador comprador2 = new Comprador(monedas1, Precio_Serie.FANTA.getNumSerie(), exp);
        } catch (PagoIncorrectoException e) {
            System.out.println("Error: Pago incorrecto.");
        } catch (NoHayProductoException e) {
            System.out.println("Error: Producto no disponible.");
        } catch (PagoInsuficienteException e) {
            System.out.println("Error: Pago insuficiente. Se necesita más dinero.");
        }

        // 3. Comprar un producto que cuesta 700 con exactamente 700
        System.out.println("\nEscenario 3: Pago exacto");
        try {
            // Definir monedas para comprar (1 moneda de 500 y 2 monedas de 100)
            List<Moneda> monedas2 = new ArrayList<>();
            monedas2.add(new Moneda500()); // 500
            monedas2.add(new Moneda100()); // 600
            monedas2.add(new Moneda100()); // 700
            // Intentar comprar Fanta (700) con 700
            Comprador comprador3 = new Comprador(monedas2, 3, exp);
            // El método comprarProducto se invocará desde el constructor de Comprador
            System.out.println("Compraste: " + comprador3.queConsumiste());
            System.out.println("Vuelto: " + comprador3.cuantoVuelto());
        } catch (PagoIncorrectoException e) {
            System.out.println("Error: Pago incorrecto.");
        } catch (NoHayProductoException e) {
            System.out.println("Error: Producto no disponible.");
        } catch (PagoInsuficienteException e) {
            System.out.println("Error: Pago insuficiente.");
        }

        // 4. Comprar un producto que cuesta 700 con 1000
        System.out.println("\nEscenario 4: Pago con exceso");
        try {
            // Definir monedas para comprar (1 moneda de 1000)
            List<Moneda> monedas3 = new ArrayList<>();
            monedas3.add(new Moneda1000());// 1000
            monedas3.add(new Moneda100());
            // Intentar comprar Fanta (700) con 1000
            Comprador comprador4 = new Comprador(monedas3, 3, exp);
            // El método comprarProducto se invocará desde el constructor de Comprador
            System.out.println("Compraste: " + comprador4.queConsumiste());
            System.out.println("Vuelto: " + comprador4.cuantoVuelto());
        } catch (PagoIncorrectoException e) {
            System.out.println("Error: Pago incorrecto.");
        } catch (NoHayProductoException e) {
            System.out.println("Error: Producto no disponible.");
        } catch (PagoInsuficienteException e) {
            System.out.println("Error: Pago insuficiente.");
        }

        System.out.println();

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

