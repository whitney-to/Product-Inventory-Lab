package services;

import models.Sneaker;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SneakerServiceTest {
    @Test
    public void createTest(){
        // (1)
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        double expectedSize = 10.5;
        int expectedQty = 10;
        float expectedPrice = 80.00f;

        // (2)
        SneakerService sneakerService = new SneakerService();
        Sneaker testSneaker = sneakerService.create(expectedName, expectedBrand,
                expectedSport, expectedSize, expectedQty, expectedPrice);

        // (3)
        int actualId = testSneaker.getId();
        String actualName = testSneaker.getName();
        String actualBrand = testSneaker.getBrand();
        String actualSport = testSneaker.getSport();
        double actualSize = testSneaker.getSize();
        int actualQty = testSneaker.getQty();
        float actualPrice = testSneaker.getPrice();

        // (4)
        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedBrand, actualBrand);
        Assertions.assertEquals(expectedSport, actualSport);
        Assertions.assertEquals(expectedSize, actualSize);
        Assertions.assertEquals(expectedQty, actualQty);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void findAllTest(){
        // Given
        SneakerService sneakerService = new SneakerService();
        sneakerService.create("", "", "", 0.0, 0, 5.0f);
        sneakerService.create("", "", "", 0.0, 0, 5.0f);
        sneakerService.create("", "", "", 0.0, 0, 5.0f);
        sneakerService.create("", "", "", 0.0, 0, 5.0f);
        Integer expected = 4;

        // When
        Sneaker[] sneakerArray = sneakerService.findAll();

        // Then
        Assertions.assertEquals(expected,sneakerArray.length);
        //sneakerService = null;

    }

    @Test
    public void findTest(){
        // Given
        SneakerService sneakerService = new SneakerService();

        sneakerService.create("", "", "", 0.0, 0, 5.0f);
        sneakerService.create("", "", "", 0.0, 0, 5.0f);

        Sneaker expected = sneakerService.create("", "", "", 0.0, 0, 5.0f);

        sneakerService.create("", "", "", 0.0, 0, 5.0f);

        // When
        Sneaker actual = sneakerService.findSneaker(3);

        // Then
        Assertions.assertEquals(expected,actual);
        sneakerService = null;
    }

    @Test
    public void deleteTest(){
        // Given
        SneakerService sneakerService = new SneakerService();

        sneakerService.create("", "", "", 0.0, 0, 5.0f);
        sneakerService.create("", "", "", 0.0, 0, 5.0f);
        sneakerService.create("", "", "", 0.0, 0, 5.0f);
        Sneaker sneaker = sneakerService.create("", "", "", 0.0, 0, 5.0f);

        // When
        Integer id = sneaker.getId();
        // Then
        Assertions.assertTrue(sneakerService.delete(id));
        Assertions.assertFalse(sneakerService.delete(id));
    }


}
