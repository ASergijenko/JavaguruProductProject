package lv.javaguru.finalwork.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Category category;

    private BigDecimal discount;
    private String description;

    private BigDecimal divisor = new BigDecimal("100");

    public Product() {

    }

    public Product(String name, BigDecimal price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(String name, BigDecimal price, Category category, BigDecimal discount, String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.discount = discount;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (category != product.category) return false;
        if (discount != null ? !discount.equals(product.discount) : product.discount != null) return false;
        return description != null ? description.equals(product.description) : product.description == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        BigDecimal stringPrice = price.setScale(2, RoundingMode.CEILING);
        BigDecimal stringDiscount = (discount.multiply(divisor)).setScale(2,RoundingMode.CEILING);
        BigDecimal stringActualPrice = (price.subtract(price.divide(divisor).multiply(discount.multiply(divisor)))).setScale(2, RoundingMode.CEILING);

        return  "Product ID: " + id +", Name: " + name + " Category: " + category + ", Regular price: " + stringPrice + "EUR, Discount: " + stringDiscount + "%, Actual price: " + stringActualPrice + "EUR, description: " + description;
    }
}
