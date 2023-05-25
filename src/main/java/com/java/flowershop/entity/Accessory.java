package com.java.flowershop.entity;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Accessory {
    private double price;
    private String name;

    public Accessory(String name) {
        this.price = ThreadLocalRandom.current().nextDouble(5,20);
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accessory accessory = (Accessory) o;
        return Double.compare(accessory.price, price) == 0 && Objects.equals(name, accessory.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }

    @Override
    public String toString() {
        return "\nAccessory{" +
                "price=" + String.format("%.2f",price) +
                ", name='" + name + '\'' +
                '}';
    }
}
