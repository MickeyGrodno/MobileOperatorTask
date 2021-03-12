package com.epam.mobileOperator.filter;

import java.util.Arrays;
import java.util.Scanner;

public class FilterSettings {
    private double[] subscriptionFee;
    private int[] freeMinute;
    private int[] freeMinuteToOtherNetwork;
    private int[] freeTraffic;
    private int[] freeSms;
    private int[] freeMinuteRoaming;

    public void setFilterParametersViaUserInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите диапазон абон платы ");
        setSubscriptionFee(Arrays.stream(scanner.nextLine().split("-")).mapToDouble(Double::parseDouble).toArray());
        System.out.print("Введите диапазон беспл мин ");
        setFreeMinute(Arrays.stream(scanner.nextLine().split("-")).mapToInt(Integer::parseInt).toArray());
        System.out.print("Введите диапазон беспл мин др сети ");
        setFreeMinuteToOtherNetwork(Arrays.stream(scanner.nextLine().split("-")).mapToInt(Integer::parseInt).toArray());
        System.out.print("Введите диапазон Трафик ");
        setFreeTraffic(Arrays.stream(scanner.nextLine().split("-")).mapToInt(Integer::parseInt).toArray());
        System.out.print("Введите диапазон СМС ");
        setFreeSms(Arrays.stream(scanner.nextLine().split("-")).mapToInt(Integer::parseInt).toArray());
        System.out.print("Введите диапазон мин роум ");
        setFreeMinuteRoaming(Arrays.stream(scanner.nextLine().split("-")).mapToInt(Integer::parseInt).toArray());
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
