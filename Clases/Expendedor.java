enum TipoProducto{
    COCA(1), SPRITE(2), FANTA(3), SUPER8(4), SNICKERS(5);

    private final int numero;

    TipoProducto(int numero){
        this.numero = numero;
    }

    public int getNumero(){
        return numero;
    }

    public static TipoProducto fromNumero(int numero){
        for(TipoProducto tipo : TipoProducto.values()){
            if (tipo.getNumero() == numero){
                return tipo;
            }
        }
        return null;
    }
}

class Expendedor {
    private Deposito<Producto> depositoProducto;
    private Deposito<Moneda> depositoMonedasVuelto;

    public Expendedor(int numProducto) {
        depositoProducto = new Deposito<>();
        depositoMonedasVuelto = new Deposito<>();

        for (int i = 0; i < numProductos; i++) {
            depositoProducto.add(new CocaCola(i));
            depositoProducto.add(new Sprite(i));
            depositoProducto.add(new Fanta(i));
            depositoProducto.add(new Super8(i));
            depositoProducto.add(new Snickers(i));
        }
    }

    public Producto comprarProducto(Moneda m, int cual) {
        if (m == null || cual < 1 || cual > 5) {
            depositoMonedasVuelto.add(m);
            return null;
        }

        TipoProducto tipo = TipoProducto.fromNumero(cual);
        Producto producto = obtenerProducto(tipo);

        if (producto == null) {
            if (m != null) depositoMonedasVuelto.add(m);
            return null;
        }

        if (m.getValor() >= getProducto().getPrecio()) {
            int vuelto = m.getValor() - producto.getPrecio().getValor();
            while (vuelto >= 100) {
                depositoMonedasVuelto.add(new Moneda100());
                vuelto -= 100;
            }
            return producto;
        }
        else {
            depositoProducto.add(producto);
            depositoMonedasVuelto.add(m);
            return null;
        }
    }

    private Producto obtenerProducto(TipoProducto tipo){
        for (Producto producto : depositoProducto.getItems()){
            if(tipo != null && producto.getPrecio() == tipo.getPrecio()){
                return producto;
            }
        }
        return null;
    }


    public Moneda getVuelto() {
        return depositoMonedasVuelto.get();
    }
}
