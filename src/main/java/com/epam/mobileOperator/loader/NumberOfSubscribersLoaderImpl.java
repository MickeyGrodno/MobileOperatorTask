package com.epam.mobileOperator.loader;

import com.epam.mobileOperator.interfaces.NumberOfSubscribersLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberOfSubscribersLoaderImpl implements NumberOfSubscribersLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(NumberOfSubscribersLoaderImpl.class);
    public int getNumberOfSubscribers() {

        int numberOfSubscribers = 0;
        String SUBSCRIBERS_BASE = "src\\main\\resources\\usersBase.csv";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(SUBSCRIBERS_BASE));
            LOGGER.info("База пользователей загружена");
            String line;
            while ((line = reader.readLine()) != null) {
                int value = Integer.parseInt(line.split("_")[1]);
                numberOfSubscribers += value;
            }
            LOGGER.info("Произведено вычисление количества абонентов");
        } catch (IOException e) {
            LOGGER.error("База данных абонентов не найдена", e);
            e.printStackTrace();
        } catch (NumberFormatException e) {
            LOGGER.error("Неверный формат данных в базе данных", e);
            e.printStackTrace();
        }
        return numberOfSubscribers;
    }
}
