package com.epam.mobileOperator.filter;

import com.epam.mobileOperator.Tariff;
import com.epam.mobileOperator.interfaces.Filter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FilterImplTest {

    private static FilterSettings mFilterSettings1;
    private static FilterSettings mFilterSettings2;
    private static final Filter filter = new FilterImpl();
    private static final List<Tariff> tariffList = new ArrayList<>();

    @BeforeAll
    public static void createTestData() {
        mFilterSettings1 = mock(FilterSettings.class);
        mFilterSettings2 = mock(FilterSettings.class);
        Tariff tariff1 = mock(Tariff.class);
        Tariff tariff2 = mock(Tariff.class);

        when(tariff1.getTariffName()).thenReturn("Tariff-1");
        when(tariff1.getSubscriptionFee()).thenReturn(5.0);
        when(tariff1.getFreeMinute()).thenReturn(100);
        when(tariff1.getFreeMinuteToOtherNetwork()).thenReturn(150);
        when(tariff1.getFreeTraffic()).thenReturn(500);
        when(tariff1.getFreeSms()).thenReturn(100);
        when(tariff1.getFreeMinuteRoaming()).thenReturn(100);

        when(tariff2.getTariffName()).thenReturn("Tariff-2");
        when(tariff2.getSubscriptionFee()).thenReturn(7.0);
        when(tariff2.getFreeMinute()).thenReturn(200);
        when(tariff2.getFreeMinuteToOtherNetwork()).thenReturn(110);
        when(tariff2.getFreeTraffic()).thenReturn(800);
        when(tariff2.getFreeSms()).thenReturn(200);
        when(tariff2.getFreeMinuteRoaming()).thenReturn(100);
        tariffList.add(tariff1);
        tariffList.add(tariff2);

        when(mFilterSettings1.getSubscriptionFee()).thenReturn(new double[]{4.0, 6.0});
        when(mFilterSettings1.getFreeMinute()).thenReturn(new int[]{100, 150});
        when(mFilterSettings1.getFreeMinuteToOtherNetwork()).thenReturn(new int[]{150, 200});
        when(mFilterSettings1.getFreeTraffic()).thenReturn(new int[]{400, 799});
        when(mFilterSettings1.getFreeSms()).thenReturn(new int[]{90, 111});
        when(mFilterSettings1.getFreeMinuteRoaming()).thenReturn(new int[]{50, 100});

        when(mFilterSettings2.getSubscriptionFee()).thenReturn(new double[]{4.0, 6.0});
        when(mFilterSettings2.getFreeMinute()).thenReturn(new int[]{100, 150});
        when(mFilterSettings2.getFreeMinuteToOtherNetwork()).thenReturn(new int[]{10, 20});
        when(mFilterSettings2.getFreeTraffic()).thenReturn(new int[]{400, 799});
        when(mFilterSettings2.getFreeSms()).thenReturn(new int[]{90, 111});
        when(mFilterSettings2.getFreeMinuteRoaming()).thenReturn(new int[]{50, 100});

    }

    @Test
    public void getTariffWithUserFilter() {
        List<Tariff> filteredList = filter.
                findTariffByFilterSettings(tariffList, mFilterSettings1);
        Assertions.assertEquals("Tariff-1", filteredList.get(0).getTariffName());
    }
    @Test
    public void tariffWithUserFilterNotFound() {
        List<Tariff> filteredList = filter.findTariffByFilterSettings(tariffList, mFilterSettings2);
        Assertions.assertEquals(0, filteredList.size());
    }
}
