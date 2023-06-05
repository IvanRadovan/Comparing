package dev.lpa;

import java.util.Objects;

public class Grocery implements Comparable<Grocery> {

    private String name;
    private Double price;

    public Grocery(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Grocery o) {
       if (!Objects.equals(this.name, o.name)) {
           return this.name.compareTo(o.name);
       }
       return Double.compare(price, o.price);

    }

    @Override
    public String toString() {
        return "[" + name + " - $" + price + "]";
    }
}
