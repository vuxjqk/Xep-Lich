/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class DateUtils {

    public static YearMonth parseYearMonth(String yearStr, String monthStr) {
        try {
            int year = Integer.parseInt(yearStr.trim());
            int month = Integer.parseInt(monthStr.trim());

            if (month < 1 || month > 12) {
                throw new IllegalArgumentException("Tháng không hợp lệ. Vui lòng nhập từ 1 đến 12.");
            }

            if (year <= 0) {
                throw new IllegalArgumentException("Năm không hợp lệ. Vui lòng nhập số năm lớn hơn 0.");
            }

            return YearMonth.of(year, month);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Vui lòng nhập số hợp lệ cho tháng và năm.");
        }
    }

    public static List<LocalDate> getDatesInMonth(int year, int month) {
        List<LocalDate> dates = new ArrayList<>();
        int daysInMonth = YearMonth.of(year, month).lengthOfMonth();

        for (int day = 1; day <= daysInMonth; day++) {
            dates.add(LocalDate.of(year, month, day));
        }

        return dates;
    }

    public static LocalDate getWeekStartDate(int year, int month, int weekIndex) {
        LocalDate firstMonday = LocalDate.of(year, month, 1).with(DayOfWeek.MONDAY);
        return firstMonday.plusWeeks(weekIndex - 1);
    }

    public static LocalDate getWeekEndDate(LocalDate weekStartDate) {
        return weekStartDate.plusDays(6);
    }
}
