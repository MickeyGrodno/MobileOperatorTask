package com.epam.mobileOperator.loader;

import com.epam.mobileOperator.Tariff;
import com.epam.mobileOperator.interfaces.TariffLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TariffLoaderImpl implements TariffLoader {
    private final static Logger LOGGER = LoggerFactory.getLogger(TariffLoaderImpl.class);

    private int unLimFromCsvCheck(String lineValue) {
        if (!lineValue.equalsIgnoreCase("unlim")) {
            return Integer.parseInt(lineValue);
        }
        else return Integer.MAX_VALUE;

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

    public List<Tariff> getAllTariffFromCsv() {

            List<Tariff> allTariff = new ArrayList<>();
            try {
            String RATE_BASE = "src\\main\\resources\\rateTariff.csv";
            BufferedReader reader = new BufferedReader(new FileReader(RATE_BASE));
            LOGGER.info("База тарифов загружена");
            String line;
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split("_");
                    allTariff.add(tariffSetter(values));
                }
            } catch (IOException e) {
                LOGGER.error("База данных абонентов не найдена");
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException e) {
                LOGGER.error("Неверный формат данных в базе данных");
                e.printStackTrace();
            }
        return allTariff;
    }
}
