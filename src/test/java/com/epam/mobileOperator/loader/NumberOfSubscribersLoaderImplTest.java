package com.epam.mobileOperator.loader;

import com.epam.mobileOperator.interfaces.NumberOfSubscribersLoader;
import com.epam.mobileOperator.loader.NumberOfSubscribersLoaderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NumberOfSubscribersLoaderImplTest {
    @Test
    public void test() throws IOException {
        NumberOfSubscribersLoader numberOfSubscribersLoader = new NumberOfSubscribersLoaderImpl();
        int correctValue = 172938833;
        Assertions.assertEquals(correctValue, numberOfSubscribersLoader.getNumberOfSubscribers());
    }
}
