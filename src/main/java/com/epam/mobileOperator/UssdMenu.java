package com.epam.mobileOperator;

import com.epam.mobileOperator.filter.FilterImpl;
import com.epam.mobileOperator.filter.FilterSettings;
import com.epam.mobileOperator.interfaces.Filter;
import com.epam.mobileOperator.interfaces.NumberOfSubscribersPrinter;
import com.epam.mobileOperator.interfaces.TariffLoader;
import com.epam.mobileOperator.interfaces.TariffPrinter;
import com.epam.mobileOperator.loader.TariffLoaderImpl;
import com.epam.mobileOperator.printer.NumberOfSubscribersPrinterImpl;
import com.epam.mobileOperator.printer.TariffPrinterImpl;

import java.io.IOException;
import java.util.Scanner;

public class UssdMenu {
    TariffLoader loader = new TariffLoaderImpl();
    TariffPrinter tariffPrinter = new TariffPrinterImpl();
    Filter filter = new FilterImpl();
    FilterSettings filterSettings;
    NumberOfSubscribersPrinter numberOfSubscribersPrinter;


    void startMenu() throws IOException {
        Scanner sc = new Scanner(System.in);
        numberOfSubscribersPrinter = new NumberOfSubscribersPrinterImpl();
        while (true) {
            numberOfSubscribersPrinter.printNumberOfSubscribers();
            System.out.println("1 - для получения списка тарифов компании");
            System.out.println("2 - для получения информации о всех тарифах компании");
            System.out.println("3 - для получения списка тарифов компании (Абон. плата min->max)");
            System.out.println("4 - подобрать тариф, соответствующий заданным параметрам");

            int userInput = sc.nextInt();

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
            if (userInput == 0) {
                break;
            }
        }
    }
    void showAllTariffByLine() throws IOException {
        tariffPrinter.printGroupTariffByTariffLine(loader.sortTariffsByTariffLine());
    }
    void showAllTariffInfo() throws IOException {
        tariffPrinter.printAllTariffInfo(loader.getAllTariffFromCsv());
    }
    void showAllTariffInfoSortedBySubscriptionFee() throws IOException {
        tariffPrinter.printAllTariffSortedBySubscriptionFee(loader.getAllTariffFromCsv());
    }
    void showAllTariffByUserFilter() throws IOException {
        filterSettings = new FilterSettings();
        filterSettings.setFilterParametersViaUserInterface();
        tariffPrinter.printAllTariffInfo(filter.findTariffByFilterSettings(loader.getAllTariffFromCsv(), filterSettings));
    }
}