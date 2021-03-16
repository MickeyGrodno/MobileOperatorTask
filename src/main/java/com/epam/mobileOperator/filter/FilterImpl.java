package com.epam.mobileOperator.filter;

import com.epam.mobileOperator.Tariff;
import com.epam.mobileOperator.interfaces.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class FilterImpl implements Filter {

    private final static Logger LOGGER = LoggerFactory.getLogger(FilterImpl.class);

    public List<Tariff> findTariffByFilterSettings(List<Tariff> tariffList, FilterSettings filterSettings) {
        LOGGER.info("Вызов метода");
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
        LOGGER.info("Поизведена фильтрация данных согласно пользовательского фильтра");
        return filteredTariffList;
    }
}
