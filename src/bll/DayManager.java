/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll;

import dto.Day;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

/**
 *
 * @author PC
 */
public class DayManager {

    private static List<Day> days;

    public static List<Day> getDays() {
        if (days == null) {
            YearMonth ym = YearMonthManager.getYearMonth0();
            List<LocalDate> dates = DateUtils.getDatesInMonth(ym.getYear(), ym.getMonthValue());
            days = dates.stream()
                    .map(date -> new Day(date.getDayOfMonth(), date))
                    .toList();
        }
        return days;
    }
}
