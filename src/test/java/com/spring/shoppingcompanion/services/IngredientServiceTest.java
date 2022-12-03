package com.spring.shoppingcompanion.services;

import com.spring.shoppingcompanion.dto.IngredientDto;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IngredientServiceTest {

    private String ingredientUrl;

    @Autowired
    IngredientService ingredientService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeAll
    public void setup() {
        ingredientUrl = "http://localhost:" + port + "/ingredients/add";
    }

    @Test
    void addIngredientTest() {
        IngredientDto testIngredient = new IngredientDto("Ketchup", "Condiments");

        IngredientDto createdIngredient = restTemplate.postForEntity(ingredientUrl, testIngredient, IngredientDto.class).getBody();

        assertNotNull(createdIngredient.getId());
        assertIngredientEquivalence(testIngredient, createdIngredient);
    }

    @Test
    void addRecipeIngredients() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByIngredientName() {
    }

    @Test
    void findById() {
    }

    private void assertIngredientEquivalence(IngredientDto expected, IngredientDto actual) {
        assertEquals(expected.getIngredientName(), actual.getIngredientName());
        assertEquals(expected.getAisle(), actual.getAisle());
    }
}