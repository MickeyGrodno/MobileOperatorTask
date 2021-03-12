package com.epam.mobileOperator.printer;

import com.epam.mobileOperator.interfaces.NumberOfSubscribersPrinter;
import com.epam.mobileOperator.loader.NumberOfSubscribersLoaderImpl;

import java.io.IOException;

public class NumberOfSubscribersPrinterImpl implements NumberOfSubscribersPrinter {
    NumberOfSubscribersLoaderImpl numberOfSubscribersLoader;

    public void printNumberOfSubscribers() throws IOException {
        numberOfSubscribersLoader = new NumberOfSubscribersLoaderImpl();
        int numberOfSubscribers = numberOfSubscribersLoader.getNumberOfSubscribers();
        System.out.println("Зарегистрировано абонентов: "+numberOfSubscribers);
    }
}
