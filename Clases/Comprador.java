class Comprador {
    private String bebida;
    private int vuelto;

    public Comprador(Moneda m, int cualBebida, Expendedor exp) {
        this.bebida = null;
        this.vuelto = 0;
        Bebida bebida = exp.comprarBebida(m, cualBebida);
        if (bebida != null) {
            this.bebida = bebida.beber();
        }

        Moneda moneda;
        while ((moneda = exp.getVuelto()) != null) {
            this.vuelto += moneda.getValor();
        }
    }
    public int cuantoVuelto() {
        return vuelto;
    }

    public String queBebiste() {
        return bebida;
    }
}