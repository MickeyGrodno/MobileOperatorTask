package com.epam.mobileOperator.printer;

import com.epam.mobileOperator.interfaces.NumberOfSubscribersPrinter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class NumberOfSubscribersPrinterTest {
    private static ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testString() throws IOException {
        NumberOfSubscribersPrinter numberOfSubscribersPrinter = new NumberOfSubscribersPrinterImpl();
        numberOfSubscribersPrinter.printNumberOfSubscribers();
        String template = "Зарегистрировано абонентов:";
        Assertions.assertEquals(template, output.toString().substring(0,27));
    }
}
