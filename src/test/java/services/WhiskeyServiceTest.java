package services;

import models.Sneaker;
import models.Whiskey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WhiskeyServiceTest {

    @Test
    public void createTest(){
        // (1)
        String expectedBrand = "Hennessy";
        float expectedPrice = 80.00f;

        // (2)
        WhiskeyService whiskeyService = new WhiskeyService();
        Whiskey testWhiskey = whiskeyService.create(expectedBrand, expectedPrice);

        // (3)
        int actualId = testWhiskey.getId();
        String actualBrand = testWhiskey.getBrand();
        float actualPrice = testWhiskey.getPrice();

        // (4)
        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedBrand, actualBrand);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void findAllTest(){
        // Given
        WhiskeyService whiskeyService = new WhiskeyService();
        whiskeyService.create("", 5.0f);
        whiskeyService.create("", 5.0f);
        whiskeyService.create("", 5.0f);
        whiskeyService.create("", 5.0f);
        Integer expected = whiskeyService.getInventory().size();

        // When
        Whiskey[] wishkeyArray = whiskeyService.findAll();

        // Then
        Assertions.assertEquals(expected,wishkeyArray.length);
    }

    @Test
    public void findTest(){
        // Given
        WhiskeyService whiskeyService = new WhiskeyService();
        whiskeyService.create("", 5.0f);
        whiskeyService.create("", 5.0f);
        whiskeyService.create("", 5.0f);
        Whiskey test = whiskeyService.create("", 5.0f);

        // When
        Whiskey actual = whiskeyService.findWhiskey(test.getId());

        // Then
        Assertions.assertEquals(test,actual);
    }

    @Test
    public void deleteTest(){
        // Given
        WhiskeyService whiskeyService = new WhiskeyService();
        whiskeyService.create("", 5.0f);
        whiskeyService.create("", 5.0f);
        whiskeyService.create("", 5.0f);
        Whiskey test = whiskeyService.create("", 5.0f);

        // When
        Integer id = test.getId();
        // Then
        Assertions.assertTrue(whiskeyService.delete(id));
        Assertions.assertFalse(whiskeyService.delete(id));
    }
}
