package com.epam.mobileOperator.loader;

import com.epam.mobileOperator.interfaces.NumberOfSubscribersLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NumberOfSubscribersLoaderImplTest {
    @Test
    public void numberOfSubscribersLoaderTest() throws IOException {
        NumberOfSubscribersLoader numberOfSubscribersLoader = new NumberOfSubscribersLoaderImpl();
        Assertions.assertTrue(numberOfSubscribersLoader.getNumberOfSubscribers()>0);
    }
}
