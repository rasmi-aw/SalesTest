package com.rasmi.salestest.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.rasmi.salestest.model.Basket;
import com.rasmi.salestest.model.Good;
import lombok.Getter;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Abdelouadoud Rasmi
 * Singleton diesign pattern to simulate single data source for the whole application
 */
public class FakeDataProvider {
    private static FakeDataProvider DATA_PROVIDER;

    @Getter
    private List<Basket> baskets;

    private FakeDataProvider() {
        try {
            String file = new String(new ClassPathResource("/data/data.json").getInputStream().readAllBytes());
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new SimpleModule().addDeserializer(Good.class, new CustomGoodDeserializer()));
            Basket[] basketsArray = mapper.readValue(file, Basket[].class);
            baskets = Arrays.asList(basketsArray);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("The list of fake data will be empty, there was a problem while parsing data.json file, please check it");
            baskets = new ArrayList<>();
        }
    }

    /**
     * Singleton creation method
     *
     * @return FakeDataProvider single instance for the whole application
     */
    public static FakeDataProvider getInstance() {
        if (DATA_PROVIDER == null) {
            // thread safety for mutli-threading requests
            synchronized (new Object()) {
                DATA_PROVIDER = new FakeDataProvider();
            }
        }
        return DATA_PROVIDER;
    }
}
