package shop.services;

import shop.models.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProductRepo {
    public Map<Integer, Product> allProducts = new HashMap<>();

    public ProductRepo()
    {
        createMockProducts();
    }

    void addProduct(Product product){
        allProducts.put(product.productId(), product);
    }

    void deleteProduct(String productId){
        allProducts.remove(productId);
    }

    Product findProduct(int productId)
    {
        if(allProducts.get(productId) == null){
            System.out.println("No product found.");
        }
        return allProducts.get(productId);
    }

    @Override
    public String toString() {
        return "All Products:" + allProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(allProducts, that.allProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allProducts);
    }

    private void createMockProducts()
    {
        Product p1 = new Product("Mobile", 1, BigDecimal.valueOf(99));
        Product p2 = new Product("Tablet", 2, BigDecimal.valueOf(799));
        Product p3 = new Product("Mobile", 3, BigDecimal.valueOf(199));
        Product p4 = new Product("TV", 4, BigDecimal.valueOf(455));

        allProducts.put(p1.productId(), p1);
        allProducts.put(p2.productId(), p2);
        allProducts.put(p3.productId(), p3);
        allProducts.put(p4.productId(), p4);
    }
}
