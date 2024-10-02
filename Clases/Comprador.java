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

class Comprador {
    private String productoComprado;
    private int vuelto;

    public Comprador(Moneda m, int cualProducto, Expendedor exp) {
        this.productoComprado = null;
        this.vuelto = 0;

        Producto producto = exp.comprarProducto(m, cualProducto);

        if (producto != null) {
            this.productoComprado = producto.consumir();
        }

        Moneda moneda;
        while ((moneda = exp.getVuelto()) != null) {
            this.vuelto += moneda.getValor();
        }
    }
    public int cuantoVuelto() {
        return vuelto;
    }

    public String queConsumiste() {
        return productoComprado;
    }
}