/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import bll.DayManager;
import bll.DoctorManager;
import bll.RoomManager;
import dto.Day;
import dto.Doctor;
import dto.Room;
import dto.Schedule;
import java.util.List;

/**
 *
 * @author PC
 */
public class ScheduleRepository {

    public static List<Schedule> loadSchedules() {
        List<Doctor> doctors = DoctorManager.getDoctors();
        List<Room> rooms = RoomManager.getRooms();
        List<Day> days = DayManager.getCurrentDays();

        return CsvHelper.readCsv("data/schedules.csv", values -> {
            int doctorId = Integer.parseInt(values[0]);
            int roomId = Integer.parseInt(values[1]);
            int dayId = Integer.parseInt(values[2]);

            Doctor doctor = doctors.stream()
                    .filter(d -> d.id() == doctorId)
                    .findFirst()
                    .orElse(null);

            Room room = rooms.stream()
                    .filter(r -> r.id() == roomId)
                    .findFirst()
                    .orElse(null);

            Day day = days.stream()
                    .filter(d -> d.id() == dayId)
                    .findFirst()
                    .orElse(null);

            return new Schedule(doctor, room, day);
        });
    }

    public static void saveSchedules(List<Schedule> schedules) {
        CsvHelper.writeCsv(
                "data/schedules.csv",
                new String[]{"DoctorId", "RoomId", "DayId"},
                schedules,
                schedule -> new String[]{
                    String.valueOf(schedule.doctor().id()),
                    String.valueOf(schedule.room().id()),
                    String.valueOf(schedule.day().id())
                }
        );
    }
}
