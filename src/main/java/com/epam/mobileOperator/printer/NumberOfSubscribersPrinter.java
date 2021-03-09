package com.epam.mobileOperator.printer;

import com.epam.mobileOperator.loader.NumberOfSubscribersLoader;

import java.io.IOException;

public class NumberOfSubscribersPrinter {
    NumberOfSubscribersLoader numberOfSubscribersLoader;

    public void printNumberOfSubscribers() throws IOException {
        numberOfSubscribersLoader = new NumberOfSubscribersLoader();
        int numberOfSubscribers = numberOfSubscribersLoader.getNumberOfSubscribers();
        System.out.println("Зарегистрировано абонентов: "+numberOfSubscribers);
    }
}
