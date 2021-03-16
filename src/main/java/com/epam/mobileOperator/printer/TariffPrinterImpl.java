package com.epam.mobileOperator.printer;

import com.epam.mobileOperator.Tariff;
import com.epam.mobileOperator.interfaces.TariffPrinter;
import com.epam.mobileOperator.loader.TariffLoaderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TariffPrinterImpl implements TariffPrinter {
    private final static Logger LOGGER = LoggerFactory.getLogger(TariffLoaderImpl.class);

    private String unLimFromTariffCheck(Integer lineValue) {
        if (!lineValue.equals(Integer.MAX_VALUE)) {
            return Integer.toString(lineValue);
        }
        else return "unlim";
    }
    private void headLinePrinter() {
        System.out.println("Название тарифа | Абон. плата | Мин. внутри сети | Мин. в др. сети | Беспл. МБ | Беспл. СМС | " +
                "Мин. роум. | Цена 1 мин. | Цена 1 мин др. сети | Цена 1 Мб | Цена 1 СМС | Цена 1 мин роум. |");
    }
    private void tariffInfoPrinter(Tariff tariff) {
        System.out.printf("|   %s    |    %s    |    %s    |    %s    |    %s    |    %s    | " +
                        "   %s    |    %s    |    %s    |    %s    |     %s    |    %s    |%n", tariff.getTariffName(),
                tariff.getSubscriptionFee(), unLimFromTariffCheck(tariff.getFreeMinute()),
                unLimFromTariffCheck(tariff.getFreeMinuteToOtherNetwork()), unLimFromTariffCheck(tariff.getFreeTraffic()),
                unLimFromTariffCheck(tariff.getFreeSms()), unLimFromTariffCheck(tariff.getFreeMinuteRoaming()), tariff.getPriceMinute(), tariff.getPriceMinuteToOtherNetwork(),
                tariff.getPriceTraffic(), tariff.getPriceSms(), tariff.getPriceMinuteRoaming());
    }
    public void printGroupTariffByTariffLine(List<Tariff> tariffList) {
        LOGGER.info("Группировка тарифов по тарифной линии");
        Map<String, List<Tariff>> map = tariffList.stream().collect(
                Collectors.groupingBy(x -> x.getTariffName().split("[ +]")[0]));
        LOGGER.info("Вызов печати");
        for (Map.Entry<String, List<Tariff>> current : map.entrySet()) {
            System.out.println("Тарифы линейки " + current.getKey());
            System.out.println("------------------------------------");
            current.getValue().forEach(a -> System.out.println(a.getTariffName()));
            System.out.println();
        }
    }
    public void printAllTariffSortedBySubscriptionFee(List<Tariff> tariffList) {
        headLinePrinter();
        LOGGER.info("Вызов печати");
        tariffList.stream().sorted(Comparator.comparing(Tariff::getSubscriptionFee)).forEach(this::tariffInfoPrinter);
    }
    public void printAllTariffInfo(List<Tariff> tariffList) {
        headLinePrinter();
        LOGGER.info("Вызов печати");
        tariffList.forEach(this::tariffInfoPrinter);
    }
}
