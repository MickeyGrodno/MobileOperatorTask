package com.epam.mobileOperator.printer;

import com.epam.mobileOperator.interfaces.NumberOfSubscribersPrinter;
import com.epam.mobileOperator.loader.NumberOfSubscribersLoaderImpl;

public class NumberOfSubscribersPrinterImpl implements NumberOfSubscribersPrinter {
    NumberOfSubscribersLoaderImpl numberOfSubscribersLoader;

    public void printNumberOfSubscribers() {
        numberOfSubscribersLoader = new NumberOfSubscribersLoaderImpl();
        int numberOfSubscribers = numberOfSubscribersLoader.getNumberOfSubscribers();
        System.out.println("Зарегистрировано абонентов: "+numberOfSubscribers);
    }
}
