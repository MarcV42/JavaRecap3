package shop.services;

import shop.models.Order;
import shop.models.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class ShopService implements IShopService
{

    private final ProductRepo productRepo;
    private final  OrderListRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderListRepo orderRepo)
    {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public void placeOrder(Map<Integer, Product> orderedProducts)
    {
        // for(Product product : orderedProducts)

        boolean isProductAvailable = true;
        boolean isWholeOrderAvailable = true;
        for(Map.Entry<Integer, Product> entry : orderedProducts.entrySet())
        {
            int key = entry.getKey();
            isProductAvailable =  checkProductExist(key);
            if(!isProductAvailable){
                isWholeOrderAvailable = false;
            }
        }
        if(isWholeOrderAvailable){
            Random rand = new Random();
            int orderId = rand.nextInt(9999999);
            Order order = new Order(orderId, orderedProducts);
            orderRepo.addOrder(order);
        }
    }

    private boolean checkProductExist(int productId)
    {
        Product pro = productRepo.findProduct(productId);
        //frage: ist das noch da wenn oder solten wir lieber amount repo checken

        if(pro == null) return false;
        else return true;
    }
}
