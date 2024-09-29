class Expendedor {
    private Deposito<Bebida> depositoCoca;
    private Deposito<Bebida> depositoSprite;
    private Deposito<Moneda> depositoMonedasVuelto;
    public int precioBebidas;

    public static final int COCA = 1;
    public static final int SPRITE = 2;

    public Expendedor(int numBebidas, int precioBebidas) {
        depositoCoca = new Deposito<>();
        depositoSprite = new Deposito<>();
        depositoMonedasVuelto = new Deposito<>();
        this.precioBebidas = precioBebidas;

        for (int i = 0; i < numBebidas; i++) {
            depositoCoca.add(new CocaCola(i));
            depositoSprite.add(new Sprite(i));
        }
    }

    public Bebida comprarBebida(Moneda m, int cual) {
        if (m == null || cual < 1 || cual > 2) {
            depositoMonedasVuelto.add(m);
            return null;
        }

        Bebida bebida = null;
        if (cual == COCA) {
            bebida = depositoCoca.get();
        } else if (cual == SPRITE) {
            bebida = depositoSprite.get();
        }

        if (bebida == null) {
            if (m != null) depositoMonedasVuelto.add(m);
            return null;
        }

        if (m.getValor() >= precioBebidas) {
            int vuelto = m.getValor() - precioBebidas;
            while (vuelto >= 100) {
                depositoMonedasVuelto.add(new Moneda100());
                vuelto -= 100;
            }
            return bebida;
        } else {
            if (cual == COCA) {
                depositoCoca.add(bebida);
            } else {
                depositoSprite.add(bebida);
            }

            depositoMonedasVuelto.add(m);
            return null;
        }
    }

    public Moneda getVuelto() {
        return depositoMonedasVuelto.get();
    }
}