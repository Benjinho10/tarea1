class Comprador {
    private String producto;
    private int vuelto;

    public Comprador(Moneda m, int cualProducto, Expendedor exp) {
        this.productoComprado = null;
        this.vuelto = 0;

        Producto producto = exp.comprarProducto(m, cualProducto);

        if (bebida != null) {
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