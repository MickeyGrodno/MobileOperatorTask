package com.epam.mobileOperator.filter;

import com.epam.mobileOperator.Tariff;
import com.epam.mobileOperator.interfaces.Filter;

import java.util.ArrayList;
import java.util.List;

public class FilterImpl implements Filter {

    public List<Tariff> findTariffByFilterSettings(List<Tariff> tariffList, FilterSettings filterSettings) {
        List<Tariff> filteredTariffList = new ArrayList<>();
        for(Tariff tariff : tariffList) {
            if(tariff.getSubscriptionFee()>= filterSettings.getSubscriptionFee()[0]
                    && tariff.getSubscriptionFee()<= filterSettings.getSubscriptionFee()[1]) {
                if(tariff.getFreeMinute()>= filterSettings.getFreeMinute()[0]
                        && tariff.getFreeMinute()<= filterSettings.getFreeMinute()[1]) {
                    if(tariff.getFreeMinuteToOtherNetwork()>= filterSettings.getFreeMinuteToOtherNetwork()[0]
                            && tariff.getFreeMinuteToOtherNetwork()<= filterSettings.getFreeMinuteToOtherNetwork()[1]) {
                        if(tariff.getFreeTraffic()>= filterSettings.getFreeTraffic()[0]
                                && tariff.getFreeTraffic()<= filterSettings.getFreeTraffic()[1]) {
                            if(tariff.getFreeSms()>= filterSettings.getFreeSms()[0]
                                    && tariff.getFreeSms()<= filterSettings.getFreeSms()[1]) {
                                if(tariff.getFreeMinuteRoaming()>= filterSettings.getFreeMinuteRoaming()[0]
                                        && tariff.getFreeMinuteRoaming()<= filterSettings.getFreeMinuteRoaming()[1]) {
                                    filteredTariffList.add(tariff);
                                }
                            }
                        }
                    }
                }
            }
        }
        return filteredTariffList;
    }
}
