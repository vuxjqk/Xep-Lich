/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.User;
import java.util.List;

/**
 *
 * @author PC
 */
public class UserManager {

    private static List<User> users;

    public static List<User> getUsers() {
        if (users == null) {
            users = CsvHelper.readFromCsv("users.csv", record -> new User(
                    Integer.parseInt(record[0]), record[1], record[2], record[3],
                    DoctorManager.getDoctors().stream()
                            .filter(d -> d.doctorID() == Integer.parseInt(record[0]))
                            .findFirst()
                            .orElse(null)));
        }
        return users;
    }
}
