package shop.models;

import java.util.Map;

public record Order(int orderId, Map<Integer, Product> orderedProducts)
{
    
}
