package com.java.flowershop.entity;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Flower {
    private String name;
    private double price;
    private int freshness;
    private int stemLength;

    public Flower(String name) {
        this.name = name;
        this.price= ThreadLocalRandom.current().nextDouble(20,100);
        this.freshness=ThreadLocalRandom.current().nextInt(1,10);
        this.stemLength=ThreadLocalRandom.current().nextInt(40,80);
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public int getFreshness(){
        return freshness;
    }
    public void setFreshness(int freshness){
        this.freshness=freshness;
    }

    public int getStemLength() {
        return stemLength;
    }

    public void setStemLength(int stemLength) {
        this.stemLength = stemLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return Double.compare(flower.price, price) == 0 && freshness == flower.freshness && stemLength == flower.stemLength && Objects.equals(name, flower.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, freshness, stemLength);
    }

    @Override
    public String toString() {
        return "\nFlower{" +
                "name='" + name + '\'' +
                ", price=" + String.format("%.2f",price) +
                ", freshness=" + freshness +
                ", stemLength=" + stemLength +
                '}';
    }
}
