package com.epam.mobileOperator.loader;

import com.epam.mobileOperator.interfaces.NumberOfSubscribersLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberOfSubscribersLoaderImpl implements NumberOfSubscribersLoader {

    public int getNumberOfSubscribers() throws IOException {
        int numberOfSubscribers = 0;
        String SUBSCRIBERS_BASE = "src\\main\\resources\\usersBase.csv";
        BufferedReader reader = new BufferedReader(new FileReader(SUBSCRIBERS_BASE));

        String line;
        while ((line = reader.readLine()) != null) {
            int value = Integer.parseInt(line.split("_")[1]);
            numberOfSubscribers += value;
        }
        return numberOfSubscribers;
    }
}
