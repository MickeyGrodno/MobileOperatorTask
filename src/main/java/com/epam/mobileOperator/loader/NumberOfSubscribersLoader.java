package com.epam.mobileOperator.loader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NumberOfSubscribersLoader {
    private final String SUBSCRIBERS_BASE = "src\\main\\resources\\usersBase.csv";
    private BufferedReader reader;
    private String line;

    public int getNumberOfSubscribers() throws IOException {
        int numberOfSubscribers = 0;
        reader = new BufferedReader(new FileReader(SUBSCRIBERS_BASE));

        while ((line = reader.readLine()) != null) {
            Integer value = Integer.parseInt(line.split("_")[1]);
            numberOfSubscribers += value;
        }
        return numberOfSubscribers;
    }
}
