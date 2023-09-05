    package shop.models;

import java.math.BigDecimal;

public record Product(String name, int productId, BigDecimal amount) {
}
