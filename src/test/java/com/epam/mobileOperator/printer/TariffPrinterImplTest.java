package com.epam.mobileOperator.printer;

import com.epam.mobileOperator.Tariff;
import com.epam.mobileOperator.interfaces.TariffPrinter;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

public class TariffPrinterImplTest {
    private static final TariffPrinter tariffPrinter = new TariffPrinterImpl();
    private static ArrayList allTariffList;
    private static PrintStream stream = mock(PrintStream.class);

    @AfterEach
    public void cleanStream(){
        stream = mock(PrintStream.class);
        System.setOut(stream);
    }
    @BeforeAll
    public static void createTestData() {
        System.setOut(stream);
        allTariffList = new ArrayList();
        Map<String, List<Tariff>> mapTariff = new HashMap<>();
        String tariffName = "The best";

        Tariff tariff1 = Mockito.mock(Tariff.class);
        Tariff tariff2 = Mockito.mock(Tariff.class);
        Tariff tariff3 = Mockito.mock(Tariff.class);
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
    @Test
    public void correctPrintTariffLineAndTariffNameTest() {
        String actualValue = "Тарифы линейки Comfort\r\n" +
                "------------------------------------\r\n" +
                "Comfort LITE\r\n" +
                "Comfort MEDIUM\r\n" +
                "Comfort MAX";
        tariffPrinter.printGroupTariffByTariffLine(allTariffList);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(stream, times(5)).println(captor.capture());
        String line = String.join("\r\n", captor.getAllValues());
        Assertions.assertEquals(actualValue, line);
    }
    @Test
    public void correctSortTariffBySubscriptionFeeTest() {
        String actualValue = "Название тарифа | Абон. плата | Мин. внутри сети | Мин. в др. сети | Беспл. МБ | Беспл. СМС | Мин. роум. | Цена 1 мин. | Цена 1 мин др. сети | Цена 1 Мб | Цена 1 СМС | Цена 1 мин роум. |\r\n" +
                "|   Comfort MEDIUM    |    2.0    |    0    |    0    |    0    |    0    |    0    |    0.0    |    0.0    |    0.0    |     0.0    |    0.0    |\r\n" +
                "|   Comfort LITE    |    3.0    |    0    |    0    |    0    |    0    |    0    |    0.0    |    0.0    |    0.0    |     0.0    |    0.0    |\r\n" +
                "|   Comfort MAX    |    10.0    |    0    |    0    |    0    |    0    |    0    |    0.0    |    0.0    |    0.0    |     0.0    |    0.0    |\r\n";
        tariffPrinter.printAllTariffSortedBySubscriptionFee(allTariffList);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(stream, times(4)).println(captor.capture());
        String line = String.join("", captor.getAllValues());
        Assertions.assertEquals(actualValue, line);
    }
    @Test
    public void printAllTariffInfoTest() {
        String actualValue = "Название тарифа | Абон. плата | Мин. внутри сети | Мин. в др. сети | Беспл. МБ | Беспл. СМС | Мин. роум. | Цена 1 мин. | Цена 1 мин др. сети | Цена 1 Мб | Цена 1 СМС | Цена 1 мин роум. |\r\n" +
                "|   Comfort LITE    |    3.0    |    0    |    0    |    0    |    0    |    0    |    0.0    |    0.0    |    0.0    |     0.0    |    0.0    |\r\n" +
                "|   Comfort MEDIUM    |    2.0    |    0    |    0    |    0    |    0    |    0    |    0.0    |    0.0    |    0.0    |     0.0    |    0.0    |\r\n" +
                "|   Comfort MAX    |    10.0    |    0    |    0    |    0    |    0    |    0    |    0.0    |    0.0    |    0.0    |     0.0    |    0.0    |\r\n";
        tariffPrinter.printAllTariffInfo(allTariffList);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(stream, times(4)).println(captor.capture());
        String line = String.join("", captor.getAllValues());
        Assertions.assertEquals(actualValue, line);
    }
}

