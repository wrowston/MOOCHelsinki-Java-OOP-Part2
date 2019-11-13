import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storehouse {

    private Map<String, Integer> products;
    private Map<String, Integer> stock;

    public Storehouse() {
        this.products = new HashMap<String, Integer>();
        this.stock = new HashMap<String, Integer>();
    }

    public void addProduct(String product, int price, int stock) {
        this.products.put(product, price);
        this.stock.put(product, stock);
    }

    public int price(String product) {
        if (this.products.containsKey(product)) {
            return this.products.get(product);
        }
        return -99;
    }

    public int stock(String product) {
        if (this.stock.containsKey(product)) {
            return this.stock.get(product);
        }
        return 0;
    }

    public boolean take(String product) {

        if (this.stock.containsKey(product)) {
            int stock = this.stock.get(product);
            if (stock > 0) {
                stock--;
                this.stock.put(product, stock);
                return true;
            }
        }
        return false;
    }

    public Set<String> products() {
        return this.products.keySet();
    }
}
