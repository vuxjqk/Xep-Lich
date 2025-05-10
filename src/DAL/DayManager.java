/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Day;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author PC
 */
public class DayManager {

    private static List<Day> days;

    public static List<Day> getDays() {
        if (days == null) {
            days = CsvHelper.readFromCsv("days.csv", record -> new Day(
                    Integer.parseInt(record[0]), LocalDate.parse(record[1])));
        }
        return days;
    }

    public static void setDays(List<Day> newDays) {
        CsvHelper.writeToCsv(
                new String[]{"DayID", "Date"},
                newDays, "days.csv",
                (Day item) -> new String[]{
                    String.valueOf(item.dayID()),
                    String.valueOf(item.date())
                }
        );
        days = newDays;
    }
}
