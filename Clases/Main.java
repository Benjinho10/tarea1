public class Main {
    public static void main(String[] args) {
        // Inicializa el expendedor con 5 productos de cada tipo
        Expendedor exp = new Expendedor(5);

        // Ejemplo 1: Comprar un Snickers con una moneda de 1000
        Moneda moneda1 = new Moneda1000();
        Comprador comprador1 = new Comprador(moneda1, Expendedor.SNICKERS, exp);
        System.out.println("Comprador 1: " + comprador1.queConsumiste() + ", vuelto: $" + comprador1.cuantoVuelto());

        // Ejemplo 2: Intentar comprar una bebida (Sprite) con una moneda de 500
        Moneda moneda2 = new Moneda500();
        Comprador comprador2 = new Comprador(moneda2, Expendedor.SPRITE, exp);
        System.out.println("Comprador 2: " + comprador2.queConsumiste() + ", vuelto: $" + comprador2.cuantoVuelto());

        // Ejemplo 3: Comprar Fanta con una moneda de 1000
        Moneda moneda3 = new Moneda1000();
        Comprador comprador3 = new Comprador(moneda3, Expendedor.FANTA, exp);
        System.out.println("Comprador 3: " + comprador3.queConsumiste() + ", vuelto: $" + comprador3.cuantoVuelto());

        // Ejemplo 4: Comprar Super8 con una moneda de 500
        Moneda moneda4 = new Moneda500();
        Comprador comprador4 = new Comprador(moneda4, Expendedor.SUPER8, exp);
        System.out.println("Comprador 4: " + comprador4.queConsumiste() + ", vuelto: $" + comprador4.cuantoVuelto());

        // Ejemplo 5: Comprar CocaCola con una moneda de 1000
        Moneda moneda5 = new Moneda1000();
        Comprador comprador5 = new Comprador(moneda5, Expendedor.COCA, exp);
        System.out.println("Comprador 5: " + comprador5.queConsumiste() + ", vuelto: $" + comprador5.cuantoVuelto());

        // Ejemplo 6: Comprar Sprite con varias monedas de 500 (hasta que se agoten)
            Moneda moneda6 = new Moneda500();
            Comprador comprador6 = new Comprador(moneda6, Expendedor.SPRITE, exp);
            System.out.println("Comprador 6: " + comprador6.queConsumiste() + ", vuelto: $" + comprador6.cuantoVuelto());

        // Ejemplo 7: Intentar comprar CocaCola con una moneda de 100 (no suficiente)
        Moneda moneda7 = new Moneda100();
        Comprador comprador7 = new Comprador(moneda7, Expendedor.COCA, exp);
        System.out.println("Comprador 7: " + comprador7.queConsumiste() + ", vuelto: $" + comprador7.cuantoVuelto());
    }
}