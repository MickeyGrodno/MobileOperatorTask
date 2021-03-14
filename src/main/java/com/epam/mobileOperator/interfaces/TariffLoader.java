package com.epam.mobileOperator.interfaces;

import com.epam.mobileOperator.Tariff;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface TariffLoader {
    List<Tariff> getAllTariffFromCsv() throws IOException;
}
