package com.epam.mobileOperator.printer;

import com.epam.mobileOperator.interfaces.NumberOfSubscribersPrinter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NumberOfSubscribersPrinterTest {
    private static final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Test
    public void numberOfSubscribersCorrectPrinterTest() throws IOException {
        PrintStream stream = mock(PrintStream.class);
        System.setOut(stream);
        NumberOfSubscribersPrinter numberOfSubscribersPrinter = new NumberOfSubscribersPrinterImpl();
        numberOfSubscribersPrinter.printNumberOfSubscribers();
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(stream).println(captor.capture());
        String actualLine = captor.getValue();
        int numberOfSubscribersValue = Integer.parseInt(actualLine.replaceAll("[^0-9]", ""));
        Assertions.assertTrue(numberOfSubscribersValue >=0);

    }
}
