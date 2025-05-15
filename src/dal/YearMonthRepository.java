/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.time.YearMonth;
import java.util.List;

/**
 *
 * @author PC
 */
public class YearMonthRepository {

    public static List<YearMonth> loadYearMonth() {
        return CsvHelper.readCsv("data/year_month.csv", values -> YearMonth.of(
                Integer.parseInt(values[0]),
                Integer.parseInt(values[1])
        ));
    }

    public static void saveYearMonth(List<YearMonth> yms) {
        CsvHelper.writeCsv(
                "data/year_month.csv",
                new String[]{"Year", "Month"},
                yms,
                ym -> new String[]{
                    String.valueOf(ym.getYear()),
                    String.valueOf(ym.getMonthValue())
                }
        );
    }
}
