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
class Expendedor {
    private Deposito<Producto> depositoProducto;
    private Deposito<Moneda> depositoMonedasVuelto;
    public int numProducto;

    public Expendedor(int numProducto) {
        this.numProducto = numProducto;
        depositoProducto = new Deposito<>();
        depositoMonedasVuelto = new Deposito<>();

        for (int i = 0; i < numProducto; i++) {
            depositoProducto.add(new CocaCola(i));
            depositoProducto.add(new Sprite(i));
            depositoProducto.add(new Fanta(i));
            depositoProducto.add(new Super8(i));
            depositoProducto.add(new Snickers(i));
        }
    }

    public Producto comprarProducto(Moneda m, int numSerie) throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {
        if (m == null || !esSerieValida(numSerie)) {
            throw new PagoIncorrectoException();
        }

        Producto producto = obtenerProducto(numSerie);

        if (producto == null) {
            throw new NoHayProductoException();
        }

        if (producto.getPrecio().getValor() <= m.getValor()) {
            int vuelto = m.getValor() - producto.getPrecio().getValor();
            while (vuelto >= 100) {
                depositoMonedasVuelto.add(new Moneda100());
                vuelto -= 100;
            }
            return producto;
        }
        else {
            throw new PagoInsuficienteException();
        }
    }

    private boolean esSerieValida(int numSerie){
        for(Precio_Serie precio : Precio_Serie.values()){
            if(precio.getNumSerie() == numSerie){
                return true;
            }
        }
        return false;
    }

    private Producto obtenerProducto(int numSerie){
        for (Producto producto : depositoProducto.getItems()) {
            if (producto.getPrecio().getNumSerie() == numSerie){
                return producto;
            }
        }
        return null;
    }


    public Moneda getVuelto() {
        return depositoMonedasVuelto.get();
    }
}
