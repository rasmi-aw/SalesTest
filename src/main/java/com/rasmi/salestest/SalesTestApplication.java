package com.rasmi.salestest;

import com.rasmi.salestest.model.Basket;
import com.rasmi.salestest.utils.FakeDataProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SalesTestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SalesTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Reading data
        List<Basket> baskets = FakeDataProvider.getInstance().getBaskets();
        baskets.forEach(System.out::println);
    }
}
