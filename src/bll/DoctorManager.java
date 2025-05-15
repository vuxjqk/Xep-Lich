/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll;

import dal.DoctorRepository;
import dto.Doctor;
import java.util.List;

/**
 *
 * @author PC
 */
public class DoctorManager {

    private static List<Doctor> doctors;

    public static List<Doctor> getDoctors() {
        if (doctors == null) {
            doctors = DoctorRepository.loadDoctors();
        }
        return doctors;
    }

    public static void setDoctors(List<Doctor> newDoctors) {
        DoctorRepository.saveDoctors(newDoctors);
        doctors = newDoctors;
    }
}
