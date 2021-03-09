package com.epam.mobileOperator;

import com.epam.mobileOperator.filter.Filter;
import com.epam.mobileOperator.loader.TariffLoader;
import com.epam.mobileOperator.printer.NumberOfSubscribersPrinter;
import com.epam.mobileOperator.printer.TariffPrinter;

import java.io.IOException;
import java.util.Scanner;

public class UssdMenu {
    TariffLoader loader = new TariffLoader();
    TariffPrinter tariffPrinter = new TariffPrinter();
    Filter filter = new Filter();
    private Scanner sc;
    private int userInput;
    NumberOfSubscribersPrinter numberOfSubscribersPrinter;
    void startMenu() throws IOException {
        sc = new Scanner(System.in);
        numberOfSubscribersPrinter = new NumberOfSubscribersPrinter();
        numberOfSubscribersPrinter.printNumberOfSubscribers();
        System.out.println("1 - для получения списка тарифов компании");
        System.out.println("2 - для получения информации о всех тарифах компании");
        System.out.println("3 - для получения списка тарифов компании (Абон. плата min->max)");
        System.out.println("4 - подобрать тариф, соответствующий заданным параметрам");

        userInput = sc.nextInt();

        if (userInput == 1) {
            showAllTariffByLine();
        }
        if (userInput == 2) {
            showAllTariffInfo();
        }
        if (userInput == 3) {
            showAllTariffInfoSortedBySubscriptionFee();
        }
        if (userInput == 4) {
            showAllTariffByUserFilter();
        }
    }
    void showAllTariffByLine() throws IOException {
        tariffPrinter.printGroupTariffByTariffLine(loader.getSortTariffsByTariffLine());
    }
    void showAllTariffInfo() throws IOException {
        tariffPrinter.printAllTariffInfo(loader.getAllTariffFromCsv());
    }
    void showAllTariffInfoSortedBySubscriptionFee() throws IOException {
        tariffPrinter.printAllTariffSortedBySubscriptionFee(loader.getAllTariffFromCsv());
    }
    void showAllTariffByUserFilter() throws IOException {
        tariffPrinter.printAllTariffInfo(filter.getAllTariffByUserFilter());
    }
}
