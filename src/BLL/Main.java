/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DayManager;
import DAL.DoctorManager;
import DAL.RoomManager;
import DAL.ScheduleManager;
import DTO.Day;
import DTO.Doctor;
import DTO.Room;
import java.util.List;
import java.util.Random;

/**
 *
 * @author PC
 */
public class Main {

    public static void run() {
        List<Doctor> doctors = DoctorManager.getDoctors();
        List<Room> rooms = RoomManager.getRooms();
        List<Day> days = DayManager.getDays();

        GeneticAlgorithm ga = new GeneticAlgorithm(doctors, rooms, days, 200, 2000, 3, 0.8, 0.2, new Random());
        ScheduleManager.setSchedules(ga.run());
    }
}
