package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class BasketsTest {

    @Test
    public void testAddBaskets(){
        String[] products = {"Зерно","Хлеб","Вода"};
        int [] prices = {55,35,34};
        Baskets basket = new Baskets(products,prices);

        basket.addToCart(0,2);
        basket.addToCart(1,4);
        int [] actual = basket.getQuantities();
        int [] expected = {2,4,0};

        Assertions.assertArrayEquals(expected,actual);

    }
    @Test
    public void loadFromTxtFile(){
        Baskets basket = Baskets.loadFromTxtFile(new File("src/test/resources/basket_test.txt"));

        String [] actualGoods = basket.getThings();
        String [] expectGoods = {"Зерно","Хлеб","Вода"};

        Assertions.assertArrayEquals(expectGoods,actualGoods);

    }


}