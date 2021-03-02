import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TariffLoader {
    private final String RATE_BASE = "src\\main\\resources\\rateTariff.csv";
    private BufferedReader reader;
    private Tariff tariff = new Tariff();
    private List<Tariff> allTariff;
    private Map<String, List<Tariff>> allTariffsGroupByTariffLine;
    private String line;


    private int unlimCheck(String lineValue) {
        if (!lineValue.equalsIgnoreCase("unlim")) {
            return Integer.parseInt(lineValue);
        }
        else return Integer.MAX_VALUE;
    }

    private void tariffSetter(String[] values) {
        tariff.setTariffName(values[0]);
        tariff.setSubscriptionFee(Double.parseDouble(values[1]));
        tariff.setFreeMinute(unlimCheck(values[2]));
        tariff.setFreeMinuteToOtherNetwork(unlimCheck(values[3]));
        tariff.setFreeTraffic(unlimCheck(values[4]));
        tariff.setFreeSms(unlimCheck(values[5]));
        tariff.setFreeMinuteRoaming(unlimCheck(values[6]));
        tariff.setPriceMinute(Double.parseDouble(values[7]));
        tariff.setPriceMinuteToOtherNetwork(Double.parseDouble(values[8]));
        tariff.setPriceTraffic(Double.parseDouble(values[9]));
        tariff.setPriceSms(Double.parseDouble(values[10]));
        tariff.setPriceMinuteRoaming(Double.parseDouble(values[11]));
    }

    List<Tariff> loadAllTariffFromCsv() throws IOException {
        allTariff = new ArrayList<>();
        reader = new BufferedReader(new FileReader(RATE_BASE));

        while ((line = reader.readLine()) != null) {
            String[] values = line.split("_");
            tariffSetter(values);
            allTariff.add(tariff);
        }
        return allTariff;
    }

    Map<String, List<Tariff>> sortTariffsByLine(List<Tariff> tariffList) {

        allTariffsGroupByTariffLine = tariffList.stream().collect(
                Collectors.groupingBy(x -> x.getTariffName().split(" ")[0]));

        return allTariffsGroupByTariffLine;
    }

    private void print(Map<String, List<Tariff>> map) {
        for (Map.Entry<String, List<Tariff>> current : map.entrySet()) {
            System.out.println("Тарифы линейки "+current.getKey());
            System.out.println("------------------------------------");
            for (Tariff currentTariff : current.getValue()) {
                System.out.println(currentTariff.getTariffName());
            }
        }
    }
    void printAllTariff() throws IOException {
        print(sortTariffsByLine(loadAllTariffFromCsv()));
    }
}
