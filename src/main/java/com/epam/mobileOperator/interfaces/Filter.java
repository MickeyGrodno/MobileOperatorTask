package com.epam.mobileOperator.interfaces;

import com.epam.mobileOperator.Tariff;
import com.epam.mobileOperator.filter.FilterSettings;

import java.util.List;

public interface Filter {
    List<Tariff> findTariffByFilterSettings(List<Tariff> tariffList, FilterSettings filterSettings);
}
