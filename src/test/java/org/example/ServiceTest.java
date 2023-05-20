package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    @Test
    public void averageSale() {
        Service service = new Service();
        int[] sales = {1,2,3,4,5};
        int actual = service.averageSale(sales);
        int expected = (1 + 2 + 3 + 4 + 5) / sales.length;

        Assertions.assertEquals(expected,actual);
    }
}