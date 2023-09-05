import shop.models.Product;
import shop.services.OrderListRepo;
import shop.services.ProductRepo;
import shop.services.ShopService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ProductRepo proRepo = new ProductRepo();
        OrderListRepo orderRepo = new OrderListRepo();

        ShopService shopService = new ShopService(proRepo, orderRepo);

        System.out.println(proRepo);

        Product p1 = new Product("Mobile", 1, BigDecimal.valueOf(2));
        //product;
        Map<Integer, Product> orderedProducts= new HashMap<>();
        orderedProducts.put(p1.productId(), p1);

        System.out.println(orderedProducts);

        shopService.placeOrder(orderedProducts);
    }
}
