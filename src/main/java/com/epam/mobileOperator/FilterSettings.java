package com.epam.mobileOperator;

public class FilterSettings {
    private double[] subscriptionFee;
    private int[] freeMinute;
    private int[] freeMinuteToOtherNetwork;
    private int[] freeTraffic;
    private int[] freeSms;
    private int[] freeMinuteRoaming;

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
