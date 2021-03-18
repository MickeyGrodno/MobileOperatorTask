package com.epam.mobileOperator.loader;

import com.epam.mobileOperator.Tariff;
import com.epam.mobileOperator.interfaces.TariffLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TariffLoaderImplTest {
    TariffLoader tariffLoader;
    List<Tariff> list;
    @Test
    public void correctLoadAllTariffFromCsv() throws IOException {
        tariffLoader = new TariffLoaderImpl();
        list = tariffLoader.getAllTariffFromCsv();
        Assertions.assertTrue(!list.isEmpty());
    }
}
