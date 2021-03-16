package com.epam.mobileOperator.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Scanner;

public class FilterSettings {
    private double[] subscriptionFee;
    private int[] freeMinute;
    private int[] freeMinuteToOtherNetwork;
    private int[] freeTraffic;
    private int[] freeSms;
    private int[] freeMinuteRoaming;
    private static final Logger LOGGER = LoggerFactory.getLogger(FilterSettings.class);

    public void setFilterParametersViaUserInterface() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите диапазон абонентской платы ");
            setSubscriptionFee(Arrays.stream(scanner.nextLine().split("-")).mapToDouble(Double::parseDouble).toArray());
            System.out.print("Введите диапазон бесплатных минут ");
            setFreeMinute(Arrays.stream(scanner.nextLine().split("-")).mapToInt(Integer::parseInt).toArray());
            System.out.print("Введите диапазон бесплатных минут в другие сети ");
            setFreeMinuteToOtherNetwork(Arrays.stream(scanner.nextLine().split("-")).mapToInt(Integer::parseInt).toArray());
            System.out.print("Введите диапазон бесплатного трафика ");
            setFreeTraffic(Arrays.stream(scanner.nextLine().split("-")).mapToInt(Integer::parseInt).toArray());
            System.out.print("Введите диапазон бесплатных СМС ");
            setFreeSms(Arrays.stream(scanner.nextLine().split("-")).mapToInt(Integer::parseInt).toArray());
            System.out.print("Введите диапазон бесплатных минут в роуминге ");
            setFreeMinuteRoaming(Arrays.stream(scanner.nextLine().split("-")).mapToInt(Integer::parseInt).toArray());
        }
        catch (NumberFormatException e) {
            LOGGER.error("Неверный формат вводимых данных");
            e.printStackTrace();
        }
    }

    public double[] getSubscriptionFee() {
        return subscriptionFee;
    }

    public void setSubscriptionFee(double[] subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    public int[] getFreeMinute() {
        return freeMinute;
    }

    public void setFreeMinute(int[] freeMinute) {
        this.freeMinute = freeMinute;
    }

    public int[] getFreeMinuteToOtherNetwork() {
        return freeMinuteToOtherNetwork;
    }

    public void setFreeMinuteToOtherNetwork(int[] freeMinuteToOtherNetwork) {
        this.freeMinuteToOtherNetwork = freeMinuteToOtherNetwork;
    }

    public int[] getFreeTraffic() {
        return freeTraffic;
    }

    public void setFreeTraffic(int[] freeTraffic) {
        this.freeTraffic = freeTraffic;
    }

    public int[] getFreeSms() {
        return freeSms;
    }

    public void setFreeSms(int[] freeSms) {
        this.freeSms = freeSms;
    }

    public int[] getFreeMinuteRoaming() {
        return freeMinuteRoaming;
    }

    public void setFreeMinuteRoaming(int[] freeMinuteRoaming) {
        this.freeMinuteRoaming = freeMinuteRoaming;
    }
}
