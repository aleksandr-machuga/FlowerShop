package com.java.flowershop.service;

import com.java.flowershop.entity.*;
import com.java.flowershop.enums.BouquetItem;

import java.util.*;
import java.util.stream.Collectors;

public class Manager {
    private static final Map<BouquetItem, Integer> order = new HashMap<>();

    public static Bouquet composeBouquet() {
        List<Flower> flowers = new ArrayList<>();
        List<Accessory> accessories = new ArrayList<>();
        order.forEach((key, value) -> {
            switch (key) {
                case ROSE:
                    for (int i = 0; i < value; i++) {
                        flowers.add(new Rose());
                    }
                    break;
                case PEONY:
                    for (int i = 0; i < value; i++) {
                        flowers.add(new Peony());
                    }
                    break;
                case CHAMOMILE:
                    for (int i = 0; i < value; i++) {
                        flowers.add(new Chamomile());
                    }
                    break;
                case PAPER:
                    for (int i = 0; i < value; i++) {
                        accessories.add(new Paper());
                    }
                    break;
                case DECOR:
                    for (int i = 0; i < value; i++) {
                        accessories.add(new Decor());
                    }
                    break;
                case RIBBON:
                    for (int i = 0; i < value; i++) {
                        accessories.add(new Ribbon());
                    }
                    break;
            }
        });
        order.clear();
        return new Bouquet(flowers, accessories);
    }

    public static List<Flower> sortByFreshness(Bouquet bouquet) {
        return bouquet.getFlowers().stream()
                .sorted(Comparator.comparing(Flower::getFreshness))
                .collect(Collectors.toList());
    }

    public static List<Flower> findFlower(int from, int to, Bouquet bouquet) {
        return bouquet.getFlowers().stream()
                .filter(flower -> flower.getStemLength() >= from && flower.getStemLength() <= to)
                .collect(Collectors.toList());
    }

    public static void setOrder(BouquetItem bouquetItem, Integer quantity) {
        order.put(bouquetItem, quantity);
    }

    public static double getTotalPrice(Bouquet bouquet) {
        double flowersCost = bouquet.getFlowers().stream().mapToDouble(Flower::getPrice).sum();
        double accessoriesCost = bouquet.getAccessories().stream().mapToDouble(Accessory::getPrice).sum();
        return flowersCost+accessoriesCost;
    }
}
