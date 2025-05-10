/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Day;
import DTO.Doctor;
import DTO.Room;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author PC
 */
public class DoctorManager {

    private static List<Doctor> doctors;

    public static List<Doctor> getDoctors() {
        if (doctors == null) {
            doctors = CsvHelper.readFromCsv("doctors.csv", record -> {
                List<String> roomsID = Arrays.asList(record[2].split(" "));
                List<Room> roomsAllowed = RoomManager.getRooms().stream()
                        .filter(room -> roomsID.contains(String.valueOf(room.roomID())))
                        .collect(Collectors.toList());

                List<String> daysID = record[3].isEmpty() ? List.of() : Arrays.asList(record[3].split(" "));
                List<Day> daysOff = DayManager.getDays().stream()
                        .filter(day -> daysID.contains(String.valueOf(day.dayID())))
                        .collect(Collectors.toList());

                return new Doctor(Integer.parseInt(record[0]), record[1], roomsAllowed, daysOff);
            });
        }
        return doctors;
    }

    public static void setDoctors(List<Doctor> newDoctors) {
        CsvHelper.writeToCsv(
                new String[]{"DoctorID", "DoctorName", "RoomsAllowed", "DaysOff"},
                newDoctors, "doctors.csv",
                (Doctor doctor) -> new String[]{
                    String.valueOf(doctor.doctorID()),
                    doctor.doctorName(),
                    String.join(" ", doctor.roomsAllowed().stream()
                            .map(room -> String.valueOf(room.roomID()))
                            .toList()),
                    String.join(" ", doctor.daysOff().stream()
                            .map(day -> String.valueOf(day.dayID()))
                            .toList())
                }
        );
        doctors = newDoctors;
    }
}
