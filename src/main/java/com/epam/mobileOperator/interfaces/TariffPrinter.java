package com.epam.mobileOperator.interfaces;

import com.epam.mobileOperator.Tariff;

import java.util.List;
import java.util.Map;

public interface TariffPrinter {
    void printGroupTariffByTariffLine(Map<String, List<Tariff>> map);
    void printAllTariffSortedBySubscriptionFee(List<Tariff> tariffList);
    void printAllTariffInfo(List<Tariff> tariffList);
}
