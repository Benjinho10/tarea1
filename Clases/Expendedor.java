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
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int FANTA = 3;
    public static final int SUPER8 = 4;
    public static final int SNICKERS = 5;

    public Expendedor(int numProducto) {
        this.numProducto = numProducto;
        depositoProducto = new Deposito<>();
        depositoMonedasVuelto = new Deposito<>();

        for (int i = 0; i < numProducto; i++) {
            if (i < Precio_Serie.values().length){
              switch (i){

                  case 0:
                      depositoProducto.add(new CocaCola());
                      break;
                  case 1:
                      depositoProducto.add(new Sprite());
                      break;
                  case 2:
                      depositoProducto.add(new Fanta());
                      break;
                  case 3:
                      depositoProducto.add(new Super8());
                      break;
                  case 4:
                      depositoProducto.add(new Snickers());
                      break;
                  default:
                      break;
              }


            }

            //depositoProducto.add(new CocaCola(i));
            //depositoProducto.add(new Sprite(i));
            //depositoProducto.add(new Fanta(i));
            //depositoProducto.add(new Super8(i));
            //depositoProducto.add(new Snickers(i));
        }
    }

    public Producto comprarProducto(Moneda m, int cual) throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {
        if (m == null || cual < 1 || cual > 5) {
            throw new PagoIncorrectoException();
        }

        Producto producto = obtenerProducto(cual);

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

    private Producto obtenerProducto(int cual){
        for (Producto producto : depositoProducto.getItems()) {
            // Aquí se comparan los tipos de productos con las constantes
            if ((cual == COCA && producto instanceof CocaCola) ||
                    (cual == SPRITE && producto instanceof Sprite) ||
                    (cual == FANTA && producto instanceof Fanta) ||
                    (cual == SUPER8 && producto instanceof Super8) ||
                    (cual == SNICKERS && producto instanceof Snickers)) {
                return producto;
            }
        }
        return null;
    }


    public Moneda getVuelto() {
        return depositoMonedasVuelto.get();
    }
}
