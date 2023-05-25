package com.java.flowershop.entity;

import java.util.List;
import java.util.Objects;

public class Bouquet {
    private List<Flower> flowers;
    private List<Accessory> accessories;

    public Bouquet(List<Flower> flowers, List<Accessory> accessories) {
        this.flowers = flowers;
        this.accessories = accessories;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bouquet bouquet = (Bouquet) o;
        return Objects.equals(flowers, bouquet.flowers) && Objects.equals(accessories, bouquet.accessories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowers, accessories);
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "flowers=" + flowers +
                ", \naccessories=" + accessories +
                '}';
    }
}
