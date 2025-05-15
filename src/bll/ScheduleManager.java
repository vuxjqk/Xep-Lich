/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll;

import dal.ScheduleRepository;
import dto.Doctor;
import dto.Schedule;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author PC
 */
public class ScheduleManager {
    
    private static List<Schedule> schedules;
    
    public static List<Schedule> getSchedules() {
        if (schedules == null) {
            schedules = ScheduleRepository.loadSchedules();
        }
        return schedules;
    }
    
    public static void setSchedules(List<Schedule> newSchedules) {
        ScheduleRepository.saveSchedules(newSchedules);
        schedules = newSchedules;
    }
    
    public static List<Schedule> getSchedulesByDoctor(Doctor doctor) {
        return ScheduleManager.getSchedules().stream()
                .filter(schedule -> schedule.doctor().equals(doctor))
                .toList();
    }
    
    public static List<Schedule> getSchedulesForWeek(Doctor doctor, LocalDate weekStartDate) {
        LocalDate weekEndDate = DateUtils.getWeekEndDate(weekStartDate);
        List<Schedule> schedulesByDoctor = getSchedulesByDoctor(doctor);
        
        return schedulesByDoctor.stream()
                .filter(
                        schedule -> schedule.doctor().equals(doctor)
                        && !schedule.day().date().isBefore(weekStartDate)
                        && !schedule.day().date().isAfter(weekEndDate)
                )
                .sorted(Comparator.comparing(s -> s.day().date()))
                .toList();
    }
    
    public static Object[] getDatesForWeek(LocalDate weekStartDate) {
        Object[] rowDays = new Object[7];
        
        for (int day = 0; day < 7; day++) {
            rowDays[day] = weekStartDate.plusDays(day);
        }
        
        return rowDays;
    }
    
    public static Object[] getRoomsForWeek(List<Schedule> schedules) {
        Object[] rowRooms = new Object[7];
        
        for (Schedule schedule : schedules) {
            int dayOfWeek = schedule.day().date().getDayOfWeek().getValue();
            rowRooms[dayOfWeek - 1] = schedule.room().name();
        }
        
        for (int day = 0; day < 7; day++) {
            if (rowRooms[day] == null) {
                rowRooms[day] = "";
            }
        }
        
        return rowRooms;
    }
}
