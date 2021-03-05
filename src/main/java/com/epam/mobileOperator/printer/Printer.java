package com.epam.mobileOperator.printer;

import com.epam.mobileOperator.Tariff;
import com.epam.mobileOperator.TariffLoader;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Printer {
    TariffLoader loader;

    private void printGroupTariffByLine(Map<String, List<Tariff>> map) {
        for (Map.Entry<String, List<Tariff>> current : map.entrySet()) {
            System.out.println("Тарифы линейки " + current.getKey());
            System.out.println("------------------------------------");
            current.getValue().forEach(a -> System.out.println(a.getTariffName()));
            System.out.println();
        }
    }

    private String unlimFromTariffCheck(Integer lineValue) {
        if (!lineValue.equals(Integer.MAX_VALUE)) {
            return Integer.toString(lineValue);
        }
        else return "unlim";
    }

    private void printSortedTariffBySubscriptionFee(List<Tariff> tariffList) {
        System.out.println("Название тарифа | Абон. плата | Мин. внутри сети | Мин. в др. сети | Беспл. МБ | Беспл. СМС | " +
                "Мин. роум. | Цена 1 мин. | Цена 1 мин др. сети | Цена 1 Мб | Цена 1 СМС | Цена 1 мин роум. |");
        tariffList.stream().sorted(Comparator.comparing(Tariff::getSubscriptionFee)).forEach(a -> tariffInfoPrinter(a));
//            current.getValue().forEach(a ->  System.out.println(a.getTariffName()));

//            for (com.epam.mobileOperator.Tariff currentTariff : current.getValue()) {
//                System.out.println(currentTariff.getTariffName());
//            }
    }

    private void tariffInfoPrinter(Tariff tariff) {
        System.out.println(String.format("|   %s    |    %s    |    %s    |    %s    |    %s    |    %s    | " +
                        "   %s    |    %s    |    %s    |    %s    |     %s    |    %s    |", tariff.getTariffName(),
                tariff.getSubscriptionFee(), unlimFromTariffCheck(tariff.getFreeMinute()),
                unlimFromTariffCheck(tariff.getFreeMinuteToOtherNetwork()), unlimFromTariffCheck(tariff.getFreeTraffic()),
                unlimFromTariffCheck(tariff.getFreeSms()), unlimFromTariffCheck(tariff.getFreeMinuteRoaming()), tariff.getPriceMinute(), tariff.getPriceMinuteToOtherNetwork(),
                tariff.getPriceTraffic(), tariff.getPriceSms(), tariff.getPriceMinuteRoaming()));
    }

    private void printAllTariff(List<Tariff> tariffList) {
        printSortedTariffBySubscriptionFee(tariffList);
//        printGroupTariffByLine(sortTariffsByLine(loadAllTariffFromCsv()));
    }

    public void printGroupTariffByLine() throws IOException {
        loader = new TariffLoader();
        printGroupTariffByLine(loader.getSortTariffsByTariffLine());
    }

    public void printAllTariffInfo() throws IOException {
        loader = new TariffLoader();
        printAllTariff(loader.getAllTariff());
    }
}
