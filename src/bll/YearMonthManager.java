/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll;

import dal.YearMonthRepository;
import java.time.YearMonth;
import java.util.List;

/**
 *
 * @author PC
 */
public class YearMonthManager {

    private static List<YearMonth> yms;

    private static void loadYearMonth() {
        if (yms == null) {
            yms = YearMonthRepository.loadYearMonth();
        }
    }

    public static YearMonth getYearMonth0() {
        loadYearMonth();
        return yms.get(0);

    }

    public static YearMonth getYearMonth1() {
        loadYearMonth();
        return yms.get(1);
    }

    public static void setYearMonth0(YearMonth ym) {
        loadYearMonth();
        yms.set(0, ym);
        YearMonthRepository.saveYearMonth(yms);
    }

    public static void setYearMonth1(YearMonth ym) {
        loadYearMonth();
        yms.set(1, ym);
        YearMonthRepository.saveYearMonth(yms);
    }
}
