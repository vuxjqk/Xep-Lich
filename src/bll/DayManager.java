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

    private static List<Day> currentDays;
    private static List<Day> nextDays;

    public static List<Day> getCurrentDays() {
        if (currentDays == null) {
            YearMonth ym = YearMonthManager.getCurrentYearMonth();
            List<LocalDate> dates = DateUtils.getDatesInMonth(ym.getYear(), ym.getMonthValue());
            currentDays = dates.stream()
                    .map(date -> new Day(date.getDayOfMonth(), date))
                    .toList();
        }
        return currentDays;
    }

    public static List<Day> getNextDays() {
        if (nextDays == null) {
            YearMonth ym = YearMonthManager.getNextYearMonth();
            List<LocalDate> dates = DateUtils.getDatesInMonth(ym.getYear(), ym.getMonthValue());
            nextDays = dates.stream()
                    .map(date -> new Day(date.getDayOfMonth(), date))
                    .toList();
        }
        return nextDays;
    }
}
