package com.epam.mobileOperator;

import com.epam.mobileOperator.printer.Printer;

import java.io.IOException;
import java.util.Scanner;

public class UssdMenu {
    Printer printer = new Printer();
    private Scanner sc;
    private int userInput;
    void startMenu() throws IOException {
        sc = new Scanner(System.in);
        System.out.println("Hello");
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

        }
    }

    void showAllTariffByLine() throws IOException {
        printer.printGroupTariffByLine();
    }

    void showAllTariffInfo() throws IOException {
        printer.printAllTariffInfo();
    }
}
