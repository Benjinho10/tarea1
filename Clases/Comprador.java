import java.util.List;
import Monedas.Moneda;
import Productos.Producto;
import Excepciones.PagoIncorrectoException;
import Excepciones.NoHayProductoException;
import Excepciones.PagoInsuficienteException;

class Comprador {
    private String productoComprado;
    private int vuelto;

    public Comprador(List<Moneda> monedas, int cualProducto, Expendedor exp) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        this.productoComprado = null;
        this.vuelto = 0;

        // Validar monedas
        if (monedas == null || monedas.isEmpty()) {
            throw new PagoIncorrectoException();
        }

        // Calcular el valor total de las monedas
        int totalPagado = 0;
        for (Moneda moneda : monedas) {
            totalPagado += moneda.getValor();
        }
        Producto producto = exp.comprarProducto(totalPagado, cualProducto);
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