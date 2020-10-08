package com.kbr.homework.homework6;

import java.util.Arrays;
import java.util.Objects;

public class MyProducts {
    private int permissionQuantityOfProteins;
    private int permissionQuantityOfFats;
    private int permissionQuantityOfCarbohydrates;
    private int permissionQuantityOfCalories;
    private String[] listOfPermissionProduct;


    public MyProducts(int permissionQuantityOfProteins, int permissionQuantityOfFats, int permissionQuantityOfCarbohydrates, int permissionQuantityOfCalories) {
        this.permissionQuantityOfProteins = permissionQuantityOfProteins;
        this.permissionQuantityOfFats = permissionQuantityOfFats;
        this.permissionQuantityOfCarbohydrates = permissionQuantityOfCarbohydrates;
        this.permissionQuantityOfCalories = permissionQuantityOfCalories;
        listOfPermissionProduct = new String[10];
    }

    // Метод выводит список разрешенных продуктов
    public void printPermissionProducts() {
        System.out.println(Arrays.toString(listOfPermissionProduct));
    }

    // Метод  добавляет продукт в список разрешенных
    public void addToProductsListPermission(NutritionalValue product) {
        for (int i = 0; i < listOfPermissionProduct.length; i++) {
            if (isAllow(product)) {
                if (Objects.isNull(listOfPermissionProduct[i])) {
                    listOfPermissionProduct[i] = product.getNameOfProduct();
                    return;
                }
            } else throw new IllegalArgumentException("Product is inadmissible");
        }
    }

    // Метод проверяет соответствует-ли продукт заявленным требованиям
    private boolean isAllow(NutritionalValue product) {
        if (product.getProteins() <= this.permissionQuantityOfProteins
                && product.getCarbohydrates() <= this.permissionQuantityOfCarbohydrates
                && product.getFats() <= this.permissionQuantityOfFats
                && product.getCalories() <= this.permissionQuantityOfCalories) {
            return true;
        } else return false;
    }
}
