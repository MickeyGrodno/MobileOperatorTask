package com.epam.mobileOperator.printer;

import com.epam.mobileOperator.interfaces.NumberOfSubscribersPrinter;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
public class NumberOfSubscribersPrinterTest {
    private static final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(output));
    }
    @Test
    public void testString() throws IOException {
        NumberOfSubscribersPrinter numberOfSubscribersPrinter = new NumberOfSubscribersPrinterImpl();
        numberOfSubscribersPrinter.printNumberOfSubscribers();
        String[] lineArr = output.toString().split("\\n");
        String actualLine = lineArr[lineArr.length-1];
        int numberOfSubscribersValue = Integer.parseInt(actualLine.replaceAll("[^0-9]", ""));
        Assertions.assertTrue(numberOfSubscribersValue>0);
    }
}
