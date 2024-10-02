import java.util.ArrayList;
import Productos.Producto;
import Productos.Precio_Serie;
import Productos.bebidas.Bebida;
import Productos.bebidas.CocaCola;
import Productos.bebidas.Sprite;
import Productos.bebidas.Fanta;
import Productos.dulces.Dulce;
import Productos.dulces.Snickers;
import Productos.dulces.Super8;

class Deposito<T> {

    private ArrayList<T> items;

    public ArrayList<T> getItems(){
        return items;
    }

    public Deposito() {
        items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public T get() {
        if (items.size() > 0) {
            return items.remove(0);
        }
        return null;
    }
}