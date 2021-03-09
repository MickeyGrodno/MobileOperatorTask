package com.epam.mobileOperator.printer;

import com.epam.mobileOperator.Tariff;
import com.epam.mobileOperator.loader.TariffLoader;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class TariffPrinter {

    private String unlimFromTariffCheck(Integer lineValue) {
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
        System.out.println(String.format("|   %s    |    %s    |    %s    |    %s    |    %s    |    %s    | " +
                        "   %s    |    %s    |    %s    |    %s    |     %s    |    %s    |", tariff.getTariffName(),
                tariff.getSubscriptionFee(), unlimFromTariffCheck(tariff.getFreeMinute()),
                unlimFromTariffCheck(tariff.getFreeMinuteToOtherNetwork()), unlimFromTariffCheck(tariff.getFreeTraffic()),
                unlimFromTariffCheck(tariff.getFreeSms()), unlimFromTariffCheck(tariff.getFreeMinuteRoaming()), tariff.getPriceMinute(), tariff.getPriceMinuteToOtherNetwork(),
                tariff.getPriceTraffic(), tariff.getPriceSms(), tariff.getPriceMinuteRoaming()));
    }
    public void printGroupTariffByTariffLine(Map<String, List<Tariff>> map) {
        for (Map.Entry<String, List<Tariff>> current : map.entrySet()) {
            System.out.println("Тарифы линейки " + current.getKey());
            System.out.println("------------------------------------");
            current.getValue().forEach(a -> System.out.println(a.getTariffName()));
            System.out.println();
        }
    }
    public void printAllTariffSortedBySubscriptionFee(List<Tariff> tariffList) {
        headLinePrinter();
        tariffList.stream().sorted(Comparator.comparing(Tariff::getSubscriptionFee)).forEach(a -> tariffInfoPrinter(a));
//            current.getValue().forEach(a ->  System.out.println(a.getTariffName()));

//            for (com.epam.mobileOperator.Tariff currentTariff : current.getValue()) {
//                System.out.println(currentTariff.getTariffName());
//            }
    }
    public void printAllTariffInfo(List<Tariff> tariffList) {
        headLinePrinter();
        tariffList.stream().forEach(a -> tariffInfoPrinter(a));
//        printSortedTariffBySubscriptionFee(tariffList);
//        printGroupTariffByLine(sortTariffsByLine(loadAllTariffFromCsv()));
    }
}
