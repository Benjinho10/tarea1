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

        Producto producto = obtenerProducto(cual);

        if (producto == null) {
            if (m != null) depositoMonedasVuelto.add(m);
            return null;
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
            depositoMonedasVuelto.add(m);
            return null;
        }
    }

    private Producto obtenerProducto(int cual) {
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
