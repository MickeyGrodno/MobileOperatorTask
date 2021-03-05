package com.epam.mobileOperator.loader;

import com.epam.mobileOperator.Tariff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TariffLoader {
    private final String RATE_BASE = "src\\main\\resources\\rateTariff.csv";
    private BufferedReader reader;
    private List<Tariff> allTariff;
    private Map<String, List<Tariff>> allTariffsGroupByTariffLine;
    private String line;


    private int unlimFromCsvCheck(String lineValue) {
        if (!lineValue.equalsIgnoreCase("unlim")) {
            return Integer.parseInt(lineValue);
        }
        else return Integer.MAX_VALUE;
    }

    private Tariff tariffSetter(String[] values) {
        Tariff tariff = new Tariff();
        tariff.setTariffName(values[0]);
        tariff.setSubscriptionFee(Double.parseDouble(values[1]));
        tariff.setFreeMinute(unlimFromCsvCheck(values[2]));
        tariff.setFreeMinuteToOtherNetwork(unlimFromCsvCheck(values[3]));
        tariff.setFreeTraffic(unlimFromCsvCheck(values[4]));
        tariff.setFreeSms(unlimFromCsvCheck(values[5]));
        tariff.setFreeMinuteRoaming(unlimFromCsvCheck(values[6]));
        tariff.setPriceMinute(Double.parseDouble(values[7]));
        tariff.setPriceMinuteToOtherNetwork(Double.parseDouble(values[8]));
        tariff.setPriceTraffic(Double.parseDouble(values[9]));
        tariff.setPriceSms(Double.parseDouble(values[10]));
        tariff.setPriceMinuteRoaming(Double.parseDouble(values[11]));
        return tariff;
    }

    public List<Tariff> getAllTariffFromCsv() throws IOException {
        allTariff = new ArrayList<>();
        reader = new BufferedReader(new FileReader(RATE_BASE));

        while ((line = reader.readLine()) != null) {
            String[] values = line.split("_");
            allTariff.add(tariffSetter(values));
        }
        return allTariff;
    }

    private Map<String, List<Tariff>> sortTariffsByTariffLine(List<Tariff> tariffList) {

        allTariffsGroupByTariffLine = tariffList.stream().collect(
                Collectors.groupingBy(x -> x.getTariffName().split("[ \\+]")[0]));

        return allTariffsGroupByTariffLine;
    }

    public Map<String, List<Tariff>> getSortTariffsByTariffLine() throws IOException {
        return sortTariffsByTariffLine(getAllTariffFromCsv());
    }
}
