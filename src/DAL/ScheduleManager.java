/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Schedule;
import java.util.List;

/**
 *
 * @author PC
 */
public class ScheduleManager {

    private static List<Schedule> schedules;

    public static List<Schedule> getSchedules() {
        if (schedules == null) {
            schedules = CsvHelper.readFromCsv("schedules.csv", record -> new Schedule(
                    DoctorManager.getDoctors().stream()
                            .filter(d -> d.doctorID() == Integer.parseInt(record[0]))
                            .findFirst()
                            .orElse(null),
                    RoomManager.getRooms().stream()
                            .filter(r -> r.roomID() == Integer.parseInt(record[1]))
                            .findFirst()
                            .orElse(null),
                    DayManager.getDays().stream()
                            .filter(d -> d.dayID() == Integer.parseInt(record[2]))
                            .findFirst()
                            .orElse(null)));
        }
        return schedules;
    }

    public static void setSchedules(List<Schedule> newSchedules) {
        CsvHelper.writeToCsv(
                new String[]{"DoctorID", "RoomID", "DayID"},
                newSchedules, "schedules.csv",
                (Schedule schedule) -> new String[]{
                    String.valueOf(schedule.doctor().doctorID()),
                    String.valueOf(schedule.room().roomID()),
                    String.valueOf(schedule.day().dayID())
                }
        );
        schedules = newSchedules;
    }
}
