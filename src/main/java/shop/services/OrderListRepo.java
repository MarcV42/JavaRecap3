package shop.services;

import shop.models.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderListRepo {
    Map<Integer, Order> allOrders = new HashMap<>();

    void addOrder(Order order)
    {
        allOrders.put(order.orderId(), order);
    }

    void deleteOrder(int orderId){
        allOrders.remove(orderId);
    }

    Order findOrder(int orderId){
        if(allOrders.get(orderId) == null){
            System.out.println("No Order found.");
        }
        return allOrders.get(orderId);
    }
}
