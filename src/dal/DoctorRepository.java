/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import bll.DayManager;
import bll.RoomManager;
import dto.Day;
import dto.Doctor;
import dto.Room;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author PC
 */
public class DoctorRepository {

    public static List<Doctor> loadDoctors() {
        List<Room> rooms = RoomManager.getRooms();
        List<Day> days = DayManager.getDays();

        return CsvHelper.readCsv("data/doctors.csv", values -> {
            List<Room> roomsAllowed = Arrays.stream(values[2].split(" "))
                    .map(Integer::parseInt)
                    .map(
                            id -> rooms.stream()
                                    .filter(room -> room.id() == id)
                                    .findFirst()
                                    .orElse(null)
                    )
                    .collect(Collectors.toList());

            List<Day> daysOff = values[3].isEmpty()
                    ? List.of()
                    : Arrays.stream(values[3].split(" "))
                            .map(Integer::parseInt)
                            .map(
                                    id -> days.stream()
                                            .filter(day -> day.id() == id)
                                            .findFirst()
                                            .orElse(null)
                            )
                            .collect(Collectors.toList());

            return new Doctor(
                    Integer.parseInt(values[0]),
                    values[1],
                    roomsAllowed,
                    daysOff
            );
        });
    }

    public static void saveDoctors(List<Doctor> doctors) {
        CsvHelper.writeCsv(
                "data/doctors.csv",
                new String[]{"DoctorId", "DoctorName", "RoomsAllowed", "DaysOff"},
                doctors,
                doctor -> new String[]{
                    String.valueOf(doctor.id()),
                    doctor.name(),
                    doctor.roomsAllowed().stream()
                            .map(room -> String.valueOf(room.id()))
                            .collect(Collectors.joining(" ")),
                    doctor.daysOff().stream()
                            .map(day -> String.valueOf(day.id()))
                            .collect(Collectors.joining(" "))
                }
        );
    }
}
