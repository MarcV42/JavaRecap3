package shop.services;

import shop.models.Order;
import shop.models.Product;

import java.util.Map;

public interface IShopService
{
    // Implementiere eine Methode, um eine neue Bestellung aufzugeben.
    void placeOrder(Map<Integer, Product> products);


}
