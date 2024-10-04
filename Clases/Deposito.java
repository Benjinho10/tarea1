import java.util.ArrayList;

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