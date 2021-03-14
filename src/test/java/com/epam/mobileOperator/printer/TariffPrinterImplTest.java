package com.epam.mobileOperator.printer;

import com.epam.mobileOperator.Tariff;
import com.epam.mobileOperator.interfaces.TariffPrinter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TariffPrinterImplTest {
    private static TariffPrinter tariffPrinter = new TariffPrinterImpl();
    private static Map<String, List<Tariff>> mapTariff;
    private static List<Tariff> allTariffList;
    private static Tariff tariff1;
    private static Tariff tariff2;
    private static Tariff tariff3;
    private static String tariffName;
    private static String trueValue;
    private static ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeAll
    public static void createTestData() {
        allTariffList = new ArrayList();
        mapTariff = new HashMap<>();
        tariffName = "The best";
        System.setOut(new PrintStream(output));
        tariff1 = Mockito.mock(Tariff.class);
        tariff2 = Mockito.mock(Tariff.class);
        tariff3 = Mockito.mock(Tariff.class);
        when(tariff1.getTariffName()).thenReturn("Comfort LITE");
        when(tariff1.getSubscriptionFee()).thenReturn(3.0);
        when(tariff2.getTariffName()).thenReturn("Comfort MEDIUM");
        when(tariff2.getSubscriptionFee()).thenReturn(2.0);
        when(tariff3.getTariffName()).thenReturn("Comfort MAX");
        when(tariff3.getSubscriptionFee()).thenReturn(10.0);
        allTariffList.add(tariff1);
        allTariffList.add(tariff2);
        allTariffList.add(tariff3);
        mapTariff.put(tariffName, allTariffList);
    }
    @AfterEach
    public void clearOutput() {
        output.reset();
    }
    @Test
    public void correctPrintTariffLineAndTariffNameTest() {
        trueValue = "Тарифы линейки Comfort\r\n" +
                "------------------------------------\r\n" +
                "Comfort LITE\r\n" +
                "Comfort MEDIUM\r\n" +
                "Comfort MAX\r\n" +
                "\r\n";
        tariffPrinter.printGroupTariffByTariffLine(allTariffList);
        Assertions.assertEquals(trueValue, output.toString());
    }
    @Test
    public void correctSortTariffBySubscriptionFeeTest() {
        trueValue = "Название тарифа | Абон. плата | Мин. внутри сети | Мин. в др. сети | Беспл. МБ | Беспл. СМС | Мин. роум. | Цена 1 мин. | Цена 1 мин др. сети | Цена 1 Мб | Цена 1 СМС | Цена 1 мин роум. |\r\n" +
                "|   Comfort MEDIUM    |    2.0    |    0    |    0    |    0    |    0    |    0    |    0.0    |    0.0    |    0.0    |     0.0    |    0.0    |\r\n" +
                "|   Comfort LITE    |    3.0    |    0    |    0    |    0    |    0    |    0    |    0.0    |    0.0    |    0.0    |     0.0    |    0.0    |\r\n" +
                "|   Comfort MAX    |    10.0    |    0    |    0    |    0    |    0    |    0    |    0.0    |    0.0    |    0.0    |     0.0    |    0.0    |\r\n";
        tariffPrinter.printAllTariffSortedBySubscriptionFee(allTariffList);
        Assertions.assertEquals(trueValue, output.toString());
    }
    @Test
    public void printAllTariffInfoTest() {
        trueValue = "Название тарифа | Абон. плата | Мин. внутри сети | Мин. в др. сети | Беспл. МБ | Беспл. СМС | Мин. роум. | Цена 1 мин. | Цена 1 мин др. сети | Цена 1 Мб | Цена 1 СМС | Цена 1 мин роум. |\r\n" +
                "|   Comfort LITE    |    3.0    |    0    |    0    |    0    |    0    |    0    |    0.0    |    0.0    |    0.0    |     0.0    |    0.0    |\r\n" +
                "|   Comfort MEDIUM    |    2.0    |    0    |    0    |    0    |    0    |    0    |    0.0    |    0.0    |    0.0    |     0.0    |    0.0    |\r\n" +
                "|   Comfort MAX    |    10.0    |    0    |    0    |    0    |    0    |    0    |    0.0    |    0.0    |    0.0    |     0.0    |    0.0    |\r\n";
        tariffPrinter.printAllTariffInfo(allTariffList);
        Assertions.assertEquals(trueValue,output.toString());
    }
}

