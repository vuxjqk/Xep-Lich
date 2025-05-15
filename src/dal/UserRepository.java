/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import bll.DoctorManager;
import dto.Doctor;
import dto.User;
import java.util.List;

/**
 *
 * @author PC
 */
public class UserRepository {

    public static List<User> loadUsers() {
        List<Doctor> doctors = DoctorManager.getDoctors();

        return CsvHelper.readCsv("data/users.csv", values -> {
            int userId = Integer.parseInt(values[0]);
            Doctor doctor = doctors.stream()
                    .filter(d -> d.id() == userId)
                    .findFirst()
                    .orElse(null);

            return new User(
                    userId,
                    values[1],
                    values[2],
                    values[3],
                    doctor
            );
        });
    }
}
