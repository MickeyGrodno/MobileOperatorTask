package com.epam.mobileOperator;

public class Tariff {
    private String TariffName;
    private Double subscriptionFee;
    private int freeMinute;
    private int freeMinuteToOtherNetwork;
    private int freeTraffic;
    private int freeSms;
    private int freeMinuteRoaming;
    private double priceMinute;
    private double priceMinuteToOtherNetwork;
    private double priceTraffic;
    private double priceSms;
    private double priceMinuteRoaming;



    public String getTariffName() {
        return TariffName;
    }

    public void setTariffName(String RateName) {
        this.TariffName = RateName;
    }

    public Double getSubscriptionFee() {
        return subscriptionFee;
    }

    public void setSubscriptionFee(Double subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    public int getFreeMinute() {
        return freeMinute;
    }

    public void setFreeMinute(int freeMinute) {
        this.freeMinute = freeMinute;
    }

    public int getFreeMinuteToOtherNetwork() {
        return freeMinuteToOtherNetwork;
    }

    public void setFreeMinuteToOtherNetwork(int freeMinuteToOtherNetwork) {
        this.freeMinuteToOtherNetwork = freeMinuteToOtherNetwork;
    }

    public int getFreeTraffic() {
        return freeTraffic;
    }

    public void setFreeTraffic(int freeTraffic) {
        this.freeTraffic = freeTraffic;
    }

    public int getFreeSms() {
        return freeSms;
    }

    public void setFreeSms(int freeSms) {
        this.freeSms = freeSms;
    }

    public int getFreeMinuteRoaming() {
        return freeMinuteRoaming;
    }

    public void setFreeMinuteRoaming(int freeMinuteRoaming) {
        this.freeMinuteRoaming = freeMinuteRoaming;
    }

    public double getPriceMinute() {
        return priceMinute;
    }

    public void setPriceMinute(double priceMinute) {
        this.priceMinute = priceMinute;
    }

    public double getPriceMinuteToOtherNetwork() {
        return priceMinuteToOtherNetwork;
    }

    public void setPriceMinuteToOtherNetwork(double priceMinuteToOtherNetwork) {
        this.priceMinuteToOtherNetwork = priceMinuteToOtherNetwork;
    }

    public double getPriceTraffic() {
        return priceTraffic;
    }

    public void setPriceTraffic(double priceTraffic) {
        this.priceTraffic = priceTraffic;
    }

    public double getPriceSms() {
        return priceSms;
    }

    public void setPriceSms(double priceSms) {
        this.priceSms = priceSms;
    }

    public double getPriceMinuteRoaming() {
        return priceMinuteRoaming;
    }

    public void setPriceMinuteRoaming(double priceMinuteRoaming) {
        this.priceMinuteRoaming = priceMinuteRoaming;
    }
}
