package com.epam.mobileOperator.loader;

import com.epam.mobileOperator.Tariff;
import com.epam.mobileOperator.interfaces.TariffLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TariffLoaderImpl implements TariffLoader {

    private int unLimFromCsvCheck(String lineValue) {
        if (!lineValue.equalsIgnoreCase("unlim")) {
            return Integer.parseInt(lineValue);
        } else return Integer.MAX_VALUE;
    }

    private Tariff tariffSetter(String[] values) {
        Tariff tariff = new Tariff();
        tariff.setTariffName(values[0]);
        tariff.setSubscriptionFee(Double.parseDouble(values[1]));
        tariff.setFreeMinute(unLimFromCsvCheck(values[2]));
        tariff.setFreeMinuteToOtherNetwork(unLimFromCsvCheck(values[3]));
        tariff.setFreeTraffic(unLimFromCsvCheck(values[4]));
        tariff.setFreeSms(unLimFromCsvCheck(values[5]));
        tariff.setFreeMinuteRoaming(unLimFromCsvCheck(values[6]));
        tariff.setPriceMinute(Double.parseDouble(values[7]));
        tariff.setPriceMinuteToOtherNetwork(Double.parseDouble(values[8]));
        tariff.setPriceTraffic(Double.parseDouble(values[9]));
        tariff.setPriceSms(Double.parseDouble(values[10]));
        tariff.setPriceMinuteRoaming(Double.parseDouble(values[11]));
        return tariff;
    }

    public Map<String, List<Tariff>> sortTariffsByTariffLine() throws IOException {

        List<Tariff> allTariffFromCsv = getAllTariffFromCsv();
        return allTariffFromCsv.stream().collect(
                Collectors.groupingBy(x -> x.getTariffName().split("[ +]")[0]));
    }

    public List<Tariff> getAllTariffFromCsv() throws IOException {
        List<Tariff> allTariff = new ArrayList<>();
        String RATE_BASE = "src\\main\\resources\\rateTariff.csv";
        BufferedReader reader = new BufferedReader(new FileReader(RATE_BASE));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split("_");
            allTariff.add(tariffSetter(values));
        }
        return allTariff;
    }
}
