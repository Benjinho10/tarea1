import Monedas.Moneda;
import Monedas.Moneda100;
import Productos.Producto;
import Productos.Precio_Serie;
import Productos.bebidas.CocaCola;
import Productos.bebidas.Sprite;
import Productos.bebidas.Fanta;
import Productos.dulces.Snickers;
import Productos.dulces.Super8;
import Excepciones.PagoIncorrectoException;
import Excepciones.NoHayProductoException;
import Excepciones.PagoInsuficienteException;
import java.util.HashMap;
import java.util.Map;

class Expendedor {
    private Deposito<Producto> depositoProducto;
    private Deposito<Moneda> depositoMonedasVuelto;
    private Map<Integer, Integer> stock;

    public Expendedor(int cantidadPorProducto) {
        depositoProducto = new Deposito<>();
        depositoMonedasVuelto = new Deposito<>();
        stock = new HashMap<>(); // Inicializar el mapa de stock

        // Añadir productos y stock inicial
        for (int i = 0; i < cantidadPorProducto; i++) {
            // Añade CocaCola
            Producto cocaCola = new CocaCola(i);
            depositoProducto.add(cocaCola);
            stock.put(cocaCola.getPrecio().getNumSerie(), cantidadPorProducto);

            // Añade Sprite
            Producto sprite = new Sprite(i);
            depositoProducto.add(sprite);
            stock.put(sprite.getPrecio().getNumSerie(), cantidadPorProducto);

            // Añade Fanta
            Producto fanta = new Fanta(i);
            depositoProducto.add(fanta);
            stock.put(fanta.getPrecio().getNumSerie(), cantidadPorProducto);

            // Añade Super8
            Producto super8 = new Super8(i);
            depositoProducto.add(super8);
            stock.put(super8.getPrecio().getNumSerie(), cantidadPorProducto);

            // Añade Snickers
            Producto snickers = new Snickers(i);
            depositoProducto.add(snickers);
            stock.put(snickers.getPrecio().getNumSerie(), cantidadPorProducto);
        }
    }


    public Producto comprarProducto(int totalPagado, int numSerie) throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {
        if (totalPagado <= 0 || !esSerieValida(numSerie)) {
            throw new PagoIncorrectoException();
        }

        Producto producto = obtenerProducto(numSerie);

        if (producto == null || stock.get(numSerie) <= 0) {
            throw new NoHayProductoException();        }

        if (producto.getPrecio().getValor() <= totalPagado) {
            int vuelto = totalPagado - producto.getPrecio().getValor();
            while (vuelto >= 100) {
                depositoMonedasVuelto.add(new Moneda100());
                vuelto -= 100;
            }


            stock.put(numSerie, stock.get(numSerie) - 1);

            return producto;
        } else {
            throw new PagoInsuficienteException();
        }
    }

    private boolean esSerieValida(int numSerie) {
        for (Precio_Serie precio : Precio_Serie.values()) {
            if (precio.getNumSerie() == numSerie) {
                return true;
            }
        }
        return false;
    }

    private Producto obtenerProducto(int numSerie) {
        for (Producto producto : depositoProducto.getItems()) {
            if (producto.getPrecio().getNumSerie() == numSerie) {
                return producto;
            }
        }
        return null;
    }

    public Moneda getVuelto() {
        return depositoMonedasVuelto.get(); // Retornar la moneda del vuelto
    }
}
