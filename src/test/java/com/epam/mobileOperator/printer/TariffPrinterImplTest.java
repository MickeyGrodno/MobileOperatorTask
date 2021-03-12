package com.epam.mobileOperator.printer;

import com.epam.mobileOperator.Tariff;
import com.epam.mobileOperator.interfaces.TariffPrinter;
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
        when(tariff1.getTariffName()).thenReturn("The best of the best1");
        when(tariff1.getSubscriptionFee()).thenReturn(3.0);
        when(tariff2.getTariffName()).thenReturn("The best of the best2");
        when(tariff2.getSubscriptionFee()).thenReturn(2.0);
        when(tariff3.getTariffName()).thenReturn("The best of the best3");
        when(tariff3.getSubscriptionFee()).thenReturn(10.0);
        allTariffList.add(tariff1);
        allTariffList.add(tariff2);
        allTariffList.add(tariff3);
        mapTariff.put(tariffName, allTariffList);
    }
    @Test
    public void correctPrintTariffLineAndTariffNameTest() {
        trueValue = "Тарифы линейки The best\r\n" +
                "------------------------------------\r\n" +
                "The best of the best1\r\n" +
                "The best of the best2\r\n" +
                "The best of the best3\r\n" +
                "\r\n";
        tariffPrinter.printGroupTariffByTariffLine(mapTariff);
        Assertions.assertEquals(trueValue, output.toString());
    }
    @Test
    public void correctSortTariffBySubscriptionFeeTest() {
        trueValue = "Название тарифа | Абон. плата | Мин. внутри сети | Мин. в др. сети | Беспл. МБ | Беспл. СМС | Мин. роум. | Цена 1 мин. | Цена 1 мин др. сети | Цена 1 Мб | Цена 1 СМС | Цена 1 мин роум. |\r\n" +
                "|   The best of the best2    |    2.0    |    0    |    0    |    0    |    0    |    0    |    0.0    |    0.0    |    0.0    |     0.0    |    0.0    |\r\n" +
                "|   The best of the best1    |    3.0    |    0    |    0    |    0    |    0    |    0    |    0.0    |    0.0    |    0.0    |     0.0    |    0.0    |\r\n" +
                "|   The best of the best3    |    10.0    |    0    |    0    |    0    |    0    |    0    |    0.0    |    0.0    |    0.0    |     0.0    |    0.0    |\r\n";
        tariffPrinter.printAllTariffSortedBySubscriptionFee(allTariffList);
        Assertions.assertEquals(trueValue, output.toString());
    }
    @Test
    public void printAllTariffInfoTest() {
        trueValue = "Название тарифа | Абон. плата | Мин. внутри сети | Мин. в др. сети | Беспл. МБ | Беспл. СМС | Мин. роум. | Цена 1 мин. | Цена 1 мин др. сети | Цена 1 Мб | Цена 1 СМС | Цена 1 мин роум. |\r\n" +
                "|   The best of the best1    |    3.0    |    0    |    0    |    0    |    0    |    0    |    0.0    |    0.0    |    0.0    |     0.0    |    0.0    |\r\n" +
                "|   The best of the best2    |    2.0    |    0    |    0    |    0    |    0    |    0    |    0.0    |    0.0    |    0.0    |     0.0    |    0.0    |\r\n" +
                "|   The best of the best3    |    10.0    |    0    |    0    |    0    |    0    |    0    |    0.0    |    0.0    |    0.0    |     0.0    |    0.0    |\r\n";
        tariffPrinter.printAllTariffInfo(allTariffList);
        Assertions.assertEquals(trueValue,output.toString());
    }
}

