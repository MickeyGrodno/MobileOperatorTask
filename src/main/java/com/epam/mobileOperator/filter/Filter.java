package com.epam.mobileOperator.filter;

import com.epam.mobileOperator.Tariff;
import com.epam.mobileOperator.loader.TariffLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Filter {
    TariffLoader tariffLoader;
    Scanner scanner;

    private List<Tariff> findTariffByFilter (List<Tariff> tariffList, FilterSettings filterSettings) {
        List<Tariff> filteredTariffList = new ArrayList<>();
        for(Tariff tariff : tariffList) {
            if(tariff.getSubscriptionFee()>=filterSettings.getSubscriptionFee()[0]
                    && tariff.getSubscriptionFee()<=filterSettings.getSubscriptionFee()[1]) {
                if(tariff.getFreeMinute()>=filterSettings.getFreeMinute()[0]
                        && tariff.getFreeMinute()<=filterSettings.getFreeMinute()[1]) {
                    if(tariff.getFreeMinuteToOtherNetwork()>=filterSettings.getFreeMinuteToOtherNetwork()[0]
                            && tariff.getFreeMinuteToOtherNetwork()<=filterSettings.getFreeMinuteToOtherNetwork()[1]) {
                        if(tariff.getFreeTraffic()>=filterSettings.getFreeTraffic()[0]
                                && tariff.getFreeTraffic()<=filterSettings.getFreeTraffic()[1]) {
                            if(tariff.getFreeSms()>=filterSettings.getFreeSms()[0]
                                    && tariff.getFreeSms()<=filterSettings.getFreeSms()[1]) {
                                if(tariff.getFreeMinuteRoaming()>=filterSettings.getFreeMinuteRoaming()[0]
                                        && tariff.getFreeMinuteRoaming()<=filterSettings.getFreeMinuteRoaming()[1]) {
                                    filteredTariffList.add(tariff);
                                }
                            }
                        }
                    }
                }
            }
        }
        return filteredTariffList;
    }

    private FilterSettings setFilterSettings() {

        scanner = new Scanner(System.in);
        FilterSettings filterSettings = new FilterSettings();
        System.out.printf("Введите диапазон абон платы ");
        filterSettings.setSubscriptionFee(Arrays.stream(scanner.nextLine().split("-")).mapToDouble(Double::parseDouble).toArray());
        System.out.printf("Введите диапазон беспл мин ");
        filterSettings.setFreeMinute(Arrays.stream(scanner.nextLine().split("-")).mapToInt(Integer::parseInt).toArray());
        System.out.printf("Введите диапазон беспл мин др сети ");
        filterSettings.setFreeMinuteToOtherNetwork(Arrays.stream(scanner.nextLine().split("-")).mapToInt(Integer::parseInt).toArray());
        System.out.printf("Введите диапазон Трафик ");
        filterSettings.setFreeTraffic(Arrays.stream(scanner.nextLine().split("-")).mapToInt(Integer::parseInt).toArray());
        System.out.printf("Введите диапазон СМС ");
        filterSettings.setFreeSms(Arrays.stream(scanner.nextLine().split("-")).mapToInt(Integer::parseInt).toArray());
        System.out.printf("Введите диапазон мин роум ");
        filterSettings.setFreeMinuteRoaming(Arrays.stream(scanner.nextLine().split("-")).mapToInt(Integer::parseInt).toArray());
        return filterSettings;
    }

    public List<Tariff> getAllTariffByUserFilter() throws IOException {
        tariffLoader = new TariffLoader();
        return findTariffByFilter(tariffLoader.getAllTariffFromCsv(), setFilterSettings());

    }
}
